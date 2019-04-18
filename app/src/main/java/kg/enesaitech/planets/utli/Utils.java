package kg.enesaitech.planets.utli;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.provider.Settings;
import android.util.Base64;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import kg.enesaitech.planets.lib.MyRequestQueue;
import kg.enesaitech.planets.lib.ResponseCallback;


/**
 * Created by e.zhumanasyrov on 18.04.2019.
 */
public class Utils {
    private static Utils utils = null;
    public static String VERSION = "1.0.0";
    public static String SERVER_URL = "https://www.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=";

    public static Utils GetInstance() {
        if (utils == null) utils = new Utils();
        return utils;
    }

    public void warnErrorsToast(Context context, JSONObject obj) {
        try {
            if (obj.has("result")) {
                int result = obj.getInt("result");
                if (result < 0) {
                    if (obj.has("message")) {
                        String message = obj.getString("message");
                        Toast.makeText(context, "Ошибка: " + message, Toast.LENGTH_SHORT).show();
                    }

                } else if (result > 0) {
                    if (obj.has("message")) {
                        String message = obj.getString("message");
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

    public void sendRequest(final Activity activity, String url, JSONObject obj, boolean silent, final ResponseCallback responseCallback) {

        final String imei = Settings.Secure.getString(activity.getContentResolver(), Settings.Secure.ANDROID_ID);
        try {
            if (obj == null) {
                obj = new JSONObject();
            }
//            obj.put("device", imei);
//            obj.put("version", VERSION);
//            obj.put("lang", "ru");
//            obj.put("device_name", "my_android");

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    Utils.SERVER_URL + url,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            //Utils.GetInstance().warnErrors(LoginActivity.this, response);
                            warnErrorsToast(activity, response);
                            responseCallback.onResponse(response);

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(activity, "Сервер недоступен!", Toast.LENGTH_SHORT).show();
                            responseCallback.onError(error.getMessage());
                            System.out.println("finished");
                            System.out.println("*****************" + error.toString());
                            // TODO: Handle error
                        }
                    }) {

                /**
                 * Passing some request headers
                 */
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Basic " +
                            Base64.encodeToString((imei).getBytes(), Base64.NO_WRAP));
                    return headers;
                }
            };
            MyRequestQueue.getInstance(activity).addToRequestQueue(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

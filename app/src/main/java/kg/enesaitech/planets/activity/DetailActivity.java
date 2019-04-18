package kg.enesaitech.planets.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import kg.enesaitech.planets.R;
import kg.enesaitech.planets.db.Database;
import kg.enesaitech.planets.db.Planets;
import kg.enesaitech.planets.lib.ResponseCallback;
import kg.enesaitech.planets.utli.Utils;

public class DetailActivity extends Activity {

    TextView nameTV, noteTV, descriptionTV;
    ImageView imageIV;
    Activity activity;

    int planet_id;
    String planet_name;
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameTV = findViewById(R.id.name_of_planet_detail);
        noteTV = findViewById(R.id.note_of_planet_detail);
        descriptionTV = findViewById(R.id.description_of_planet_detail);
        imageIV = findViewById(R.id.image_of_planet_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            Toast.makeText(DetailActivity.this, "Your bundle: " + bundle, Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        planet_id = bundle.getInt("planet_id");
        planet_name = bundle.getString("planet_name");
        Planets planet = db.getPlanet(planet_id);

        getInfoFromWiki();

        nameTV.setText(planet.getName());
        noteTV.setText(planet.getNote());
        descriptionTV.setText(planet.getDescription());
//        int id = activity.getResources().getIdentifier(planet.getImage(), "drawable", planet.getImage());
//        imageIV.setImageResource(id);

    }

    private void getInfoFromWiki() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("planet_name", planet_name);
            Utils.GetInstance().sendRequest(this, "venus", null, false, new ResponseCallback() {

                @Override
                public void onResponse(JSONObject responseData) {
                    try {
                        if (responseData.getInt("result") == 0) {
                            String query = responseData.getString("query");
                            Toast.makeText(DetailActivity.this, "RESPONSE" + query, Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(DetailActivity.this, "ERROR", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }

                @Override
                public void onError(String error) {
                    Log.e("GET_TRANSFER_DATA", "ERROR : " + error);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

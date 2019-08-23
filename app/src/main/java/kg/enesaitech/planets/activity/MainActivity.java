package kg.enesaitech.planets.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import kg.enesaitech.planets.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Handler handler = new Handler();

//        isNetworkAvailable();

        final Runnable r = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, PlanetsActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(r, 1500);

    }

//    public boolean isNetworkAvailable() {
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//        Log.d("BUNDLE*******", "You clicked Item: " + activeNetworkInfo);
//        Toast.makeText(MainActivity.this, "You choose: " + activeNetworkInfo , Toast.LENGTH_LONG).show();
//        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//    }
}

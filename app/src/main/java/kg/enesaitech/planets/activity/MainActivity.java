package kg.enesaitech.planets.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kg.enesaitech.planets.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Handler handler = new Handler();

        final Runnable r = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, PlanetsActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(r, 2500);

    }
}

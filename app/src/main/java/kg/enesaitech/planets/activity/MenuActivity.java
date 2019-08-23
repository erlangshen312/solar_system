package kg.enesaitech.planets.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import kg.enesaitech.planets.R;

public class MenuActivity extends AppCompatActivity {

    private Toolbar toolbarMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toolbarMenu = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMenu);
        getSupportActionBar().setTitle("Menu");

        ImageButton imageB = findViewById(R.id.main_menu_close);
        imageB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMenu = new Intent(MenuActivity.this, PlanetsActivity.class);
                startActivity(intentMenu);
            }
        });

    }
}

package kg.enesaitech.planets.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

import kg.enesaitech.planets.R;

public class MenuActivity extends AppCompatActivity {

    private Toolbar toolbarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toolbarMenu = findViewById(R.id.toolbar_main);
//        toolbarMenu.setTitleTextColor(0xFFFFFF); //Color set
        setSupportActionBar(toolbarMenu);
        getSupportActionBar().setTitle(R.string.menu);


        ImageButton imageButtonCancel = findViewById(R.id.main_menu_close);
        imageButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    //onBackPressed : return to previous activity
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

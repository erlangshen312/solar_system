package kg.enesaitech.planets.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import kg.enesaitech.planets.R;
import kg.enesaitech.planets.adapter.PlanetsAdapter;
import kg.enesaitech.planets.db.Database;
import kg.enesaitech.planets.db.Planets;

public class PlanetsActivity extends AppCompatActivity {

    PlanetsAdapter planetsListAdapter;
    ArrayList<Planets> planet;
    ListView planetsListView;

    Database db = new Database(this);

    private Toolbar toolbarMain;
    private boolean isRunning = false;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);

        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setTitle(R.string.planets);

        ImageButton imageButtonNextPage = findViewById(R.id.main_menu);
        imageButtonNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMenuIntent = new Intent(PlanetsActivity.this, MenuActivity.class);
                startActivity(openMenuIntent);
            }
        });

        planetsListView = findViewById(R.id.planets_list);
        planet = db.getPlanets();

        planetsListAdapter = new PlanetsAdapter(this, planet);
        planetsListView.setAdapter(planetsListAdapter);
        planetsListView.deferNotifyDataSetChanged();

        planetsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   int p_id = planet.get(position).getId();
                   Intent intent = new Intent(PlanetsActivity.this, DetailActivity.class);
                   intent.putExtra("p_id", p_id);
                   startActivity(intent);
               }
           }
        );


    }
}

package kg.enesaitech.planets.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import kg.enesaitech.planets.R;
import kg.enesaitech.planets.adapter.PlanetsAdapter;
import kg.enesaitech.planets.db.Database;
import kg.enesaitech.planets.db.Planets;

public class PlanetsActivity extends Activity {

    PlanetsAdapter planetsListAdapter;
    ArrayList<Planets> planet;
    ListView planetsListView;

    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);

        planetsListView = findViewById(R.id.planets_list);
        planet = db.getPlanets();

        planetsListAdapter = new PlanetsAdapter(this, planet);
        planetsListView.setAdapter(planetsListAdapter);
        planetsListView.deferNotifyDataSetChanged();

        planetsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   int planet_id = planet.get(position).getId();
                   String planet_name = planet.get(position).getName();
                   Intent intent = new Intent(PlanetsActivity.this, DetailActivity.class);
                   intent.putExtra("planet_id", planet_id);
                   Log.i("BUNDLE*******", "You clicked Item: " + planet_id + " " + planet_name);
                   Toast.makeText(PlanetsActivity.this, "You choose: " + planet_name , Toast.LENGTH_LONG).show();
                   startActivity(intent);


               }
           }
        );


    }
}

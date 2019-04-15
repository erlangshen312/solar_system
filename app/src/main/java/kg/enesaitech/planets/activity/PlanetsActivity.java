package kg.enesaitech.planets.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

                   Toast.makeText(PlanetsActivity.this, "ID" + id, Toast.LENGTH_LONG).show();

//                   if (planet.get(position).getLocked() == 1) {
//                       Toast.makeText(TestListActivity.this, "Sorry this is disabled", Toast.LENGTH_LONG).show();
//                   } else {
//                       int test_id = tests.get(position).getId();
//                       String test_name = tests.get(position).getName();
//                       intent = new Intent(TestListActivity.this, AnswerActivity.class);
//                       intent.putExtra("test_id", test_id);
//                       Log.i("BUNDLE*******", "You clicked Item: " + test_id + " " + test_name);
//                       Toast.makeText(TestListActivity.this, "Сиз " + test_name + " дегенди тандадыныз", Toast.LENGTH_LONG).show();
//                       startActivity(intent);
//                   }


               }
           }
        );


    }
}

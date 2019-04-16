package kg.enesaitech.planets.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kg.enesaitech.planets.R;
import kg.enesaitech.planets.db.Database;
import kg.enesaitech.planets.db.Planets;

public class DetailActivity extends Activity {

    TextView nameTV, noteTV, descriptionTV;
    ImageView imageIV;

    int planet_id;
    Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameTV = findViewById(R.id.name_of_planet_detail);
        noteTV = findViewById(R.id.note_of_planet_detail);
        descriptionTV = findViewById(R.id.description_of_planet_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            Toast.makeText(DetailActivity.this, "Your bundle: " + bundle , Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        planet_id = bundle.getInt("planet_id");
        Planets planet = db.getPlanet(planet_id);

        nameTV.setText(planet.getName());
        noteTV.setText(planet.getNote());
        descriptionTV.setText(planet.getDescription());

    }
}

package kg.enesaitech.planets.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kg.enesaitech.planets.R;
import kg.enesaitech.planets.db.Database;
import kg.enesaitech.planets.db.Planets;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    TextView noteTV, descriptionTV, equatorialDiameterTV, polarDiameterTV, diameterTV, massTV;
    TextView moonsTV, orbitDistanceTV, orbitPeriodTV, surfaceTempTV, effectiveTempTV, firstRecordTV;
    TextView recordedByTV, discoveryDateTV, discoveryByTV, quickFactsTV, detailedFactsTV, ringsTV, atmospherTV;
    TextView edTV, atmosTV;
    ImageView secondImageIV, thirdImageIV;
    Activity activity;

    int planet_id;
    Database db = new Database(this);

    private Toolbar toolbarDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            Toast.makeText(DetailActivity.this, "Your bundle: " + bundle, Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        planet_id = bundle.getInt("planet_id");
        Planets planet = db.getPlanet(planet_id);

        toolbarDetail = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbarDetail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(planet.getName());

//        nameTV = findViewById(R.id.name_of_planet_detail);
        noteTV = findViewById(R.id.note_of_planet_detail);
//        descriptionTV = findViewById(R.id.text_quick_facts);
        equatorialDiameterTV = findViewById(R.id.eq_diameter_tv);
        polarDiameterTV = findViewById(R.id.p_diameter_tv);
        diameterTV = findViewById(R.id.diameter_tv);
        massTV = findViewById(R.id.mass_tv);
        moonsTV = findViewById(R.id.moons_tv);
        orbitDistanceTV = findViewById(R.id.orbit_distance_tv);
        orbitPeriodTV = findViewById(R.id.orbit_period_tv);
        surfaceTempTV = findViewById(R.id.surface_temp_tv);
        effectiveTempTV = findViewById(R.id.effective_temp_tv);
        firstRecordTV = findViewById(R.id.first_record_tv);
        recordedByTV = findViewById(R.id.recorded_tv);
//        discoveryDateTV = findViewById();
//        discoveryByTV
        quickFactsTV = findViewById(R.id.quick_facts_tv);
        detailedFactsTV = findViewById(R.id.detailed_facts_tv);
        ringsTV = findViewById(R.id.rings_tv);
        atmospherTV = findViewById(R.id.atmosphere_tv);

        secondImageIV = findViewById(R.id.image_second);
        thirdImageIV = findViewById(R.id.image_third);

        edTV = findViewById(R.id.text_equatorial_diameter);
        atmosTV = findViewById(R.id.text_atmosphere_note);

        //SET PLANET
//        nameTV.setText(planet.getName());
        noteTV.setText(planet.getNote());
        equatorialDiameterTV.setText(planet.getEquatorial_diameter());
        polarDiameterTV.setText(planet.getPolar_diameter());
        diameterTV.setText(planet.getDiameter());
        massTV.setText(planet.getMass());
        moonsTV.setText(planet.getMoons());
        orbitDistanceTV.setText(planet.getOrbit_distance());
        orbitPeriodTV.setText(planet.getOrbit_period());
        surfaceTempTV.setText(planet.getSurface_temperature());
        effectiveTempTV.setText(planet.getEffective_temperature());
        if (planet.getRecorded_date() != null) {
            firstRecordTV.setText(planet.getRecorded_date());
            recordedByTV.setText(planet.getRecorded_by());
        } else {
            firstRecordTV.setText(planet.getDiscovery_date());
            recordedByTV.setText(planet.getDiscovery_by());
        }
//        firstRecordTV.setText(planet.getRecorded_date());
//        recordedByTV.setText(planet.getRecorded_by());
//        discoveryDateTV.setText(planet.getDiscovery_date());
//        discoveryByTV.setText(planet.getDiscovery_by());
        quickFactsTV.setText(planet.getQuick_facts());
        detailedFactsTV.setText(planet.getDetailed_facts());
        ringsTV.setText(planet.getRings());
        if (planet.getAtmosphere_note() != null) {
            atmosTV.setVisibility(View.VISIBLE);
            atmospherTV.setText(planet.getAtmosphere_note());
        } else {
            atmosTV.setVisibility(View.INVISIBLE);
            atmospherTV.setVisibility(View.INVISIBLE);
        }

        int image_second = this.getResources().getIdentifier("@drawable/" + planet.getSecond_image(), null, this.getPackageName());
        int image_third = this.getResources().getIdentifier("@drawable/" + planet.getThird_image(), null, this.getPackageName());
        secondImageIV.setImageResource(image_second);
        thirdImageIV.setImageResource(image_third);


//        int id = activity.getResources().getIdentifier(planet.getImage(), "drawable", planet.getImage());
//        imageIV.setImageResource(id);

    }

//    private void getInfoFromWiki() {
//        JSONObject obj = new JSONObject();
//        try {
////            obj.put("planet_name", planet_name);
//            Utils.GetInstance().sendRequest(this, "venus", null, false, new ResponseCallback() {
//
//                @Override
//                public void onResponse(JSONObject responseData) {
//                    Log.d("RESPONSE DATA " , "DATA" + responseData);
//                    try {
//                        if (responseData.getJSONObject("query").length() == 1) {
//                            String data = String.valueOf(responseData.getJSONObject("query").getJSONObject("pages").getString("extract"));
//                            descriptionTV.setText(data);
//                            Toast.makeText(DetailActivity.this, "RESPONSE" + data, Toast.LENGTH_LONG).show();
//                        }
//                    } catch (Exception e) {
//                        Toast.makeText(DetailActivity.this, "ERROR", Toast.LENGTH_LONG).show();
//                        e.printStackTrace();
//                    }
//                }
//
//                @Override
//                public void onError(String error) {
//                    Log.e("GET_TRANSFER_DATA", "ERROR : " + error);
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}

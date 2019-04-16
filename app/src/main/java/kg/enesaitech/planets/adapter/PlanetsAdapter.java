package kg.enesaitech.planets.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kg.enesaitech.planets.R;
import kg.enesaitech.planets.activity.PlanetsActivity;
import kg.enesaitech.planets.db.Planets;


/**
 * Created by e.zhumanasyrov on 15.04.2019.
 */

public class PlanetsAdapter extends BaseAdapter {

    private final ArrayList<Planets> planetsListAdapter;
    private Activity context;

    public PlanetsAdapter(PlanetsActivity planetsActivity, ArrayList<Planets> planet) {
        this.planetsListAdapter = planet;
        this.context = planetsActivity;
    }

    @Override
    public int getCount() {
        return planetsListAdapter.size();
    }

    @Override
    public Object getItem(int position) {
        return planetsListAdapter.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_planet_item, parent, false);
        }

        TextView namePlanetTV = (TextView) view.findViewById(R.id.name_of_planet);
        TextView notePlanetTV = (TextView) view.findViewById(R.id.note_of_planet);
        ImageView imagePlanetIV = (ImageView) view.findViewById(R.id.image_of_planet);

        namePlanetTV.setText(planetsListAdapter.get(position).getName());
        notePlanetTV.setText(planetsListAdapter.get(position).getNote());

//        int id = context.getResources().getIdentifier("yourpackagename:drawable/" + planetsListAdapter.get(position).getImage(), null, null);

//        int id = getResources().getIdentifier("yourpackagename:drawable/" + StringGenerated, null, null);
//        int id = view.getResources().getIdentifier(planetsListAdapter.get(position).getImage(),"Planets/drawable", planetsListAdapter.get(position).getImage());
        int id = context.getResources().getIdentifier(planetsListAdapter.get(position).getImage(), "drawable", context.getPackageName());
//        imagePlanetIV.setImageResource();
//        Toast.makeText(PlanetsAdapter.this, "You choose: " +  planetsListAdapter.get(position).getImage() , Toast.LENGTH_LONG).show();
        System.out.println("********************************" + planetsListAdapter.get(position).getImage());
        System.out.println("***************ID***************" + id);

        imagePlanetIV.setImageResource(id);
//        String image = planetsListAdapter.get(position).getImage();
//        imagePlanetIV.setImageResource(R.drawable.image);
//        imagePlanetIV.setImageDrawable(context.getPackageName());
        return view;
    }
}

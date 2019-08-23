package kg.enesaitech.planets.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

        TextView titlePlanetTV = (TextView) view.findViewById(R.id.name_of_planet);
        TextView subtitlePlanetTV = (TextView) view.findViewById(R.id.subname_of_planet);
        TextView planetTypeTV = (TextView) view.findViewById(R.id.planet_type);
        ImageView imagePlanetIV = (ImageView) view.findViewById(R.id.image_of_planet);

        titlePlanetTV.setText(planetsListAdapter.get(position).getName());
        subtitlePlanetTV.setText(planetsListAdapter.get(position).getSubname());
        planetTypeTV.setText(planetsListAdapter.get(position).getPlanet_type());

        int id = context.getResources().getIdentifier(planetsListAdapter.get(position).getMain_image(), "drawable", context.getPackageName());
        System.out.println("********************************" + planetsListAdapter.get(position).getMain_image());
        System.out.println("***************ID***************" + id);

        imagePlanetIV.setImageResource(id);
        return view;
    }
}

package kg.enesaitech.planets.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
    private Context context;

    public PlanetsAdapter(PlanetsActivity planetsActivity, ArrayList<Planets> planet) {
        this.planetsListAdapter = planet;
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
        imagePlanetIV.setImageDrawable(Drawable.createFromPath(planetsListAdapter.get(position).getImage()));

        return view;
    }
}

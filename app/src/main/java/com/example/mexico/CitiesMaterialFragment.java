package com.example.mexico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CitiesMaterialFragment extends Fragment {

    public CitiesMaterialFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView cityRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_cities_material, container, false);

        String[] cityNames = new String[City.cities.length];
        for (int i = 0; i < cityNames.length; i++) {
            cityNames[i] = City.cities[i].getName();
        }

        int[] cityImages = new int[City.cities.length];
        for (int i = 0; i < cityImages.length; i++) {
            cityImages[i] = City.cities[i].getImageResourceId();
        }

        CaptionImagesAdapter adapter =
                new CaptionImagesAdapter(getContext(), cityNames, cityImages);
        cityRecycler.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        cityRecycler.setLayoutManager(layoutManager);

        /*adapter.setListener(new CaptionImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), ZoneDetailActivity.class);
                intent.putExtra(ZoneDetailActivity.EXTRA_STREFANO, position);
                getActivity().startActivity(intent);
            }
        });*/

        return cityRecycler;
    }


}

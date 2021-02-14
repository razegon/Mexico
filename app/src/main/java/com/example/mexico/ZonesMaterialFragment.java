package com.example.mexico;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ZonesMaterialFragment extends Fragment {



    public ZonesMaterialFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView zoneRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_zones_material, container, false);

        String[] zoneNames = new String[Zone.zones.length];
        for (int i = 0; i < zoneNames.length; i++) {
            zoneNames[i] = Zone.zones[i].getName();
        }

        int[] zoneImages = new int[Zone.zones.length];
        for (int i = 0; i < zoneImages.length; i++) {
            zoneImages[i] = Zone.zones[i].getImageResourceId();
        }

        CaptionImagesAdapter adapter =
                new CaptionImagesAdapter(getContext(), zoneNames, zoneImages);
        zoneRecycler.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        zoneRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), ZoneDetailActivity.class);
                intent.putExtra(ZoneDetailActivity.EXTRA_ZONENO, position);
                getActivity().startActivity(intent);
            }
        });

        return zoneRecycler;
    }
}
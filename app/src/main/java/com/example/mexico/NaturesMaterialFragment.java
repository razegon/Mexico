package com.example.mexico;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NaturesMaterialFragment extends Fragment {

    public NaturesMaterialFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        RecyclerView natureRecycler = (RecyclerView) inflater.inflate(
                R.layout.fragment_natures_material, container, false);

        String[] natureNames = new String[Nature.natures.length];
        for (int i = 0; i < natureNames.length; i++) {
            natureNames[i] = Nature.natures[i].getName();
        }

        int[] natureImages = new int[Nature.natures.length];
        for (int i = 0; i < natureImages.length; i++) {
            natureImages[i] = Nature.natures[i].getImageResourceId();
        }

        CaptionImagesAdapter adapter =
                new CaptionImagesAdapter(getContext(), natureNames, natureImages);
        natureRecycler.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        natureRecycler.setLayoutManager(layoutManager);

        /*adapter.setListener(new CaptionImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), ZoneDetailActivity.class);
                intent.putExtra(ZoneDetailActivity.EXTRA_STREFANO, position);
                getActivity().startActivity(intent);
            }
        });*/

        return natureRecycler;
    }
}
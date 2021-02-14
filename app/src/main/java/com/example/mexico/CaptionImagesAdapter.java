package com.example.mexico;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CaptionImagesAdapter extends RecyclerView.Adapter<CaptionImagesAdapter.ViewHolder> {

    private Context mContext;
    private String[] captions;
    private int[] imageIds;
    private Listener listener;

    public static interface Listener {
        public void onClick(int position);
    }

    //Metoda zwraca referencje do widoków używanych:
    public class ViewHolder extends RecyclerView.ViewHolder {

       private CardView cardView;
       private ImageView imageView;

        //Definiujemy obiekt ViewHolder:
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CaptionImagesAdapter(Context mContext, String[] captions, int[] imageIds) {

        this.mContext = mContext;
        this.captions = captions;
        this.imageIds = imageIds;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CaptionImagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Tworzymy nowy widok:
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);

        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // Ustawiamy wartości w konkretnym widoku:
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.info_image);
        //Drawable drawable = cardView.getResources().getDrawable(imageIds[position]);
        //imageView.setImageDrawable(drawable);
        //imageView.setContentDescription(captions[position]);

        Glide.with(mContext).load(imageIds[position]).into(imageView);

        TextView textView = cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        // Metoda zwraca liczbę elementów w zbiorze danych:
        return captions.length;
    }
}

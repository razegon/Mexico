package com.example.mexico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import static com.example.mexico.Zone.zones;

public class ZoneDetailActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;
    public static final String EXTRA_ZONENO = "zoneNo";

    int zoneNo[];

    private Button overviewButton, historyButton, curiositiesButton;
    private TextView descriptionText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_detail);

        // Włączamy przycisk "W górę" :
        getSupportActionBar().hide();

        // Wyświatlamy szczegółowe informacje o strefie:
        int zoneNo = (Integer) getIntent().getExtras().get(EXTRA_ZONENO);
        String strefaName = zones[zoneNo].getName();

        TextView textView = findViewById(R.id.strefa_text);
        textView.setText(strefaName);

        int strefaImage = zones[zoneNo].getImageResourceId();
        SubsamplingScaleImageView imageView = findViewById(R.id.strefa_image);
        imageView.setImage(ImageSource.resource(strefaImage));
        imageView.setContentDescription(strefaName);

        descriptionText = findViewById(R.id.detail_description);
        overviewButton = findViewById(R.id.btn_overview);
        historyButton = findViewById(R.id.btn_history);
        curiositiesButton = findViewById(R.id.btn_curiosities);

        overviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zoneNo == 0) {
                    descriptionText.setText(R.string.overview_teotihuacan);
                    imageView.setImage(ImageSource.resource(R.drawable.map_teotihuacan));
                }else if(zoneNo == 1) {
                    descriptionText.setText(R.string.overview_cholula);
                    imageView.setImage(ImageSource.resource(R.drawable.map_cholula));
                }else if(zoneNo == 2) {
                    descriptionText.setText(R.string.overview_monte_alban);
                    imageView.setImage(ImageSource.resource(R.drawable.map_monte_alban));
                }else if(zoneNo == 3) {
                    descriptionText.setText(R.string.overview_mitla);
                    imageView.setImage(ImageSource.resource(R.drawable.map_mitla));
                }else if(zoneNo == 4) {
                    descriptionText.setText(R.string.overview_palenque);
                    imageView.setImage(ImageSource.resource(R.drawable.map_palenque));
                }else if(zoneNo == 5) {
                    descriptionText.setText(R.string.overview_uxmal);
                    imageView.setImage(ImageSource.resource(R.drawable.map_uxmal));
                }else if(zoneNo == 6) {
                    descriptionText.setText(R.string.overview_chichen_itza);
                    imageView.setImage(ImageSource.resource(R.drawable.map_chichen_itza));
                }else if(zoneNo == 7) {
                    descriptionText.setText(R.string.overview_tulum);
                    imageView.setImage(ImageSource.resource(R.drawable.map_tulum));
                }

                descriptionText.setMovementMethod(new ScrollingMovementMethod());
            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zoneNo == 0) {
                    descriptionText.setText(R.string.history_teotihuacan);
                    imageView.setImage(ImageSource.resource(R.drawable.history_teotihuacan));
                }else if (zoneNo == 1) {
                    descriptionText.setText(R.string.history_cholula);
                    imageView.setImage(ImageSource.resource(R.drawable.history_cholula));
                }else if (zoneNo == 2) {
                    descriptionText.setText(R.string.history_monte_alban);
                    imageView.setImage(ImageSource.resource(R.drawable.history_monte_alban));
                }else if (zoneNo == 3) {
                    descriptionText.setText(R.string.history_mitla);
                    imageView.setImage(ImageSource.resource(R.drawable.history_mitla));
                }else if(zoneNo == 4) {
                    descriptionText.setText(R.string.history_palenque);
                    imageView.setImage(ImageSource.resource(R.drawable.history_palenque));
                }else if(zoneNo == 5) {
                    descriptionText.setText(R.string.history_uxmal);
                    imageView.setImage(ImageSource.resource(R.drawable.history_uxmal));
                }else if(zoneNo == 6) {
                    descriptionText.setText(R.string.history_chichen_itza);
                    imageView.setImage(ImageSource.resource(R.drawable.history_chichen_itza));
                }else if(zoneNo == 7) {
                    descriptionText.setText(R.string.history_tulum);
                    imageView.setImage(ImageSource.resource(R.drawable.history_tulum));
                }

                descriptionText.setMovementMethod(new ScrollingMovementMethod());
            }
        });

    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Udostępniamy nazwę Strefy:
        TextView textView = findViewById(R.id.strefa_text);
        CharSequence strefaName = textView.getText();
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, strefaName);
        shareActionProvider.setShareIntent(intent);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
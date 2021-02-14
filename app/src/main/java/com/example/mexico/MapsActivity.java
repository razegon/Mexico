package com.example.mexico;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.appbar.MaterialToolbar;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;



    final LatLng teotihuacan = new LatLng(19.693578, -98.848905);
    final LatLng cholula = new LatLng(19.057550, -98.298444);
    final LatLng monteAlban = new LatLng(17.046733, -96.764879);
    final LatLng mitla = new LatLng(16.928085, -96.358666);
    final LatLng palenque = new LatLng(17.484906, -92.048719);
    final LatLng uxmal = new LatLng(20.360511, -89.767175);
    final LatLng chichenItza = new LatLng(20.682933, -88.572213);
    final LatLng tulum = new LatLng(20.218117, -87.437761);


    final LatLng oaxaca = new LatLng(17.061655, -96.725617);
    final LatLng cdmx = new LatLng(19.432716, -99.133177);
    final LatLng taxco = new LatLng(18.556530, -99.605287);
    final LatLng acapulco = new LatLng(16.848258, -99.908073);
    final LatLng puebla = new LatLng(19.043696, -98.198146);
    final LatLng sanCristobal = new LatLng(16.737065, -92.637695);
    final LatLng campeche = new LatLng(19.845897, -90.536996);
    final LatLng merida = new LatLng(20.967096, -89.623726);
    final LatLng cancun= new LatLng(21.161276, -86.827562);
    final LatLng queretaro = new LatLng(20.593018, -100.389693);


    final LatLng sumidero = new LatLng(16.740014, -93.031374);
    final LatLng celestun = new LatLng(20.857839, -90.383886);
    final LatLng aguaAzul = new LatLng(17.257197, -92.113730);
    final LatLng misolHa = new LatLng(17.392524, -92.000160);
    final LatLng tule = new LatLng(17.044720, -96.633070);
    final LatLng cacahuamilpa = new LatLng(18.669533, -99.509264);
    final LatLng eiypantla = new LatLng(18.384585, -95.205129);
    final LatLng hierveElAgua = new LatLng(16.868002, -96.276296);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Toolbar toolbar = findViewById(R.id.materialToolbar);
        setActionBar(toolbar);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getActionBar().setDisplayHomeAsUpEnabled(true);


        if (mMap != null) {
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    View v = getLayoutInflater().inflate(R.layout.info_window, null);

                    TextView tvLocality = v.findViewById(R.id.tv_locality);
                    TextView tvLat = v.findViewById(R.id.tv_lat);
                    TextView tvLng = v.findViewById(R.id.tv_lng);
                    TextView tvSnippet = v.findViewById(R.id.tv_snippet);


                    return v;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View v = getLayoutInflater().inflate(R.layout.info_window, null);

                    TextView tvLocality = v.findViewById(R.id.tv_locality);
                    TextView tvLat = v.findViewById(R.id.tv_lat);
                    TextView tvLng = v.findViewById(R.id.tv_lng);
                    TextView tvSnippet = v.findViewById(R.id.tv_snippet);

                    LatLng teotihuacan = marker.getPosition();
                    tvLocality.setText(marker.getTitle());
                    tvLat.setText("" + teotihuacan.latitude);
                    tvLng.setText("" + teotihuacan.longitude);
                    tvSnippet.setText(marker.getSnippet());



                    return v;
                }
            });
        }





    }

    private void zoneMarkers() {

        mMap.addMarker(new MarkerOptions().snippet("Place where Men bacome to the Gods")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_teotihuacan))
                .position(teotihuacan)).setTitle("Teotihuacan");


        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cholula))
                .position(cholula)).setTitle("Cholula");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mitla))
                .position(monteAlban)).setTitle("Monte Alban");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mitla))
                .position(mitla)).setTitle("Mitla");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_pakal))
                .position(palenque)).setTitle("Palenque");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_uxmal))
                .position(uxmal)).setTitle("Uxmal");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_kukulkan))
                .position(chichenItza)).setTitle("Chichen Itza");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_tulum))
                .position(tulum)).setTitle("Tulum");
    }

    private void cityMarkers() {

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(oaxaca).title("Oaxaca de Juarez")).setSnippet(getResources().getString(R.string.snippet_oaxaca));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(cdmx).title("CDMX"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(taxco).title("Taxco de Alarcon"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(acapulco).title("Acapulco de Juarez"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(puebla).title("Puebla"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(sanCristobal).title("San Cristobal de las Casas"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(campeche).title("Campeche"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(merida).title("Merida"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(cancun).title("Cancun"));
        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(queretaro).title("Queretaro"));

    }

    private void natureMarkers(){


        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nature_marker))
                .position(sumidero)).setTitle("Canon del Sumidero");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_flamingo))
                .position(celestun)).setTitle("Ria Celestun");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_toucan))
                .position(aguaAzul)).setTitle("Cascades Agua Azul");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nature_marker))
                .position(misolHa)).setTitle("Misol-Ha");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_tule_tree))
                .position(tule)).setTitle("Santa Maria de el Tule");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cave))
                .position(cacahuamilpa)).setTitle("Grutas de Cacahuamilpa");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_waterfall))
                .position(eiypantla)).setTitle("Eiypantla");

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nature_marker))
                .position(hierveElAgua)).setTitle("Hierve el Agua");
        
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        // Add a marker in Sydney and move the camera

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(oaxaca, 4.75f));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menuMap) {
        getMenuInflater().inflate(R.menu.menu_map, menuMap);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch(id) {

            case R.id.maptype_normal: {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            }
            case R.id.maptype_satellite: {
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            }
            case R.id.maptype_terrain: {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            }
            case R.id.maptype_hybrid: {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            }
            case R.id.zones_marker: {
                mMap.clear();
                zoneMarkers();
                break;
            }
            case R.id.cities_marker: {
                mMap.clear();
                cityMarkers();
                break;
            }
            case R.id.nature_marker: {
                mMap.clear();
                natureMarkers();
                break;
            }
            case R.id.all_markers: {
                mMap.clear();
                zoneMarkers();
                cityMarkers();
                natureMarkers();
                break;
            }
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
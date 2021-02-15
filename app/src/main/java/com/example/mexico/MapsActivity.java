package com.example.mexico;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
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

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    GoogleApiClient googleApiClient;


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
    final LatLng cancun = new LatLng(21.161276, -86.827562);
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
        if (googleServicesAvailable()) {
            Toast.makeText(this, "Connected to play services", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_maps);
            initMap();
        } else {
            // No Google Maps Layout
        }

        Toolbar toolbar = findViewById(R.id.materialToolbar);
        setActionBar(toolbar);

        getActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public boolean googleServicesAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if (isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(isAvailable)) {
            Dialog dialog = api.getErrorDialog(this, isAvailable, 0);
            dialog.show();
        } else {
            Toast.makeText(this, "Can\'t connect to play services", Toast.LENGTH_LONG).show();
        }
        return false;

    }


    private void zoneMarkers() {

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_teotihuacan))
                .position(teotihuacan).title("Teotihuacan")
                .snippet("Place where Men bacome to the Gods" + "\n" + "\n"
                        + getResources().getString(R.string.snippet_cholula)));


        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cholula))
                .position(cholula).title("Cholula")
                .snippet(getResources().getString(R.string.snippet_cholula)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mitla))
                .position(monteAlban).title("Monte Alban")
                .snippet("White Mountain" + "\n" + "\n"
                        + getResources().getString(R.string.snippet_monte_alban)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mitla))
                .position(mitla).title("Mitla")
                .snippet("A place of good rest" + "\n" + "\n"
                        + getResources().getString(R.string.snippet_mitla)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_pakal))
                .position(palenque).title("Palenque")
                .snippet("Palisade" + "\n" + "\n"
                        + getResources().getString(R.string.snippet_palenque)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_uxmal))
                .position(uxmal).title("Uxmal")
                .snippet("Three times builded" + "\n" + "\n"
                        + getResources().getString(R.string.snippet_uxmal)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_kukulkan))
                .position(chichenItza).title("Chichen Itza")
                .snippet("At the mouth of the well of the Itza" + "\n" + "\n"
                        + getResources().getString(R.string.snippet_chichen_itza)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_tulum))
                .position(tulum).title("Tulum")
                .snippet("Walls" + "\n" + "\n"
                        + getResources().getString(R.string.snippet_tulum)));
    }

    private void cityMarkers() {

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(oaxaca).title("Oaxaca de Juarez")
                .snippet(getResources().getString(R.string.snippet_oaxaca)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(cdmx).title("CDMX")
                .snippet(getResources().getString(R.string.snippet_cdmx)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(taxco).title("Taxco de Alarcon")
                .snippet(getResources().getString(R.string.snippet_taxco)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(acapulco).title("Acapulco de Juarez")
                .snippet(getResources().getString(R.string.snippet_acapulco)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(puebla).title("Puebla")
                .snippet(getResources().getString(R.string.snippet_puebla)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(sanCristobal).title("San Cristobal de las Casas")
                .snippet(getResources().getString(R.string.snippet_san_cristobal)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(campeche).title("Campeche")
                .snippet(getResources().getString(R.string.snippet_campeche)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(merida).title("Merida")
                .snippet(getResources().getString(R.string.snippet_merida)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(cancun).title("Cancun")
                .snippet(getResources().getString(R.string.snippet_cancun)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cities_marker2_red))
                .position(queretaro).title("Queretaro")
                .snippet(getResources().getString(R.string.snippet_queretaro)));

    }

    private void natureMarkers() {


        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nature_marker))
                .position(sumidero).title("Canon del Sumidero")
                .snippet(getResources().getString(R.string.snippet_sumidero)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_flamingo))
                .position(celestun).title("Ria Celestun")
                .snippet(getResources().getString(R.string.snippet_celestun)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_toucan))
                .position(aguaAzul).title("Cascades Agua Azul")
                .snippet(getResources().getString(R.string.snippet_agua_azul)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nature_marker))
                .position(misolHa).title("Misol-Ha")
                .snippet(getResources().getString(R.string.snippet_misol_ha)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_tule_tree))
                .position(tule).title("Santa Maria de el Tule")
                .snippet(getResources().getString(R.string.snippet_tule)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cave))
                .position(cacahuamilpa).title("Grutas de Cacahuamilpa")
                .snippet(getResources().getString(R.string.snippet_cacahuamilpa)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_waterfall))
                .position(eiypantla).title("Eiypantla")
                .snippet(getResources().getString(R.string.snippet_eiypantla)));

        mMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_nature_marker))
                .position(hierveElAgua).title("Hierve el Agua")
                .snippet(getResources().getString(R.string.snippet_hierve_el_agua)));

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        }

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

                Geocoder gc = new Geocoder(MapsActivity.this);
                LatLng ll = marker.getPosition();
                List<Address> list = null;
                try {
                    list = gc.getFromLocation(ll.latitude, ll.longitude, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Address add = list.get(0);
                marker.setTitle(add.getLocality());
                marker.showInfoWindow();

            }
        });

        if (mMap != null) {
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View v = getLayoutInflater().inflate(R.layout.info_window, null);

                    TextView tvLocality = v.findViewById(R.id.tv_locality);
                    TextView tvSnippet = v.findViewById(R.id.tv_snippet);

                    //LatLng ll = marker.getPosition();
                    tvLocality.setText(marker.getTitle());
                    tvSnippet.setText(marker.getSnippet());

                    return v;
                }
            });
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }

        }

        mMap.setMyLocationEnabled(true);
        goToLocationZoom(23.077740, -102.671084, 4);
        //mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);



        // Add a marker in Sydney and move the camera

        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(oaxaca, 4.75f));

//        googleApiClient = new GoogleApiClient.Builder(this)
//                .addApi(LocationServices.API)
//                .addConnectionCallbacks(this)
//                .build();
//        googleApiClient.connect();

    }

    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private void goToLocation(double lat, double lng) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLng(ll);
        mMap.moveCamera(update);
    }

    private void goToLocationZoom(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mMap.moveCamera(update);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menuMap) {
        getMenuInflater().inflate(R.menu.menu_map, menuMap);
        return true;
    }

    Marker marker;

    public void geoLocate(View view) throws IOException {

        EditText et = findViewById(R.id.editText);
        String location = et.getText().toString();

        Geocoder gc = new Geocoder(this);
        List<Address> list = gc.getFromLocationName(location, 1);
        Address address = list.get(0);
        String locality = address.getLocality();

        Toast.makeText(this, locality, Toast.LENGTH_LONG).show();

        double lat = address.getLatitude();
        double lng = address.getLongitude();
        goToLocationZoom(lat, lng, 15);

        hideKeyBoard();

        setMarker(locality, lat, lng);

    }

    private void setMarker(String locality, double lat, double lng) {
        if (marker != null) {
            marker.remove();
        }

        MarkerOptions options = new MarkerOptions()
                .title(locality)
                .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN))
                .position(new LatLng(lat, lng))
                .snippet("I am here");
        marker = mMap.addMarker(options);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {

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

    public void hideKeyBoard() {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.
                INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

    }

    LocationRequest mLocationRequest;

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(1000);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            LocationServices.FusedLocationApi.requestLocationUpdates(
                    googleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        if (location == null) {
            Toast.makeText(this, "Unable to get current location", Toast.LENGTH_LONG).show();
        }else {
            LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, 15);
            mMap.animateCamera(update);
        }


    }
}
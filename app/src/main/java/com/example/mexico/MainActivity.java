package com.example.mexico;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.widget.ShareActionProvider;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;
    private String[] titles;
    private ListView drawerList;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private int currentPosition = 0;

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        titles = getResources().getStringArray(R.array.titles);
        drawerList = (ListView) findViewById(R.id.drawer);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Określamy zawartość widoku ListView:
        drawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, titles));

        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        // Wyświatlamy odpowiedni fragment:
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("position");
            setActionBarTitle(currentPosition);
        }else {
            selectItem(0);
        }

        // Tworzymy obiekt ActionBarDrawerToggle
        drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, R.string.open_drawer, R.string.close_drawer) {

            // Wywołana, kiedy stan szuflady odpowiada jej zamknięciu:
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                // Kod który ma zastać wywołany gdy szuflada zostanie zamknięta:
                supportInvalidateOptionsMenu();
        }

        // Wywołana, kiedy stan szuflady odpowiada jej otwarciu:
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                // Kod który ma zostać wywołany gdy szuflada zostanie otwarta:
                supportInvalidateOptionsMenu();
            }
        };

        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    @Override
                    public void onBackStackChanged() {
                        // Kod wykonywany po zmianie stanu stosu cofnięć:
                        FragmentManager fragMan = getSupportFragmentManager();
                        Fragment fragment = fragMan.findFragmentByTag("visible_fragment");
                        if (fragment instanceof TopFragment) {
                            currentPosition = 0;
                        }

                        if (fragment instanceof ZonesMaterialFragment) {
                            currentPosition = 1;
                        }

                        if (fragment instanceof CitiesMaterialFragment) {
                            currentPosition = 2;
                        }

                        if (fragment instanceof NaturesMaterialFragment) {
                            currentPosition = 3;
                        }

                        setActionBarTitle(currentPosition);
                        drawerList.setItemChecked(currentPosition, true);
                    }
                }
        );

    }

    private void selectItem(int position) {

        // Aktualizujemy główną zawartość aplikacji, podmieniając prezentowany fragment
        currentPosition = position;

        Fragment fragment;
        switch(position) {
            case 1:
                fragment = new ZonesMaterialFragment();
                break;
            case 2:
                fragment = new CitiesMaterialFragment();
                break;
            case 3:
                fragment = new NaturesMaterialFragment();
                break;
            default:
                fragment = new TopFragment();
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment, "visible_fragment");
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        // Ustawiamy tytuł Action Bara:
        setActionBarTitle(position);

        // Zamykamy szufladę nawigacyjną:
        drawerLayout.closeDrawer(drawerList);
    }

    // Ta metoda jest wywoływana po każdym wywołaniu metody invalidateOptionsMenu()
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        // Jeśli szuflada jest otwarta, ukrywamy elementy akcji związane z prezentowaną zawartością
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
        menu.findItem(R.id.action_share).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Synchronizujemy stan przycisku przełącznika po wywołaniu metody onRestoreInstanceState:
        drawerToggle.syncState();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", currentPosition);
    }

    private void setActionBarTitle(int position) {

        String title;
        if (position == 0) {
            title = getResources().getString(R.string.app_name);
        }else {
            title = titles[position];
        }

        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Przygotowujemy menu; jeśli jest pasek akcji, to dodajemy do niego elementy
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setIntent("Przykładowy tekst.");

        return true;
    }

    private void setIntent(String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       if (drawerToggle.onOptionsItemSelected(item)) {
           return true;
       }

        switch (item.getItemId()) {

            case R.id.action_go_web:
                // Kod do przeglądarki chrome
                Intent intent2 = new Intent(this, WebsiteActivity.class);
                intent2.putExtra("url", "https://google.com/");
                startActivity(intent2);
                return true;
            case R.id.action_settings:
                // Kod do Ustawien
                return true;
            case R.id.map_mexico:
                Intent intent3 = new Intent(this, MapsActivity.class);
                startActivity(intent3);

            default:
                return super.onOptionsItemSelected(item);
        }
    }





}
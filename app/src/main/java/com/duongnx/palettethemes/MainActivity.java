package com.duongnx.palettethemes;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.duongnx.configs.GApplication;
import com.duongnx.configs.utils.Utils;
import com.duongnx.palettethemes.fragments.FrgAbout;
import com.duongnx.palettethemes.fragments.FrgPreview;
import com.duongnx.palettethemes.fragments.FrgSliddingTabsColor;
import com.duongnx.palettethemes.fragments.FrgTemplate;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String[] colorNames;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(GApplication.getInstance().getThemeType().getThemeId());
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, 0, 0);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setTitle(getString(R.string.color_palette));
        changeMenuFragment(new FrgSliddingTabsColor());
        loadNames();
    }

    public String[] getColorNames() {
        return colorNames;
    }

    private void loadNames() {
        TypedArray typedArray = getResources().obtainTypedArray(R.array.color_names);
        colorNames = new String[typedArray.length()];
        for (int i = 0; i < typedArray.length(); i++) {
            colorNames[i] = typedArray.getString(i);
        }
        typedArray.recycle();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_view_source:
                Utils.startActivityWithUrl(this, Defines.GIT_MY_SOURCE);
                break;
            case R.id.menu_rate: {
                Utils.startActivityWithUrl(this, Defines.RATE);
                break;
            }
            case R.id.menu_more: {
                Utils.startActivityWithUrl(this, Defines.MORE_APPS);
            }
            break;
        }
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_color:
                setTitle(getString(R.string.color_palette));
                floatingActionButton.setVisibility(View.VISIBLE);
                changeMenuFragment(new FrgSliddingTabsColor());
                break;
            case R.id.nav_theme:
                setTitle(getString(R.string.material_theme));
                floatingActionButton.setVisibility(View.GONE);
                changeMenuFragment(new FrgTemplate());
                break;
            case R.id.nav_about:
                setTitle(getString(R.string.about));
                floatingActionButton.setVisibility(View.GONE);
                changeMenuFragment(new FrgAbout());
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void changeMenuFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content, fragment);
            //fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
            fragmentTransaction.commitAllowingStateLoss();
        }
    }

    public FloatingActionButton getFloatingActionButton() {
        return floatingActionButton;
    }
}

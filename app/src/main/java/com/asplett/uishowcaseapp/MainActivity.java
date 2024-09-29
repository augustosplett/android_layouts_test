package com.asplett.uishowcaseapp;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar o DrawerLayout e o NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configurar o botão de menu para abrir o Drawer
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        loadFragment(new LinearLayoutDemo());
//        // Configurar navegação do Navigation Drawer
//        navigationView.setNavigationItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.page1:
//                    loadFragment(new LinearLayoutDemo());
//                    break;
////                case R.id.nav_settings:
////                    loadFragment(new SettingsFragment());
////                    break;
////                case R.id.nav_language:
////                    showLanguageDialog();
////                    break;
//            }
//            drawerLayout.closeDrawers(); // Fechar o Drawer após a seleção
//            return true;
//        });

//        // Exibir o primeiro fragmento ao iniciar
//        if (savedInstanceState == null) {
//            loadFragment(new LinearLayoutDemo());
//        }
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    // Método para mostrar o diálogo de seleção de idioma
    public void showLanguageDialog() {
        final String[] languages = {"English", "Français"};

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Select Language");
        mBuilder.setSingleChoiceItems(languages, -1, (dialog, which) -> {
            if (which == 0) {
                setLocale("en");  // Mudar para inglês
            } else if (which == 1) {
                setLocale("fr");  // Mudar para francês
            }
            dialog.dismiss();
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    // Método para mudar o idioma
    public void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }
        resources.updateConfiguration(config, resources.getDisplayMetrics());

        // Reiniciar a Activity para aplicar o novo idioma
        recreate();
    }
}
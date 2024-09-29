package com.asplett.uishowcaseapp;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

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

    //declarando as variáveis que vamos precisar para fazer o menu funcionar
    private DrawerLayout main; //activity_main.xml
    private NavigationView navigationView;//navigation view incluída na main activity
    private ActionBarDrawerToggle drawerToggle;//chave para mostrar/esconde o menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //relacionando o XML com a Classe para poder implementar a lógica
        main = findViewById(R.id.main);
        navigationView = findViewById(R.id.navigation_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //botao para mudar idioma
        Button toolbarButton = findViewById(R.id.toolbar_button);
        toolbarButton.setOnClickListener(v -> {
            toggleLanguage();
        });

        //criando e inserindo o btãoq ue vai mostrar ou ocultar o menu
        drawerToggle = new ActionBarDrawerToggle(this, main, toolbar, R.string.drawer_open, R.string.drawer_close);
        main.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        //logica de controle de mudança de página, neste caso, estou usando fragments
        navigationView.setNavigationItemSelectedListener(item -> {
            Log.d("item", "id do item:" + item.getItemId());
            if (item.getItemId() == R.id.page1) {
                loadFragment(new LinearLayoutDemo());
            } else if (item.getItemId() == R.id.page2) {
                loadFragment(new ConstraintLayoutDemo());
            } else if (item.getItemId() == R.id.page3) {
                loadFragment(new GridLayoutDemo());
            } else if (item.getItemId() == R.id.page4) {
                loadFragment(new ListLayoutDemo());
            }
            //fecha o menu apos alterar o fragment
            main.closeDrawers();
            return true;
        });
        //aqui define qual vai ser o primeiro elemento a ser carregado caso o usuário nunca tenha usado o app
        if (savedInstanceState == null) {
            loadFragment(new LinearLayoutDemo());
        }
    }
    //função que carrega o fragmento desejado na tela
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
    //função que muda a linguagem
    public void toggleLanguage() {
        String currentLanguage = getResources().getConfiguration().locale.getLanguage();

        if (currentLanguage.equals("en")) {
            setLocale("fr");
        } else {
            setLocale("en");
        }
    }
    //recarrega as infos com a nova linguagem
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

        recreate();
    }
}
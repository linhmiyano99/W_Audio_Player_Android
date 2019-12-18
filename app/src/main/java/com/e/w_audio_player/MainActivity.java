package com.e.w_audio_player;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MakeTransparentStatusBar();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.setting) {
            Toast.makeText(MainActivity.this, "Action Settings clicked", Toast.LENGTH_LONG).show();
            return true;
        }
        if(id == R.id.equalizer){
            Toast.makeText(MainActivity.this, "Action EQ click", Toast.LENGTH_LONG).show();
            return true;
        }

        if(id == R.id.action_search){
            Intent intent = new Intent(this,SearchActivity.class);
            startActivity(intent);

        }
        if(id == R.id.recognizeSongs){
            Intent intent = new Intent(this,RecognizeSongsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menuItem);
    }



}

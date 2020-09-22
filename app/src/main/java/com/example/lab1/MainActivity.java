package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goNewCompte(View view) {
        Intent i = new Intent(this,new_compte.class);
        startActivity(i);
    }

    public void goListeClient(View view) {
        Intent i = new Intent(this,liste_client.class);
        startActivity(i);
    }

    public void goListeClientD(View view) {
        Intent i = new Intent(this,liste_client_d.class);
        startActivity(i);
    }
}

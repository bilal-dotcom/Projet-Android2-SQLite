package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class liste_client_d extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_client_d);


        MyDbAdapter myDbAdapter = new MyDbAdapter(getApplicationContext());
        myDbAdapter.Open();
        // myDbAdapter.InsertCompte("bil","prenom","ad","ise","pw33",12,1);

        ListView listView = (ListView)findViewById(R.id.listClientD);
        ArrayList<compte> compteArrayList = new ArrayList<compte>();


        compteArrayList = myDbAdapter.SelectCompteD();
        //     Log.i("dbTest",String.valueOf(compteArrayList.size()));

        // compteArrayList.add(new compte("Mecatronique","Electronique Industriel"));
        //compteArrayList.add(new compte("nom2"," Industriel"));


        CompteArrayAdapterD adapter = new CompteArrayAdapterD(this,R.layout.mon_layout2,compteArrayList);
        listView.setAdapter(adapter);
    }

    public void goAcceuil(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}

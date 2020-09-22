package com.example.lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CompteArrayAdapterD extends ArrayAdapter<compte> {

    private Context context;
    private ArrayList<compte> lcD;
    private int resource;


    public CompteArrayAdapterD(@NonNull Context context, int resource, @NonNull List<compte> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        lcD = new ArrayList<compte>();
        lcD = (ArrayList<compte>)objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        compte ptemp = this.lcD.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(this.resource,parent,false);

        TextView nom = (TextView)convertView.findViewById(R.id.lblnomD);
        TextView prenom = (TextView)convertView.findViewById(R.id.lblprenomD);
        TextView credit = (TextView)convertView.findViewById(R.id.lblcreditD);
        TextView solde = (TextView)convertView.findViewById(R.id.lblsoldeD);

        nom.setText("Nom:"+ptemp.getNom());
        prenom.setText("Prenom:"+ptemp.getPrenom());
        credit.setText("Credit:"+ptemp.getCredit());
        solde.setText("Solde:"+ptemp.getSolde());

        return convertView;
    }
}

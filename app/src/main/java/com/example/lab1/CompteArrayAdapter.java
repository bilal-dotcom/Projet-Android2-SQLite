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

public class CompteArrayAdapter extends ArrayAdapter<compte> {

    private Context context;
    private ArrayList<compte> lc;
    private int resource;


    public CompteArrayAdapter(@NonNull Context context, int resource, @NonNull List<compte> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        lc = new ArrayList<compte>();
        lc = (ArrayList<compte>)objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        compte ptemp1 = this.lc.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(this.resource,parent,false);

        TextView id1 = (TextView)convertView.findViewById(R.id.lblid);
        TextView nom1 = (TextView)convertView.findViewById(R.id.lblnom);
        TextView prenom1 = (TextView)convertView.findViewById(R.id.lblprenom);

        id1.setText("Id:" +ptemp1.getId());
        nom1.setText("Nom:"+ptemp1.getNom());
        prenom1.setText("Prenom:"+ptemp1.getPrenom());

        return convertView;
    }
}

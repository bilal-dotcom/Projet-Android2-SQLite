package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class new_compte extends AppCompatActivity {

    private Button btn,btn2;
    private EditText txtId,txtNom,txtPrenom,txtAdresse,txtUser,txtPw,txtSolde,txtCredit;
    private String newNom;
    private String newPrenom;
    private String newAdresse;
    private String newUser;
    private String newPw;
    private int newId,newCredit, newSolde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_compte);

        //Creer compte
        this.btn=(Button)findViewById(R.id.creerCompte);
        this.btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    txtNom=(EditText)findViewById(R.id.nom);
                    txtPrenom=(EditText)findViewById(R.id.prenom);
                    txtAdresse=(EditText)findViewById(R.id.adresse);
                    txtUser=(EditText)findViewById(R.id.userName);
                    txtPw=(EditText)findViewById(R.id.pw);
                    txtSolde=(EditText)findViewById(R.id.solde);
                    txtCredit=(EditText)findViewById(R.id.credit);

                    newNom = txtNom.getText().toString();
                    newPrenom = txtPrenom.getText().toString();
                    newAdresse =txtAdresse.getText().toString();
                    newUser = txtUser.getText().toString();
                    newPw = txtPw.getText().toString();
                    newSolde = Integer.parseInt(txtSolde.getText().toString());
                    newCredit = Integer.parseInt(txtCredit.getText().toString());

                    try
                    {
                        newSolde = Integer.parseInt(txtSolde.getText().toString());
                        newCredit = Integer.parseInt(txtCredit.getText().toString());
                    }
                    catch (NumberFormatException e)
                    {
                        // handle the exception
                        newSolde=0;
                        newCredit=0;
                    }

                    MyDbAdapter myDbAdapter = new MyDbAdapter(getApplicationContext());
                    myDbAdapter.Open();
                    myDbAdapter.InsertCompte(newNom,newPrenom,newAdresse,newUser,newPw,newSolde,newCredit);
                    Toast.makeText(new_compte.this,"Data Insert",Toast.LENGTH_LONG).show();

//                    txtId.setText("");
//                    txtNom.setText("");
//                    txtPrenom.setText("");
//                    txtAdresse.setText("");
//                    txtUser.setText("");
//                    txtPrenom.setText("");
//                    txtCredit.setText("");
//                    txtSolde.setText("");
//                    ArrayList<compte> ls = new ArrayList<compte>();
//                    ls = myDbAdapter.SelectAllCompte();
//                    Log.i("dbTest",String.valueOf(ls.size()));
                }
                catch (Exception ex)
                {
                    Log.i("Page Error",ex.getMessage());
                    Toast.makeText(new_compte.this,"Ereeur",Toast.LENGTH_LONG).show();
                }
            }
        });


                //Effacer compte
        this.btn2=(Button)findViewById(R.id.effacerCompte);
        this.btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    txtId=(EditText)findViewById(R.id.id);

                    newId = Integer.parseInt(txtId.getText().toString());

                    MyDbAdapter myDbAdapter = new MyDbAdapter(getApplicationContext());
                    myDbAdapter.Open();
                    myDbAdapter.effacerCompte(newId);
                    Toast.makeText(new_compte.this,"Data Delete",Toast.LENGTH_LONG).show();

                }
                catch (Exception ex)
                {
                    Log.i("Page Error",ex.getMessage());
                    Toast.makeText(new_compte.this,"Erreur de suppression",Toast.LENGTH_LONG).show();
                }
            }
        });


        //mODIFIER compte
        this.btn2=(Button)findViewById(R.id.modifierCompte);
        this.btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    txtId=(EditText)findViewById(R.id.id);
                    txtNom=(EditText)findViewById(R.id.nom);
                    txtPrenom=(EditText)findViewById(R.id.prenom);
                    txtSolde=(EditText)findViewById(R.id.solde);
                    txtCredit=(EditText)findViewById(R.id.credit);


                    newId = Integer.parseInt(txtId.getText().toString());
                    newNom=txtNom.getText().toString();
                    newPrenom=txtPrenom.getText().toString();
                    newSolde = Integer.parseInt(txtSolde.getText().toString());
                    newCredit = Integer.parseInt(txtCredit.getText().toString());

                    MyDbAdapter myDbAdapter = new MyDbAdapter(getApplicationContext());
                    myDbAdapter.Open();
                    myDbAdapter.modifierStudent(newId,newNom,newPrenom,newSolde,newCredit);
                    Toast.makeText(new_compte.this,"Data Update",Toast.LENGTH_LONG).show();

                }
                catch (Exception ex)
                {
                    Log.i("Page Error",ex.getMessage());
                    Toast.makeText(new_compte.this,"Erreur de Update",Toast.LENGTH_LONG).show();
                }
            }
        });



    }

    public void goAcceuil(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

}

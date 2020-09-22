package com.example.lab1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MyDbAdapter {
    private Context context;
    private final String DATABASE_NAME ="MaDb";
    private MyDbHelper dbHelper;
    private final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public MyDbAdapter(Context context)
    {
        this.context = context;
        this.dbHelper = new MyDbHelper(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void Open()
    {
        this.db = this.dbHelper.getWritableDatabase();
    }

    public void InsertCompte( String nom, String prenom, String adresse, String user, String pw, int solde, int credit)
    {

        this.db.execSQL("INSERT INTO account(nom,prenom,adresse,user,pw,solde ,credit) values('" +nom + "','" +prenom + "', '" +adresse + "', '" +user + "', '" +pw + "', " +solde + "," +credit+ ")");
        // this.db.execSQL("INSERT INTO compte(id,nom,prenom,adresse,user,pw,solde ,credit ) values('"+id+"','"+ prenom +"',prenom,adresse,user,pw,solde,credit);");

    }

    public ArrayList<compte> SelectAllCompte()
    {

        ArrayList<compte> listOfClient = new ArrayList<compte>();
        Cursor cursor = this.db.query("account",null,null,null,null,null,null);

        int idIndex = cursor.getColumnIndex("id");
        int nomIndex = cursor.getColumnIndex("nom");
        int prenomIndex = cursor.getColumnIndex("prenom");
        int adressIndex = cursor.getColumnIndex("adresse");
        int userIndex = cursor.getColumnIndex("user");
        int pwIndex = cursor.getColumnIndex("pw");
        int soldeIndex = cursor.getColumnIndex("solde");
        int creditIndex = cursor.getColumnIndex("credit");

        if((cursor != null) && cursor.moveToFirst())
        {
            do{
                listOfClient.add(new compte(cursor.getInt(idIndex),cursor.getString(nomIndex),cursor.getString(prenomIndex),cursor.getString(adressIndex),
                        cursor.getString(userIndex),cursor.getString(pwIndex),cursor.getInt(soldeIndex),cursor.getInt(creditIndex)));
            }while(cursor.moveToNext());
        }

        return listOfClient;


    }

    public ArrayList<compte> SelectCompteD() {

               ArrayList<compte> listOfClient = new ArrayList<compte>();

        Cursor cursor = this.db.rawQuery("select * from account where solde > credit",null);

        int idIndex = cursor.getColumnIndex("id");
        int nomIndex = cursor.getColumnIndex("nom");
        int prenomIndex = cursor.getColumnIndex("prenom");
        int adressIndex = cursor.getColumnIndex("adresse");
        int userIndex = cursor.getColumnIndex("user");
        int pwIndex = cursor.getColumnIndex("pw");
        int soldeIndex = cursor.getColumnIndex("solde");
        int creditIndex = cursor.getColumnIndex("credit");

        if((cursor != null) && cursor.moveToFirst())
        {
            do{

                listOfClient.add(new compte(cursor.getInt(idIndex),cursor.getString(nomIndex),cursor.getString(prenomIndex),cursor.getString(adressIndex),
                        cursor.getString(userIndex),cursor.getString(pwIndex),cursor.getInt(soldeIndex),cursor.getInt(creditIndex)));
            }while(cursor.moveToNext());
        }

                 return listOfClient;

    }

    public void effacerCompte(int id)

    {
        this.db.execSQL("delete from account where id = "+ id +" ;");
    }

    public void deleteAllCompte()
    {
        this.db.delete("account",null,null);
        // this.db.execSQL("DELETE FROM COMPTE  ;");
    }



    public void modifierStudent2(String nom,int id)
    {
        this.db.execSQL("update account set nom = '" + nom +"' where id= "+ id +";");
    }

    public void modifierStudent(int id,String nom,String prenom,int solde,int credit)
    {
        this.db.execSQL("update account set nom = '" + nom +"', prenom='" + prenom +"', solde="+solde+", credit = "+credit+"  where id= "+ id +";");
    }


}

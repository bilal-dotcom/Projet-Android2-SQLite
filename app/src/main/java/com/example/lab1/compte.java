package com.example.lab1;

import java.io.Serializable;

public class compte implements Serializable {

    private int id;
    private  String nom;
    private String prenom;
    private  String adresse;
    private String user;
    private  String pw;
    private int solde;
    private int credit;


    public compte(int id, String nom, String prenom, String adresse, String user, String pw, int solde, int credit) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.user = user;
        this.pw = pw;
        this.solde = solde;
        this.credit = credit;
        this.id =id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}

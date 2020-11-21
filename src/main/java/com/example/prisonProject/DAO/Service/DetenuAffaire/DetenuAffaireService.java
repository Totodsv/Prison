package com.example.prisonProject.DAO.Service.DetenuAffaire;


import com.example.prisonProject.POJO.DetenuAffaire;

public interface DetenuAffaireService {
    DetenuAffaire createDetenuAffaire(String n_ecrou, String n_affaire, String nom_juridiction);
    DetenuAffaire readDetenuAffaire(String n_ecrou, String n_affaire, String nom_juridiction);
    DetenuAffaire updateDetenuAffaire(String n_ecrou, String n_affaire, String nom_juridiction); //Inutile
    void deleteDetenuAffaire(String n_ecrou, String n_affaire, String nom_juridiction);
}

package com.example.prisonProject.DAO.Service.Detenu;

import com.example.prisonProject.POJO.Detenu;

import java.sql.Date;

public interface DetenuService {
    Detenu createDetenu(String n_ecrou, String prenom, String nom, Date dateNaissance, String lieuNaissance);
    Detenu readDetenu(String n_ecrou);
    Detenu updateDetenu(String n_ecrou, String prenom, String nom, Date dateNaissance, String lieuNaissance);
    void deleteDetenu(String n_ecrou);
}

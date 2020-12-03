package com.example.prisonProject.DAO.Service.Incarceration;

import com.example.prisonProject.POJO.DetenuAffaire;
import com.example.prisonProject.POJO.Incarceration;
import com.example.prisonProject.POJO.Motif;

import java.sql.Date;
import java.util.List;

public interface IncarcerationService {
    Incarceration createIncarceration(String nEcrou, Date dateIncarceration, DetenuAffaire detenuAffaire, Motif motifByNMotif);
    Incarceration readIncarceration(String nEcrou);
    Incarceration updateIncarceration(String nEcrou, Date dateIncarceration, String n_affaire, String nom_juridiction);
    void deleteIncarceration(String nEcrou);
    List<Incarceration> readAllIncarcerations();
}

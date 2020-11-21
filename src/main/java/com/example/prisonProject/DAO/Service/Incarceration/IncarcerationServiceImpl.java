package com.example.prisonProject.DAO.Service.Incarceration;

import com.example.prisonProject.DAO.Repository.IncarcerationRepository;
import com.example.prisonProject.POJO.DetenuAffaire;
import com.example.prisonProject.POJO.Incarceration;
import com.example.prisonProject.POJO.Motif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class IncarcerationServiceImpl implements IncarcerationService {

    @Autowired
    private IncarcerationRepository incarcerationRepository;

    @Override
    public Incarceration createIncarceration(String nEcrou, Date dateIncarceration, DetenuAffaire detenuAffaire, Motif motifByNMotif){
        Incarceration i = new Incarceration();
        i.setnEcrou(nEcrou);
        i.setDateIncarceration(dateIncarceration);
        i.setDetenuAffaire(detenuAffaire);
        i.setMotifByNMotif(motifByNMotif);
        return incarcerationRepository.save(i);
    }

    @Override
    public Incarceration readIncarceration(String nEcrou){
        return incarcerationRepository.findIncarcerationBynEcrou(nEcrou);
    }

    @Override
    public Incarceration updateIncarceration(String nEcrou, Date dateIncarceration, String n_affaire, String nom_juridiction){
        Incarceration i = incarcerationRepository.findIncarcerationBynEcrou(nEcrou);
        i.setDateIncarceration(dateIncarceration);
        i.setNumAffaire(n_affaire);
        i.setNomJuridiction(nom_juridiction);
        return incarcerationRepository.save(i);
    }

    @Override
    public void deleteIncarceration(String nEcrou){
        Incarceration i = incarcerationRepository.findIncarcerationBynEcrou(nEcrou);
        incarcerationRepository.delete(i);
    }
}

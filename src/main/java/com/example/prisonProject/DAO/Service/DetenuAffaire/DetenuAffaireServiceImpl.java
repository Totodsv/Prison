package com.example.prisonProject.DAO.Service.DetenuAffaire;

import com.example.prisonProject.DAO.Repository.DetenuAffaireRepository;
import com.example.prisonProject.POJO.DetenuAffaire;
import com.example.prisonProject.POJO.Incarceration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class DetenuAffaireServiceImpl implements DetenuAffaireService {
    @Autowired
    private DetenuAffaireRepository detenuAffaireRepository;

    @Override
    public DetenuAffaire createDetenuAffaire(String n_ecrou, String n_affaire, String nom_juridiction) {
        DetenuAffaire d = new DetenuAffaire();
        d.setnEcrou(n_ecrou);
        d.setNumAffaire(n_affaire);
        d.setNomJuridiction(nom_juridiction);
        Collection<Incarceration> incarcerations = Collections.emptyList();
        d.setIncarcerations(incarcerations);
        return detenuAffaireRepository.save(d);
    }

    @Override
    public DetenuAffaire readDetenuAffaire(String n_ecrou, String n_affaire, String nom_juridiction) {
        return detenuAffaireRepository.findDetenuAffaireBynEcrouAndNumAffaireAndNomJuridiction(n_ecrou,n_affaire,nom_juridiction);
    }

    @Override
    public DetenuAffaire updateDetenuAffaire(String n_ecrou, String n_affaire, String nom_juridiction) {
        return null;
    }

    @Override
    public void deleteDetenuAffaire(String n_ecrou, String n_affaire, String nom_juridiction) {
        DetenuAffaire d = detenuAffaireRepository.findDetenuAffaireBynEcrouAndNumAffaireAndNomJuridiction(n_ecrou,n_affaire,nom_juridiction);
        detenuAffaireRepository.delete(d);
    }
}

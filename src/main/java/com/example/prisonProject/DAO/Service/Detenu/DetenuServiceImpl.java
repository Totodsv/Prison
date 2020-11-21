package com.example.prisonProject.DAO.Service.Detenu;

import com.example.prisonProject.DAO.Repository.DetenuRepository;
import com.example.prisonProject.POJO.Detenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;


@Service
public class DetenuServiceImpl implements DetenuService {
    @Autowired
    private DetenuRepository detenuRepository;

    @Override
    public Detenu createDetenu(String n_ecrou, String prenom, String nom, Date dateNaissance, String lieuNaissance){
        Detenu d = new Detenu();
        d.setnEcrou(n_ecrou);
        d.setPrenom(prenom);
        d.setNom(nom);
        d.setDateNaissance(dateNaissance);
        d.setLieuNaissance(lieuNaissance);

        return detenuRepository.save(d);
    }

    @Override
    public Detenu readDetenu(String n_ecrou){
        return detenuRepository.findDetenuBynEcrou(n_ecrou);
    }

    @Override
    public Detenu updateDetenu(String n_ecrou, String prenom, String nom, Date dateNaissance, String lieuNaissance){
        Detenu d = detenuRepository.findDetenuBynEcrou(n_ecrou);
        d.setPrenom(prenom);
        d.setNom(nom);
        d.setDateNaissance(dateNaissance);
        d.setLieuNaissance(lieuNaissance);
        return detenuRepository.save(d);
    }

    @Override
    public void deleteDetenu(String n_ecrou){
        Detenu d = detenuRepository.findDetenuBynEcrou(n_ecrou);
        detenuRepository.delete(d);
    }
}

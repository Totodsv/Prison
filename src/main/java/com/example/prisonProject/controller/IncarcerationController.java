package com.example.prisonProject.controller;

import com.example.prisonProject.DAO.Service.Affaire.AffaireService;
import com.example.prisonProject.DAO.Service.Detenu.DetenuService;
import com.example.prisonProject.DAO.Service.DetenuAffaire.DetenuAffaireService;
import com.example.prisonProject.DAO.Service.Incarceration.IncarcerationService;
import com.example.prisonProject.DAO.Service.Motif.MotifService;
import com.example.prisonProject.POJO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;


@Controller
public class IncarcerationController {

    @Autowired
    private DetenuService detenuService;
    @Autowired
    private IncarcerationService incarcerationService;
    @Autowired
    private AffaireService affaireService;
    @Autowired
    private MotifService motifService;
    @Autowired
    private DetenuAffaireService detenuAffaireService;

    @PostMapping(value = "/createIncarceration")
    public Incarceration createIncarceration(HttpServletRequest request, @Valid Incarceration incarceration) {
        Date dateDetenu = new Date(1996-1900, 11-1, 18);
        Date dateIncarceration = new Date(2019-1900, 11-1, 13);
        Date dateAffaire = new Date(2019-1900, 7-1, 11);

        Detenu detenu1 = detenuService.createDetenu("1966", "Julien", "Bercot", dateDetenu, "Nantes");
        Affaire affaire = affaireService.createAffaire("46", "Pau", dateAffaire);
        DetenuAffaire detenuAffaire = detenuAffaireService.createDetenuAffaire(detenu1.getnEcrou(),affaire.getNumAffaire(),affaire.getNomJuridiction());

        Motif motif = motifService.createMotif("12","abus de confiance");
        Incarceration incarcerationDetenu = incarcerationService.createIncarceration("1966",dateIncarceration, detenuAffaire,motif);
        detenuAffaire.ajouterIncarceration(incarcerationDetenu);
        incarcerationService.updateIncarceration(incarcerationDetenu.getnEcrou(),incarcerationDetenu.getDateIncarceration(),detenuAffaire.getNumAffaire(),detenuAffaire.getNomJuridiction());
        return incarcerationDetenu;
    }

    @DeleteMapping(value="/deleteIncarceration")
    public void deleteIncarceration(HttpServletRequest request, @Valid Incarceration incarceration){
        Detenu detenu1 = detenuService.readDetenu("1965");
        incarcerationService.deleteIncarceration("1965");
        detenuAffaireService.deleteDetenuAffaire(detenu1.getnEcrou(),"45","Lescar");
        detenuService.deleteDetenu(detenu1.getnEcrou());
        affaireService.deleteAffaire("45", "Lescar");

    }
}

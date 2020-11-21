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
import java.util.Collection;

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

    /*@PostMapping(value = "/createIncarceration")
    public Incarceration createIncarceration(HttpServletRequest request, @Valid Incarceration incarceration) {

        java.sql.Date dateDetenu = new java.sql.Date(1997, 12, 27);
        java.sql.Date dateIncarceration = new java.sql.Date(2020, 10, 28);
        java.sql.Date dateAffaire = new java.sql.Date(2019, 9, 25);

        DetenuAffaire detenuAffaire;
        Detenu detenu = detenuService.createDetenu("1965", "Thomas", "Brunel", dateDetenu, "Massy");
        Affaire affaire = affaireService.createAffaire("45", "Lescar", dateAffaire);

        Collection<DetenuAffaire> detenuAffaires = detenu.getDetenuAffairesByNEcrou();
        for(DetenuAffaire da : detenuAffaires) {
            if (da.getnAffaire() == affaire.getnAffaire()) {
                detenuAffaire = da;
            }
        }
        detenu.ajouterAffaire(affaire);

        Motif motif = motifService.createMotif("02","détournement d'argent");
        Incarceration incarcerationDetenu = incarcerationService.createIncarceration("1965",dateIncarceration);
        incarceration.setMotif(motif);
        affaire.ajouterIncarceration(incarceration);

        return incarceration;

        return joueurService.createJoueur(pseudo, mdp, age, sexe, ville);
        return joueurService.createJoueur("max", "silver", 24, "F", "Pau");
    }
    @Autowired
    private AffaireService affaireService;

    @RequestMapping(value = {"/readAffaire"}, method = RequestMethod.GET)
    public Affaire lireAffaire(HttpServletRequest request, @Valid Affaire joueur){
        System.out.println(affaireService.readAffaire("44","Nantes").getDateFaits());
        return affaireService.readAffaire("44","Nantes");
    }*/

    @PostMapping(value = "/createDA")
    public Detenu createDetenu(HttpServletRequest request, @Valid Detenu detenu) {
        java.sql.Date dateDetenu = new java.sql.Date(1997, 12, 27);
        java.sql.Date dateIncarceration = new java.sql.Date(2020, 10, 28);
        java.sql.Date dateAffaire = new java.sql.Date(2019, 9, 25);

        Detenu detenu1 = detenuService.createDetenu("1965", "Thomas", "Brunel", dateDetenu, "Massy");
        Affaire affaire = affaireService.createAffaire("45", "Lescar", dateAffaire);
        DetenuAffaire detenuAffaire = detenuAffaireService.createDetenuAffaire(detenu1.getnEcrou(),affaire.getNumAffaire(),affaire.getNomJuridiction());

        Motif motif = motifService.createMotif("02","détournement d'argent");
        Incarceration incarcerationDetenu = incarcerationService.createIncarceration("1965",dateIncarceration, detenuAffaire,motif);
        detenuAffaire.ajouterIncarceration(incarcerationDetenu);
        incarcerationService.updateIncarceration(incarcerationDetenu.getnEcrou(),incarcerationDetenu.getDateIncarceration(),detenuAffaire.getNumAffaire(),detenuAffaire.getNomJuridiction());
        return detenu1;
    }

    @DeleteMapping(value="/deleteDA")
    public void deleteDetenu(HttpServletRequest request, @Valid Detenu detenu){
        Detenu detenu1 = detenuService.readDetenu("1965");
        detenuAffaireService.deleteDetenuAffaire(detenu1.getnEcrou(),"45","Lescar");
        detenuService.deleteDetenu(detenu1.getnEcrou());
        affaireService.deleteAffaire("45", "Lescar");
        incarcerationService.deleteIncarceration("1965");

    }

}

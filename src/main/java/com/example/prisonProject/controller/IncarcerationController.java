package com.example.prisonProject.controller;

import com.example.prisonProject.DAO.Service.Affaire.AffaireService;
import com.example.prisonProject.POJO.Affaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class IncarcerationController {

    /*@Autowired
    private DetenuService detenuService;
    @Autowired
    private IncarcerationService incarcerationService;
    @Autowired
    private AffaireService affaireService;
    @Autowired
    private MotifService motifService;

    @PostMapping(value ="/createIncarceration")
    public IncarcerationEntity createIncarceration(HttpServletRequest request, @Valid IncarcerationEntity incarceration){

        java.sql.Date dateDetenu = new java.sql.Date(1997,12,27);
        java.sql.Date dateIncarceration = new java.sql.Date(2020,10,28);
        java.sql.Date dateAffaire = new java.sql.Date(2019,9,25);

        DetenuEntity detenu = detenuService.createDetenu("1965", "Thomas", "Brunel", dateDetenu, "Massy");
        AffaireEntity affaire = affaireService.createAffaire("45","Lescar", dateAffaire);
        detenu.ajouterAffaire(affaire);

        MotifEntity motif = motifService.createMotif("02","détournement d'argent");
        IncarcerationEntity incarcerationDetenu = incarcerationService.createIncarceration("1965",dateIncarceration);
        incarceration.setMotif(motif);
        affaire.ajouterIncarceration(incarceration);

        return incarceration;

        //return joueurService.createJoueur(pseudo, mdp, age, sexe, ville);
        // return joueurService.createJoueur("max", "silver", 24, "F", "Pau");
    }*/

    @Autowired
    private AffaireService affaireService;

    @RequestMapping(value = {"/readAffaire"}, method = RequestMethod.GET)
    public Affaire lireAffaire(HttpServletRequest request, @Valid Affaire joueur){
        System.out.println(affaireService.readAffaire("44","Nantes").getDateFaits());
        return affaireService.readAffaire("44","Nantes");
    }
}

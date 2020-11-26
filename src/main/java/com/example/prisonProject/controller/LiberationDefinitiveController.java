package com.example.prisonProject.controller;

import com.example.prisonProject.DAO.Service.Affaire.AffaireService;
import com.example.prisonProject.DAO.Service.Condamnation.CondamnationService;
import com.example.prisonProject.DAO.Service.Decision.DecisionService;
import com.example.prisonProject.DAO.Service.Detenu.DetenuService;
import com.example.prisonProject.DAO.Service.DetenuAffaire.DetenuAffaireService;
import com.example.prisonProject.DAO.Service.Incarceration.IncarcerationService;
import com.example.prisonProject.DAO.Service.LiberationDefinitive.LiberationDefinitiveService;
import com.example.prisonProject.DAO.Service.ReductionPeine.ReductionPeineService;
import com.example.prisonProject.POJO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class LiberationDefinitiveController {
    @Autowired
    DecisionService decisionService;
    @Autowired
    LiberationDefinitiveService liberationDefinitiveService;
    @Autowired
    CondamnationService condamnationService;
    @Autowired
    DetenuService detenuService;
    @Autowired
    ReductionPeineService reductionPeineService;
    @Autowired
    DetenuAffaireService detenuAffaireService;
    @Autowired
    IncarcerationService incarcerationService;
    @Autowired
    AffaireService affaireService;

    @PostMapping(value = "/createLiberationDefinitive")
    public LiberationDefinitive createLiberationDefinitive(HttpServletRequest request, @Valid LiberationDefinitive liberationDefinitive) {
        //Création de la décision de la libération définitive
        Date dateDecision = new Date(2060 - 1900, 12 - 1, 25);
        Date dateLiberation = new Date(2060 - 1900, 12 - 1, 27);
        Decision decision = decisionService.createDecision("3", "1965", dateDecision);

        //Création de la libération définitive
        LiberationDefinitive liberationDefinitive1 = liberationDefinitiveService.createLiberationDefinitive(decision.getNumTypeDecision(), decision.getnEcrou(), decision.getDateDecision(),dateLiberation);
        decision.setLiberationDefinitive(liberationDefinitive1);

        //Mettre à jour les fichiers de la prison
        Detenu detenuLibere = detenuService.readDetenu(decision.getnEcrou());
        Collection<Decision> decisionsDetenu = detenuLibere.getDecisionsByNEcrou();

        for(Decision d : decisionsDetenu){ // On supprime les décisions (ainsi que les condamnations et les réductions de peines liées) prises sauf la libération
            if(d.getNumTypeDecision().equals("1") || d.getNumTypeDecision().equals("2")){
                decisionService.deleteDecision(d.getnEcrou(), d.getNumTypeDecision(), d.getDateDecision());
            }
        }

        Incarceration incarcerationDetenu = incarcerationService.readIncarceration(decision.getnEcrou());
        DetenuAffaire detenuAffaireLibere = detenuAffaireService.readDetenuAffaire(incarcerationDetenu.getnEcrou(),incarcerationDetenu.getNumAffaire(), incarcerationDetenu.getNomJuridiction());
        Affaire affaireLibere = affaireService.readAffaire(detenuAffaireLibere.getNumAffaire(), detenuAffaireLibere.getNomJuridiction());

        incarcerationService.deleteIncarceration(incarcerationDetenu.getnEcrou()); //On supprime l'incarcération du détenu libéré
        detenuAffaireService.deleteDetenuAffaire(detenuAffaireLibere.getnEcrou(),detenuAffaireLibere.getNumAffaire(),detenuAffaireLibere.getNomJuridiction());
        affaireService.deleteAffaire(affaireLibere.getNumAffaire(), affaireLibere.getNomJuridiction()); //On supprime l'affaire du détenu libéré
        return liberationDefinitive1;
    }

    @DeleteMapping(value="/deleteLiberationDefinitive")
    public void deleteLiberationDefinitive(HttpServletRequest request, @Valid LiberationDefinitive liberationDefinitive){
        Date dateDecision = new Date(2060 - 1900, 12 - 1, 25);
        liberationDefinitiveService.deleteLiberationDefinitive("1965","3",dateDecision);
        decisionService.deleteDecision("1965","3", dateDecision);

    }
}

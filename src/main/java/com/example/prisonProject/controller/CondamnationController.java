package com.example.prisonProject.controller;

import com.example.prisonProject.DAO.Service.Condamnation.CondamnationService;
import com.example.prisonProject.DAO.Service.Decision.DecisionService;
import com.example.prisonProject.POJO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;

@Controller
public class CondamnationController {

    @Autowired
    DecisionService decisionService;
    @Autowired
    CondamnationService condamnationService;

    @PostMapping(value = "/createCondamnation")
    public Condamnation createCondamnation(HttpServletRequest request, @Valid Condamnation condamnation) {
        //Création de la décision de condamnation
        Date dateDecision = new Date(2020-1900, 12-1, 2);
        Decision decision = decisionService.createDecision("1","1965",dateDecision);

        //Création de la condamnation
        Condamnation condamnation1 = condamnationService.createCondamnation(decision.getNumTypeDecision(),decision.getnEcrou(),decision.getDateDecision(),50);
        decision.setCondamnation(condamnation1);

        return condamnation1;
    }
}

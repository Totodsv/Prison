package com.example.prisonProject.controller;

import com.example.prisonProject.DAO.Service.Decision.DecisionService;
import com.example.prisonProject.DAO.Service.ReductionPeine.ReductionPeineService;
import com.example.prisonProject.POJO.Condamnation;
import com.example.prisonProject.POJO.Decision;
import com.example.prisonProject.POJO.ReductionPeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;

@Controller
public class ReductionPeineController {

    @Autowired
    DecisionService decisionService;
    @Autowired
    ReductionPeineService reductionPeineService;
    @PostMapping(value = "/createReductionPeine")
    public ReductionPeine createReductionPeine(HttpServletRequest request, @Valid ReductionPeine reductionPeine) {
        //Création de la décision de condamnation
        Date dateDecision = new Date(2022 - 1900, 12 - 1, 27);
        Decision decision = decisionService.createDecision("2", "1965", dateDecision);

        //Création de la réduction de peine
        ReductionPeine reductionPeine1 = reductionPeineService.createReductionPeine(decision.getNumTypeDecision(), decision.getnEcrou(), decision.getDateDecision(), 10);
        decision.setReductionPeine(reductionPeine1);

        return reductionPeine1;
    }
}

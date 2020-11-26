package com.example.prisonProject.DAO.Service.Decision;

import com.example.prisonProject.DAO.Repository.DecisionRepository;
import com.example.prisonProject.DAO.Repository.DetenuAffaireRepository;
import com.example.prisonProject.POJO.Decision;
import com.example.prisonProject.POJO.DetenuAffaire;
import com.example.prisonProject.POJO.Incarceration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collection;
import java.util.Collections;

@Service
public class DecisionServiceImpl implements DecisionService {

    @Autowired
    private DecisionRepository decisionRepository;

    @Override
    public Decision createDecision(String n_type_decision, String n_ecrou, Date date_decision) {

        Decision d = new Decision();
        d.setNumTypeDecision(n_type_decision);
        d.setnEcrou(n_ecrou);
        d.setDateDecision(date_decision);

        return decisionRepository.save(d);
    }

    @Override
    public Decision readDecision(String n_type_decision, String n_ecrou, Date date_decision) {
        return decisionRepository.findDecisionBynEcrouAndNumTypeDecisionAndDateDecision(n_type_decision, n_ecrou, date_decision);
    }

    @Override
    public Decision updateDecision(String n_type_decision, String n_ecrou, Date date_decision) {
        return null;
    }

    @Override
    public void deleteDecision(String n_ecrou, String n_type_decision, Date date_decision) {
        Decision d = decisionRepository.findDecisionBynEcrouAndNumTypeDecisionAndDateDecision(n_ecrou, n_type_decision, date_decision);
        decisionRepository.delete(d);
    }
}

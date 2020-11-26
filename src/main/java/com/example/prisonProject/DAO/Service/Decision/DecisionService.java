package com.example.prisonProject.DAO.Service.Decision;

import com.example.prisonProject.POJO.Decision;
import com.example.prisonProject.POJO.DetenuAffaire;

import java.sql.Date;

public interface DecisionService {
    Decision createDecision(String n_type_decision, String n_ecrou, Date date_decision);
    Decision readDecision(String n_type_decision, String n_ecrou, Date date_decision);
    Decision updateDecision(String n_type_decision, String n_ecrou, Date date_decision); //Inutile
    void deleteDecision(String n_ecrou, String n_type_decision, Date date_decision);
}

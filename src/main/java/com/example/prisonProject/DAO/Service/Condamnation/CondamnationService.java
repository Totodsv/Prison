package com.example.prisonProject.DAO.Service.Condamnation;

import com.example.prisonProject.POJO.Condamnation;

import java.sql.Date;


public interface CondamnationService {
        Condamnation createCondamnation(String nTypeDecision, String nEcrou, Date dateDecision, Integer duree);
        Condamnation readCondamnation(String nTypeDecision, String nEcrou, Date dateDecision);
        Condamnation updateCondamnation(String nTypeDecision, String nEcrou, Date dateDecision, Integer duree);
        void deleteCondmanation(String nTypeDecision, String nEcrou, Date dateDecision);
}

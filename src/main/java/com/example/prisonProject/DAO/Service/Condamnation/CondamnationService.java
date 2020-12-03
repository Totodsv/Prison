package com.example.prisonProject.DAO.Service.Condamnation;

import com.example.prisonProject.POJO.Condamnation;
import com.example.prisonProject.POJO.Incarceration;

import java.sql.Date;
import java.util.List;


public interface CondamnationService {
        Condamnation createCondamnation(String nTypeDecision, String nEcrou, Date dateDecision, Integer duree);
        Condamnation readCondamnation(String nTypeDecision, String nEcrou, Date dateDecision);
        Condamnation updateCondamnation(String nTypeDecision, String nEcrou, Date dateDecision, Integer duree);
        void deleteCondmanation(String nTypeDecision, String nEcrou, Date dateDecision);
        List<Condamnation> readAllCondamnations();
}

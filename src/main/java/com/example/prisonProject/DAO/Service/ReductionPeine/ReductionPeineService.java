package com.example.prisonProject.DAO.Service.ReductionPeine;

import com.example.prisonProject.POJO.ReductionPeine;

import java.sql.Date;

public interface ReductionPeineService {

    ReductionPeine createReductionPeine(String nTypeDecision, String nEcrou, Date dateDecision, Integer duree);
    ReductionPeine readReductionPeine(String nTypeDecision, String nEcrou, Date dateDecision);
    ReductionPeine updateReductionPeine(String nTypeDecision, String nEcrou, Date dateDecision, Integer duree);
    void deleteReductionPeine(String nTypeDecision, String nEcrou, Date dateDecision);
}

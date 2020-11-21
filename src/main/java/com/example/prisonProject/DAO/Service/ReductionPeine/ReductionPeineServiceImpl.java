package com.example.prisonProject.DAO.Service.ReductionPeine;

import com.example.prisonProject.DAO.Repository.ReductionPeineRepository;
import com.example.prisonProject.POJO.ReductionPeine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class ReductionPeineServiceImpl implements ReductionPeineService {

    @Autowired
    private ReductionPeineRepository reductionPeineRepository;

    @Override
    public ReductionPeine createReductionPeine(String nTypeDecision, String nEcrou, Date dateDecision, Integer duree){
        ReductionPeine r = new ReductionPeine();
        r.setNumTypeDecision(nTypeDecision);
        r.setnEcrou(nEcrou);
        r.setDateDecision(dateDecision);
        r.setDuree(duree);
        return reductionPeineRepository.save(r);
    }

    @Override
    public ReductionPeine readReductionPeine(String nTypeDecision, String nEcrou, Date dateDecision){
        return reductionPeineRepository.findReductionPeineBynEcrouAndNumTypeDecisionAndDateDecision(nEcrou,nTypeDecision,dateDecision);
    }

    @Override
    public ReductionPeine updateReductionPeine(String nTypeDecision, String nEcrou, Date dateDecision, Integer duree){
        ReductionPeine r = reductionPeineRepository.findReductionPeineBynEcrouAndNumTypeDecisionAndDateDecision(nEcrou,nTypeDecision,dateDecision);
        r.setDuree(duree);
        return reductionPeineRepository.save(r);
    }

    @Override
    public void deleteReductionPeine(String nTypeDecision, String nEcrou, Date dateDecision){
        ReductionPeine r = reductionPeineRepository.findReductionPeineBynEcrouAndNumTypeDecisionAndDateDecision(nEcrou,nTypeDecision,dateDecision);
        reductionPeineRepository.delete(r);
    }
}

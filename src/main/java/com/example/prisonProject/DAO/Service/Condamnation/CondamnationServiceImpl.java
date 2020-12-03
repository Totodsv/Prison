package com.example.prisonProject.DAO.Service.Condamnation;

import com.example.prisonProject.DAO.Repository.CondamnationRepository;
import com.example.prisonProject.POJO.Condamnation;
import com.example.prisonProject.POJO.Incarceration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CondamnationServiceImpl implements CondamnationService {
    @Autowired
    private CondamnationRepository condamnationRepository;

    @Override
    public Condamnation createCondamnation(String nTypeDecision, String nEcrou, Date dateDecision, Integer duree){
        Condamnation c = new Condamnation();
        c.setNumTypeDecision(nTypeDecision);
        c.setnEcrou(nEcrou);
        c.setDateDecision(dateDecision);
        c.setDuree(duree);

        return condamnationRepository.save(c);
    }

    @Override
    public Condamnation readCondamnation(String nTypeDecision, String nEcrou, Date dateDecision){
        return condamnationRepository.findCondamnationBynEcrouAndNumTypeDecisionAndDateDecision(nEcrou,nTypeDecision,dateDecision);
    }

    @Override
    public Condamnation updateCondamnation(String nTypeDecision, String nEcrou, Date dateDecision, Integer duree){
        Condamnation c = condamnationRepository.findCondamnationBynEcrouAndNumTypeDecisionAndDateDecision(nEcrou,nTypeDecision,dateDecision);
        c.setDuree(duree);
        return condamnationRepository.save(c);
    }

    @Override
    public void deleteCondmanation(String nTypeDecision, String nEcrou, Date dateDecision){
        Condamnation c = condamnationRepository.findCondamnationBynEcrouAndNumTypeDecisionAndDateDecision(nEcrou,nTypeDecision,dateDecision);
        condamnationRepository.delete(c);
    }

    @Override
    public List<Condamnation> readAllCondamnations(){
        return condamnationRepository.findAll();
    }
}

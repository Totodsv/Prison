package com.example.prisonProject.DAO.Service.LiberationDefinitive;

import com.example.prisonProject.DAO.Repository.LiberationDefinitiveRepository;
import com.example.prisonProject.POJO.LiberationDefinitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class LiberationDefinitiveServiceImpl implements LiberationDefinitiveService {
    @Autowired
    private LiberationDefinitiveRepository liberationDefinitiveRepository;

    @Override
    public LiberationDefinitive createLiberationDefinitive(String nTypeDecision, String nEcrou, Date dateDecision, Date dateLiberation){
        LiberationDefinitive l = new LiberationDefinitive();
        l.setNumTypeDecision(nTypeDecision);
        l.setnEcrou(nEcrou);
        l.setDateDecision(dateDecision);
        l.setDateLiberation(dateLiberation);
        return liberationDefinitiveRepository.save(l);
    }

    @Override
    public LiberationDefinitive readLiberationDefinitive(String nTypeDecision, String nEcrou, Date dateDecision){
        return liberationDefinitiveRepository.findLiberationDefinitiveBynEcrouAndNumTypeDecisionAndDateDecision(nEcrou,nTypeDecision,dateDecision);
    }

    @Override
    public LiberationDefinitive updateLiberationDefinitive(String nTypeDecision, String nEcrou, Date dateDecision, Date dateLiberation){
        LiberationDefinitive l = liberationDefinitiveRepository.findLiberationDefinitiveBynEcrouAndNumTypeDecisionAndDateDecision(nEcrou,nTypeDecision,dateDecision);
        l.setDateLiberation(dateLiberation);
        return liberationDefinitiveRepository.save(l);
    }

    @Override
    public void deleteLiberationDefinitive(String nEcrou, String nTypeDecision, Date dateDecision){
        LiberationDefinitive l = liberationDefinitiveRepository.findLiberationDefinitiveBynEcrouAndNumTypeDecisionAndDateDecision(nEcrou,nTypeDecision,dateDecision);
        liberationDefinitiveRepository.delete(l);
    }
}

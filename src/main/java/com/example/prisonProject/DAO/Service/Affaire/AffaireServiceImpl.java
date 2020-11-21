package com.example.prisonProject.DAO.Service.Affaire;

import com.example.prisonProject.DAO.Repository.AffaireRepository;
import com.example.prisonProject.POJO.Affaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class AffaireServiceImpl implements AffaireService {
    @Autowired
    private AffaireRepository affaireRepository;

    @Override
    public Affaire createAffaire(String nAffaire, String nomJuridiction, Date dateFaits){
        Affaire a = new Affaire();
        a.setNumAffaire(nAffaire);
        a.setNomJuridiction(nomJuridiction);
        a.setDateFaits(dateFaits);

        return affaireRepository.save(a);
    }

    @Override
    public Affaire readAffaire(String nAffaire, String nomJuridiction){
        return affaireRepository.findAffaireByNumAffaireAndNomJuridiction(nAffaire, nomJuridiction);
    }

    @Override
    public Affaire updateAffaire(String nAffaire, String nomJuridiction, Date dateFaits){
        Affaire a = affaireRepository.findAffaireByNumAffaireAndNomJuridiction(nAffaire, nomJuridiction);
        a.setDateFaits(dateFaits);

        return affaireRepository.save(a);
    }

    @Override
    public void deleteAffaire(String nAffaire, String nomJuridiction) {
        Affaire a = affaireRepository.findAffaireByNumAffaireAndNomJuridiction(nAffaire, nomJuridiction);
        affaireRepository.delete(a);
    }
}

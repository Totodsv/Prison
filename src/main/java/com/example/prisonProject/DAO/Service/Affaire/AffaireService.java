package com.example.prisonProject.DAO.Service.Affaire;

import com.example.prisonProject.POJO.Affaire;

import java.sql.Date;
import java.util.List;

public interface AffaireService {
    Affaire createAffaire(String nAffaire, String nomJuridiction, Date dateFaits);
    Affaire readAffaire(String nAffaire, String nomJuridiction);
    Affaire updateAffaire(String nAffaire, String nomJuridiction, Date dateFaits);
    void deleteAffaire(String nAffaire, String nomJuridiction);
}

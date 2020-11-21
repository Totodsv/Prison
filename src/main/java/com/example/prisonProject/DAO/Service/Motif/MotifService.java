package com.example.prisonProject.DAO.Service.Motif;

import com.example.prisonProject.POJO.Motif;

import java.util.List;

public interface MotifService {

    Motif createMotif(String nMotif, String libelleMotif);
    Motif readMotif(String nMotif);
    Motif updateMotif(String nMotif, String libelleMotif);
    void deleteMotif(String nMotif);

}

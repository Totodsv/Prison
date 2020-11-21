package com.example.prisonProject.DAO.Service.Motif;

import com.example.prisonProject.DAO.Repository.MotifRepository;
import com.example.prisonProject.POJO.Motif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotifServiceImpl implements MotifService {
    @Autowired
    private MotifRepository motifRepository;

    @Override
    public Motif createMotif(String nMotif, String libelleMotif) {
        Motif m = new Motif();
        m.setnMotif(nMotif);
        m.setLibelleMotif(libelleMotif);
        return motifRepository.save(m);
    }

    @Override
    public Motif readMotif(String nMotif){
        return motifRepository.findMotifBynMotif(nMotif);
    }

    @Override
    public Motif updateMotif(String nMotif, String libelleMotif){
        Motif m = motifRepository.findMotifBynMotif(nMotif);
        m.setLibelleMotif(libelleMotif);
        return motifRepository.save(m);
    }

    @Override
    public void deleteMotif(String nMotif){
        Motif m = motifRepository.findMotifBynMotif(nMotif);
        motifRepository.delete(m);
    }
}

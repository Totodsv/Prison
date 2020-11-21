package com.example.prisonProject.DAO.Repository;

import com.example.prisonProject.POJO.Motif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotifRepository extends JpaRepository<Motif, String> {

    Motif findMotifBynMotif(String n_motif);
}

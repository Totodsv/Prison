package com.example.prisonProject.DAO.Repository;

import com.example.prisonProject.POJO.Detenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetenuRepository extends JpaRepository<Detenu, String> {

    Detenu findDetenuBynEcrou(String n_ecrou);
}

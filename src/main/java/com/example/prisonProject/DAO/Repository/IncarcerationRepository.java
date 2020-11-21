package com.example.prisonProject.DAO.Repository;

import com.example.prisonProject.POJO.Incarceration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncarcerationRepository extends JpaRepository<Incarceration, String> {
    Incarceration findIncarcerationBynEcrou(String n_ecrou);
}

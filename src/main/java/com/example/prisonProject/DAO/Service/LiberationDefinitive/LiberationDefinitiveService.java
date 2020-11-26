package com.example.prisonProject.DAO.Service.LiberationDefinitive;


import com.example.prisonProject.POJO.LiberationDefinitive;

import java.sql.Date;

public interface LiberationDefinitiveService {
    LiberationDefinitive createLiberationDefinitive(String nTypeDecision, String nEcrou, Date dateDecision, Date dateLiberation);
    LiberationDefinitive readLiberationDefinitive(String nTypeDecision, String nEcrou, Date dateDecision);
    LiberationDefinitive updateLiberationDefinitive(String nTypeDecision, String nEcrou, Date dateDecision, Date dateLiberation);
    void deleteLiberationDefinitive(String nEcrou, String nTypeDecision, Date dateDecision);

}

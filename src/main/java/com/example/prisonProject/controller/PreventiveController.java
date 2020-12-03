package com.example.prisonProject.controller;

import com.example.prisonProject.DAO.Service.Condamnation.CondamnationService;
import com.example.prisonProject.DAO.Service.Detenu.DetenuService;
import com.example.prisonProject.DAO.Service.Incarceration.IncarcerationService;
import com.example.prisonProject.POJO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PreventiveController {

    @Autowired
    IncarcerationService incarcerationService;
    @Autowired
    CondamnationService condamnationService;
    @Autowired
    DetenuService detenuService;

    @GetMapping(value = "/readPreventive")
    public List<Detenu> readPreventive(HttpServletRequest request, @Valid Detenu detenu) {

        List<Incarceration> incarcerations = incarcerationService.readAllIncarcerations();
        List<Condamnation> condamnations = condamnationService.readAllCondamnations();
        List<Detenu> detenus = new ArrayList<>();

        for(Incarceration i : incarcerations){
            for(Condamnation c : condamnations){
                if(!i.getnEcrou().equals(c.getnEcrou()) ){ //Si un detenu est incarcéré mais pas encore condamné :
                    detenus.add(detenuService.readDetenu(i.getnEcrou()));
                }
            }
        }
        for(Detenu d : detenus){
            System.out.println(d.getnEcrou()+" "+d.getPrenom()+" "+d.getNom());
        }
        return detenus;
    }
}

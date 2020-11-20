package com.example.prisonProject.POJO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Detenu {
    private String nEcrou;
    private String prenom;
    private String nom;
    private Date dateNaissance;
    private String lieuNaissance;
    private Collection<Decision> decisionsByNEcrou;
    private Collection<DetenuAffaire> detenuAffairesByNEcrou;

    public Detenu(){

    }

    @Id
    @Column(name = "n_ecrou", nullable = false, length = 10)
    public String getnEcrou() {
        return nEcrou;
    }

    public void setnEcrou(String nEcrou) {
        this.nEcrou = nEcrou;
    }

    @Basic
    @Column(name = "prenom", nullable = true, length = 30)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = 30)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "date_naissance", nullable = true)
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Basic
    @Column(name = "lieu_naissance", nullable = true, length = 30)
    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detenu detenu = (Detenu) o;
        return Objects.equals(nEcrou, detenu.nEcrou) &&
                Objects.equals(prenom, detenu.prenom) &&
                Objects.equals(nom, detenu.nom) &&
                Objects.equals(dateNaissance, detenu.dateNaissance) &&
                Objects.equals(lieuNaissance, detenu.lieuNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nEcrou, prenom, nom, dateNaissance, lieuNaissance);
    }

    @OneToMany(mappedBy = "detenuByNEcrou")
    public Collection<Decision> getDecisionsByNEcrou() {
        return decisionsByNEcrou;
    }

    public void setDecisionsByNEcrou(Collection<Decision> decisionsByNEcrou) {
        this.decisionsByNEcrou = decisionsByNEcrou;
    }

    @OneToMany(mappedBy = "detenuByNEcrou")
    public Collection<DetenuAffaire> getDetenuAffairesByNEcrou() {
        return detenuAffairesByNEcrou;
    }

    public void setDetenuAffairesByNEcrou(Collection<DetenuAffaire> detenuAffairesByNEcrou) {
        this.detenuAffairesByNEcrou = detenuAffairesByNEcrou;
    }
}

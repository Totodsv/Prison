package com.example.prisonProject.POJO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Incarceration {
    private String nEcrou;
    private Date dateIncarceration;
    private DetenuAffaire detenuAffaire;
    private Motif motifByNMotif;
    private String numAffaire;
    private String nomJuridiction;

    public Incarceration(){}

    @Id
    @Column(name = "n_ecrou", nullable = false, length = 10)
    public String getnEcrou() {
        return nEcrou;
    }

    public void setnEcrou(String nEcrou) {
        this.nEcrou = nEcrou;
    }

    @Basic
    @Column(name = "date_incarceration", nullable = true)
    public Date getDateIncarceration() {
        return dateIncarceration;
    }

    public void setDateIncarceration(Date dateIncarceration) {
        this.dateIncarceration = dateIncarceration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incarceration that = (Incarceration) o;
        return Objects.equals(nEcrou, that.nEcrou) &&
                Objects.equals(dateIncarceration, that.dateIncarceration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nEcrou, dateIncarceration);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "n_ecrou", referencedColumnName = "n_ecrou", nullable = true, insertable = false, updatable = false), @JoinColumn(name = "n_affaire", referencedColumnName = "n_affaire", nullable = true, insertable = false, updatable = false), @JoinColumn(name = "nom_juridiction", referencedColumnName = "nom_juridiction", nullable = true, insertable = false, updatable = false)})
    public DetenuAffaire getDetenuAffaire() {
        return detenuAffaire;
    }

    public void setDetenuAffaire(DetenuAffaire detenuAffaire) {
        this.detenuAffaire = detenuAffaire;
    }

    @ManyToOne
    @JoinColumn(name = "n_motif", referencedColumnName = "n_motif")
    public Motif getMotifByNMotif() {
        return motifByNMotif;
    }

    public void setMotifByNMotif(Motif motifByNMotif) {
        this.motifByNMotif = motifByNMotif;
    }

    @Column(name="n_affaire", nullable = true)
    public String getNumAffaire() {
        return numAffaire;
    }

    public void setNumAffaire(String numAffaire) {
        this.numAffaire = numAffaire;
    }

    @Column(name="nom_juridiction", nullable = true)
    public String getNomJuridiction() {
        return nomJuridiction;
    }

    public void setNomJuridiction(String nomJuridiction) {
        this.nomJuridiction = nomJuridiction;
    }
}

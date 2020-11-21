package com.example.prisonProject.POJO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DetenuAffairePK implements Serializable {
    private String nEcrou;
    private String numAffaire;
    private String nomJuridiction;

    @Column(name = "n_ecrou", nullable = false, length = 10)
    @Id
    public String getnEcrou() {
        return nEcrou;
    }

    public void setnEcrou(String nEcrou) {
        this.nEcrou = nEcrou;
    }

    @Column(name = "n_affaire", nullable = false, length = 10)
    @Id
    public String getNumAffaire() {
        return numAffaire;
    }

    public void setNumAffaire(String numAffaire) {
        this.numAffaire = numAffaire;
    }

    @Column(name = "nom_juridiction", nullable = false, length = 30)
    @Id
    public String getNomJuridiction() {
        return nomJuridiction;
    }

    public void setNomJuridiction(String nomJuridiction) {
        this.nomJuridiction = nomJuridiction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetenuAffairePK that = (DetenuAffairePK) o;
        return Objects.equals(nEcrou, that.nEcrou) &&
                Objects.equals(numAffaire, that.numAffaire) &&
                Objects.equals(nomJuridiction, that.nomJuridiction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nEcrou, numAffaire, nomJuridiction);
    }
}

package com.example.prisonProject.POJO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AffairePK implements Serializable {
    private String nAffaire;
    private String nomJuridiction;

    @Column(name = "n_affaire", nullable = false, length = 10)
    @Id
    public String getnAffaire() {
        return nAffaire;
    }

    public void setnAffaire(String nAffaire) {
        this.nAffaire = nAffaire;
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
        AffairePK affairePK = (AffairePK) o;
        return Objects.equals(nAffaire, affairePK.nAffaire) &&
                Objects.equals(nomJuridiction, affairePK.nomJuridiction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nAffaire, nomJuridiction);
    }
}

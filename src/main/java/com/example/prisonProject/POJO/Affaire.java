package com.example.prisonProject.POJO;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@IdClass(AffairePK.class)
public class Affaire  {
    private String numAffaire;
    private String nomJuridiction;
    private Date dateFaits;
    private Collection<DetenuAffaire> detenuAffaires;

    @Autowired
    public Affaire(){
    }

    @Id
    @Column(name = "n_affaire", nullable = false, length = 10)
    public String getNumAffaire() {
        return numAffaire;
    }

    public void setNumAffaire(String numAffaire) {
        this.numAffaire = numAffaire;
    }

    @Id
    @Column(name = "nom_juridiction", nullable = false, length = 30)
    public String getNomJuridiction() {
        return nomJuridiction;
    }

    public void setNomJuridiction(String nomJuridiction) {
        this.nomJuridiction = nomJuridiction;
    }

    @Basic
    @Column(name = "date_faits", nullable = true)
    public Date getDateFaits() {
        return dateFaits;
    }

    public void setDateFaits(Date dateFaits) {
        this.dateFaits = dateFaits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Affaire affaire = (Affaire) o;
        return Objects.equals(affaire, affaire.numAffaire) &&
                Objects.equals(nomJuridiction, affaire.nomJuridiction) &&
                Objects.equals(dateFaits, affaire.dateFaits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAffaire, nomJuridiction, dateFaits);
    }

    @OneToMany(mappedBy = "affaire")
    public Collection<DetenuAffaire> getDetenuAffaires() {
        return detenuAffaires;
    }

    public void setDetenuAffaires(Collection<DetenuAffaire> detenuAffaires) {
        this.detenuAffaires = detenuAffaires;
    }
}

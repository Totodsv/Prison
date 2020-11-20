package com.example.prisonProject.POJO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "detenu_affaire", schema = "public", catalog = "Prison")
@IdClass(DetenuAffairePK.class)
public class DetenuAffaire {
    private String nEcrou;
    private String nAffaire;
    private String nomJuridiction;
    private Detenu detenuByNEcrou;
    private Affaire affaire;
    private Collection<Incarceration> incarcerations;

    public DetenuAffaire(){}

    @Id
    @Column(name = "n_ecrou", nullable = false, length = 10)
    public String getnEcrou() {
        return nEcrou;
    }

    public void setnEcrou(String nEcrou) {
        this.nEcrou = nEcrou;
    }

    @Id
    @Column(name = "n_affaire", nullable = false, length = 10)
    public String getnAffaire() {
        return nAffaire;
    }

    public void setnAffaire(String nAffaire) {
        this.nAffaire = nAffaire;
    }

    @Id
    @Column(name = "nom_juridiction", nullable = false, length = 30)
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
        DetenuAffaire that = (DetenuAffaire) o;
        return Objects.equals(nEcrou, that.nEcrou) &&
                Objects.equals(nAffaire, that.nAffaire) &&
                Objects.equals(nomJuridiction, that.nomJuridiction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nEcrou, nAffaire, nomJuridiction);
    }

    @ManyToOne
    @JoinColumn(name = "n_ecrou", referencedColumnName = "n_ecrou", nullable = false, insertable = false, updatable = false)
    public Detenu getDetenuByNEcrou() {
        return detenuByNEcrou;
    }

    public void setDetenuByNEcrou(Detenu detenuByNEcrou) {
        this.detenuByNEcrou = detenuByNEcrou;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "n_affaire", referencedColumnName = "n_affaire", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "nom_juridiction", referencedColumnName = "nom_juridiction", nullable = false, insertable = false, updatable = false)})
    public Affaire getAffaire() {
        return affaire;
    }

    public void setAffaire(Affaire affaire) {
        this.affaire = affaire;
    }

    @OneToMany(mappedBy = "detenuAffaire")
    public Collection<Incarceration> getIncarcerations() {
        return incarcerations;
    }

    public void setIncarcerations(Collection<Incarceration> incarcerations) {
        this.incarcerations = incarcerations;
    }
}

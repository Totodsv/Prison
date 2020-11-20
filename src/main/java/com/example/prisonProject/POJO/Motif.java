package com.example.prisonProject.POJO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Motif {
    private String nMotif;
    private String libelleMotif;
    private Collection<Incarceration> incarcerationsByNMotif;

    public Motif(){}

    @Id
    @Column(name = "n_motif", nullable = false, length = 10)
    public String getnMotif() {
        return nMotif;
    }

    public void setnMotif(String nMotif) {
        this.nMotif = nMotif;
    }

    @Basic
    @Column(name = "libelle_motif", nullable = false, length = 50)
    public String getLibelleMotif() {
        return libelleMotif;
    }

    public void setLibelleMotif(String libelleMotif) {
        this.libelleMotif = libelleMotif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motif motif = (Motif) o;
        return Objects.equals(nMotif, motif.nMotif) &&
                Objects.equals(libelleMotif, motif.libelleMotif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nMotif, libelleMotif);
    }

    @OneToMany(mappedBy = "motifByNMotif")
    public Collection<Incarceration> getIncarcerationsByNMotif() {
        return incarcerationsByNMotif;
    }

    public void setIncarcerationsByNMotif(Collection<Incarceration> incarcerationsByNMotif) {
        this.incarcerationsByNMotif = incarcerationsByNMotif;
    }
}

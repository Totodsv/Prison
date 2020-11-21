package com.example.prisonProject.POJO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(CondamnationPK.class)
public class Condamnation {
    private String numTypeDecision;
    private String nEcrou;
    private Date dateDecision;
    private Integer duree;
    private Decision decision;

    public Condamnation(){

    }

    @Id
    @Column(name = "n_type_decision", nullable = false, length = 1)
    public String getNumTypeDecision() {
        return numTypeDecision;
    }

    public void setNumTypeDecision(String numTypeDecision) {
        this.numTypeDecision = numTypeDecision;
    }

    @Id
    @Column(name = "n_ecrou", nullable = false, length = 10)
    public String getnEcrou() {
        return nEcrou;
    }

    public void setnEcrou(String nEcrou) {
        this.nEcrou = nEcrou;
    }

    @Id
    @Column(name = "date_decision", nullable = false)
    public Date getDateDecision() {
        return dateDecision;
    }

    public void setDateDecision(Date dateDecision) {
        this.dateDecision = dateDecision;
    }

    @Basic
    @Column(name = "duree", nullable = true)
    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condamnation that = (Condamnation) o;
        return Objects.equals(numTypeDecision, that.numTypeDecision) &&
                Objects.equals(nEcrou, that.nEcrou) &&
                Objects.equals(dateDecision, that.dateDecision) &&
                Objects.equals(duree, that.duree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numTypeDecision, nEcrou, dateDecision, duree);
    }

    @OneToOne
    @JoinColumns({@JoinColumn(name = "n_type_decision", referencedColumnName = "n_type_decision", nullable = false), @JoinColumn(name = "n_ecrou", referencedColumnName = "n_ecrou", nullable = false), @JoinColumn(name = "date_decision", referencedColumnName = "date_decision", nullable = false)})
    public Decision getDecision() {
        return decision;
    }

    public void setDecision(Decision decision) {
        this.decision = decision;
    }
}

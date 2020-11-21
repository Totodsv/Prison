package com.example.prisonProject.POJO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(DecisionPK.class)
public class Decision {
    private String numTypeDecision;
    private String nEcrou;
    private Date dateDecision;
    private Condamnation condamnation;
    private Detenu detenuByNEcrou;
    private LiberationDefinitive liberationDefinitive;
    private ReductionPeine reductionPeine;

    public Decision(){
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
    @Column(name = "n_ecrou", nullable = false, length = 10, insertable = false, updatable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decision decision = (Decision) o;
        return Objects.equals(numTypeDecision, decision.numTypeDecision) &&
                Objects.equals(nEcrou, decision.nEcrou) &&
                Objects.equals(dateDecision, decision.dateDecision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numTypeDecision, nEcrou, dateDecision);
    }

    @OneToOne(mappedBy = "decision")
    public Condamnation getCondamnation() {
        return condamnation;
    }

    public void setCondamnation(Condamnation condamnation) {
        this.condamnation = condamnation;
    }

    @ManyToOne
    @JoinColumn(name = "n_ecrou", referencedColumnName = "n_ecrou", nullable = false, insertable = false, updatable = false)
    public Detenu getDetenuByNEcrou() {
        return detenuByNEcrou;
    }

    public void setDetenuByNEcrou(Detenu detenuByNEcrou) {
        this.detenuByNEcrou = detenuByNEcrou;
    }

    @OneToOne(mappedBy = "decision")
    public LiberationDefinitive getLiberationDefinitive() {
        return liberationDefinitive;
    }

    public void setLiberationDefinitive(LiberationDefinitive liberationDefinitive) {
        this.liberationDefinitive = liberationDefinitive;
    }

    @OneToOne(mappedBy = "decision")
    public ReductionPeine getReductionPeine() {
        return reductionPeine;
    }

    public void setReductionPeine(ReductionPeine reductionPeine) {
        this.reductionPeine = reductionPeine;
    }
}

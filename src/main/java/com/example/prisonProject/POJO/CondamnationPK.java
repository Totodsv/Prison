package com.example.prisonProject.POJO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class CondamnationPK implements Serializable {
    private String nTypeDecision;
    private String nEcrou;
    private Date dateDecision;

    @Column(name = "n_type_decision", nullable = false, length = 1)
    @Id
    public String getnTypeDecision() {
        return nTypeDecision;
    }

    public void setnTypeDecision(String nTypeDecision) {
        this.nTypeDecision = nTypeDecision;
    }

    @Column(name = "n_ecrou", nullable = false, length = 10)
    @Id
    public String getnEcrou() {
        return nEcrou;
    }

    public void setnEcrou(String nEcrou) {
        this.nEcrou = nEcrou;
    }

    @Column(name = "date_decision", nullable = false)
    @Id
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
        CondamnationPK that = (CondamnationPK) o;
        return Objects.equals(nTypeDecision, that.nTypeDecision) &&
                Objects.equals(nEcrou, that.nEcrou) &&
                Objects.equals(dateDecision, that.dateDecision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nTypeDecision, nEcrou, dateDecision);
    }
}

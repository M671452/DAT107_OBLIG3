package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Ansatt")
public class Ansatt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ansatt_id")
    private int ansattId;

    @Column(name = "brukernavn", unique = true)
    private String brukernavn;

    @Column(name = "fornavn")
    private String fornavn;

    @Column(name = "etternavn")
    private String etternavn;

    @Column(name = "dato_for_ansettelse")
    private LocalDate datoForAnsettelse;

    @Column(name = "stilling")
    private String stilling;

    @Column(name = "manedslonn")
    private BigDecimal manedslonn;

    @ManyToOne
    @JoinColumn(name = "avdeling_id")
    private Avdeling avdeling;

    // Getters and setters
    public int getAnsattId() {
        return ansattId;
    }

    public void setAnsattId(int ansattId) {
        this.ansattId = ansattId;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public LocalDate getDatoForAnsettelse() {
        return datoForAnsettelse;
    }

    public void setDatoForAnsettelse(LocalDate datoForAnsettelse) {
        this.datoForAnsettelse = datoForAnsettelse;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public BigDecimal getManedslonn() {
        return manedslonn;
    }

    public void setManedslonn(BigDecimal manedslonn) {
        this.manedslonn = manedslonn;
    }

    public Avdeling getAvdeling() {
        return avdeling;
    }

    public void setAvdeling(Avdeling avdeling) {
        this.avdeling = avdeling;
    }

    public void setAnsettelsesdato(LocalDate now) {
        this.datoForAnsettelse = now;
    }
}
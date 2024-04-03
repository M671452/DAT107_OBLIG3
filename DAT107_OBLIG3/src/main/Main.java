package main;
import java.math.BigDecimal;
import java.time.LocalDate;

import dao.AnsattDAO;
import dao.AvdelingDAO;
import entities.Ansatt;
import entities.Avdeling;


public class Main {

    public static void main(String[] args) {
        AnsattDAO ansattDAO = new AnsattDAO();
        AvdelingDAO avdelingDAO = new AvdelingDAO();

        // Legge til en ny ansatt
        Ansatt nyAnsatt = new Ansatt();
        nyAnsatt.setBrukernavn("abc");
        nyAnsatt.setFornavn("John");
        nyAnsatt.setEtternavn("Doe");
        nyAnsatt.setAnsettelsesdato(LocalDate.now());
        nyAnsatt.setStilling("Manager");
        nyAnsatt.setManedslonn(BigDecimal.valueOf(5000));

        Avdeling avdeling = avdelingDAO.finnAvdelingMedId(1); // Anta at avdeling med id 1 eksisterer
        nyAnsatt.setAvdeling(avdeling);

        ansattDAO.leggTilAnsatt(nyAnsatt);

        // Oppdatere en ansatt
        Ansatt ansatt = ansattDAO.finnAnsattMedId(1); // Anta at ansatt med id 1 eksisterer
        ansatt.setStilling("Senior Manager");
        ansatt.setManedslonn(BigDecimal.valueOf(6000));
        ansattDAO.oppdaterAnsatt(ansatt);

        // Slette en ansatt
        ansattDAO.slettAnsatt(2); // Anta at ansatt med id 2 eksisterer og ønskes slettet
    }
}
       

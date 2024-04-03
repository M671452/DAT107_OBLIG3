package entities;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Prosjekt")
public class Prosjekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prosjekt_id")
    private int prosjektId;

    @Column(name = "navn")
    private String navn;

    @Column(name = "beskrivelse")
    private String beskrivelse;

    // Getters and setters
    public int getProsjektId() {
        return prosjektId;
    }

    public void setProsjektId(int prosjektId) {
        this.prosjektId = prosjektId;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
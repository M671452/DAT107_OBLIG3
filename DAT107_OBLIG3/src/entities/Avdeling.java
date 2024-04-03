package entities;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Avdeling")
public class Avdeling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avdeling_id")
    private int avdelingId;

    @Column(name = "navn")
    private String navn;

    @OneToOne
    @JoinColumn(name = "sjef_id")
    private Ansatt sjef;

    // Getters and setters
    public int getAvdelingId() {
        return avdelingId;
    }

    public void setAvdelingId(int avdelingId) {
        this.avdelingId = avdelingId;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Ansatt getSjef() {
        return sjef;
    }

    public void setSjef(Ansatt sjef) {
        this.sjef = sjef;
    }
}
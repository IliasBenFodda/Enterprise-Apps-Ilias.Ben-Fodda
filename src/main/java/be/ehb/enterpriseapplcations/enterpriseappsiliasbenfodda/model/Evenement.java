package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime tijdstip;
    private String titel;
    private String omschrijving;
    private String organisatie;
    private String emailContactpersoon;

    @ManyToOne(optional = false)
    @JoinColumn(name = "locatie_id", nullable = false)
    private Locatie locatie;

    protected Evenement() {
    }

    public Evenement(
            LocalDateTime tijdstip,
            String titel,
            String omschrijving,
            String organisatie,
            String emailContactpersoon,
            Locatie locatie) {

        this.tijdstip = tijdstip;
        this.titel = titel;
        this.omschrijving = omschrijving;
        this.organisatie = organisatie;
        this.emailContactpersoon = emailContactpersoon;
        this.locatie = locatie;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public String getTitel() {
        return titel;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getOrganisatie() {
        return organisatie;
    }

    public String getEmailContactpersoon() {
        return emailContactpersoon;
    }

    public Locatie getLocatie() {
        return locatie;
    }
}

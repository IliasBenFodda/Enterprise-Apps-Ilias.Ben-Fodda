package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Tijdstip is verplicht")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime tijdstip;

    @NotBlank(message = "Titel is verplicht")
    private String titel;

    @NotBlank(message = "Omschrijving is verplicht")
    private String omschrijving;

    @NotBlank(message = "Organisatie is verplicht")
    private String organisatie;

    @NotBlank(message = "E-mailadres is verplicht")
    @Email(message = "E-mailadres is niet geldig")
    private String emailContactpersoon;

    @NotNull(message = "Locatie is verplicht")
    @ManyToOne(optional = false)
    @JoinColumn(name = "locatie_id", nullable = false)
    private Locatie locatie;

    public Evenement() {
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

    public void setTijdstip(LocalDateTime tijdstip) {
        this.tijdstip = tijdstip;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public void setOrganisatie(String organisatie) {
        this.organisatie = organisatie;
    }

    public void setEmailContactpersoon(String emailContactpersoon) {
        this.emailContactpersoon = emailContactpersoon;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }
}

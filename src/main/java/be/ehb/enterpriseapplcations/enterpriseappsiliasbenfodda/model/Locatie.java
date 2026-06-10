package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Locatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Naam is verplicht")
    private String naam;

    @NotBlank(message = "Adres is verplicht")
    private String adres;

    @NotNull(message = "Capaciteit is verplicht")
    @Min(value = 1, message = "Capaciteit moet minstens 1 zijn")
    private Integer capaciteit;

    public Locatie() {
    }

    public Locatie(String naam, String adres, Integer capaciteit) {
        this.naam = naam;
        this.adres = adres;
        this.capaciteit = capaciteit;
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getAdres() {
        return adres;
    }

    public Integer getCapaciteit() {
        return capaciteit;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setCapaciteit(Integer capaciteit) {
        this.capaciteit = capaciteit;
    }
}

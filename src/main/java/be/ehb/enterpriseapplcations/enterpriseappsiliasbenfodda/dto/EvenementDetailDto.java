package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.dto;

import java.time.LocalDateTime;

public record EvenementDetailDto(
        Long id,
        LocalDateTime tijdstip,
        String titel,
        String omschrijving,
        String organisatie,
        String emailContactpersoon,
        String locatieNaam,
        String locatieAdres,
        int locatieCapaciteit
) {
}

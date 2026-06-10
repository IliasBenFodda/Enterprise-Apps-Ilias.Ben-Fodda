package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.service;

import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.dto.EvenementDetailDto;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.dto.EvenementForm;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.dto.EvenementOverzichtDto;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model.Evenement;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model.Locatie;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.repository.EvenementRepository;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.repository.LocatieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementService {

    private final EvenementRepository evenementRepository;
    private final LocatieRepository locatieRepository;

    public EvenementService(EvenementRepository evenementRepository,
                            LocatieRepository locatieRepository) {
        this.evenementRepository = evenementRepository;
        this.locatieRepository = locatieRepository;
    }

    public List<EvenementOverzichtDto> getRecenteEvenementen() {
        return evenementRepository.findTop10ByOrderByTijdstipDesc().stream()
                .map(e -> new EvenementOverzichtDto(e.getId(), e.getTitel(), e.getOrganisatie()))
                .toList();
    }

    public EvenementDetailDto getEvenementDetail(Long id) {
        Evenement e = evenementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evenement niet gevonden: " + id));
        return new EvenementDetailDto(
                e.getId(),
                e.getTijdstip(),
                e.getTitel(),
                e.getOmschrijving(),
                e.getOrganisatie(),
                e.getEmailContactpersoon(),
                e.getLocatie().getNaam(),
                e.getLocatie().getAdres(),
                e.getLocatie().getCapaciteit()
        );
    }

    public void saveEvenement(EvenementForm form) {
        Locatie locatie = locatieRepository.findById(form.getLocatieId())
                .orElseThrow(() -> new RuntimeException("Locatie niet gevonden: " + form.getLocatieId()));

        Evenement evenement = new Evenement(
                form.getTijdstip(),
                form.getTitel(),
                form.getOmschrijving(),
                form.getOrganisatie(),
                form.getEmailContactpersoon(),
                locatie
        );
        evenementRepository.save(evenement);
    }

    public void saveLocatie(Locatie locatie) {
        locatieRepository.save(locatie);
    }

    public Iterable<Locatie> getAllLocaties() {
        return locatieRepository.findAll();
    }
}

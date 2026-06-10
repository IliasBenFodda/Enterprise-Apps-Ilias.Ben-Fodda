package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.service;

import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.dto.EvenementForm;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model.Evenement;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model.Locatie;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.repository.EvenementRepository;
import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.repository.LocatieRepository;
import org.springframework.stereotype.Service;

@Service
public class EvenementService {

    private final EvenementRepository evenementRepository;
    private final LocatieRepository locatieRepository;

    public EvenementService(EvenementRepository evenementRepository,
                            LocatieRepository locatieRepository) {
        this.evenementRepository = evenementRepository;
        this.locatieRepository = locatieRepository;
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

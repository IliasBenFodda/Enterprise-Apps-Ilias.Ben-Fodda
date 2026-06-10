package be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.repository;

import be.ehb.enterpriseapplcations.enterpriseappsiliasbenfodda.model.Evenement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EvenementRepository extends CrudRepository<Evenement, Long> {

    List<Evenement> findTop10ByOrderByTijdstipDesc();
}

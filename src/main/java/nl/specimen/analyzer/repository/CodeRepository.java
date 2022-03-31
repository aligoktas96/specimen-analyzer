package nl.specimen.analyzer.repository;

import nl.specimen.analyzer.model.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeRepository extends JpaRepository<Code, String> {
    Optional<Code> findByCode(String code);
}

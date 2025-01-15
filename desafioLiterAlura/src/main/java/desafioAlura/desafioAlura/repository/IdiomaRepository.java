package desafioAlura.desafioAlura.repository;

import desafioAlura.desafioAlura.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long> {

    Optional<Idioma> findByCodigo(String nombre);
}

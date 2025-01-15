package desafioAlura.desafioAlura.repository;

import desafioAlura.desafioAlura.model.Autor;
import desafioAlura.desafioAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombre(String name);

    @Query("SELECT a FROM Autor a WHERE a.ano_nacimiento <= :ano AND a.ano_muerte >= :ano")
    List<Autor> findAutorsByAno(Integer ano);

    @Query("SELECT l.titulo FROM Libro l JOIN l.autores a  WHERE a.id = :autorId")
    List<String> findLibrosByAutorId(Long autorId);
}

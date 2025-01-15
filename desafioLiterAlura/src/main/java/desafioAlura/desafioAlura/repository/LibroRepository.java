package desafioAlura.desafioAlura.repository;

import desafioAlura.desafioAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT i.codigo, COUNT(l) FROM Libro l JOIN l.idiomas i GROUP BY i.codigo")
    List<Object[]> contarLibrosByIdioma();
}

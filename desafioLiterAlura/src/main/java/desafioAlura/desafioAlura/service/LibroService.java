package desafioAlura.desafioAlura.service;

import desafioAlura.desafioAlura.model.DatosLibro;
import desafioAlura.desafioAlura.model.Idioma;
import desafioAlura.desafioAlura.model.Libro;
import desafioAlura.desafioAlura.repository.AutorRepository;
import desafioAlura.desafioAlura.repository.IdiomaRepository;
import desafioAlura.desafioAlura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private IdiomaRepository idiomaRepository;

    public Libro guardarLibro(DatosLibro datoslibro) {

        Optional<Libro> libroExistente = libroRepository.findById(datoslibro.id());

        if (libroExistente.isPresent()) {
            return libroExistente.get();
        }

        Libro nuevoLibro = new Libro(datoslibro, autorRepository, idiomaRepository);

        return libroRepository.save(nuevoLibro);
    }
}

package desafioAlura.desafioAlura.model;

import desafioAlura.desafioAlura.repository.AutorRepository;
import desafioAlura.desafioAlura.repository.IdiomaRepository;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    private long id;
    private String titulo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_idioma",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "idioma_id")
    )
    private List<Idioma> idiomas;

    private Long descargas;

    public Libro(DatosLibro datosLibro, AutorRepository autorRepository, IdiomaRepository idiomaRepository) {
        this.id = datosLibro.id();
        this.titulo = datosLibro.titulo();
        this.autores = datosLibro.autor().stream()
                        .filter(a -> a.nombre() != null)
                        .map(datosAutor -> autorRepository.findByNombre(datosAutor.nombre())
                                .orElseGet(() -> new Autor(datosAutor)))
                        .collect(Collectors.toList());
        this.idiomas = datosLibro.idiomas().stream()
                .map(datosIdioma -> idiomaRepository.findByCodigo(datosIdioma.codigo())// Buscar idioma por código
                        .orElseGet(() -> new Idioma(datosIdioma))) // Crear un nuevo idioma si no existe
                .collect(Collectors.toList());
        this.descargas = datosLibro.descargas();
    }

    public Libro() {}

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public Long getDescargas() {
        return descargas;
    }

    public void setDescargas(Long descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return "----- Libro -----" + "\n" +
                "titulo = " + titulo + '\n' +
                "autores = " + autores.stream().map(Autor::toString).collect(Collectors.joining(", ")) + '\n' +
                "idiomas = " + idiomas.stream().map(Idioma::toString).collect(Collectors.joining(", ")) + '\n' +
                "descargas=" + descargas + '\n' +
                "----------------";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

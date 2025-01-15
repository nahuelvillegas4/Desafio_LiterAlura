package desafioAlura.desafioAlura.principal;

import desafioAlura.desafioAlura.model.Autor;
import desafioAlura.desafioAlura.model.Idioma;
import desafioAlura.desafioAlura.repository.AutorRepository;
import desafioAlura.desafioAlura.repository.IdiomaRepository;
import desafioAlura.desafioAlura.repository.LibroRepository;
import desafioAlura.desafioAlura.model.DatosApi;
import desafioAlura.desafioAlura.model.Libro;
import desafioAlura.desafioAlura.service.ConsumoAPI;
import desafioAlura.desafioAlura.service.ConvierteDatos;
import desafioAlura.desafioAlura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books";
    private LibroRepository repository;
    private AutorRepository autorRepository;
    private IdiomaRepository idiomaRepository;
    private ConvierteDatos conversor = new ConvierteDatos();
    private final LibroService libroService;
    public List<Libro> libros;
    public List<Autor> autores;

    public Principal(LibroRepository repository, AutorRepository autorRepository, IdiomaRepository idiomaRepository
            ,LibroService libroService) {
        this.repository = repository;
        this.autorRepository = autorRepository;
        this.idiomaRepository = idiomaRepository;
        this.libroService = libroService;
    }

    public void muestraElMenu(){
        var opcion = -1;
        while(opcion != 0){
            var menu = """
                    1 - Buscar libro por titulo 
                    2 - Mostrar libros consultados
                    3 - Mostrar autores buscadas
                    4 - Mostrar autores vivos en año determinado
                    5 - Cantidad de libros por idioma

                    0 - Salir
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch(opcion){
                case 1:
                    buscarLibro();
                    break;

                case 2:
                    mostrarLibrosConsultados();
                    break;

                case 3:
                    mostrarAutoresLibrosConsultados();
                    break;

                case 4:
                    mostrarAutoresVivosPeriodo();
                    break;

                case 5:
                    mostrarCantidadLibrosIdioma();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicacion");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }
    }


    private void buscarLibro() {
        DatosApi datos = getDatosLibro();
        Libro libro = libroService.guardarLibro(datos.results().stream()
                .findFirst().get());
        System.out.println(libro.toString());
        libro.getAutores().stream().forEach(a -> System.out.println(a));
    }

    private DatosApi getDatosLibro() {
        System.out.println("Escribe el nombre del libro a buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "/?search=" + nombreLibro.replace(" ", "%20"));
        DatosApi datos = conversor.obtenerDatos(json, DatosApi.class);
        return datos;
    }

    public void mostrarLibrosConsultados() {
        libros = repository.findAll();

        libros.forEach(libro -> System.out.println(libro.toString()));
    }

    public void mostrarAutoresLibrosConsultados(){
        autores = autorRepository.findAll();

        autores.forEach(autor -> System.out.println(autor.toString() + '\n' + autorRepository.findLibrosByAutorId(autor.getId())));
    }

    private void mostrarAutoresVivosPeriodo() {
        System.out.println("Ingrese el año a buscar");
        int ano = teclado.nextInt();
        autores = autorRepository.findAutorsByAno(ano);

        autores.forEach(autor -> System.out.println(autor.toString() + '\n' + autorRepository.findLibrosByAutorId(autor.getId())));
    }

    private void mostrarCantidadLibrosIdioma() {

        List<Object[]> resultados = repository.contarLibrosByIdioma();

        resultados.forEach(r -> System.out.println(r[0] + " || " + r[1]));
    }


}

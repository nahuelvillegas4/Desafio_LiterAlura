package desafioAlura.desafioAlura;

import desafioAlura.desafioAlura.principal.Principal;
import desafioAlura.desafioAlura.repository.AutorRepository;
import desafioAlura.desafioAlura.repository.IdiomaRepository;
import desafioAlura.desafioAlura.repository.LibroRepository;
import desafioAlura.desafioAlura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioAluraApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository repository;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private IdiomaRepository idiomaRepository;

	@Autowired
	private LibroService service;



	public static void main(String[] args) {
		SpringApplication.run(DesafioAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository, autorRepository, idiomaRepository,service);
		principal.muestraElMenu();
	}
}

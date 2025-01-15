package desafioAlura.desafioAlura.model;

import desafioAlura.desafioAlura.repository.AutorRepository;
import jakarta.persistence.*;

@Entity
@Table(name = "autores", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nombre", "ano_nacimiento", "ano_muerte"})
})
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "nombre")
    private String nombre;

    @Column(name = "ano_nacimiento")
    private long ano_nacimiento;

    @Column(name = "ano_muerte")
    private long ano_muerte;

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.ano_nacimiento = datosAutor.ano_nacimiento() == null ? 0 : datosAutor.ano_nacimiento();
        this.ano_muerte = datosAutor.ano_muerte() == null ? 0 : datosAutor.ano_muerte();
    }

    public Autor(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getAno_nacimiento() {
        return ano_nacimiento;
    }

    public void setAno_nacimiento(long ano_nacimiento) {
        this.ano_nacimiento = ano_nacimiento;
    }

    public long getAno_muerte() {
        return ano_muerte;
    }

    public void setAno_muerte(long ano_muerte) {
        this.ano_muerte = ano_muerte;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  nombre;
    }
}

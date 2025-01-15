package desafioAlura.desafioAlura.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "idiomas", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"codigo"})
})
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false)
    private String codigo;


    public Idioma() {}

    public Idioma(DatosIdioma datosIdioma) {
        this.codigo = datosIdioma.codigo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Idioma idioma = (Idioma) o;
        return Objects.equals(codigo, idioma.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return  codigo ;
    }
}

package desafioAlura.desafioAlura.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public record DatosIdioma(String codigo) {

    @JsonCreator
    public static DatosIdioma fromString(String codigo) {
        return new DatosIdioma(codigo);
    }

}

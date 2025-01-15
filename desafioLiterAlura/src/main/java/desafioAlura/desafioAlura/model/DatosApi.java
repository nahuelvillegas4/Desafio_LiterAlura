package desafioAlura.desafioAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;

public record DatosApi(
        @JsonAlias("count") int count,
        @JsonAlias("next") String next,
        @JsonAlias("previous") String previous,
        @JsonAlias("results") List<DatosLibro> results
) {
}

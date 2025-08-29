package Factory_Method;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public abstract class Libro {
    private String nombre;
    private String autor;
    private int precio;

}

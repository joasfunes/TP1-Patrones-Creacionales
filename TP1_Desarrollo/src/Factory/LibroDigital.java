package Factory;

import lombok.ToString;

@ToString(callSuper = true)
public class LibroDigital extends Libro{

    public LibroDigital(String nombre, String autor, int precio) {
        super(nombre, autor, precio);
    }
}

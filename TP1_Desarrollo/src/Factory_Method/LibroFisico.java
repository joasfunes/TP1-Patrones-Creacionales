package Factory_Method;

import lombok.ToString;

@ToString(callSuper = true)
public class LibroFisico extends Libro{

    public LibroFisico(String nombre, String autor, int precio) {
        super(nombre, autor, precio);
    }
}

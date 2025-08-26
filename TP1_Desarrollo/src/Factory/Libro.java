package Factory;

import lombok.ToString;

@ToString
public abstract class Libro {
    private String nombre;
    private String autor;
    private int precio;

    public Libro(String nombre, String autor, int precio) {
        this.nombre = nombre;
        this.autor = autor;
        this.precio = precio;
    }
}

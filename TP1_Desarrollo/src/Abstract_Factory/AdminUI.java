package Abstract_Factory;

import Factory_Method.Libro;

public class AdminUI implements InterfazUI{
    public void mostrarInformacionLibro(Libro libro) {
        System.out.println("Admin UI - Libro: " + libro.getNombre() +
                ", Autor: " + libro.getAutor() +
                ", Precio: " + libro.getPrecio());
    }
}

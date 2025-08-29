package Abstract_Factory;

import Factory_Method.Libro;

public class UsuarioUI implements InterfazUI{
    public void mostrarInformacionLibro(Libro libro) {
        System.out.println("Usuario UI - Libro: " + libro.getNombre() +
                ", Autor: " + libro.getAutor());
    }
}

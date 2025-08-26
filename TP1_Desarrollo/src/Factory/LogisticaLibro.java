package Factory;

import Singleton.Database;

import lombok.ToString;


@ToString
public class LogisticaLibro {
    private static Database database;

    public static Libro fabricar(String nombre, String autor, int precio, String tipo){
        Libro libro;
        if ("Digital".equalsIgnoreCase(tipo)) {
            libro = new LibroDigital(nombre,autor,precio);
        } else if ("Fisico".equalsIgnoreCase(tipo)) {
            libro = new LibroFisico(nombre,autor,precio);
        }else {
            throw new IllegalArgumentException("Tipo de libro desconocido: " + tipo);
        }
        database = Database.getDatabase("unica");
        database.agregarLibro(libro);
        return libro;
    }

}


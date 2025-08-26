package Singleton;

import Factory.Libro;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Database {
    private String value;
    private static Database instancia;
    private List<Libro> libros = new ArrayList<>();

    private Database(String valor){
        this.value=valor;
        System.out.println("Instancia Database creada con valor: " + value);
    }

    public static Database getDatabase(String valor){
        if(instancia==null){
            synchronized (Database.class){
                if (instancia==null){
                    instancia=new Database(valor);
                }
            }
        }
        return instancia;
    }

    public List<Libro> getLibros(){
        System.out.println(libros);
        return libros;
    }

    public String getValue(){
        return value;
    }

    public void agregarLibro(Libro libro){
        libros.add(libro);
    }
}

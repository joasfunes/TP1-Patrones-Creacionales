package Abstract_Factory;

import Factory_Method.Libro;

public class EnvioExpress implements MetodoEnvio{
    public void enviarLibro(Libro libro){
        System.out.println("Enviando libro '" + libro.getNombre() +
                "' por método express (tiempo estimado: 24 horas).");
    }
}

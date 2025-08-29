package Abstract_Factory;

import Factory_Method.Libro;

public class EnvioNormal implements MetodoEnvio{
    public void enviarLibro(Libro libro){
        System.out.println("Enviando libro '" + libro.getNombre() +
                "' por método normal (tiempo estimado: 5-7 días).");
    }
}

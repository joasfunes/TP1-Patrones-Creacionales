import Abstract_Factory.*;
import Factory_Method.Libro;
import Factory_Method.LogisticaLibro;
import Singleton.Database;

public class Main {
    public static void main(String[] args){


        //SINGLETON


        Runnable task1 = () -> {
            Database database = Database.getDatabase("Uno");
            System.out.println(Thread.currentThread().getName() + " obtuvo valor: " + database.getValue());
        };

        Runnable task2 = () -> {
            Database database = Database.getDatabase("Dos");
            System.out.println(Thread.currentThread().getName() + " obtuvo valor: " + database.getValue());
        };

        Thread t1 = new Thread(task1, "Hilo-1");
        Thread t2 = new Thread(task2, "Hilo-2");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //FACTORY METHOD


        Libro libro1 = LogisticaLibro.fabricar("Alicia en el pais de las maravillas","joa",30000,"Digital");
        Libro libro2 = LogisticaLibro.fabricar("Padre rico padre pobre", "joafunes",50000,"Fisico");
        LogisticaLibro.fabricar("Cien años de soledad", "Gabriel García Márquez", 25000, "Fisico");
        LogisticaLibro.fabricar("El código Da Vinci", "Dan Brown", 18000, "Digital");
        LogisticaLibro.fabricar("1984", "George Orwell", 22000, "Fisico");
        LogisticaLibro.fabricar("El arte de la guerra", "Sun Tzu", 15000, "Digital");
        LogisticaLibro.fabricar("Don Quijote de la Mancha", "Miguel de Cervantes", 35000, "Fisico");
        LogisticaLibro.fabricar("Steve Jobs: La biografía", "Walter Isaacson", 40000, "Digital");

        Database database = Database.getDatabase("Dos");
        database.getLibros();


        //ABSTRACT FACTORY


        AbstractFactoryUI adminFac = new AdminFactory();
        InterfazUI admin = adminFac.crearInterfazUI();
        admin.mostrarInformacionLibro(libro1);

        AbstractFactoryUI usuarioFac = new UsuarioFactory();
        InterfazUI usuario = usuarioFac.crearInterfazUI();
        usuario.mostrarInformacionLibro(libro2);

        AbstractFactoryEnvio envioNormalFac = new EnvioNormalFactory();
        MetodoEnvio envionormal = envioNormalFac.crearMetodoEnvio();
        envionormal.enviarLibro(libro1);

        AbstractFactoryEnvio envioExpressFac = new EnvioExpressFactory();
        MetodoEnvio envioexpress = envioExpressFac.crearMetodoEnvio();
        envioexpress.enviarLibro(libro2);
    }
}

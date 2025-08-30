import Abstract_Factory.*;
import Builder.Usuario;
import Factory_Method.Libro;
import Factory_Method.LogisticaLibro;
import Prototype.Prestamo;
import Singleton.Database;

public class Main {
    public static void main(String[] args){


        //SINGLETON


        System.out.println("=====================Singleton=====================\n");
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


        System.out.println("=====================Factory Method=====================\n");
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


        System.out.println("=====================Abstract Factory=====================\n");
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


        //BUILDER


        System.out.println("=====================Builder=====================\n");
        Usuario u = new Usuario.Builder()
                .nombre("Joaquin")
                .email("jfunes186@gmail.com")
                .domicilio("Pedro Conde 630")
                .telefono("2634279747")
                .build();

        Usuario.mostrar(u);


        //Prototype


        System.out.println("=====================Prototype=====================\n");
        Prestamo prestamo = new Prestamo(libro1, u, "30/08/2025", "31/12/2025");
        Prestamo copia1 = prestamo.clone();
        Prestamo copia2 = prestamo.clone();

        copia1.setLibro(libro2);
        copia2.setFechaInicio("2/11/2025");

        System.out.println(prestamo.getLibro());
        System.out.println(copia1.getLibro());
        System.out.println(copia2.getLibro());

        System.out.println(prestamo.getFechaInicio());
        System.out.println(copia1.getFechaInicio());
        System.out.println(copia2.getFechaInicio());
    }
}

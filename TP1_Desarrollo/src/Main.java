import Factory.LogisticaLibro;
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

        // Esperamos a que terminen
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //FACTORY METHOD


        LogisticaLibro.fabricar("Alicia en el pais de las maravillas","joa",30000,"Digital");
        LogisticaLibro.fabricar("Padre rico padre pobre", "joafunes",50000,"Fisico");

        Database database = Database.getDatabase("Dos");
        database.getLibros();
    }
}

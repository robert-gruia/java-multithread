package gruia.artist;   
import java.util.Random;
import java.util.concurrent.Semaphore;

public class StreetArtistSimulation {
    private static final int NUM_CHAIRS = 4; // Numero di sedie disponibili
    static final int MAX_WAIT_TIME = 20000; // Tempo massimo di attesa per una sedia (in millisecondi)

    private Semaphore chairsSemaphore = new Semaphore(NUM_CHAIRS);

    public void startSimulation() {
        Random random = new Random();
        int numCustomers = random.nextInt(10) + 1; // Numero casuale di clienti (tra 1 e 10)

        System.out.println("Numero di clienti: " + numCustomers);

        for (int i = 1; i <= numCustomers; i++) {
            Customer customer = new Customer(i, chairsSemaphore);
            customer.start();
        }
    }
    
}

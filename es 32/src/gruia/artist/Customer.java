package gruia.artist;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Customer extends Thread {
    private int customerId;
    private Semaphore chairsSemaphore;

    public Customer(int customerId, Semaphore chairsSemaphore) {
        this.customerId = customerId;
        this.chairsSemaphore = chairsSemaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente " + customerId + " è arrivato.");
            if (chairsSemaphore.tryAcquire(MAX_WAIT_TIME)) {
                // Il cliente ha ottenuto una sedia e può procedere per il ritratto
                System.out.println("Cliente " + customerId + " ha ottenuto una sedia.");
                getPortrait();
                System.out.println("Cliente " + customerId + " ha terminato il ritratto.");
                chairsSemaphore.release();
            } else {
                // Il cliente ha aspettato troppo e rinuncia al ritratto
                System.out.println("Cliente " + customerId + " ha aspettato troppo e rinuncia al ritratto.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getPortrait() throws InterruptedException {
        Random random = new Random();
        int portraitTime = random.nextInt(5000) + 1000; // Tempo di esecuzione del ritratto (tra 1 e 5 secondi)
        Thread.sleep(portraitTime);
    }
}

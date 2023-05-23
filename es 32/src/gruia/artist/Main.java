package gruia.artist;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        Random random = new Random();
        int numCustomers = random.nextInt(10) + 1; // Numero casuale di clienti (tra 1 e 10)

        System.out.println("Numero di clienti: " + numCustomers);

        for (int i = 1; i <= numCustomers; i++) {
            Customer customer = new Customer(i);
            customer.start();
        
    }
}
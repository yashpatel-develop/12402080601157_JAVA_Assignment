import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Runnable class for checking prime number
class PrimeTask implements Runnable {

    int number;

    PrimeTask(int number) {
        this.number = number;
    }

    public void run() {

        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(number + " is Prime");
        } else {
            System.out.println(number + " is Not Prime");
        }
    }
}

public class Primenumber {

    public static void main(String[] args) {

        int[] numbers = { 11, 14, 17, 20, 23 };

        // Executor Framework with thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int num : numbers) {
            executor.execute(new PrimeTask(num));
        }

        executor.shutdown();

        try {
            // Wait for all tasks to complete
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Tasks did not finish in time");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
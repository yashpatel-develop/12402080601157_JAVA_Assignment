//Problem Statement:
//2 Producer–Consumer problem using synchronization and inter-thread communication
// Shared resource class
class Buffer {

    int data;
    boolean available = false;

    // Producer method
    synchronized void produce(int value) {

        while (available) {
            try {
                wait();
            } catch (Exception e) {
            }
        }

        data = value;
        System.out.println("Produced: " + data);

        available = true;
        notify();
    }

    // Consumer method
    synchronized void consume() {

        while (!available) {
            try {
                wait();
            } catch (Exception e) {
            }
        }

        System.out.println("Consumed: " + data);

        available = false;
        notify();
    }
}

// Producer thread
class Producer extends Thread {

    Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
        }
    }
}

// Consumer thread
class Consumer extends Thread {

    Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {
            buffer.consume();
        }
    }
}

// Main class
public class ProducerConsumer {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);

        p.start();
        c.start();
    }
}
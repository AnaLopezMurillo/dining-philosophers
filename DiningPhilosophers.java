//
import java.util.Random;
//
public class DiningPhilosophers {
    // should run ideally forever without stopping or deadlocking

    public static class Philosopher extends Thread {
        // think, eat, and think again for arbitrary amount of time
        // to avoid deadlock: pick up both forks at the same time

        private final Object leftFork;
        private final Object rightFork;
        private final boolean reverseOrder;

        public Philosopher(Object leftFork, Object rightFork, boolean reverseOrder) {
            this.leftFork = leftFork;
            this.rightFork = rightFork;
            this.reverseOrder = reverseOrder;
        }

        public void action(String action) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " is " + action);
            Thread.sleep((new Random()).nextInt(5000)); // perform action for a random time between 1-5 seconds
        }

        public void run() {
            while (true) {
                try {
                    // think
                    action("Thinking");

                    // eat by locking both forks at the same time for an amount of time
                    // https://stackoverflow.com/questions/23217190/how-can-a-thread-acquire-lock-on-two-objects-simultaneously-as-in-this-case
                    // order of forks changes, only for the last philosopher
                    if (reverseOrder) {
                        synchronized (rightFork) {
                            synchronized (leftFork) {
                                action("Eating");
                            }
                        }
                    } else {
                        synchronized (leftFork) {
                            synchronized (rightFork) {
                                action("Eating");
                            }
                        }
                    }

                    // thinking again
                    action("Thinking");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];    // 5 philosophers
        Object[] forks = new Object[philosophers.length];   // 5 forks

        // make each fork distinct
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        // make new philosophers with distinct forks
        // change reservseOrder only for the last philosopher
        for (int i = 0 ; i < philosophers.length; i++) {
            boolean reverseOrder = (i == philosophers.length - 1);
            philosophers[i] = new Philosopher(forks[i], forks[(i + 1) % forks.length], reverseOrder);
            philosophers[i].start();
        }
    }
}

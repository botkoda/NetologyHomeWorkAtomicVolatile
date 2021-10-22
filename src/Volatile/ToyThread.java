package Volatile;

import static Volatile.Main.volatileVal;

public class ToyThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (volatileVal) {
                System.out.println(Thread.currentThread().getName() + " Выключает тумблер");
                volatileVal = false;
            }
            InterruptedException sa = new InterruptedException();
        }
        System.out.println("Игрушка схлопнулась");
    }
}

package Volatile;

import static Volatile.Main.volatileVal;

public class UserThread extends Thread {
    static final int SLEEP_TIME = 3000;
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (!volatileVal) {
                System.out.println(Thread.currentThread().getName() + " Включает тумблер");
                volatileVal = true;
            }
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " закончил упражнение");
                Thread.currentThread().interrupt();
            }
        }
    }
}

package Volatile;

public class UserThread extends Thread {
    VolatileClass v;

    UserThread(VolatileClass v) {
        this.v = v;
    }

    static final int SLEEP_TIME = 3000;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (!v.volatileVal) {
                System.out.println(Thread.currentThread().getName() + " Включает тумблер");
                v.volatileVal = true;
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

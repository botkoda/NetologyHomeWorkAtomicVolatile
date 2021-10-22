package Volatile;

public class ToyThread extends Thread {
    VolatileClass  v;

    ToyThread(VolatileClass v){
        this.v=v;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (v.volatileVal) {
                System.out.println(Thread.currentThread().getName() + " Выключает тумблер");
                v.volatileVal = false;
            }
        }
        System.out.println("Игрушка схлопнулась");
    }


}

package Volatile;

public class Main {
    static final int SLEEP_TIME = 10000;
    static boolean temp = true;

    public static void main(String[] args) throws Exception {
        VolatileClass v=new VolatileClass();
        Thread toyThread = new ToyThread(v);
        toyThread.setName("Игуршка");
        Thread userThread = new UserThread(v);
        userThread.setName("Пользователь");

        System.out.println("Начало игры");
        //старт потоков
        userThread.start();
        toyThread.start();
        //потоки работают
        Thread.sleep(SLEEP_TIME);

        //останавливаем пользовательский поток
        // джоиним чтоб дождаться завершения
        // и останавливаем поток игрушки
        userThread.interrupt();
        userThread.join();
        toyThread.interrupt();


    }
}

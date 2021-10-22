package Volatile;

public class Main {
    static volatile boolean volatileVal = false;
    static final int SLEEP_TIME = 10000;
    static boolean temp = true;

    public static void main(String[] args) throws Exception {
        Thread toyThread = new ToyThread();
        toyThread.setName("Игуршка");
        Thread userThread = new UserThread();
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

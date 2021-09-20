public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Salon salon = new Salon();

        Runnable buy = salon::buyCar;
        Runnable produce = salon::produceCar;
        new Thread(buy, "1. Ivan").start();
        new Thread(buy, "2. John").start();
        new Thread(buy, "3. Josh").start();
        new Thread(buy, "4. Ann").start();
        new Thread(buy, "5. Boris").start();
        new Thread(buy, "6. Denis").start();
        new Thread(buy, "7. Martin").start();
        new Thread(buy, "8. Bob").start();
        new Thread(buy, "9. Fill").start();
        new Thread(buy, "10. Anton").start();
        new Thread(produce, "1. Toyota").start();
        new Thread(produce, "2. Nissan").start();
        new Thread(produce, "3. BMV").start();
        new Thread(produce, "4. Mazda").start();
        new Thread(produce, "5. Mercedes").start();
        new Thread(produce, "6. VAZ").start();
        new Thread(produce, "7. GAZ").start();
        new Thread(produce, "8. Lamborghini").start();
        new Thread(produce, "9. Renault").start();
        new Thread(produce, "10. Volkswagen").start();
    }
}

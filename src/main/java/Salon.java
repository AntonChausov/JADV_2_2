import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Salon {

    List<String> cars = new ArrayList<>();
    Lock seller = new ReentrantLock(true);
    Condition carCondition = seller.newCondition();

    public void buyCar() {
        seller.lock();
        try {
            String buyerName = Thread.currentThread().getName();
            System.out.printf("%s зашел в автосалон\n", buyerName);
            while (getCarsCount() == 0) {
                System.out.println("Машин нет");
                carCondition.await();
            }
            Thread.sleep(500);
            String car = getCar();
            System.out.printf("%s уехал на новеньком авто от %s\n", buyerName, car);
        } catch (InterruptedException err) {
            err.printStackTrace();
        } finally {
            seller.unlock();
        }
    }

    public void produceCar(){
        seller.lock();
        String producerName = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            addCar(producerName);
            System.out.printf("Производитель %s выпустил 1 авто\n", producerName);
            carCondition.signal();
        } catch (InterruptedException err) {
            err.printStackTrace();
        } finally {
            seller.unlock();
        }
    }

    private String getCar() {
        Random random = new Random();
        return cars.remove(random.nextInt(getCarsCount()));
    }

    private int getCarsCount() {
        return cars.size();
    }

    private void addCar(String producer) {
        cars.add(producer);
    }
}

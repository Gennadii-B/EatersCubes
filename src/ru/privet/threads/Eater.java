package ru.privet.threads;

import ru.privet.entitys.CollectionCubes;
import ru.privet.entitys.Cube;

/**
 * Created by gendy on 28.12.16.
 */
public class Eater implements Runnable {
    private int processeRange;
    private Cube cube;
    String name;
    Object lock;

    public Eater(int processeRange, Object l) {
        this.processeRange = processeRange;
        this.lock = l;
    }

    @Override
    public void run() {
        name = Thread.currentThread().getName();
        while(true){
            try {
                processe();
            }catch(ArrayIndexOutOfBoundsException e) {
                System.out.println
                        ("---------------- eater схватил съеденный куб ----------------");
            }catch(NullPointerException e){
                System.out.println
                        ("---------------- eater схватил пустую ячейку ----------------");
            }
        }
    }

    private void processe() throws ArrayIndexOutOfBoundsException, NullPointerException{
            if (CollectionCubes.getCubes().size() >= processeRange + 1) {
                cube = CollectionCubes.getCubes().remove(processeRange);
                System.out.println(name + " съел куб № " + cube.getCubeId());
            } else {
                System.out.println("eater " + name + " ждет");
                threadWait();
            }
    }

    private void threadWait(){
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                System.out.println("пробуждение вызвано");
            }
        }
    }
}

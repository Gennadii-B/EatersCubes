package ru.privet.threads;

import ru.privet.entitys.CollectionCubes;
import ru.privet.entitys.Cube;

import java.util.Random;

/**
 * Created by gendy on 28.12.16.
 */
public class Creator implements Runnable {

    private Random random = new Random();
    private int amountCubes;
    private int sleepTime;
    private int startAmount;

    public Creator(int sleepTime, int startAmount) {
        this.startAmount = startAmount;
        this.sleepTime = sleepTime * 1000;
    }

    @Override
    public void run() {
        while(true){

            amountCubes = startAmount + random.nextInt(10);
            createCubes(amountCubes);
            System.out.println("кубов добавлено в коллекцию ///- " + CollectionCubes.getCubes().size() + " -///");
            threadSleep();
        }
    }

    private void threadSleep(){
        try{
            Thread.sleep(sleepTime);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private void createCubes(int amount){
        for(int i = 0; i < amount; i++){
            CollectionCubes.getCubes().add(new Cube());
        }
    }
}

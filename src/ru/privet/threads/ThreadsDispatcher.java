package ru.privet.threads;

import ru.privet.entitys.CollectionCubes;

/**
 * Created by gendy on 28.12.16.
 */
public class ThreadsDispatcher implements Runnable {

    Object lock;

    public ThreadsDispatcher(Object l) {
        this.lock = l;
    }

    @Override
    public void run() {
        while(true){

                if(!CollectionCubes.getCubes().isEmpty()) {
                    synchronized (lock) {
                    System.out.println("eaters пробудились");
                    lock.notifyAll();
                    threadSleep();
                    }

                }
            threadSleep();


        }

    }

    private void threadSleep(){
        try{
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

package ru.privet;

import ru.privet.entitys.CollectionCubes;
import ru.privet.threads.Creator;
import ru.privet.threads.Eater;
import ru.privet.threads.ThreadsDispatcher;



public class Main {

    public static void main(String[] args) {

        Object lock = new Object();

        Thread creator = new Thread(new Creator(3, 3));
        Thread eaterAlpha = new Thread
                (new Eater(0, lock), "eaterAlpha");
        Thread eaterBeta = new Thread
                (new Eater(1, lock), "eaterBeta");
        Thread eaterGamma = new Thread
                (new Eater(2, lock), "eaterGamma");
        Thread eatersDispatcher = new Thread
                (new ThreadsDispatcher(lock), "Dispatcher");


        creator.start();
        eatersDispatcher.start();
        eaterAlpha.start();
        eaterBeta.start();
        eaterGamma.start();
    }
}

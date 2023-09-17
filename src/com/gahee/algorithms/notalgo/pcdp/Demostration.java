package com.gahee.algorithms.notalgo.pcdp;

import java.util.concurrent.*;

class Demostration {
    public static void main( String args[] ) throws Exception {
        // create an executor service
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // create an instance of Phaser class and register only a single that will arrive
        // at the barrier
        final Phaser phaser = new Phaser(1);

        try {
            // a thread registers with the Phaser post construction of the instance
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    phaser.register();
                }
            });

            // main thread bulk-registers two more parties
            phaser.bulkRegister(2);

            // main thread registering one more party.
            phaser.register();

            // we now have 5 parties registered with the Phaser instance
            // we instantiate four threads and have them arrive at the barrier
            for (int i = 0; i < 4; i++) {
                executorService.submit(new Runnable() { // submit - Future 를 반환
                    @Override
                    public void run() {
                        phaser.arriveAndAwaitAdvance();
                        System.out.println(Thread.currentThread().getName() + " moving past barrier.");
                    }
                });
            }

            // sleep for a while so that previous threads can arrive at the barrier
            Thread.sleep(2000);

            // before arriving at the barrier, print the counts of parties
            System.out.println(Thread.currentThread().getName() + " just before arrived. \n Arrived parties: " + phaser.getArrivedParties() +
                    "\n Registered parties: " + phaser.getRegisteredParties() +
                    "\n Unarrived parties: " + phaser.getUnarrivedParties());
            phaser.arriveAndAwaitAdvance();

        } finally {
            // remember to shut down the executor in a `finally` block
            executorService.shutdown();
            boolean result = executorService.awaitTermination(1, TimeUnit.HOURS);
            System.out.println("result = " + result);
        }

        // main thread prints party counts for the barrier
        System.out.println(Thread.currentThread().getName() + " exiting. \n Arrived parties: " + phaser.getArrivedParties() +
                "\n Registered parties: " + phaser.getRegisteredParties() +
                "\n Unarrived parties: " + phaser.getUnarrivedParties());
    }
}
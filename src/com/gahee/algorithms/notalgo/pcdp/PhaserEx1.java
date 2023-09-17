package com.gahee.algorithms.notalgo.pcdp;

import java.util.concurrent.Phaser;

public class PhaserEx1 {

    /*
        // initialize phaser ph	for use by n tasks ("parties")
        Phaser ph = new Phaser(n);
        // Create forall loop with n iterations that operate on ph
        forall (i : [0:n-1]) {
          print HELLO, i;
          int phase = ph.arrive();

          myId = lookup(i); // convert int to a string

          ph.awaitAdvance(phase);
          print BYE, myId;
    } */
    public static void main(String[] args) {
        Phaser phaser = new Phaser(4);
        phaser.register();
        System.out.println("phaser object registered");

        int pc = phaser.getPhase();
        System.out.println("initial phase count is " + pc);

        new PhaserEx1().test(phaser);
        System.out.println("Thread awaitAdvance " + phaser.awaitAdvance(1));
    }

    private void test(final Phaser p) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }

    //threads / tasks register with an instance of Phaser using register() or bulkRegister()
    // there is no internal book-keeping maintainted by the Phaser instnace.
    // Thread 가 자신이 어떤 Phaser 에 등록 되었는지 알 수 없다
    //
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.atomicintexample;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class AtomicIntExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Data d = new Data(1);

        /*Thread t1 =
            new Thread(() -> {
                Semaphore s = new Semaphore(1);
                try {
                    s.acquire();

                        for (int i = 0; i < 10; i++) {
                            try {
                                //Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AtomicIntExample.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            //if (d.value == 1) {
                            if (d.value.get() == 1) {
                                System.out.println("Thread: "
                                    + Thread.currentThread().getName()
                                    + " Hello # "
                                    + i);
                                //Проверить, равно ли текущее значение 1,
                                //если да - установить в 2
                                d.value.compareAndSet(1, 2);
                            } else {

                                System.out.println("Thread: "
                                    + Thread.currentThread().getName()
                                    + " Hello # "
                                    + i);
                                d.value.compareAndSet(2, 1);
                            }
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AtomicIntExample.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AtomicIntExample.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        s.release();
                    }
            });*/
        /*Thread t2 =
            new Thread(() -> {
                try {
                    s.acquire();
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AtomicIntExample.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //if (d.value == 2) {
                        if (d.value.get() == 2) {
                            System.out.println("Thread: "
                                + Thread.currentThread().getName()
                                + " Hello # "
                                + i);
                            d.value.compareAndSet(2, 1);
                        }
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AtomicIntExample.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(AtomicIntExample.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    s.release();
                }
            });*/
        Worker w = new Worker(d);
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    
}

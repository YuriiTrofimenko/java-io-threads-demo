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
public class Worker implements Runnable {

    Semaphore s = new Semaphore(1);
    Data d = new Data(1);
    
    public Worker(Data _d){
    
        d = _d;
    }
    
    @Override
    public void run() {
        try {
                for (int i = 0; i < 10; i++) {
                    s.acquire();
                    /*try {
                        //Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AtomicIntExample.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
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
                    s.release();
                    /*try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AtomicIntExample.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(AtomicIntExample.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                
            }
    }
    
}

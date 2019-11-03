/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.synchro2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yurii
 */
class Worker implements Runnable {
    
    private int id;
    private Data d;
    private Thread t;

    public Worker(int id, Data d) {
        this.id = id;
        this.d = d;
        t = new Thread(this);
        t.start();
    }
    
    public void join() throws InterruptedException{
        t.join();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            
            synchronized(d){
                while(id != d.getState()){
                    try {
                        d.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (id == 1) {
                    d.Tic();
                } else if (id == 2) {
                    d.Tak();
                }
                d.notify();
            }
        }
    }
}

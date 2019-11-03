/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.ex0;

/**
 *
 * @author yurii
 */
public class Ex0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        /* Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello " + i);
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("World " + i);
            }
        });
        
        t1.start();
        t2.start();
        
        Thread.sleep(10);
        t2.stop();
        
        t1.join();
        // t2.join(); */
        Worker w1 = new Worker(100);
        Thread t1 = new Thread(w1);
        t1.start();
        Thread.sleep(8);
        w1.active = false;
        // t1.stop();
    }
    
    private synchronized static void demo1(){
        System.out.println("demo1");
    }
    
    private static void demo2(){
        System.out.println("pre demo2");
        synchronized(new Object()){
            System.out.println("demo2");
        }
        System.out.println("post demo2");
    }
}

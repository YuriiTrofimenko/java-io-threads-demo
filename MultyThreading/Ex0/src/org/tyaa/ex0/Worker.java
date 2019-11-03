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
public class Worker implements Runnable {
    
    private int n;
    public boolean active = true;
    
    public Worker(int _n){
        n = _n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            if (active) {
                System.out.print("Hello ");
                System.out.print("World");
                System.out.println("! " + i);
            } else {
                break;
            }
        }
    }
}

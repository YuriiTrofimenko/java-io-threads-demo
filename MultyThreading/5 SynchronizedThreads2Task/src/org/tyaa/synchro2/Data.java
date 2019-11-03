/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.tyaa.synchro2;

/**
 *
 * @author Юрий
 */
public class Data
{
    private int state = 1; // 1 or 2

    public int getState() { return state; }

    public void Tic(){
        System.out.print("Tic-");
        state = 2;
    }
    public void Tak(){
        System.out.println("Tak");
        state = 1;
    }
}

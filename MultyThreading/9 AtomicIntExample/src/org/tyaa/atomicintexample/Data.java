/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.atomicintexample;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author student
 */
public class Data {
    
    public AtomicInteger value =
        new AtomicInteger();
    //public int value;
    public Data(int _initValue){
    
        value.set(_initValue);
        //value = _initValue;
    }
    
    //public void beginLoop(){while(true){System.out.println(value.get());}}
}

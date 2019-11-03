package demo2;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException
    {
        Data d=new Data();
        
        Thread tr1 = new Thread(new MyThread(d));
        Thread tr2 = new Thread(new MyThread(d));
        
        tr1.start();
        tr2.start();
        
        tr1.join(15000);
        tr2.join(15000);
        
        System.out.println(d.count);
        System.out.println(Data.countSt);
    }
}

class Data
{
    int count =0;
    static int countSt =0;
}

class MyThread implements Runnable {
  
    Data obj;
    
    MyThread(Data d){
        obj = d;
    }
    
    //TODO: синхронизировать работу обоих методов с полями count и countSt
    
    void Add(){
        try {
            synchronized(obj){
                Thread.sleep(1);
                int n=obj.count;
                n++;
                Thread.sleep(1);
                obj.count=n;
            }
            
        } catch (InterruptedException ex) {       }
    }
    static synchronized void AddStatic() {
        try {
            Thread.sleep(1);
            int n=Data.countSt;
            n++;
            Thread.sleep(1);
            Data.countSt=n;
        } catch (InterruptedException ex) {       }
    }
    public void run() {
        for(int i=0; i<1000; i++) Add();
        for(int i=0; i<1000; i++) AddStatic();
    }
}

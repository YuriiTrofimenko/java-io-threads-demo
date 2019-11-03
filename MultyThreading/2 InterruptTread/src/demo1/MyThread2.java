package demo1;
//Класс второго потока создаем интерфейсом:
//сначала создаем класс, реализующий интерфейс Runnable

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThread2 implements Runnable
{
    public volatile boolean mCancel = false;
    //Поле для класса потока
    public Thread thread;
    //В конструкторе инициализируем поле thread анонимным классом на основе
    //текущего экземпляра класса MyThread2
    public MyThread2()
    {
        thread = new Thread(this);
    }
    
    long n = 40;
    long fibBin (long n)
    {
        return (long) (((pow(((1+sqrt(5))/2),n))-(pow(((1-sqrt(5))/2),n)))/(sqrt(5)));
    }
    
    @Override
    public void run()
    {
        try
        {
            //Пока работает этот поток - n раз выводим номер итерации в консоль
            for (int i = 0; i < n; i++)
            {

                if(mCancel)
                {
                    throw new InterruptedException();
                }
                fibBin(i);
                System.out.println("Name = " + Thread.currentThread().getName() +
                    ", i = " + i);
            }
        } catch (InterruptedException ex) {
                    Logger.getLogger(MyThread2.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}

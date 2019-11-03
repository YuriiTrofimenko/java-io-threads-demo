package demo1;
//Класс первого потока создаем наследованием Thread
public class MyThread1 extends Thread
{
    @Override
    public void run()
    {
        long n = 40;
        //Пока работает этот поток - n раз выводим номер итерации в консоль
        for (int i = 0; i < n; i++)
            System.out.println("Name = " + Thread.currentThread().getName() +
                ", i = " + i);
    }
}

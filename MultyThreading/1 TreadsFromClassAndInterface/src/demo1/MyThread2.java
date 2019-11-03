package demo1;
//Класс второго потока создаем интерфейсом:
//сначала создаем класс, реализующий интерфейс Runnable
public class MyThread2 implements Runnable
{
    //Поле для класса потока
    public Thread thread;
    //В конструкторе инициализируем поле thread анонимным классом на основе
    //текущего экземпляра класса MyThread2
    public MyThread2()
    {
        thread = new Thread(this);
    }
    @Override
    public void run()
    {
        long n = 300;
        //Пока работает этот поток - n раз выводим номер итерации в консоль
        for (int i = 0; i < n; i++)
            System.out.println("Name = " + Thread.currentThread().getName() +
                ", i = " + i);
    }
}

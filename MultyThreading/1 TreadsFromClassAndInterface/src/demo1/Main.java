package demo1;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        // TODO Auto-generated method stub
        final MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        
        //myThread1.setDaemon(true);
        
        myThread1.start();
        myThread2.thread.start();
        //Третий пользовательский поток создаем в виде
        //анонимного экземпляра класса Thread, у которого переопределяем
        //метод run(); поток просим запустить сразу методом start()
        new Thread()
        {
            @Override public void run()
                {
                    int n = 30;
                    for (int i = 0; i < n; i++)
                    {
                        System.out.println("Name = "
                                + Thread.currentThread().getName()
                                + ", i = "
                                + i);
                    }
                }
        }.start();
        myThread1.join();
        //myThread2.thread.join();

        System.out.println("end of main");
    }

}

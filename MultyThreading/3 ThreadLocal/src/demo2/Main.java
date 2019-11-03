package demo2;

import java.util.Random;

public class Main {
    //Статическая переменная, общая для всех потоков
    private static Integer mThreadGlobal = 100500;
    //Статическая переменная, собственная для каждого потока
    private static ThreadLocal<Integer> mThreadLocal =
    new ThreadLocal<Integer>()
    {
        @Override
        protected Integer initialValue()
        {
            return new Random().nextInt(100);
        }
    };

    public static void main(String[] args)
    {
        mThreadLocal.set(new Random().nextInt(100));
        Runnable runner = new Runnable()
        {
            public void run()
            {
                mThreadLocal.set(new Random().nextInt(100));
                System.out.println("Thread "
                        + Thread.currentThread().getName()
                        + ", value of mThreadLocal is "
                        + mThreadLocal.get()
                        + ", value of mThreadGlobal is "
                        + mThreadGlobal
                );
            }
        };
        
        //Создаем и стартуем три пользовательских потока
        for (int i=0; i<3; i++)
        {
            (new Thread (runner)).start();
        }

        System.out.println("Main Thread, value of mThreadLocal is "
                + mThreadLocal.get()
                + ", value of mThreadGlobal is "
                + mThreadGlobal
        );
    }
}

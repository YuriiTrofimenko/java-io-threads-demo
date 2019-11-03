package org.tyaa.tpool;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        new Data().solve();
    }

}
class Data {
    public void solve() throws Exception
    {
            List<Future<String>> list =
                    new ArrayList<Future<String>>();

            ExecutorService es = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 7; i++)
                    list.add(es.submit(new MyCallable<String>()));

            es.shutdown();
            //es.shutdownNow();

            for (Future<String> f : list)
                    System.out.println(f.get());
            
            // And with callbacks: Java CompleatableFuture
            // https://www.baeldung.com/java-completablefuture
    }
}
class MyCallable<T> implements Callable {

	@Override
	public T call() throws Exception {

		String res = Thread.currentThread().getName();
                Thread.sleep(1000);
                System.out.println("done");
		return (T)res;
	}
}
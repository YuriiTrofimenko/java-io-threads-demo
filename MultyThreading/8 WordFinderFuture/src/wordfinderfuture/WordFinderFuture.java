/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordfinderfuture;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @author yurii
 */
public class WordFinderFuture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.print("Укажите базовый каталог (например, /usr/loacl/jdk/lib): ");
        String directory = in.nextLine();
        System.out.print("Введите ключевое слово (например, volatile): ");
        String keyword = in.nextLine();
        MatchCounter counter = new MatchCounter(new File(directory), keyword);
        FutureTask task = new FutureTask(counter);
        Thread t = new Thread(task);
        t.start();
        try {
            System.out.println(task.get().toString() + " файлов найдено.");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
        }
    }

}

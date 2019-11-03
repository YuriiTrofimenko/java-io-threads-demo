/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.javaiodemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author yurii
 */
public class JavaIODemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        /* File newFile = new File("./test.txt");
        newFile.createNewFile();
        
        try(FileWriter fr = new FileWriter(newFile)){
            fr.append(" Java!");
            // fr.close();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        } */
        
        Person p = new Person();
        p.fio = "Ivan Ivanovich Ivanov";
        p.balances.add(new BigDecimal(1500));
        p.balances.add(new BigDecimal(2500));
        
        // ((ArrayList)p.balances).clone();
        
        Person p2 = (Person) deepCopy(p);
        
        p2.fio = "John Doe";
        p2.balances.set(0, p2.balances.get(0).add(new BigDecimal(1500)));
        System.out.println(p2.fio);
        System.out.println(p2.balances.get(0));
        
        System.out.println(p.fio);
        System.out.println(p.balances.get(0));
        
        // WCF
    }
    
    private static Object deepCopy(Object object) {
        try {
          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
          ObjectOutputStream outputStrm = new ObjectOutputStream(outputStream);
          outputStrm.writeObject(object);
          ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
          ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
          return objInputStream.readObject();
        }
        catch (Exception e) {
          e.printStackTrace();
          return null;
        }
      }
}

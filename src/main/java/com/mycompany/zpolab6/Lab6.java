/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zpolab6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;


public class Lab6 {
    private String[] names;

    public void getLine() {
        Scanner s = new Scanner(System.in);
        String line;
        System.out.println("Podaj nazwy klas(po przecinku): ");
        line = s.nextLine();
        names = line.split(",");
        createObject();
    }
    
    private void createObject() {
        Arrays.stream(names).map(n -> {
            try {
                return Class.forName(this.getClass().getPackage().getName()+"."+n).getConstructor().newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        }).forEach(o -> Arrays.stream(o.getClass().getDeclaredMethods()).filter(a -> a.getAnnotation(Scheduled.class) != null).forEach(m -> setTimer(o, m)));
    }

    private void setTimer(Object o, Method m) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    m.invoke(o);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }, 0, m.getAnnotation(Scheduled.class).period());
    }
}

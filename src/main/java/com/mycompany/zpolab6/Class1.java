/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zpolab6;

public class Class1 {
    public Class1()
    {
        
    }
    
     @Scheduled(period=500)
    public void FirstMethod()
    {
        
        System.out.println("Class1: FirstMethod");
    }
    @Scheduled(period=1000)
    public void SecondMethod()
    {
        System.out.println("Class1: SecondMethod");
    }
}

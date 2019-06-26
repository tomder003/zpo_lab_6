/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.zpolab6;


public class Class2 {
    @Scheduled(period=1500)
    public void ThirdMethod(){
        
        System.out.println("Class2: ThirdMethod");
    }
    @Scheduled(period=2000)
    public void FourthMethod(){
        System.out.println("Class2: FourthMethod");
    }
}

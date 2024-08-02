/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankcustomer.Dao;

import java.time.Clock;
import java.util.UUID;

/**
 *
 * @author MVR-PC
 */
public class NewClass {

    private static final long LIMIT = 10000000000L;
    private static long last = 0;

    public static void main(String[] args) {
        long id = System.currentTimeMillis() % LIMIT;
        if (id <= last) {
            id = (last + 1) % LIMIT;
        }
        last = id;
        System.out.print("last id "+last);
          String randomStr = usingRandomUUID();

    System.out.println("A random string of 32 characters: " + randomStr);
    }

     static String usingRandomUUID() {

    UUID randomUUID = UUID.randomUUID();

    return randomUUID.toString();

  }
    
}

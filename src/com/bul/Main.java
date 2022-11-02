package com.bul;

import java.security.SecureRandom;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    
    System.out.print("Maximum iterasyon sayisi girin: ");
    Scanner input = new Scanner(System.in);
    int maxiter = input.nextInt();
    int i = 0;
    
    String bdArray = "110111101111011101101111010101";
    Integer bd1Count = count1(bdArray);
    Integer fbd = 20 * bd1Count - 100;
    String newBdArray = "";
    int n=0;
    while (n<maxiter) {
        newBdArray = randomBinary(bdArray);
        Integer fbdnew = 20 * count1(newBdArray);
        if(fbd<fbdnew) {
            fbd = fbdnew;
        }
        n++;
    }
    System.out.println("the best binary is : " + newBdArray + " and the best value is: " + fbd);
    }
    
    
    public static String randomBinary(String value){
        SecureRandom mixer = new SecureRandom();
        StringBuilder randomValue = new StringBuilder(30);
        for(int i=0;i<30;i++){
            randomValue.append(value.charAt(mixer.nextInt(value.length())));
        }
        return randomValue.toString();
    }
    
    public static Integer count1(String value) {
        int count = 0;
        String [] arrayOfString = value.split("");
        for(int i=0; i<value.length(); i++) {
            if(arrayOfString[i].equals("1")) {
                count ++;
            }
        }
        return count;
    }
}

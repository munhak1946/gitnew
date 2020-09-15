package com.company;

import java.io.*;


public class Main {
    public static void main(String[] args) {

        System.out.println("================================================");
        RIP input =new RIP();
        int[] A = input.read_input_file(new File("hw1_input.txt"));

        FMCS fmcs = new FMCS();
        Result result = fmcs.find_max_crossing_subarray(A,0,A.length-1);
        System.out.println("test case1 RESULT \npurchase date : "+result.low+"\nsell date : "+result.high+"\nprofit : "+result.sum);


    }
}

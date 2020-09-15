package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RIP {

    public int[] compute_price_change(int[] original_A){
        int[]A = new int[original_A.length-1];
        for(int i = 0; i < original_A.length -1 ; i++ ){
            A[i] = original_A[i+1]-original_A[i];
        }

        return A;
    }

    public int[] read_input_file(File filepath){
        ArrayList<Integer> arrayList_A =new ArrayList<>();
        try{

            Scanner scanner1 = new Scanner(filepath);
            while (scanner1.hasNextLine()) {
                String line = scanner1.nextLine();
                Scanner scanner2 = new Scanner(line).useDelimiter(",");

                while(scanner2.hasNextInt()) {
                    arrayList_A.add(scanner2.nextInt());
                }

            }

        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("cannot read the line");
        }

        Iterator<Integer> iterator= arrayList_A.iterator();
        int[] A= new int[arrayList_A.size()];
        int index=0;
        while(iterator.hasNext()){
            A[index++]=iterator.next().intValue();

        }
        return A;
        //return compute_price_change(A);
    }

}

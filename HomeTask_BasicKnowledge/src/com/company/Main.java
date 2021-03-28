package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) {
// ___________________________ 1 ______________________________________________
        try{
            System.out.println(getIntegersFromList(Arrays.asList(1,2,"a","b","aasf","1","123",231)));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

// ___________________________ 2 ______________________________________________
        System.out.println(first_non_repeating_letter("Stress"));


// ___________________________ 3 ______________________________________________
        System.out.println(digital_root(132189));

// ___________________________ 4 ______________________________________________
          System.out.println(numberOfPairs(5,new int[]{1,3,6,2,2,0,4,5}));
          System.out.println(numberOfPairs2(5,new int[]{1,3,6,2,2,0,4,5}));

// ___________________________ 5 ______________________________________________
            System.out.println(inviteList("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"));

//____________________________extra1__________________________________________
        System.out.println(nextBigger(2017));

// ____________________________extra2__________________________________________
        System.out.println(toIPv4(2149583361L));


    }


//  Task1

    public static List<Integer> getIntegersFromList(List list){

        if(!isRightList(list))
            throw new IllegalArgumentException("List should only consists of non-negative integers and" +
                " strings.");

        List<Integer> integers = new ArrayList<>();
        for(Object object: list){
            if(object instanceof Integer)
                integers.add((Integer)object);
        }
        return integers;
    }

    public static boolean isRightList(List list){
        for(Object object: list){
            if(!(object instanceof Integer) && !(object instanceof String))
                return false;
            else if (object instanceof Integer && (Integer)object < 0)
                return false;
        }
        return true;
    }

//    Task2

    public static char first_non_repeating_letter(String string){

        for(int i=0;i<string.length()-1;i++){
            String c = String.valueOf(string.charAt(i));
            if(string.length()-string.replaceAll("(?i)"+c,"").length()==1)
                return c.charAt(0);
        }
        return '\0';
    }

//    Task3

    public static int digital_root(int x){

        if(x<10) return x;
        else{
            return digital_root(x%10 + digital_root(x/10));
        }
    }

//    Task4
    public static int numberOfPairs(int target, int[] array){
        int count = 0;
        for (int i = 0;i<array.length-1;i++){
            for(int j = i;j<array.length;j++){
//                System.out.println(array[i]+" + "+array[j]+" = "+ (array[i]+array[j]));
                if(array[i]+array[j]==target && i!=j) count++;
            }
        }
        return count;
    }

//     Task4.2

    public static long numberOfPairs2(int target, int[] array){
        AtomicInteger count = new AtomicInteger();

        IntStream.range(0, array.length-1)
                .forEach( i -> {
                                    IntStream.range(i,array.length)
                                            .forEach(j -> {
                                                                if(array[i]+array[j]==target && i!=j) count.getAndIncrement();
                                                          });
                               });
        return count.getPlain();
    }

//    Task5
    public static String inviteList(String str){
        str = str.toUpperCase();
        String newStr = "";
        String[] strs = str.split(";",-1);
        String[] arr = strs.clone();
        for(int i = 0;i< strs.length;i++){
            String[] strings = strs[i].split(":");
            arr[i] = "("+strings[1]+", "+strings[0]+")";
        }

        Arrays.sort(arr);
       for(String s: arr){
           newStr += s;
       }
        return newStr;
    }

//    Extra Task1
    public static int nextBigger(int number){
        int len = Integer.toString(number).length();
        int[] arr = new int[len];
        initArray(arr,Integer.toString(number));
        int iteration;
        for(iteration = len - 1; iteration>0;iteration--){
            if(arr[iteration] > arr[iteration-1])
                break;
        }

        if(iteration==0){
            return -1;
        }
        else{
            int x = arr[iteration-1], min = iteration;

            for(int j = iteration+1;j<len;j++){
                if(arr[j]>x && arr[j]<arr[min])
                    min = j;
            }

            swap(arr, iteration-1,min);
            Arrays.sort(arr,iteration,len);
            return toInt(arr);
        }
    }
    public static void initArray(int[] arr, String number){
        for(int i=0;i< arr.length;i++){
            arr[i] = Character.getNumericValue(number.charAt(i));
        }
    }

    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static int toInt(int[] arr){
        String string = "";
        for (int j : arr) {
            string += Integer.toString(j);
        }
        return Integer.parseInt(string);
    }

//    Extra Task2
    public static String toIPv4(long number){
        String string=  Long.toBinaryString(number);
        String[] arr = new String[4];
        String address = "";
        while(string.length()!=32){
            string = "0" + string;
        }

        for(int i=0;i<4;i++){
            int start = i*8;
            arr[i] = string.substring(start, start+8);
            address += Integer.toString(Integer.parseInt(arr[i],2));
            if (i!=3) address+=".";
        }

        return address;
    }

}

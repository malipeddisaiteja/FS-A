/*

Given two Integer ArrayList, add their elements to a new ArrayList by satisfying following conditions 

1. Addition should be done starting from 0th index of both ArrayList.
2. Split the sum if it is a not a single digit number and store the digits in adjacent locations
3. Output ArrayList should accommodate any remaining digits of larger input ArrayList.
4.Assume the input contains only positive numbers

Examples:
First line contains the size of first ArrayList followed by first ArrayList elements followed by second ArrayList size followed by 
second ArrayList elements 


input =
6
9 2 3 7 9 6
8
3 1 4 7 8 7 6 9
output =
1 2 3 7 1 4 1 7 1 3 6 9

input = 
6
9343 2 3 7 9 6
8
34 11 4 7 8 7 6 99
output =
9 3 7 7 1 3 7 1 4 1 7 1 3 6 9 9

input = 
3
345 124 54
5
123 221 325 4234 5167
output = 
4 6 8 3 4 5 3 7 9 4 2 3 4 5 1 6 7

*/

import java.util.*;

class Test{
    static ArrayList<Integer> mergedArrays(int[] arr1,int[] arr2,int n1,int n2){
        ArrayList<Integer> al = new ArrayList<>();
        int idx = 0;
        while(idx<n1 && idx<n2){
            int sum = arr1[idx]+arr2[idx];
            String s = ""+sum;
            String[] digits = s.split("");
            for(String num:digits){
                al.add(Integer.parseInt(num));
            }
            idx++;
        }
        if(idx<n1){
            for(int i=idx;i<n1;i++){
                String s = ""+arr1[i];
                String[] digits = s.split("");
                for(String num:digits){
                    al.add(Integer.parseInt(num));
                }
            }
        }
        if(idx<n2){
            for(int i=idx;i<n2;i++){
                String s = ""+arr2[i];
                String[] digits = s.split("");
                for(String num:digits){
                    al.add(Integer.parseInt(num));
                }
            }
        }
        return al;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
        }
        ArrayList<Integer> mergedArray = mergedArrays(arr1,arr2,n1,n2);
        System.out.println(mergedArray);
    }
}

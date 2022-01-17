/*

Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, 
return a sorted array of only the integers that appeared in all three arrays in increasing order

For any other Boundary Conditions Print -1 
Assume all the three input array contains positive elements 

The first line of input contains the first array elements followed by second array elements followed by third array elements 

input =
1 2 3 4 5 11 15
1 2 5 7 
1 3 4 5 8 20 45 55
output = 
1 5

Explanation: Only 1 and 5 appeared in the three arrays.


input = 
3 4 4 5 6 7
40 50 60 70 80 90
500 600
output = -1


input = 
1 1 1 2
1 1 
1 2 3 4 5
output = 1

*/

import java.util.*;
class Test{
    static HashMap<Integer,Integer> h1 = new HashMap<>();
    public static int remain_sort(String s1,String s2,String s3){
        
        int i=0,j=0,k=0;
        String sarr1[] = s1.split(" ");
        String sarr2[] = s2.split(" ");
        String sarr3[] = s3.split(" ");
        int ar1[] = new int[sarr1.length];
        int ar2[] = new int[sarr2.length];
        int ar3[] = new int[sarr3.length];
        for(i=0;i<sarr1.length;i++){
            ar1[i]=Integer.parseInt(sarr1[i]);
        }
        for(i=0;i<sarr2.length;i++){
            ar2[i]=Integer.parseInt(sarr2[i]);
        }
        for(i=0;i<sarr3.length;i++){
            ar3[i]=Integer.parseInt(sarr3[i]);
        }
        i=0;
        int f=0;
        while (i < ar1.length && j < ar2.length && k < ar3.length){
            if(ar1[i]==ar2[j] && ar2[j]==ar3[k]){   
                System.out.print(ar1[i]+" ");
                i++;
                j++;
                k++;
                f=1;
            }
            else if (ar1[i] < ar2[j])
                 i++;
            else if (ar2[j] < ar3[k])
                 j++;
            else
                k++;
        }
        return f;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        int f = remain_sort(s1,s2,s3);
        if(f==0){
            System.out.print(-1);
        }
    }
}

/*

Shankar is given a set of N pluck cards, each card labelled with a number on it, and he is also given a difference value as ‘D’.
Now Shankar has to find out the length of the largest arithmetic set ‘S’.

A subset is called as arithmetic set, iff the difference between the numbers on any two adjacent cards is same as D.

A subset can be derived from the set of N pluck cads by deleting some or no cards without changing the order of the remaining cards.

Input Format:
------------- 
Line-1: Two space separated integers N, D, number of cards, difference.
Line-2: N space separated integers, numbers on the set of cards.

Output Format:
--------------
Print an integer, length of longest arithmetic subset.


input=6 2
1 2 3 4 6 8
output=4

Input=8 -2
8 1 2 6 5 4 2 0 
output=5

*/

import java.util.*;

class Test{
    static int[] arr;
    static int maxSubSetArrayLength(int n, int d){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int len = 1;
        
        for (int i = 0; i < n; i++){
            int num = arr[i] - d;
            if(hm.containsKey(num)){
                hm.put(arr[i],hm.get(num)+1);
            }
            else{
                hm.put(arr[i],1);
            }
        }
     
        for(int key: hm.keySet()){
            int subLen = hm.get(key);
            if(len<subLen) len = subLen;
        }

        return len;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),diff = sc.nextInt();
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int maxLength = maxSubSetArrayLength(n,diff);
        System.out.println(maxLength);
    }
}

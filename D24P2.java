/*
Shyam is given a group of numbers and a value(k),Now he wants to see if the group of numbers 
can be arranged into sets of k consecutive groups. 

if he can do print yes else print no 

The first line of input consists of the group of numbers followed by a value (k) 

input = 1,2,3,3,4,4,5,6
4
output = yes

Explanation: Group can be arranged into (1,2,3,4) and (3,4,5,6)


Input = 3 2 1 2 3 4 3 4 5 9 10 11
3
output = yes

Explanation: Group can be arranged into (1,2,3) , (2,3,4) , (3,4,5) and (9,10,11).

Input = 1 2 3 4 
3
output = no


Explanation: Each group should be arranged in sub-group of size 3.

*/

import java.util.*;

class Test{
    static TreeMap<Integer,Integer> tm = new TreeMap<>();
    static boolean canBeGrouped(int l,int k){
        if(l%k!=0) return false;
        
        for(int key:tm.keySet()){
            int value = tm.get(key);
            if(value>0){
                for(int i=1;i<k;i++){
                    if(tm.containsKey(key+i)){
                        tm.put(key+i,tm.get(key+i)-value);
                        if(tm.get(key+i)<0) return false;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int k=sc.nextInt(),l=0;
        for(String s:str){
            int num = Integer.parseInt(s);
            tm.put(num,tm.getOrDefault(num,0)+1);
            l++;
        }
        boolean isTrue = canBeGrouped(l,k);
        if(isTrue) System.out.println("yes");
        else System.out.println("no");
    }
}


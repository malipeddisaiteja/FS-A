/*
Sunder and Shiva are playing a word game where 
shiva gives a number 'k' and word 'w' to the sunder and 
sunder removes the first letter from the start and places it at the end(k times)
shiva has to know the new word after sunder has done with his work.
Help him to know the new word. 

Sample Test Case - 1
input = hello
2
output = 
llohe


Sample Test Case-2
input = good
3
output = dgoo
*/

import java.util.*;

class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        for(int i=k;i<s.length();i++){
            System.out.print(s.charAt(i));
        }
        for(int i=0;i<k;i++){
            System.out.print(s.charAt(i));
        }
    }
}

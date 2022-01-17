/*


Ramu is given a pair of words, Now his teacher has given him a task. 
His task is to see if the individual alphabets of the words are mapped properly or not 

If they do so print true else print false

Two strings are mapped properly  if the characters in 's' can be replaced to get 't'.
All occurrences of a alphabet must be replaced with another alphabet while preserving the order of alphabets
No two alphabets may map to the same alphabet but a alphabet may map to itself.


Note:
You may assume both s and t have the same length and all inputs contains('a-z')

input = 
egg
app
output = true

input = 
foo
bar
output = false

input = 
papel
title
output = true

*/

import java.util.*;
class Test{
    
    static Map<Character,Integer> h1 = new HashMap<>();
    static Map<Character,Integer> h2 = new HashMap<>();
    public static boolean isMappable(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            h1.put(s1.charAt(i),h1.getOrDefault(s1.charAt(i),0)+1);
            h2.put(s2.charAt(i),h2.getOrDefault(s2.charAt(i),0)+1);
        }
        for(int i=0;i<s1.length();i++){
            if(h1.get(s1.charAt(i))!=h2.get(s2.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        boolean isTrue = isMappable(s1,s2);
        System.out.println(isTrue);
    }
}

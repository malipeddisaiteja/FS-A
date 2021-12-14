/*
Suraj and Tom are two best friends. 

Both of them have given two Strings S1 and S2 
Suraj has given String S1 and Tom has given String S2
Suraj is always bothered about Tom Strings and checks if's  his string follows sSequence of Tom strings or not 

Help Suraj to solve his problem 

A sSequence of  string is a new string which is formed from the original string by removing some (can be none) of the characters without
disturbing the relative positions of the remaining characters. 

Sample Test Case1

input = abc
ahbgdc
output = true


Sample Test Case2
input = aik
appkllli
output = false

Explanation - aik is not a subsequnece of appkllli 

Sample Test Case3

input = axc 
ahbgdc
output = false

Both strings consists only of lowercase characters.

*/
import java.util.*;

class Test{
    static boolean subSequence(String s1,String s2){
        int j=0;
        for(int i=0;i<s2.length();i++){
            if(s1.charAt(j)==s2.charAt(i)){
                if((s1.length()-1)==j){
                    return true;
                }
                j++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        boolean value = subSequence(str1,str2);
        System.out.println(value);
    }
}

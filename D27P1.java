/*

Gopal is given a string s, Now he has to remove duplicate letters so that every letter appears once and only once.

He must make sure that the result produces should occur in the order given in string 

Example 1:

Input = bcabc
Output = bca

*/

" Use LinkedHashSet to maintain same order without any duplications "
  
import java.util.*;

class Test{
    static void printString(String s){
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        for(char c: set){
            System.out.print(c);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        printString(s);
    }
} 

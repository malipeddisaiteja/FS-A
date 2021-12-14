/*
Program-1

write a program to read a string from the user and print the following pattern 

Input - The input consists of one word
Output - For the given input string print the pattern as shown in the test case

Sample Test case

input = hello
output =
h
ee
lll
llll
ooooo

Explanation -
The first line of output should print the first character once 
followed by second character twice followed by third character thrice 
till it reaches the end of string 

input = welcome
output =
w
ee
lll
cccc
ooooo
mmmmmm
eeeeeee
*/
import java.util.*;

class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        int l = s.length();
        for(int i=0;i<l;i++){
            for(int j=0;j<=i;j++){
                System.out.print(s.charAt(i));
            }
            System.out.print("\n");
        }
    }
}

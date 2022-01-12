/*

Three Friends are given three rows of the keyboard, The first row is given to Shyam,second row is given to gopal, third row is given to ramu. 

Teacher has given them few lines of words and asked each individual if they can print the words that can be printed using the letters of the rows given to them 

Shyam has given the row -   QWERTYUIOP/qwertyuiop
Gopal has given the row -    ASDFGHIJKL/asdfghjkl
Ramu has given the row -   ZXCVBNM/zxcvbnm

Teacher also gave the following rules in addition ;
    You may use one character in the row more than once.
    You may assume the input string will only contain letters of alphabet(A-Z/a-z).
    Assume the alphabets are case sensitive 

    Print -1 for all Boundary Conditions 

Example:

input =hello Alaska Dad Peace
output = 
Alaska 
Dad


Here the words Alaska and Dad are the characters of second student gopal only 


input =asdf qwer zxcv
output =
asdf
qwer
zxcv

input =Dad hAS the Key
output = Dad
hAS

input =to be or not TO be 
output = to
or
TO

*/

import java.util.*;

class Test{
    static String[] rows = {"QWERTYUIOPqwertyuiop","ASDFGHIJKLasdfghjkl","ZXCVBNMzxcvbnm"};
    static String getIndex(char c){
        for(String row:rows){
            if(row.indexOf(c) != -1){
                return row;
            }
        }
        return "";
    }
    static ArrayList<String> possibleWords(String[] words){
        ArrayList<String> al = new ArrayList<String>();
        for(String word:words){
            StringBuilder compare = new StringBuilder(getIndex(word.charAt(0)));
            if(compare.length()!=0){
                boolean flag=true;
                for(int i=0;i<word.length();i++){
                    int idx = (compare.toString()).indexOf(word.charAt(i));
                    if(idx==-1){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    al.add(word);
                }
            }
        }
        return al;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        ArrayList<String> result = possibleWords(words);
        if (result.size()==0) System.out.println(-1);
        else{
            for(String word:result){
                System.out.println(word);
            }
        }
    }
}


/*

Shanmukha creating a special strings.
A string is said to be a special string, if all the letters appeared 
even number of times, or only one letter appeared odd number of times.

For example: "adda" and "iaaff" are special strings.
but "iaf" is not a special string.

You are given a word W, where W conatins the letters from a to j.
Our task is to findout, the number of non-empty special strings, 
which are substrings of word W can be formed.
if a substring appeared more than once, count each appearance separately.

NOTE: subsequences are not allowed.

Input Format:
-------------
A String W, the word.

Output Format:
--------------
Print an integer, number of special strings.


Sample Input-1:
---------------
egg

Sample Output-1:
----------------
5

Explanation:
------------
The special strings formed from the word "egg" are:
'e'gg, e'g'g, eg'g', e'gg', 'egg'.


Sample Input-2:
---------------
bajaj

Sample Output-2:
----------------
9

Explanation:
------------
The special strings formed from the word "bajaj" are:
'b'ajaj, b'a'jaj, baj'a'j, ba'j'aj, baja'j', b'aja'j, ba'jaj', b'ajaj', 'bajaj'.

*/

import java.util.*;

class Test{
    static StringBuilder str;
    static int numOfSpecialStrings(int idx,int size,int len){
        if(idx+size>len) return 0;
        
        StringBuilder subStr = new StringBuilder(str.substring(idx,idx+size));
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<subStr.length();i++){
            char c = subStr.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        //System.out.println("hm: "+hm);
        
        int charCount=0,count=0;
        for(char c:hm.keySet()){
            if(hm.get(c)%2 != 0){
                charCount++;
            }
        }
        
        if(charCount>1) charCount=0;
        else charCount=1;
        
        if(idx==len-1 || idx+size==len) count = count + charCount + numOfSpecialStrings(0,size+1,len);
        else count = count + charCount + numOfSpecialStrings(idx+1,size,len);
        
        //System.out.println("substring: "+subStr+" count: "+count);
        
        return count;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        str = new StringBuilder(sc.next());
        int l = str.length();
        int count = numOfSpecialStrings(0,1,l);
        System.out.println(count);
    }
}

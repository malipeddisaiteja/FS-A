/*

The FS Faculty  wants to send one of his best coding group to  a Coding competition
There are several groups of coding students. 
He has the marks of the students who have attended fs classes so far. 
He wants to choose the group of students with the highest overall marks.
The marks of the students is the sum of marks of all the students in the group. 

However, the coding groups is not allowed to have issues. 
A issue exists if a younger coder has a strictly higher marks than an older coder. 
A issue does not occur between coders of the same age.

Given two lists, marks and ages , where each marks[i] and ages[i] represents the marks and age of the
i coder, respectively, return the highest overall marks of all possible coding groups

The first line of input containts the marks followed by ages of the students 

input=1 3 5 10 15
1 2 3 4 5
output=34

Explanation: You can choose all the students. 


Input= 4 5 6 5 
2 1 2 1
Output = 16

Explanation: It is best to choose the last 3 coders. 
Notice that you are allowed to choose multiple students of the same age.



Input= 1 2 3 5
8 9 10 1
Output= 6
Explanation: It is best to choose the first 3 coders.

*/


import java.util.*;
class Test{
    public static int age_marks(int[] marks,int[] ages){
        int coder[][] = new int[marks.length][2];
        for(int i=0;i<marks.length;i++){
            coder[i][0]=ages[i];
            coder[i][1]=marks[i];
        }
        Arrays.sort(coder,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int dp[] = new int[marks.length];
        dp[0]=coder[0][1];
        int max = dp[0];
        for(int i=1;i<marks.length;i++){
            dp[i]=coder[i][1];
            for(int j=0;j<i;j++){
                if(coder[j][1]<=coder[i][1])
                    dp[i]=Math.max(dp[i],coder[i][1]+dp[j]);
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String sarr1[] = s1.split(" ");
        String s2 = sc.nextLine();
        String sarr2[] = s2.split(" ");
        int[] marks = new int[sarr1.length];
        int[] ages = new int[sarr2.length];
        for(int i=0;i<sarr1.length;i++){
            marks[i]=Integer.parseInt(sarr1[i]);
        }
        for(int i=0;i<sarr2.length;i++){
            ages[i]=Integer.parseInt(sarr2[i]);
        }
        int max_marks = age_marks(marks,ages);
        System.out.print(max_marks);
    }
}

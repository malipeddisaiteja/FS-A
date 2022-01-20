/*

Vikram a third class boy plays with a numbers, he will be given a number(n) and 
he starts writing the numbers on each line until he reaches the number(n).

Write the code and verify if the vikrams writing of the number is same or not. 

Assume n>=1


input = 5
output =
1
1 2
3 5 8
13 21 34 55
89 144 233 377 610


input = 4
output = 
1
1 2
3 5 8
13 21 34 55

*/

import java.util.*;

class Test{
    
    static void printFibonacci(int n){
        int a=1,b=1,c=1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(i==0&&j==0) System.out.print(1);
                else if(i==1&&j==0) System.out.print(1+" ");
                else{
                    c = a+b;
                    System.out.print(c+" ");
                    a=b;
                    b=c;
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printFibonacci(n);
    }
}

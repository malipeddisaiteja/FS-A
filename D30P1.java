/*

Ramu is a milk supplier. He has only two aluminium cups of capacity m and n litres. 
Using these two cups only, he can measure the milk. 
He has to supply exactly P litres of milk

To measure the milk, the operations allowed are:
	- Fill one of the cups completely with milk.
	- Empty the other cup.
	- Pour milk from one cup into another cup till it fills completely,
	 or the first cup itself is empty.
	 
Such that, at the end one or both cups contains P litres of the milk.
	
Please help Ramu, to check whether P litres of milk can be measured
using the two cups or not.

Input Format:
-------------
3 space separated integers, m, n and P.

Output Format:
--------------
Print a boolean value.


input=3 5 4
output=true


input=2 4 5
output=false

*/

import java.util.*;

class Test{
    static int gcd(int n1,int n2){
        if(n2==0) return n1;
        
        return gcd(n2,n1%n2);
    }
    static boolean canBeMeasured(int m,int n,int p){
        if(m+n<p) return false;
        else if(m==n || n==p || m+n==p) return true;
        else if(p%(gcd(m,n))==0) return true;
        
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(),n = sc.nextInt(),p = sc.nextInt();
        boolean isTrue = canBeMeasured(m,n,p);
        System.out.println(isTrue);
    }
}

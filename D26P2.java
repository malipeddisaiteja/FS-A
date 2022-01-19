/*

Sundeep is working with integer sets.
He is given a set of integers nums[], consist of positive integers.
You have to find a subsequence of integet set nums[], where the sum of elements
is equal to the sum of the rest of the elements.

Check whether you are able to split the entire set nums[], into two subsequences
where the two subsequences never share the elements from same index.

If it is possible to split, print true.
otherwise print false.

The first line of input contains the size followed by array elements 

Sample Input-1:
---------------
4
4 2 8 6

Sample Output-1:
----------------
true

Explanation:
----------
[4,6] and [2,8] sum of both the sets equal to 10.


Sample Input-2:
---------------
5
2 3 4 5 8

Sample Output-2:
----------------
false

*/

--------------------------------------------
----------" Method 1: using  DFS "----------
--------------------------------------------

import java.util.Scanner;

class Test{
	static int n,arr[];
	static boolean DFS(int idx,int leftSum,int rightSum){
		if(idx>=n){
			if(leftSum==rightSum){
					return true;
			}
			return false;
		}
		return DFS(idx+1,leftSum+arr[idx],rightSum) || DFS(idx+1,leftSum,rightSum+arr[idx]);
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		System.out.print(DFS(0,0,0));
	}
}

--------------------------------------------
-----------" Method 2: using DP "-----------
--------------------------------------------

import java.util.*;

class Test{
    static Boolean[][] dp;
    static int sum=0;
    static boolean getSum(int[] arr,int idx,int amount){
        if(idx<0 || amount<0) return false;
        if(amount == 0) return true;
        if(dp[amount][idx]!= null ) return dp[amount][idx];
        
        boolean pickNum = getSum(arr,idx-1,amount-arr[idx]);
        boolean notPickNum = getSum(arr,idx-1,amount);
        dp[amount][idx] = pickNum || notPickNum;
        return dp[amount][idx];
    }
    static boolean canBeHalved(int[] arr,int n,int sum){
        if(sum%2!=0) return false;
        int l = arr.length;
        dp = new Boolean[sum+1][l];
        boolean count = getSum(arr,l-1,sum/2);
        if(count) return true;
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),sum = 0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        boolean isTrue = canBeHalved(arr,n,sum);
        System.out.println(isTrue);
    }
}
  
--------------------------------------------
-----------" Method 3: using DP "-----------
--------------------------------------------

import java.util.*;
class Test{
    static HashMap<String,Boolean> h1 = new HashMap<>();
    public static boolean isSplittable(int[] arr,int idx,int cursum,int sum){
        if(sum%2!=0){
            return false;
        }
        if(cursum*2==sum){
            return true;
        }
        if(cursum>sum/2||idx>=arr.length){
            return false;
        }
        String key = idx+"|"+cursum;
        if(!h1.containsKey(key)){
            boolean res = isSplittable(arr,idx+1,cursum,sum)||isSplittable(arr,idx+1,cursum+arr[idx],sum);
            h1.put(key,res);
        }
        return h1.get(key);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        System.out.print(isSplittable(arr,0,0,sum));
    }
}

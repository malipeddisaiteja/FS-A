/*

Ramu is given an array of numbers now he has to check for a super square matrix in the given array.

A super square matrix is a matrix such that every row sum, every column sum, and both
diagonal sums are all equal. 

The integers in the magic square do not have to be distinct. 
Every 1 x 1 grid is trivially a super square matrix 

Given an m x n integer grid , return the size (i.e., the side length k ) of the largest super square matrix that can be found
within this grid.



Example 1:

Input = 
4 5
7 1 4 5 6
2 5 1 6 4
1 5 4 3 2
1 2 7 3 4
Output: 3

Explanation: 

From the above array we have the following super square matrix of size 3 
5 1 6 
5 4 3
2 7 3 



The largest super square matrix has a size of 3.
Every row sum, column sum, and diagonal sum of this magic square is equal to 12.
- Row sums: 5+1+6 = 5+4+3 = 2+7+3 = 12
- Column sums: 5+5+2 = 1+4+7 = 6+3+3 = 12
- Diagonal sums: 5+4+3 = 6+4+2 = 12

*/

import java.util.*;

class Test{
    static int[][] matrix;
    static boolean isSuperSquareMatrix(int r,int c,int size){
        // System.out.println("\n\nr+size: "+(r+size)+" c+size: "+(c+size));
        int rsum=0;
        Set<Integer> rsumSet = new HashSet<>();
        for(int i=r;i<r+size;i++){
            rsum=0;
            for(int j=c;j<c+size;j++){
                rsum +=matrix[i][j];
            }
            rsumSet.add(rsum);
        }
        // System.out.println("rsumSet: "+rsumSet);
        if(rsumSet.size()!=1) return false;
        
        int csum=0;
        Set<Integer> csumSet = new HashSet<>();
        for(int j=c;j<c+size;j++){
            csum=0;
            for(int i=r;i<r+size;i++){
                csum +=matrix[i][j];
            }
            csumSet.add(csum);
        }
        // System.out.println("csumSet: "+csumSet);
        if(csumSet.size()!=1) return false;
        
        int d1=0,d2=0;
        Set<Integer> diagSet = new HashSet<>();
        for(int i=r;i<r+size;i++){
            for(int j=c;j<c+size;j++){
                int R = i-r,C=j-c;
                if(R==C) d1+=matrix[i][j];
                if((R+C) == (size-1) ) d2+=matrix[i][j];
            }
        }
        diagSet.add(d1);
        diagSet.add(d2);
        // System.out.println("diagSet: "+diagSet);
        
        // System.out.println("rsum: "+rsum+" csum: "+csum+" d1: "+d1+" d2: "+d2);
        if(diagSet.size()!=1) return false;
        if(rsum!=csum || csum!=d1) return false;
        
        return true;
    }
    static int maxDimensionSupermatrix(int n,int m){
        int idx=0,size=2,maxDim=1;
        int min = n<m?n:m;
        while(size <= min){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i+size <=n && j+size<=m){
                        boolean isTrue = isSuperSquareMatrix(i,j,size);
                        // System.out.printf("size:%d i: %d ,j:%d   isTrue: %b\n\n",size,i,j,isTrue);
                        if(isTrue){
                            if(maxDim< (size)){
                                maxDim = size;
                            }
                        }
                    }
                }
            }
            size++;
        }
        return maxDim;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m = sc.nextInt();
        matrix = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int maxDim = maxDimensionSupermatrix(n,m);
        System.out.println(maxDim);
    }
}

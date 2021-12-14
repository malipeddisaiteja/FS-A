/*Bob has given a word which consists of numbers(0-9) and alphabets(a-z,A-Z)
now he wants to add only numbers from the word. Pls help him to do so. 


Sample Test Case - 1

input = a2b3c4d5
output = 14

Explanation - 
In the above test case we have 2,3,4,5 are the numbers so the addition of this numbers is 14 

Sample Test Case - 2

input = a10b20c30
output = 60

Explanation - 
In the above test case we have 10,20,30. So the addition of this numbers is 60

Sample Test Case-3

input = k100
output = 100

Explanation -
In the above test case we have 100 only. so the output is 100

Sample Test Case - 4

input = abc
output = 0

Explanation -
Since no numbers print 0 
*/
import java.util.*;

class Test{
    static int sumOfIntegers(String s){
        int L=s.length(),sum=0;
        String num = "";
        for(int i=0;i<L;i++){
            char c = s.charAt(i);
            int diff = c-'0';
            if(diff>=0 && diff<=9){
                num+=c;
            }
            else{
                if(num.length()!=0){
                    sum += Integer.parseInt(num);
                    num="";
                }
            }
        }
        if(num.length()!=0){
                sum += Integer.parseInt(num);
                num="";
        }
        return sum;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int sum = sumOfIntegers(str);
        System.out.println(sum);
    }
}

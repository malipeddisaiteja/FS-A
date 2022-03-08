/*

Tinku a Second Class Student is given a Phrase which contains few words in {}
His teacher marked all dificult words in the { }. 
His teacher gave him the meaning to the difficult words 
he was asked to replaced the difficult words in the { } with the meanings given to him. 

if the difficult word doesnt exist print ?

The first line of input contains the phrase followed by difficult words 
Each difficult words is given by a name followed by meaning (n difficult words)


input={name}isa{gender}
name ajay gender boy
output=ajayisaboy


input={name}is{age}yearsold
name bob age two
output=bobistwoyearsold


input=hi{name}
a b
output=hi?

*/

import java.util.*;

class Test{
    static HashMap<String,String> hm = new HashMap<>();
    private static String replacedString(StringBuilder sb){
        System.out.println(hm);
        int l = sb.length(),i=0;
        StringBuilder nsb = new StringBuilder();
        while(i<l){
            if(sb.charAt(i) != '{'){
                nsb.append(sb.charAt(i));
            }
            else{
                i++;
                StringBuilder w = new StringBuilder();
                while(sb.charAt(i) != '}' && i<l){
                    w.append(sb.charAt(i));
                    i++;
                }
                System.out.println("w: "+w);
                if(!hm.containsKey(w.toString())){
                    nsb.append("?");
                }
                else{
                    nsb.append(hm.get(w.toString()));
                }
            }
            i++;
        }
        
        return nsb.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        String[] dict = sc.nextLine().split(" ");
        for(int i=0;i<(dict.length)-1;i=i+2){
            hm.put(dict[i],dict[i+1]);
        }
        String newString = replacedString(str);
        System.out.println(newString);
    }
}

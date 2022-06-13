import java.util.Enumeration;
import java.util.Hashtable;

public class assignment {

    public static void main(String[] args) {
        System.out.println("Hello World");

        /*System.out.println(shiftedDiff("coffee","eecoff"));

        System.out.println(shiftedDiff("eecoff","coffee"));

        System.out.println(shiftedDiff("moose","Moose"));

        System.out.println(shiftedDiff("isn't","'tisn"));

        System.out.println(shiftedDiff("Esham","Esham"));

        System.out.println(shiftedDiff("dog","god"));*/
        /*
        System.out.println("cac");
        System.out.println(isValid("cac"));
        System.out.println("aabcc");
        System.out.println(isValid("aabcc"));
        System.out.println("efgh");
        System.out.println(isValid("efgh"));
        System.out.println("mumukkop");
        System.out.println(isValid("mumukkop"));
        System.out.println("pppenm");
        System.out.println(isValid("pppenm"));
        System.out.println("ekekua");
        System.out.println(isValid("ekekua"));

        System.out.println("aaaa");
        System.out.println(isValid("aaaa"));

        System.out.println("accenture");
        System.out.println(isValid("accenture"));

        System.out.println("miyt");
        System.out.println(isValid("miyt"));

        System.out.println("wtorw");
        System.out.println(isValid("wtorw"));

*/
        System.out.println();
        System.out.println("bababacc");
        System.out.println(isValid("bababacc"));

        System.out.println("aa");
        System.out.println(isValid("aa"));


    }

    public static int shiftedDiff(String first, String second) {
        if(first.length()==second.length()){
            int shiftCounter=-1;
            for(int i=0;i<first.length();i++){
                String ans = first.substring(first.length()-i,first.length())+first.substring(0,first.length()-i);
                //System.out.println(ans);
                if(ans.equals(second)) {
                    shiftCounter = i;
                }
            }
            return shiftCounter;
        }

        else {
            return -1;
        }
    }

    public static boolean isValid( String str ) {
        // Initialization of a Hashtable
        // using Generics
        Hashtable<Character, Integer> ht2 = new Hashtable<Character, Integer>();
        //create hashtable for performance well

        for(int i=0;i<str.length();i++){
            Integer n = ht2.get(str.charAt(i));
            if (n != null) {
                ht2.remove(str.charAt(i));
                ht2.put(str.charAt(i),n+1);
            }
            else{
                ht2.put(str.charAt(i),1);
            }
        }

        System.out.println(ht2.toString());
        //counter for difference in the hashtable
        int differenceCounter=0;
        int firstDifference=0;
        int firstDifferenceCounter=0;
        int secondDifference=0;
        int secondDifferenceCounter=0;

        //i took this code from https://www.geeksforgeeks.org/hashtable-elements-method-in-java/
        // Creating an empty enumeration to store
        Enumeration enu = ht2.elements();

        System.out.println("The enumeration of values are:");

        // Displaying the Enumeration
        //check difference of the all elements

        while (enu.hasMoreElements()) {
            int nextDifference=(int) enu.nextElement();
            if(firstDifferenceCounter==0) {
                firstDifference = nextDifference;
                differenceCounter+=1;
                firstDifferenceCounter=1;
            }
            else{
                if(firstDifference==nextDifference){
                    firstDifferenceCounter+=1;
                }
                else {
                    if (secondDifferenceCounter == 0) {
                        secondDifference = nextDifference;
                        differenceCounter += 1;
                        secondDifferenceCounter=1;
                    } else {
                        if(secondDifference==nextDifference){
                            secondDifferenceCounter+=1;
                        }
                        else{
                            differenceCounter+=1;
                        }
                    }
                }
            }
        }

        if(differenceCounter>2){
            return false;
        }
        else if (differenceCounter==1){
            return true;
        }
        else{
            if(Math.abs(firstDifference-secondDifference)<=1 ) {
                if (firstDifferenceCounter == 1 && secondDifferenceCounter == 1) {
                    return true;
                } else if (firstDifferenceCounter == 0 && secondDifferenceCounter >= 1) {
                    return true;
                } else if (firstDifferenceCounter >= 1 && secondDifferenceCounter == 0) {
                    return true;
                } else if (firstDifferenceCounter > 1 && secondDifferenceCounter <= 1 && secondDifference<=1) {
                    return true;
                } else if (firstDifferenceCounter <= 1 && secondDifferenceCounter > 1) {
                    return true;
                } else {
                    return false;
                }
            }
            else{
                return false;
            }
        }

    }
}



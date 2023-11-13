
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int first = stringb.indexOf(stringa);
        int second = stringb.indexOf(stringa, first + 1);
        return second != -1;
    }
    
    public String lastPart(String stringa, String stringb){
        // returns the part of stringb that follows stringa.
        int index = stringb.indexOf(stringa);
        if(index != -1)
            return stringb.substring(index + stringa.length());
            
        // If stringa does not occur in stringb, then return stringb.
        return stringb;
    }
    
    void testing(){
    /*
        // call twoOccurrences on several pairs of strings
        String strA = "abc";
        // String strB = "aabcdefgh";
        String strB = "aabcdefghabcb";
        boolean result = twoOccurrences(strA, strB);
        
        // and print the strings and the result. 
        System.out.println(strA + "\n" + strB);
        System.out.println("at least 2 occurrences ? " + result);
    */
        String strA = "an";
        String strB = "banana";
        String result = lastPart(strA, strB);
        System.out.println("The part of the string after " + strA.toUpperCase() + " in "+strB.toUpperCase()+" is "+result.toUpperCase()+".");
    }

}

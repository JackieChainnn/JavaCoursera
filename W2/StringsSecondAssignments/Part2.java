
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringA, String stringB){
        int occ = 0, counter = 0;
        int startIdx = 0;
        do{
            counter = stringB.indexOf(stringA, startIdx);
            if(counter != -1)
                occ++;
            startIdx = counter + 1;
        }while(counter != -1);
        return occ;
    }
    
    public void testHowMany(){
        String stringA = "GAA";
        String stringB = "ATGAAGGAAAGAATTGAATC";
        System.out.println(howMany(stringA, stringB));
    }
}

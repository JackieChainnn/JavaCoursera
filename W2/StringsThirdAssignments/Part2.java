
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public float cgRatio(String dna){
        int count = 0;
        for(int i = 0; i < dna.length(); i++){
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G')
                count++;
        }
        return (float)count/dna.length();
    }
    
    public void testCgRatio(){
        String dna = "ATGCCATAG";
        System.out.println(cgRatio(dna));
    }
}

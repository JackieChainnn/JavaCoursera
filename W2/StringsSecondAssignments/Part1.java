
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.StorageResource;

public class Part1 {
    public int findStopCodon(String dnaStr,
                             int startIdx,
                             String stopCodon){
        int currIdx = dnaStr.indexOf(stopCodon, startIdx+3);
        while(currIdx != -1){
            if((currIdx - startIdx) % 3 == 0){
                return currIdx;
            }else{
                currIdx = dnaStr.indexOf(stopCodon, currIdx + 1);
            }
        }
         return dnaStr.length();
    }
    
    public String findGene(String dna,int where){
        int startIdx = dna.indexOf("ATG", where);
        if(startIdx == -1){
            return "";
        }
        
        int taaIdx = findStopCodon(dna, startIdx, "TAA");
        int tagIdx = findStopCodon(dna, startIdx, "TAG");
        int tgaIdx = findStopCodon(dna, startIdx, "TGA");
        int minIdx = Math.min(Math.min(taaIdx, tagIdx), Math.min(tagIdx, tgaIdx));
        if(minIdx == dna.length()){
            return "";   
        }
        
        return dna.substring(startIdx, minIdx + 3);
    }
    
    void printAllGenes(String dna){
        int startIdx = dna.indexOf("ATG");
        while(startIdx != -1){
            String myGene = findGene(dna, startIdx);
            if(myGene.isEmpty()){
                break; 
            }
            System.out.println(myGene);
            startIdx = dna.indexOf(myGene, startIdx)
                        + myGene.length();
        }
    }
    
    void testFindGene(){
        // test cases: 
            // DNA with no “ATG”,
        // String dna = "xxxyyyTAA";
            // DNA with “ATG” and one valid stop codon, 
        // String dna = "xATGyyyzzzTGA";
            // DNA with “ATG” and multiple valid stop codons,
        // String dna = "xxxATGyyyzzTAAzxxxTGA";
            // DNA with “ATG” and no valid stop codons.
        String dna = "xxxATGyyyTAAzzATGxxxyyyTGAzzzTAGxATGyyyTAG";
        System.out.print("testing on testFindGene...");
        System.out.println("xxxATGyyyTAAzzATGxxxyyyTGAzzzTAGxATGyyyTAG");
        printAllGenes(dna);
        
    }
}

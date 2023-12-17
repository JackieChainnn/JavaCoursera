
/**
 * Write a description of AllCodons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllCodons {
    public int findStopCodon(String dnaStr,
                             int startIdx,
                             String stopCodon){
        int currIdx = dnaStr.indexOf(stopCodon, startIdx+3);
        while(currIdx != -1){
            if((currIdx - startIdx) % 3 == 0){
                return currIdx;
            }else{
                startIdx = startIdx + 1;
                currIdx = dnaStr.indexOf(stopCodon, startIdx+3);
            }
        }
         return dnaStr.length();
    }
    
    public String findGene(String dna){
        int startIdx = dna.indexOf("ATG");
        if(startIdx == -1)
            return "";
        int taaIdx = findStopCodon(dna, startIdx, "TAA");
        int tagIdx = findStopCodon(dna, startIdx, "TAG");
        int tgaIdx = findStopCodon(dna, startIdx, "TGA");
        int minIdx = Math.min(Math.min(taaIdx, tagIdx), Math.min(tagIdx, tgaIdx));
        if(minIdx == dna.length())
            return "";
        while((minIdx - startIdx) % 3 != 0){
            startIdx = dna.indexOf("ATG", startIdx+1);
        }
        return dna.substring(startIdx, minIdx + 3);
    }
    
    public void test(){
        String dna = "CATGxxATGyyyTAAG";
                    // ATG  ATGTATAG
        String myGene = findGene(dna);
        System.out.println(myGene);
    }
}

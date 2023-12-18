
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    
    public int countGenes(String dna){
        int counter = 0;
        int startIdx = dna.indexOf("ATG");
        while(startIdx != -1){
            String myGene = findGene(dna, startIdx);
            if(myGene.isEmpty()){
                break; 
            }
            counter++;
            startIdx = dna.indexOf(myGene, startIdx)
                        + myGene.length();
        }
        return counter;
    }
    
    public void testCountGenes(){
        String dna = "ATGTAAGATGCCCTAGT";
        System.out.println(countGenes(dna));
    }
}

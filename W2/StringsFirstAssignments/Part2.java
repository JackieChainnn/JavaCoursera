/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        String gene = "";
        
        int startGene = dna.toUpperCase().indexOf(startCodon.toUpperCase());
        if(startGene == -1)
            return gene;
        
        String nextCodon;
        boolean isNextCodon = false;
        int endGene = 0, nextCodonStartIndex = 0;
        while(isNextCodon != true || nextCodonStartIndex < dna.length())
        {
            nextCodonStartIndex = nextCodonStartIndex + startGene + 3;
            if(nextCodonStartIndex + 3 > dna.length())
                nextCodon = dna.substring(nextCodonStartIndex);
            else{
                nextCodon = dna.substring(nextCodonStartIndex, nextCodonStartIndex + 3);    
            }
            
            isNextCodon = nextCodon.toUpperCase().equals(stopCodon.toUpperCase());
            if(isNextCodon) // nextCodon is end of gene
            {
                endGene = nextCodonStartIndex + 2;
                break;
            }
        }
                    
        gene = dna.substring(startGene, endGene + 1);
        return gene;
    }
    
    public void testSimpleGene(){
        // DNA with no “ATG”
        // String dna = "CTACAGGACTAA";
        
        // DNA with no “TAA”,
        // String dna = "CATGTCCAGGCA";
        
        // DNA with no “ATG” and “TAA”.
        // String dna = "ATACTCCAG";
        
        // DNA with ATG, TAA and the substring is a gene
        // String dna = "CATGGGACATAGTTAA";
        
        // and DNA with ATG, TAA and the substring ISN'T a gene
        String dna = "ATGATCGCTAATAATTAA";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String gene = findSimpleGene(dna, startCodon, stopCodon);
        if(gene == ""){
            System.out.println(dna + " doesn't contain gene");
        }else{
            System.out.println("Gene: " + gene);
        }
    }
}

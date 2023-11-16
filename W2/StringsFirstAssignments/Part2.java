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

        int endGene = -2;  // not important, just reasonable condition for loop
        while(endGene != -1){
            endGene = dna.toUpperCase().indexOf(stopCodon.toUpperCase(), endGene + 1);
            if(endGene == -1)
                return gene;
            else{
                if( (endGene - startGene) % 3 == 0 ){
                    gene = dna.substring(startGene, endGene + 3);
                    return gene;
                }
            }
        }
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
        // String dna = "ATGATCGCTAAGTA";
        
        // special gene
        String dna = "CCATGCGCTTAATGATAGATTAA";
        // v v v v v v01234567890123456789023
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

import java.util.Scanner;

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
        
        int endGene = dna.toUpperCase().indexOf(stopCodon.toUpperCase());
        if(endGene == -1)
            return gene;
            
        endGene = endGene + 2;
        
        if( (endGene - startGene + 1) % 3 != 0 )
            return gene;
            
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
        String dna = "catgggaatacgttaag";
        Scanner myObj = new Scanner(System.in);
        String startCodon = myObj.nextLine();
        String stopCodon = "TAA";
        String gene = findSimpleGene(dna, startCodon, stopCodon);
        if(gene == ""){
            System.out.println(dna + " doesn't contain gene");
        }else{
            System.out.println("Gene: " + gene);
        }
    }
}

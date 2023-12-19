
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part3 {
    public void processGenes(StorageResource sr){
        int count = 0;
        int ratioCount = 0;
        int max = 0;
        for(String g : sr.data()){
            // print all the Strings in sr that are longer than 9 characters
            if(g.length() > 60){
                System.out.println("String longer than 60 characters: " + g);
                count++;
            }
            
            // print the Strings in sr whose C-G-ratio is higher than 0.35
            float ratio = Part2.cgRatio(g);
            if(ratio > 0.35){
                System.out.println("C-G-ratio is higher than 0.35: " + g);
                ratioCount++;
            }
            
            // the longest gene in sr
            if(g.length() > max)
                max = g.length();
        }
        // print the number of Strings in sr that are longer than 9 characters (count)
        System.out.println("number of Strings longer than 60 characters: " + count);
        
        // print the number of strings in sr whose C-G-ratio is higher than 0.35
        System.out.println("number of Strings whose C-G-ratio is higher than 0.35: " + ratioCount);
        
        // print length of the longest gene in sr
        System.out.println("length of the longest gene: " + max);
    }
    
    public void testProcessGenes(){
        Part1 p1 = new Part1();
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        System.out.println(dna);
        
        var geneList = p1.getAllGenes(dna);
        processGenes(geneList);
    }
}

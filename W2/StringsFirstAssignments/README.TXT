------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Finding a Gene and Web Links
PURPOSE OF PROJECT: get familiar with String class
VERSION or DATE:
HOW TO START THIS PROJECT: [Download BlueJ Environment](https://www.dukelearntoprogram.com//downloads/bluej.php?course=2)
                           [Documentation](https://www.dukelearntoprogram.com//course2/doc)
AUTHORS: Trong Toan Nguyen.
INSTRUCTIONS: 
PROJECT REQUIREMENTS:
    Part 1: Finding a Gene - Using the Simplified Algorithm
        1. Create a new Java project named StringsFirstAssignments. 
        2. Create a new Java Class named Part1.
        3. Method findSimpleGene(String dna), representing a string of DNA to return Gene string:
            - Gene(start ATG - end TAA) contains codon(Sets of three nucleotides).
          ==>
            - Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string.
            - Finds the index position of the first stop codon “TAA” appearing after the “ATG” that was found. If there is no such “TAA”, return the empty string.
            - If the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.
            
        4. void method testSimpleGene():
            - Test cases: DNA with no “ATG”, DNA with no “TAA”, DNA with no “ATG” or “TAA”, 
                          DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene),
                          and DNA with ATG, TAA and the substring between them is not a multiple of 3.
           
            - For each DNA string you should:
                  Calling findSimpleGene with this string as the parameter. 
                  If a gene exists, then print the gene, otherwise print the empty string.
        
    Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
        1. findSimpleGene to have three parameters, one for the DNA string,
            one for the start codon and one for the stop codon.
        2. findSimpleGene method with DNA strings as parameter with all uppercase letters or all lowercase letters,
            and corresponding format in return value.


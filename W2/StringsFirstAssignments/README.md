# Java

PROJECT TITLE: Finding a Gene and Web Links.

PURPOSE OF PROJECT: get familiar with String class.

VERSION or DATE:

## PROJECT REQUIREMENTS

Part 1: Finding a Gene - Using the Simplified Algorithm

    1. Create a new Java project named StringsFirstAssignments.

    2. Create a new Java Class named Part1.

    3. Method findSimpleGene(String dna), representing a string of DNA to return Gene string:

        Gene(start ATG - end TAA) contains codon(Sets of three nucleotides).
        ==> - Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string. - Finds the index position of the first stop codon “TAA” appearing after the “ATG” that was found. If there is no such “TAA”, return the empty string. - If the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.

    4. void method testSimpleGene():

        - Test cases: DNA with no “ATG”, DNA with no “TAA”, DNA with no “ATG” or “TAA”,
                        DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene),
                        and DNA with ATG, TAA and the substring between them is not a multiple of 3.

        - For each DNA string you should:
                Calling findSimpleGene with this string as the parameter.
                If a gene exists, then print the gene, otherwise print the empty string.

Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized:

    1. findSimpleGene to have three parameters, one for the DNA string,
        one for the start codon and one for the stop codon.
    2. findSimpleGene method with DNA strings as parameter with all uppercase letters or all lowercase letters,
        and corresponding format in return value.

Part 3: Problem Solving with Strings:

    1. twoOccurrences(String stringa, String stringb):
        This method returns true if stringa appears at least twice in stringb,
        otherwise it returns false.
    2.  void testing():
        call twoOccurrences on several pairs of strings
        and print the strings and the result.
    3. lastPart(String stringa, String stringb):
        This method finds the first occurrence of stringa in stringb,
        and returns the part of stringb that follows stringa.
        If stringa does not occur in stringb, then return stringb.
        EX: lastPart(“an”, “banana”) => “ana”, the part of the string after the first “an”.
            lastPart(“zoo”, “forest”) => “forest” since “zoo” does not appear in that word.
    4. In testing() call the method lastPart with several pairs of strings.
        For each call print the strings passed in and the result.
        For example, the output for the two calls above might be:
            "The part of the string after an in banana is ana."
            "The part of the string after zoo in forest is forest."

Part 4: Finding Web Links:

    Write a program that reads the lines from the file at this URL location:
    http://www.dukelearntoprogram.com/course2/data/manylinks.html
    and prints each URL on the page that is a link to youtube.com:

        1. Use URLResource to read the file at [http://www.dukelearntoprogram.com/course2/data/manylinks.html] word by word.
        2. For each word, check to see if “youtube.com” is in it.
            If it is, find the double quote to the left and right of the occurrence of “youtube.com” to identify the beginning and end of the URL.
        some Methods: indexOf(x, num), lastIndexOf(s, num)
        Caution:
            Because YouTube links are case sensitive, you will need return the original string.

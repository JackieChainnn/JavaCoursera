------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------
PROJECT TITLE: Storing All Genes
PURPOSE OF PROJECT: get familiar with String class
VERSION or DATE: 16-11-2023

INSTRUCTIONS: 
PROJECT REQUIREMENTS:
Part 1
This assignment is to write the code from the lesson to use a StorageResource to store the genes you find instead of printing them out.
This will help you see if you really understood how to put the code together, and might identify a part that you did not fully understand. 
If you get stuck, then you can go back and watch the coding videos that go with this lesson again.
Specifically, you should do the following:

1. Create a new Java project named StringsThirdAssignments. You can put all the classes for this programming exercise in this project.

2. Create a new Java Class named Part1. Copy and paste the code from your Part1 class in your StringsSecondAssignments project into this class.

3. Make a copy of the printAllGenes method called getAllGenes. Instead of printing the genes found,this method should create and return
   a StorageResource containing the genes found. Remember to import the edu.duke libraries otherwise you will get an error message cannot
   find the class StorageResource.

4. Make sure you test your getAllGenes method.

Part 2 
Write the method cgRatio that has one String parameter dna, and returns the ratio of C’s and G’s in dna as a fraction of the entire strand of DNA.
For example if the String were “ATGCCATAG,” then cgRatio would return 4/9 or .4444444.

Hint: 9/2 uses integer division because you are dividing an integer by an integer and thus Java thinks you want the result to be an integer. 
If you want the result to be a decimal number, then make sure you convert one of the integers to a decimal number by changing it to a float. 
For example, (float) 9/2 is interpreted by Java as 9.0/2 and if one of the numbers is a decimal, then Java assumes you want the result to be 
a decimal number. Thus (float) 9/2 is 4.5.

Write a method countCTG that has one String parameter dna, and returns the number of times the codon CTG appears in dna.
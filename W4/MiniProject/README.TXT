PROJECT TITLE: MiniProject Exercise Guide
USER INSTRUCTIONS:
For this assignment, we are providing data on baby names from the United States and you will answer questions about this data. The data files
give information on the first names of people born in a particular year. We have data from 1880 through 2014 on both boys and girls names. 
You can download a .zip folder of all baby name data by navigate here http://www.dukelearntoprogram.com/course2/data/us_babynames.zip

You will write a program with several methods and tester methods to test each method you write.
    - totalBirths to also print the number of girls names , the number of boys names and the total names in the file.
    - getRank that has three parameters: int year, string name, string gender.
        This method returns the rank of the name in the file for the given gender,  where rank 1 is the name with the largest number of births. 
        If the name is not in the file, then -1 is returned.  For example, in the file "yob2012short.csv", given the name Mason, the year 2012 
        and the gender ‘M’, the number returned is 2, as Mason is the boys name with the second highest number of births. Given the name Mason,
        the year 2012 and the gender ‘F’, the number returned is -1 as Mason does not appear with an F in that file.
    - getName that has three parameters: an integer named year, an integer named rank, and a string named gender (F for female and M for male).
        This method returns the name of the person in the file at this rank, for the given gender, where rank 1 is the name with the largest 
        number of births. If the rank does not exist in the file, then “NO NAME”  is returned.
    -  whatIsNameInYear has four parameters: String name, int year (the year that name was born),  int newYear, String gender. 
        This method determines what name would have been named if they were born in a different year, based on the same popularity. That is, 
        you should determine the rank of name in the year they were born, and then print the name born in newYear that is at the same rank and 
        same gender. For example, If Isabella was born in 2014 instead, she would have been named Sophia, the third most popular girl's name 
        that year
    - yearOfHighestRank has two parameters: String name, String gender. 
        This method selects a range of files to process and returns an integer, the year with the highest rank for the name and gender. If the 
        name and gender are not in any of the selected files, it should return -1. For example, calling yearOfHighestRank with name Mason and 
        gender ‘M’ and selecting the three test files above results in returning the year 2012. That is because Mason was ranked the  2nd most
        popular name in 2012, ranked 4th in 2013 and ranked 3rd in 2014. His highest ranking was in 2012.

/**
 * Write a description of CSVParser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.*;

public class Parser {
    public String countryInfo(CSVParser parser, String country){
        String result = "NOT FOUND";
        for(CSVRecord csvRecord : parser){
            if(csvRecord.get("Country").contains(country)){
                // Get the iterator
                Iterator<String> it = csvRecord.iterator();
                int counter = 0;
                while(it.hasNext()) {
                    counter++;
                    if(counter == 1)
                        result  = it.next() + ": ";
                    else
                        result += it.next() + ": ";
                }                
                /*if(csvRecord.isMapped("Country"))
                    result  = csvRecord.get("Country") + ": ";
                if(csvRecord.isMapped("Exports"))
                    result += csvRecord.get("Exports") + ": ";
                if(csvRecord.isMapped("Value (dollars)"))
                result += csvRecord.get("Value (dollars)");*/
            }
        }
        return result;
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        String result = countryInfo(parser, "United States");
        System.out.println(result);
    }
}

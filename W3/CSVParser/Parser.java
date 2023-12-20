
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
    
    public void countryExportItems(CSVParser parser, String item1, String item2){
        String result = "";
        for(CSVRecord csvRecord : parser){
            if(csvRecord.get("Exports").contains(item1) && csvRecord.get("Exports").contains(item2)){
                // Get the iterator
                Iterator<String> it = csvRecord.iterator();
                while(it.hasNext()) {
                    result += it.next() + ": ";
                } 
                System.out.println(result);
                result = "";
            }
        }
    }
    
    public int howMany(CSVParser parser, String item){
        int counter = 0;
        for(CSVRecord csvRecord : parser){
            if(csvRecord.get("Exports").contains(item)){
                counter++;               
            }
        }
        return counter;
    }
    
        public void secondEco(CSVParser parser){
        String value = "$999,999,999,999";
        String result = "";
        for(CSVRecord csvRecord : parser){
            if(csvRecord.get("Value (dollars)").length() > value.length()){
                // Get the iterator
                Iterator<String> it = csvRecord.iterator();
                while(it.hasNext()) {
                    result += it.next() + ": ";
                }
                System.out.println(result);
                result = "";
            }
        }
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        // String result = countryInfo(parser, "Nauru");
        // countryExportItems(parser, "gold", "diamonds");
        int result = howMany(parser, "sugar");
        // secondEco(parser);
        System.out.println(result);
    }
}

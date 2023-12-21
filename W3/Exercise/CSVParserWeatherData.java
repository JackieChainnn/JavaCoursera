
/**
 * Write a description of CSVParserWeatherData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class CSVParserWeatherData {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestSoFar = null;
        for(CSVRecord csvRecord : parser){
            if(coldestSoFar == null){
                coldestSoFar = csvRecord;
            }else{
                Double currentTemp = Double.parseDouble(csvRecord.get("TemperatureF"));
                Double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if(currentTemp < coldestTemp){
                    coldestSoFar = csvRecord;
                }
            }
        }
        return coldestSoFar;
    }
    
    public String fileWithColdestTemperature(){
        String result = null;
        Double coldestTemp = null;
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            CSVParser parser = fr.getCSVParser();
            CSVRecord current = coldestHourInFile(parser);
            Double coldestCurrentTemp = Double.parseDouble(current.get("TemperatureF"));
            if(coldestTemp == null){
                coldestTemp = coldestCurrentTemp;
            }else{
                if(coldestCurrentTemp < coldestTemp){
                    coldestTemp = coldestCurrentTemp;
                    result = file.getPath();
                }
            }
        }
        return result;
    }
    
    public void testFileWithColdestTemperature(){
        String coldestInFile = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + coldestInFile);
        FileResource fr = new FileResource(coldestInFile);
        CSVRecord current = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temp on that day was " + current.get("TemperatureF"));
        System.out.println("All the Temps on the coldest day were: ");
        for(CSVRecord csvRecord : fr.getCSVParser()){
            System.out.println(csvRecord.get("DateUTC") + ": " + csvRecord.get("TemperatureF"));
        }
    }
    
    public void testColdestHourInFile(){
        DirectoryResource dr = new DirectoryResource();
        for(File file : dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
            System.out.println("From: "+ file.getName() +"| coldest temp: " + coldest.get("TemperatureF") + " at: " + coldest.get("DateUTC"));
        }
    }

}

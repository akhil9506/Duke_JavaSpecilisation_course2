
/**
 * Write a description of coldest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class coldest {
    public CSVRecord smallestOfTwo(CSVRecord coldest,CSVRecord current){
        if(coldest == null){
        coldest = current;
        }
        else if(Double.parseDouble(current.get(1))==-9999){return coldest;}
        else{
        double curr = Double.parseDouble(current.get(1));
        double cold = Double.parseDouble(coldest.get(1));
        if(curr<cold){
            coldest = current;
        }
        
        }
        return coldest;
    }
    public CSVRecord coldestHourFile(CSVParser parser){
        CSVRecord coldestSoFar = null;
        for(CSVRecord currentTemp:parser){
            coldestSoFar=smallestOfTwo(coldestSoFar,currentTemp);
        }
        return coldestSoFar;
    }
    public void testday(){
    FileResource fr = new FileResource();
    CSVRecord coldest = coldestHourFile(fr.getCSVParser());
    System.out.println("The coldest temparature of the day is"+coldest.get(1)+"at"+coldest.get(0));
    }
    public  String fileWithColdestTemparature(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord cold = null;
        String name = "";
        for (File f : dr.selectedFiles()) {
            FileResource fi = new FileResource(f);
            CSVRecord curr = coldestHourFile(fi.getCSVParser());
            cold = smallestOfTwo(cold,curr);
            if(cold == curr){
                name =f.getName();
                //System.out.println(cold.get(1));
                //System.out.println(name);
            }
        }
        System.out.println(cold.get(1)+cold.get("DateUTC"));
        return name;
    }
    public CSVRecord lowestOfTwo(CSVRecord coldest,CSVRecord current){
        if(coldest == null){
        coldest = current;
        }
        else if(current.get(3).equals("N/A")){
            return coldest;
        }
        else{
        double curr = Double.parseDouble(current.get(3));
        double cold = Double.parseDouble(coldest.get(3));
        if(curr<cold){
            coldest = current;
        }
        }
        return coldest;
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowest = null;
        for(CSVRecord curr:parser){
            lowest = lowestOfTwo(lowest,curr);
        }
        return lowest;
    }
    public void testLowestHumidty(){
        FileResource fr = new FileResource();
        CSVRecord csv = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("Lowest Humidity was "+csv.get(3)+""+csv.get("DateUTC"));
    }
    public  CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord cold = null;
        for (File f : dr.selectedFiles()) {
            FileResource fi = new FileResource(f);
            CSVRecord curr = lowestHumidityInFile(fi.getCSVParser());
            cold = lowestOfTwo(cold,curr);
                //System.out.println(cold.get(1));
                //System.out.println(name);
        }
        return cold;
    }
    public void testLowestHumidtyInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity  was "+csv.get(3)+"  "+csv.get("DateUTC"));
    }
    public double averageTemparatureFile(CSVParser csv,int value){
        double sum=0;
        int n=0;
        for(CSVRecord curr:csv){
            if(Double.parseDouble(curr.get(3)) >= value){
                System.out.println(Double.parseDouble(curr.get(1)));
                sum += Double.parseDouble(curr.get(1));
                n++;
            }
        }
        if(n>0){
        return sum/n;}
        else{return 0;}
    }
    public void testaverage(){
        FileResource fr = new FileResource();
    double n = averageTemparatureFile(fr.getCSVParser(),0);
    if(n==0){
    
        System.out.println("No temperatures with that humidity");
    }
    else{
        System.out.println("Average Temp when high Humidity is "+n);
    }
    }
}

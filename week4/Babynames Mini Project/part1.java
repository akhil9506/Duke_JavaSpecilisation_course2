
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class part1 {
    public void totalBirths(FileResource fr){
        int totalBirths=0,boys=0,girls=0;
        for(CSVRecord csvr:fr.getCSVParser(false)){
            if(csvr.get(1).equals("F")){
                girls += 1;
                //girls += Double.parseDouble(csvr.get(2));
                }
            if(csvr.get(1).equals("M")){
                boys += 1;
                //boys += Double.parseDouble(csvr.get(2));
                }
            totalBirths += Double.parseDouble(csvr.get(2));
            System.out.println(csvr.get(0));    
        }
        System.out.println("total number of births is"+totalBirths);
        System.out.println("total nuber of girls and boys are"+girls+" "+boys);
    }
    public void test(){
        FileResource fr= new FileResource();
        totalBirths(fr);
    }
    public int getRank(int year,String name,String gender){
    int rank=0;
    FileResource fr = new FileResource();
    for(CSVRecord csvr:fr.getCSVParser()){
        if(csvr.get(1).equals(gender)){
            rank++;
        }
        if(csvr.get(0).equals(name)&&csvr.get(1).equals(gender)){
            if(gender.equals("F"))
            return rank+1;
            else{return rank;}
        }
    }
    return -1;
    }
    public int getRankf(FileResource fr,String name,String gender){
        int rank=0;
        for(CSVRecord csvr:fr.getCSVParser()){
        if(csvr.get(1).equals(gender)){
            rank++;
        }
        if(csvr.get(0).equals(name)&&csvr.get(1).equals(gender)){
            if(gender.equals("F"))
            return rank+1;
            else{return rank;}
        }
    }
    return -1;
    }
    public int yearOfHighestRank(String name,String gender){
    DirectoryResource dr = new DirectoryResource();
    int rank_max= 0;
    String year =  "";
    int y=0;
    for(File f:dr.selectedFiles()){
        int curr_rank;
        FileResource fr = new FileResource(f);
        curr_rank = getRankf(fr,name,gender);
        if(rank_max==0){rank_max=curr_rank;}
        if((rank_max>=curr_rank)&& (curr_rank!=-1)){
            rank_max = curr_rank;
            year = f.getName();
            System.out.println(""+f.getName()+rank_max);
        }
        int k= year.indexOf("20");
        if(k==-1||rank_max==-1){return -1;}
        y = Integer.parseInt(year.substring(k,k+4));
    }
    return y;
    }
    public double getAverageRank(String Name,String gender){
        double average=0;
        int n=0;
        DirectoryResource dr = new DirectoryResource();
        for(File f:dr.selectedFiles()){
             FileResource fr = new FileResource(f);
             if(average != -1){
                 n++;
                 average += getRankf(fr,Name,gender);
                }
        }
        if(average == 0){return -1;}
        return average/n;
    }
    public int getTotalBirthsRankedHigher(int year,String name,String gender){
        FileResource fr = new FileResource();
        FileResource f = fr;
        int rank=0;
        int r=0;
        for(CSVRecord csv:fr.getCSVParser(false)){
            r++;
          if(csv.get(0).equals(name)&&csv.get(1).equals(gender)){
            rank = r;
            break;
        }  
        System.out.println(rank);
        }
        if(rank==0){return -1;}
        int count=0;
        int t=0;
        for(CSVRecord csvr:f.getCSVParser(false)){
            //System.out.println("grbnrb");
            t++;
            //System.out.println((csvr.get(1).equals(gender))+" "+ t+" "+ rank);
            if((csvr.get(1).equals(gender))&&t < rank){
                count += Integer.parseInt(csvr.get(2));
                System.out.println((csvr.get(1).equals(gender))+" "+count+" "+ t+" "+ rank);
            }
            
        }
        return count;
    }
    public String getName(int rank,String gender){
        FileResource fr = new FileResource();
        int i=1;
        for(CSVRecord csv:fr.getCSVParser()){
            //i++;
            if(csv.get(1).equals(gender)){
                i++;
            }
            if(i==rank){
                return csv.get(0);
            }
            
        }
        return null;
    }
}

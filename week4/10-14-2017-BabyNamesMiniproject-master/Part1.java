import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
/**
 *For this assignment, we are providing data on baby names from the United States and you will answer questions about this data. The data files give information on the first names of people born in a particular year. We have data from 1880 through 2014 on both boys and girls names. 
 *You can download a .zip folder of all baby name data here: http://www.dukelearntoprogram.com/course2/data/us_babynames.zip   in order to test everything properly.
 * 
 * @author (Abraham Ferrero) 
 * @version (OCT/04/2017)
 */
public class Part1 {
    public void totalBirths(FileResource f){
      /*This method takes every name, gender and number of births and 
      calculates the total of boys, girls and births in the list and also 
      counts how many different names we have in the database*/
      CSVParser data = f.getCSVParser(false);  
      int peroBoy = 0;
      int peroGirl = 0;
      int totalBirths = 0;
      int countNames = 0;
      int countGirlNames = 0;
      int countBoyNames = 0;
      for (CSVRecord rec : data){
          String gender = rec.get(1);
          int numBirth = Integer.parseInt(rec.get(2));
          countNames = countNames + 1;
          //System.out.println("Name: " + name + " Gender: " + gender + " Total Births with name: " + numBirth);
          if (gender.equals("M")){
              peroBoy += numBirth;
              countBoyNames = countBoyNames + 1;
            }
          else {
              peroGirl += numBirth;
              countGirlNames = countGirlNames + 1;
            }
        }
      totalBirths = peroBoy + peroGirl;
      System.out.println("Total boys = " + peroBoy);
      System.out.println("Total girls = " + peroGirl);
      System.out.println("Total births = " + totalBirths);
      System.out.println("Total girl Names = " + countGirlNames);
      System.out.println("Total Boy Names = " + countBoyNames);
      System.out.println("Total Names = " + countNames);
    }
    
    public void testTotalBirthsInFile(){
        //This method just tests the one above by choosing a file to test.
        FileResource f = new FileResource();
        totalBirths(f);
    }
    
    public String getRank(int year, String name, String gender){
        /*This method takes the year, name and gender given in the testGetRank() method and returns
        the string rank, which is the position in the chart where the name is depending on how many people were named with that name*/
        FileResource f = new FileResource();
        CSVParser data = f.getCSVParser(false); 
        String genderList = "";
        String nameList = "";
        String rank = "";
        int count1 = 0;
        int count2 = 0;
        for (CSVRecord rec : data){
            nameList = rec.get(0);
            genderList = rec.get(1);
            if  (genderList.equals("F")){
                //Starts counting and thus giving you the rank from the first female name.
                count1 = count1 + 1;
                rank = Integer.toString(count1);
            } 
            else {
                //Same for male name.
                count2 = count2 + 1;
                rank = Integer.toString(count2);
            } 
            if (name.equals(nameList) && genderList.equals(gender)){
                //Finds the name and gender given in the test in the file chosen.
                return rank;
            }
            
            else{
                rank ="-1";
            }
        }
        return rank;
    }
    
    
    public void testGetRank(){
       String name = "Frank";
       String gender = "M";
       int year = calculateYear();
       String ranko = getRank(year,name,gender); 
       System.out.println("The name "+ name + " is in position " + ranko + " in the rank, the year: " +year);
    }
    
    public String getName(int year, String rank, String gender){
        FileResource f = new FileResource();
        CSVParser data = f.getCSVParser(false); 
        String genderList = "";
        String rankList = "";
        String name = "";
        int count1 = 0;
        int count2 = 0;
        for (CSVRecord rec : data){
            genderList = rec.get(1);
            name = rec.get(0);
            if  (genderList.equals("M")){
                count1 = count1 + 1;
                rankList = Integer.toString(count1);;
            } 
            if  (genderList.equals("F")) {
                count2 = count2 + 1;
                rankList = Integer.toString(count2);
            } 
            if (rank.equals(rankList) && gender.equals(genderList)){
                return name;
            }
        }
        return "NO NAME";
    }
    
    public void testGetName(){
        int year = 1982;
        String rank = "350";
        String gender = "F";
        String namo = getName(year,rank,gender);
        /*If rank is too big for the file selected, there won't be any name, so I configurated it to say just
        that there is no name, our result is now nice and tidy  :)*/
        if (namo.equals("NO NAME")){
            System.out.println(namo);
        }
        else {
            System.out.println("The person with the rank " + rank + " in " + year + " is " + namo);
            
        }
    }
    
    
    public int calculateYear(){
         DirectoryResource d = new DirectoryResource();
        String RealYear = "";
        for (File fi : d.selectedFiles()){
            FileResource fr = new FileResource(fi);
            //totalBirths(fr); --testing that you can iterate the function and works
            String fileName = fi.getName();
            RealYear = fileName.substring(3,7);
            CSVParser data = fr.getCSVParser(false);
            for (CSVRecord rec : data){
                String nameBaby = rec.get(0);
            }
        }
        //converts the year in the filename to an int year value.
        int year = Integer.parseInt(RealYear);
        return year;
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        DirectoryResource dr = new DirectoryResource();
        String nameYear1 = "";
        String nameYear2Temp = "";
        String nameYear2 = "";
        String genderList = "";
        String rank1Temp = "";
        String rank1 = "";
        String rank2 = "";
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        
        for (File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            //the filename selected gives you the year:
            String fileName = f.getName().substring(3,7);
            
            //If the year in the test method and the year in the file name is the same, it works.
            if (Integer.toString(year).equals(fileName)) {
                  CSVParser year1 = fr.getCSVParser(false);  
                  for (CSVRecord rec : year1){
                      nameYear1 = rec.get(0);
                      genderList = rec.get(1);
                      if  (genderList.equals("F")){
                          //converts name in rank for female
                          count1 = count1 + 1;
                          rank1Temp = Integer.toString(count1);
                        } 
                      if  (genderList.equals("M")){
                          //converts name in rank for female
                          count2 = count2 + 1;
                          rank1Temp = Integer.toString(count2);
                        }
                      if (name.equals(nameYear1)&& gender.equals(genderList)){
                          //It returns the rank for the name and gender given in the test method
                          rank1 = rank1Temp;
                        }
                    }
            }
            /*if the newYear (the second year selected in the test method) is the same as the year in the
            fileResource, then iterate the data in the file to find the name with the same rank,
            this way we will find what name the person in year "A" would have in year "B":  */
            if (Integer.toString(newYear).equals(fileName)){
                CSVParser year2 = fr.getCSVParser(false);
                 for (CSVRecord rec : year2){
                      nameYear2Temp = rec.get(0);
                      genderList = rec.get(1);
                      if  (genderList.equals("F")){
                          //converts name in rank
                          count3 = count3 + 1;
                          rank2 = Integer.toString(count3);
                        } 
                      if  (genderList.equals("M")){
                          count4 = count4 + 1;
                          rank2 = Integer.toString(count4);
                        } 
                      if (rank2.equals(rank1) && gender.equals(genderList)){
                          nameYear2 = nameYear2Temp;
                      }
                }
            }
           }
        //Now we will print the result in order to have a nice and tidy string to print:
        System.out.println(name + ", born in " + year + " would be " + nameYear2 + " if she was born in " + newYear + ".");
    }
    
    public void testWhatIsNameInYear(){
        int year = 1972;
        int newYear = 2014;
        String name = "Susan";
        String gender = "F";
        whatIsNameInYear(name, year, newYear, gender);
    }
    
    public int yearOfHighestRank(String name, String gender){
        /*This method gets the year and gender from the test method below, and iterates over the 
         * files selected looking for the highest rank (the name with the biggest number of births per file)
         * and returns the year when the name given had the biggest number of births.
         */
        DirectoryResource dr = new DirectoryResource();
        String nameYear = "";
        String genderList = "";
        int count1 = 0;
        int count2 = 0;
        int largestRankGirl = 0;
        int largestRankBoy = 0;
        String fileName = "";
        int maxYear = 0;
        for (File f: dr.selectedFiles()){
            //We want to take the file name for every file and iterate over every file selected.
            FileResource fr = new FileResource(f);
            fileName = f.getName().substring(3,7);
            int fileNumber = Integer.parseInt(fileName);
            CSVParser year = fr.getCSVParser(false);
            for (CSVRecord rec : year){
                //This will give us the highest rank of every file:
                nameYear= rec.get(0);
                genderList = rec.get(1);
                if  (genderList.equals("F")){
                    count1 = count1 + 1;
                }
                if  (genderList.equals("M")){
                    count2 = count2 + 1;
                }
                //This will give us the rank of our name per year (per file selected):
                if (name.equals(nameYear) && gender.equals(genderList)){
                    if (genderList.equals("F")){
                        //This method will give us the max rank of our name (the name in the test method).
                        if (largestRankGirl == 0){
                            largestRankGirl = count1;
                        }
                        
                        if (largestRankGirl > count1){
                            //Here is the key: We take the maximum rank and the filename, which give is the year, the value we want.
                            largestRankGirl = count1;
                            maxYear = fileNumber;
                        }
                        //System.out.println("Success! " +nameYear + " the count is: " + count1 + " and largest: " + largestRankGirl + " " + fileName); //Nice printing operation to test so I keep it here
                    }
                    else {
                        //We will do the same but for male values, just by changing the name of our variables.
                        if (largestRankBoy == 0){
                            largestRankBoy = count2;
                        }
                        
                        if (largestRankBoy > count2){
                            largestRankBoy = count2;
                            maxYear = fileNumber;
                        }
                        //System.out.println("Success! " +nameYear + " the count is: " + count2 + " and largest: " + largestRankBoy + " " + fileName);
                    }
                }
                
            }
            /*It is VITAL to reset the "count" variables everytime we iterate a 
             * new file (we execute the loop again for the next file). Otherwise
             * the rank from the last file will be added to the rank for the next file
             * and obviously we do not want that.
             */
            count1 = 0;
            count2 = 0;
        }
        return maxYear;
    }
    
    public void testYearOfHighestRank(){
        String name = "Genevieve";
        String gender = "F";
        int highest = yearOfHighestRank(name, gender);
        System.out.println("Highest rank was in year: "+highest);
    }
    
    public double getAverageRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        String nameYear = "";
        String genderList = "";
        int count1 = 0;
        int count2 = 0;
        int largestRankGirl = 0;
        double addRank = 0;
        double fileAmount = 0;
        double averageRank = 0;
        for (File f: dr.selectedFiles()){
            //We want to take the file name for every file and iterate over every file selected.
            FileResource fr = new FileResource(f);
            CSVParser year = fr.getCSVParser(false);
            for (CSVRecord rec : year){
                //This will give us the highest rank of every file:
                nameYear= rec.get(0);
                genderList = rec.get(1);
                if  (genderList.equals("F")){
                    count1 = count1 + 1;
                }
                if  (genderList.equals("M")){
                    count2 = count2 + 1;
                }
                //This will give us the rank of our name per year (per file selected):
                if (name.equals(nameYear) && gender.equals(genderList)){
                    if (genderList.equals("F")){
                        //This method will give us the max rank of our name (the name in the test method).
                        fileAmount = fileAmount + 1;
                        //System.out.println(nameYear + " rank : " + count1 + " Number of files = " + fileAmount);
                        //addRank will give us the total of every rank in every file for the name and gender in the test method: 
                        if (addRank == 0){
                            addRank = (double)count1;
                        }
                        else {
                            addRank = (addRank + (double)count1);
                        }
                        //And finally, we will calculate the average by dividing the total rank value by the number of files(years) we have selected.
                        averageRank = addRank/fileAmount;
                    }
                    else {
                        //We do the same for male gender, so we just have to swap count1 variable with count2 which gives us the rank for male.
                        fileAmount = fileAmount + 1;
                        //System.out.println(nameYear + " rank : " + count2 + " Number of files = " + fileAmount);
                        if (addRank == 0){
                            addRank = (double)count2;
                        }
                        else {
                            addRank = (addRank + (double)count2);
                        }
                        averageRank = addRank/fileAmount;
                    }
                }
            }
            //We reset the rank everytime we iterate over a new file.
            count1 = 0;
            count2 = 0;
        }  
        return averageRank;
    }
    
    public void testGetAverageRank(){
        String name = "Susan";
        String gender = "F";
        double average = getAverageRank(name, gender);
        System.out.println(average);
    }
}

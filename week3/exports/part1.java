
/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class part1 {
        public void test(){
            FileResource fr = new FileResource();
            CSVParser parser = fr.getCSVParser();
            System.out.println(countryInfo(parser,"Nauru"));
            CSVParser pars = fr.getCSVParser();
            listExportersTwoProducts(pars,"cotton","flowers");
            parser = fr.getCSVParser();
            System.out.println(numberOfExporters(parser,"cocoa"));
            parser = fr.getCSVParser();
            bigExporters(parser,"$999,999,999,999");
        }
        public String countryInfo(CSVParser pars,String countr){
            for(CSVRecord p:pars){
                //System.out.println(p.get(0)+countr);
                //System.out.println(s);
                if(countr.equals(p.get(0))){
                return p.get(0)+":"+p.get(1)+p.get(2);
                }
            }
            return "NOT FOUND";
        }
        public void listExportersTwoProducts(CSVParser p,String exportitem2,String exportitem1){
            for(CSVRecord r:p){
                String s = r.get(1);
                //System.out.println(s);
                if((s.indexOf(exportitem1)!=-1) &&(s.indexOf(exportitem2)!=-1)){
                    System.out.println("qqq"+r.get(0));
                }
            }
        
        }
        public int numberOfExporters(CSVParser pars,String s){
            int n=0;
            for(CSVRecord r:pars){
            String g = r.get(1);
            if(g.indexOf(s)!=-1){
                n++;}
            }
            return n;
        }
        public void bigExporters(CSVParser p,String amount){
            for(CSVRecord c:p){
            String s = c.get(2);
            //System.out.println(s.length());
            if(s.length()>amount.length()){
                System.out.println(c.get(0)+""+c.get(2));
            }
            }
        
        }
}

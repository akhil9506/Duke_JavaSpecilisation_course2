import edu.duke.*;
import java.io.File;
/**
 * Write a description of part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part4 {
    public String findUrl(){
        String search ="youtube.com";
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
         String u = ur.asString();
        for(int i=0;;i++){
            String delim = "\"";
            int a;
            a = u.indexOf(search,i);
            int k;
            k = u.lastIndexOf(delim,a);
            int e = u.indexOf(delim,a);
            if(e<0 || a<0 ||k<0){
                break;}
            else{
            System.out.println(u.substring(k,e+1));
            }
            i = e;
        }
        return u;
    }
    public void test(){
        findUrl();
    }
    
}


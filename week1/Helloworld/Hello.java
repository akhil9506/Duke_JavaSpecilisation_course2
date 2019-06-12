
/**
 * Write a description of Hello here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.FileResource;
public class Hello {
                public void runHello(){
                    FileResource f;
                    f = new FileResource("file.txt");
                    for(String line: f.line())
                }
}

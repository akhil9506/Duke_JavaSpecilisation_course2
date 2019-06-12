import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int num =0;
        for(Point curr:s.getPoints()){
            num += 1;
        }
        return num;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double average =0;
        Point prev = s.getLastPoint();
        for(Point curr:s.getPoints()){
            average = average + prev.distance(curr);
        }
        int n;
        n = getNumPoints(s);
        average = average /n;
        return average;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prev;
        prev = s.getLastPoint();
        double max_len=0,len=0;
        for(Point curr:s.getPoints()){
            len = prev.distance(curr);
            if(max_len < len){
            max_len = len;
            }
        }
        return max_len;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double max_x=0,x=0;
        for(Point curr:s.getPoints()){
        x = curr.getX();
        if(max_x<x){
        max_x = x;
        }
        }
        return max_x;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr= new DirectoryResource();
        double max_per=0,per=0;
        
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            per = getPerimeter(s);
            if(max_per<per){
            max_per = per;
            }
        }
        return max_per;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return null;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of sides is" + getNumPoints(s));
        System.out.println("average length is" + getAverageLength(s));
        System.out.println("maximum length is" + getLargestSide(s));
        System.out.println("maximum x-coordinate is" + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("the largest perimeter of selected files" + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}

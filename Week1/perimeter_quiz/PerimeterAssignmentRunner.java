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
        int numPoints = 0;
        for(Point point : s.getPoints()){
            numPoints++;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double perimeter = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double avgLength = perimeter/numPoints;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        // Declare largest variable
        double largest = 0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // compare largest with currDist
            if(currDist > largest){
                largest = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = -1;
        for(Point currPt : s.getPoints()){
            double currX = currPt.getX();
            if(currX > largestX)
                largestX = currX;
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestP = 0;
        String largestPerimeterFile = null;
        File lPFile = null;  
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            System.out.println("file: " + f);
            System.out.println("perim = " + perimeter);
            if(perimeter > largestP)
            {
                largestP = perimeter;
                lPFile = f;
            }
        }
        System.out.println("lP file: " + lPFile);
        return largestP;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        String largestPerimeterFile = null;
        
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints = getNumPoints(s);
        System.out.println("num points = " + numPoints);
        double avgLength = getAverageLength(s);
        System.out.println("Avg length = " + avgLength);
        double largestSide = getLargestSide(s);
        System.out.println("Largest side = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("Largest x = " + largestX);
        System.out.println();
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largestP = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter = " + largestP);
        System.out.println();
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
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}

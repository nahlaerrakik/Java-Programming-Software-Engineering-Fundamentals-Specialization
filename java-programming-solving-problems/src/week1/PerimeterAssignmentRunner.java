package week1;

import uni.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start with prevPt = the last point 
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
        int count = 0;
        for (Point currPt : s.getPoints()){
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double avr = getPerimeter(s)/getNumPoints(s);
        return avr;
    }

    public double getLargestSide(Shape s) {
         double largest = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if(currDist>largest) largest = currDist;
            prevPt = currPt;
            }
        return largest;
    }

    public double getLargestX(Shape s) {
        double largestX = 0.0;
        for(Point currentPt : s.getPoints()){
            double currentPtX  = currentPt.getX();
            if(currentPtX>largestX) largestX = currentPtX;
        }

        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeter = 0.0;        
        DirectoryResource dr = new DirectoryResource();        
        FileResource fr = null;
        for (File f : dr.selectedFiles()){
        FileResource file = new FileResource(f);
        Shape s = new Shape(file);
        double peri = getPerimeter(s);
            if (peri>largestPerimeter){
            largestPerimeter = peri;            
            }
    }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;

        for(File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if(perim > largestPerim) {
                largestPerim = perim;
                largestFile = f;
            }
        }    

        return largestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        int numPoints = getNumPoints(s);
        System.out.println("Number of points = " + numPoints);
        
        double avLength = getAverageLength(s);
        System.out.println("Average length = " + avLength);
    
        double largestSide = getLargestSide(s);
        System.out.println("The largest side in the shape = " + largestSide);
	
        double largestX = getLargestX(s);
        System.out.println("The largest x point in the shape = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPeriMultiFIle = getLargestPerimeterMultipleFiles();
        String fileName = getFileWithLargestPerimeter();
	
        System.out.println("The largest perimeter in the directory = " + largestPeriMultiFIle);
        System.out.println("The largest perimeter in the directory = " + fileName);
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
        pr.testPerimeterMultipleFiles();
        pr.printFileNames();
    }
}

package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by user on 20-Apr-16.
 */
public class PointTests {


     @Test
    public static void checkDistance(){
         Point p1 = new Point(3.0,3.0);
         Point p2 = new Point(3.0,3.0);
       if( (p1.distance(p2))==0.0){

           System.out.println("Points have equal data. Change parameters to calculate a distance!");
       }
     }

    @Test
    public static void ifNegative(){
        Point p1 = new Point(0.0,-3.0);
        Point p2 = new Point(0.0,3.0);
        Assert.assertEquals(p2.distance(p1),6.0);


    }
}

package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 20-Apr-16.
 */


public class SquareTests {

    @Test
    public static void testaAre() {
        Square s = new Square(5);
        Assert.assertEquals(s.area(),25.0);
    }


}

package ru.stqa.pft.sandbox;

/**
 * Created by Анна on 19.04.2016.
 */
public class Point {

  double x;
  double y;

  public Point(double x, double y){
    this.x= x;
    this.y=y;
  }

  public double distance(Point p){

    double res= Math.sqrt(Math.pow(x-p.x,2)+Math.pow(y-p.y,2));
    return res;

  }
}

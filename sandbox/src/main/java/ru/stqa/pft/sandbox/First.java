package ru.stqa.pft.sandbox;

public class First {

  public static void main(String[] args) {

    Square s = new Square(5);
    Rectangle r = new Rectangle(2, 5);
    Point p1= new Point(1.0,1.0);
    Point p2 = new Point(4.0,4.0);

    System.out.println(s.area());
    System.out.println(r.area());
    System.out.println(p2.distance(p1));
  }
}



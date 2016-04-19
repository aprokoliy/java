package ru.stqa.pft.sandbox;

/**
 * Created by Анна on 19.04.2016.
 */
public class Square {

  public double l;

  public Square(double len){

    this.l= len;
  }

   public double area(){

    return this.l * this.l;
  }
}

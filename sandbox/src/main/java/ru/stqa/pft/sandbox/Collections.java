package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 30-May-16.
 */
public class Collections {

    public static void main(String[] args){
   // String[] langs = {"Java","C#","Python","PHP"};
        List<String> languages = Arrays.asList("Java","C#","Python","PHP");

        for(String l: languages){
            System.out.println("I want to learn " + l);
        }

    }
}

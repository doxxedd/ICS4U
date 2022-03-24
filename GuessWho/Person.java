/*
 * File Name: Person.java
 * Authors: Daniel.D
 * Date: 22 - 01 - 2021
 * Description: Person class that stores attributes of a GuessWho character, has a function returning if a person has a specified attribute, and accessor methods for attributes and names of persons
 * Teacher: Ms. Andreghetti
 */

package GuessWho;

import java.util.*;

public class Person {

    private Attribute name;
    private List<Attribute> attributes = new ArrayList<Attribute>();

    //constructor for a person. parameters are name and an attribute
    public Person(Attribute name, List<Attribute> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    //function that returns if a given person has an attribute or not, when the asked about attribute is given as parameter
    public boolean hasAttribute(Attribute attribute){
        for (Attribute a : attributes) {
            if (a == attribute) {
                return true;
            }
        }
        return false;
    }

    //getter/accessor method for attributes of person
    public List<Attribute> getAttributes(){
        return attributes;
    }

    //accessor method for name of person
    public Attribute getName(){
        return name;
    }
    
}
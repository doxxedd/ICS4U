/*
* Author: Daniel.D
* Date: 25-01-2021
* Description: This class is responsible for reading the characters.txt file which contains all the attributes that each person on the guesswho board has, then puts them into an array
*/
package GuessWho;

import java.util.*;

//This class takes in the raw data of the text file (using readAllLines method from FileManager) containing the attributes of each person and puts them into an arraylist of characters with type person
public class CharacterManager {
    
    // Example of how a line looks like in characters.txt file. (numbers refer to the specific attributes of a person, separated by semicolons)
    //nameOfPerson;5;2;10;3;1; 

    public static Person[] getCharactersInArray() throws Exception {

        var rawData = FileManager.readAllLines("characters.txt"); //the rawData variable equals to a file manager instance using the readAllLines method to scan the characters.txt

        ArrayList<Person> characters = new ArrayList<Person>(); //an arraylist of characters with type person

        //for each loop that is looping through the rawData gathered, 
        for (String personAttributesInString : rawData) {

            String[] nameAndAttributesList = personAttributesInString.split(";"); //the ";" is splitting different attributes that belongs to a character

            List<Attribute> attributes = new ArrayList<Attribute>(); //arrayList called attributes that is type Attribute

            //for loop that adds the attributes and names list to the attribute arraylist
            for (int i = 1; i < nameAndAttributesList.length; i++) {
                attributes.add(Attribute.values()[Integer.parseInt(nameAndAttributesList[i])]);
            }

            characters.add(new Person(Attribute.valueOf(nameAndAttributesList[0].toUpperCase()), attributes));
        }

        // Converting the persons list to array before returning
        return characters.toArray(new Person[characters.size()]);
    }
}

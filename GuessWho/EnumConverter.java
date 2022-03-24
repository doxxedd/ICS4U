/*
* Author: Daniel.D
* Date: 25-01-2021
* Description: This class contains static functions to convert strings into attributes and attributes into string in good format
*/
package GuessWho;


public class EnumConverter {
    
    //A static function that takes in an attribute and converts it into a well formatted string
    public static String enumToString(Attribute attribute) {
        boolean capitalize = true;
        String attributeString = "";
        //Build a string letter by letter to make enums into proper case string
        for(int i = 0; i < attribute.toString().length(); i ++){
            if(attribute.toString().substring(i,i+1).equals("_")){
                attributeString += " ";
                capitalize = true;
            }
            else if(capitalize) {
                attributeString += attribute.toString().substring(i, i+1).toUpperCase();
                capitalize = false;
            }
            else {
                attributeString += attribute.toString().substring(i, i+1).toLowerCase();
            }
        }
        return attributeString;
    }

    //A function that takes in a string which represents an attribute and converts it into an Attribute enum
    public static Attribute stringToEnum(String attributeString) {
        //Convert string from proper case to the value of the enum
        attributeString = attributeString.toUpperCase();
        String newAttributeString = "";
        for(int i = 0; i < attributeString.length(); i ++){
            if(attributeString.substring(i,i+1).equals(" ")) {
                newAttributeString += "_";
            }
            else {
                newAttributeString += attributeString.substring(i, i+1);
            }
        }
        //Convert string to attribute and return it
        return Attribute.valueOf(newAttributeString);
    }
}
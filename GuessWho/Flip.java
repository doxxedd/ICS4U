/*
* Author: Daniel.D
* Date: 19-01-2021
* Description: Flips refer to each rectangular box on a physical guess who board that contains the face of a person
*/
package GuessWho;

public class Flip{
	private boolean isActive = true;
	private Person person;

    public Flip (Person person) {
        this.person = person;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public Person getPerson() {
        return person;
    }

    public void flipDown(){
        this.isActive = false;
    }

    //deactivates flips if the attribute given exists in a person. takes in attribute type attribute 
    public void flipDownIfHasAttribute(Attribute attribute){
        if (this.person.hasAttribute(attribute)) {
            isActive = false;
        }
    }
   
    //deactivates flips if the attribute given does not exist in a person. takes in attribute type attribute 
    public void flipDownIfDoesntHaveAttribute(Attribute attribute){
        if (this.person.hasAttribute(attribute) == false) {
            isActive = false;
        }
    }
}
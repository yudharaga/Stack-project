/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

/**
 *
 * @author Arzan-PC
 */
public class InvalidLengthException extends Exception {

    

    private String lengthSent;

    //Membuat InvalidLengthException dengan Panjang String tidak valid.
    public InvalidLengthException(String inString)
    {
        this.lengthSent = inString;
    }
    //Returns dengan memasukan String pada InvalidLengthException.
    public String getLengthSet()
    {
        return this.lengthSent;
    }

    //Returns InvalidLengthException pada String.

    public String toString()
    {
        String returnString;

        returnString = this.lengthSent + " Ini tidak valid pada lenght!\n";

        return returnString;
    }

}

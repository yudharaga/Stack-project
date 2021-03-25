/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

/**
 *
 * @author Arzan-PC
 */
public class InvalidRatingException extends Exception {

    private int numberSent;

    //Membuat InvalidRatingException dengan nomor tidak valid.
    public InvalidRatingException(int inNumberSent)
    {
        this.numberSent = inNumberSent;
    }

    //Returns nomor yang dikirim pada InvalidRatingException.
    public int getNumberSent()
    {
        return this.numberSent;
    }

    //Returns InvalidRatingException untuk sebuah String.
    public String toString()
    {
        String returnString;

        returnString = this.numberSent + " Rating ini tidak valid! Mohon pilih rating 1 sampai 5.\n";

        return returnString;
    }
}
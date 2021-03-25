/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

/**
 *
 * @author Arzan-PC
 */

import java.io.Serializable;

public class Song implements Serializable
{
    private String artist;
    private String title;
    private String length;
    private String genre;
    private int rating;

    //Membuat objek daftar putar dengan artis, judul, panjang, genre, dan peringkat.
    public Song(String artist, String title, String length, String genre, int rating)
    {
        this.artist = artist;
        this.title = title;
        this.length = length;
        this.genre = genre;
        this.rating = rating;
    }

    //Menyetel artis Lagu ke artis argumen.
    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    //Kembalikan nilai artis dalam sebuah Lagu.
    public String getArtist()
    {
        return artist;
    }

    //Setel judul Lagu ke judul argumen.
    public void setTitle(String title)
    {
        this.title = title;
    }

    //Mengembalikan nilai judul dalam sebuah Lagu.
    public String getTitle()
    {
        return this.title;
    }

    //Setel panjang lagu ke argumen panjang; membuat InvalidLengthException.
    /* Ini bukan cara yang saya inginkan untuk melakukan ini, sebagai gantinya
     * ini memeriksa validitas dengan melihat apakah argumen String
     * berisi titik dua dan hanya angka.*/
    public void setLength(String length) throws InvalidLengthException
    {
        if(length.matches("(\\d.*):(\\d.*)"))
        {
            this.length = length;
        }
        else
        {
            throw new InvalidLengthException(length);
        }
    }

    //Mengembalikan nilai panjang dalam sebuah Lagu.
    public String getLength()
    {
        return this.length;

    }

    //Setel genre Lagu ke genre argumen.
    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    //Mengembalikan nilai genre dalam sebuah Lagu.
    public String getGenre()
    {
        return this.genre;
    }

    //Setel rating Lagu ke rating argumen; membuat InvalidRatingException.
    public void setRating(int rating) throws InvalidRatingException
    {
        if(rating > 0 || rating < 6)
        {
            this.rating = rating;		}
        else
        {
            throw new InvalidRatingException(rating);
        }

    }

    //Mengembalikan nilai peringkat dalam sebuah Lagu.
    public int getRating()
    {
        return this.rating;
    }


}



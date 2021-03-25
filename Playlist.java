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
import java.util.ArrayList;

public class Playlist implements Serializable
{
    private ArrayList<Song> playlist;

    //Membuat objek Playlist yang berisi ArrayList untuk Lagu.
    public Playlist()
    {
        playlist = new ArrayList<>();
    }

    //Menambahkan Lagu ke Daftar Putar.
    public void addSong(Song song)
    {
        playlist.add(song);
    }

    //Mengembalikan ukuran Daftar Putar.
    public int getPlaylistSize()
    {
        return playlist.size();
    }

    //Menampilkan artis Lagu pada posisi (indeks) Daftar Putar.
    public String getArtist(int index)
    {
        return playlist.get(index).getArtist();
    }

    //Mengembalikan judul Lagu pada posisi (indeks) Daftar Pemutaran.
    public String getTitle(int index)
    {
        return playlist.get(index).getTitle();
    }

    //Mengembalikan panjang Lagu pada posisi (indeks) Daftar Pemutaran.
    public String getLength(int index)
    {
        return playlist.get(index).getLength();
    }

    //Mengembalikan genre Lagu pada posisi (indeks) Daftar Putar.
    public String getGenre(int index)
    {
        return playlist.get(index).getGenre();
    }

    //Mengembalikan peringkat Lagu pada posisi (indeks) Daftar Pemutaran.
    public int getRating(int index)
    {
        return playlist.get(index).getRating();
    }

    //Menyetel artis Lagu pada posisi (indeks) ke artis.
    public void updateArtist(int index, String artist)
    {
        playlist.get(--index).setArtist(artist);
    }

    //Menyetel judul Lagu pada posisi (indeks) menjadi judul.
    public void updateTitle(int index, String title)
    {
        playlist.get(--index).setTitle(title);
    }

    //Menyetel panjang Lagu pada posisi (indeks) menjadi panjang; melempar InvalidLengthException.
    public void updateLength(int index, String length) throws InvalidLengthException
    {
        if(length.matches("(\\d.*):(\\d.*)"))
        {
            playlist.get(--index).setLength(length);
        }
        else
        {
            throw new InvalidLengthException(length);
        }
    }

    //Setel genre Lagu pada posisi (indeks) ke genre.
    public void updateGenre(int index, String genre)
    {
        playlist.get(--index).setGenre(genre);
    }

    //Setel peringkat Lagu pada posisi (indeks) ke peringkat.
    public void updateRating(int index, int rating) throws InvalidRatingException
    {
        if(rating > 0 && rating < 6)
        {
            playlist.get(--index).setRating(rating);
        }
        else
        {
            throw new InvalidRatingException(rating);
        }
    }

    //Menghapus lagu yang terletak di indeks tertentu dari Daftar Putar.
    public void removeSong(int index)
    {
        playlist.remove(index);
    }
    public void removeindex (int index1){
        playlist.remove(index1);
    }

    //Menghapus Playlist dari semua Lagu dengan mengaktifkan clear () pada Playlist.
    public void deletePlaylist()
    {
        if(playlist.size() == 0)
        {
            System.out.print("Playlist Kosong!\n");
        }
        else
        {
            playlist.clear();
            System.out.print("Playlist Berhasil di Format.\n");
        }
    }

} 

package projectjava;

/**
 *
 * @author Arzan-PC
 */
import java.io.*;
import java.util.Scanner;

public class Menu {
   
    private Scanner scan = new Scanner(System.in);
    private Playlist playlist = new Playlist();

    //Menampilkan menu, meminta masukan pengguna (pilihan int), dan mengembalikan masukan.
    public int showMenu()
    {
        int selection;

        System.out.print("\nApa yang ingin anda update?"
                + "\n1- Tampilkan Data Playlist"+ "\n2- Tambah Data Playlist"
                + "\n3- Hapus Data Playlist" + "\n4- Tambah Data Playlist dalam urutan tertentu" 
                + "\n5- Hapus Data Playlist dalam urutan tertentu"
                + "\n6- Hapus Semua Playlist" + " \n7- Exit" + "\n Pilih: ");
        selection = scan.nextInt();
        System.out.print("\n");

        return selection;
    }

    //Menu tampilan dari showMenu (): Berisi sakelar,
    //menjalankan kasus berdasarkan int yang dikembalikan dari showMenu ().
    public void runMenu()
    {

        int selection = showMenu();

        switch (selection) {
            case 1:
                viewPlaylist();
                runMenu();
                break;
            case 2:
                addSong();
                savePlaylist();
                runMenu();
                break;
            case 3:
                removeSong();
                savePlaylist();
                runMenu();
                break;
            case 4:
                updateSong();
                savePlaylist();
                runMenu();
                break;
            case 5:
                removeindex();
                savePlaylist();
                runMenu();
                break;
            case 6:
                playlist.deletePlaylist();
                runMenu();
                break;
            case 7:
                savePlaylist();
                System.exit(0);
                break;
            default:
                System.out.println("\nPilihan tidak valid!\n");
                runMenu();
        }

    }

    //Membuat Lagu baru dengan input pengguna untuk artis, judul,
    // panjang, genre, peringkat; menambahkan Lagu ke Daftar Putar.
    /*Saya mengalami banyak masalah saat meminta pemindai mendapatkan input dan menetapkannya dengan benar.
     *Seseorang menyarankan agar saya menggunakan scanner.reset (), tetapi saya akan mendapatkan pengecualian scanner. Cara ini berhasil.*/
    public void addSong()
    {
        Song newSong = new Song(null, null, null, null, 0);

        newSong.setArtist(scan.nextLine());
        System.out.print("Nama Artist: ");
        newSong.setArtist(scan.nextLine());
        System.out.print("Nama Judul : ");
        newSong.setTitle(scan.nextLine());
        do
        {
            try
            {
                System.out.print("Durasi: ");
                newSong.setLength(scan.next());
            }
            catch (InvalidLengthException invalidLength)
            {
                System.out.print(invalidLength.toString());
                System.out.print("Masukan durasi musik \"menit:detik\".\n");
            }
        }while (newSong.getLength() == null);

        newSong.setGenre(scan.nextLine());
        System.out.print("Genre: ");
        newSong.setGenre(scan.nextLine());
        boolean flag = false;
        do
        {
            try
            {
                System.out.print("Masukan Rating: ");
                newSong.setRating(scan.nextInt());
                flag = true;
            }
            catch (InvalidRatingException invalidRating)
            {
                System.out.print(invalidRating.toString());
            }
        } while(flag == false);

        playlist.addSong(newSong);
    }

    //Memformat dan menampilkan semua Lagu dalam Daftar Putar.
    public void viewPlaylist()
    {
        if(playlist.getPlaylistSize() == 0)
        {
            System.out.println("\nPlaylist Kosong!");
        }
        else
        {
            for(int i = 0; i < playlist.getPlaylistSize(); i++)
            {
                System.out.print("\n#" + (i+1) + " ");
                System.out.print(""+ playlist.getArtist(i) + " - ");
                System.out.print("\"" +playlist.getTitle(i)+ "\"" + ", ");
                System.out.print(playlist.getLength(i) + ", ");
                System.out.print(playlist.getGenre(i) + ", ");
                System.out.print(playlist.getRating(i)+ " out of 5");
            }
            System.out.print("\n");
        }
    }

    //Menampilkan Daftar Putar; meminta pengguna untuk memilih lagu,
    // menanyakan variabel lagu mana yang ingin mereka perbarui,
    // meminta masukan untuk variabel itu untuk diperbarui.
    public void updateSong()
    {
        if(playlist.getPlaylistSize() == 0)
        {
            System.out.println("\nPlaylist Kosong!");
        }
        else
        {
            viewPlaylist();
            System.out.print("\nPilihlah lagu pada playlist: ");
            int songSelection = scan.nextInt();

            System.out.print("\nApa yang ingin anda update ?\n"+"1- Artist\n"+"2- Judul\n"
                    +"3- Durasi\n"+"4- Genre\n"+"5- Rating\n"+"Pilih : ");

            int updateSelection = scan.nextInt();

            switch (updateSelection) {
                case 1:
                    System.out.print("Nama Artist: ");
                    String artist = scan.next();
                    playlist.updateArtist(songSelection, artist);
                    break;
                case 2:
                    System.out.print("Nama Judul: ");
                    String title = scan.next();
                    playlist.updateTitle(songSelection, title);
                    break;
                case 3:
                    boolean lengthFlag = false;
                    do
                    {
                        try
                        {
                            System.out.print("Durasi: ");
                            String length = scan.next();
                            playlist.updateLength(songSelection, length);
                            lengthFlag = true;
                        }
                        catch (InvalidLengthException invalidLength)
                        {
                            System.out.print(invalidLength.toString());
                            System.out.print("Masukan durasi musik \"menit:detik\".\n");
                        }
                    }while (lengthFlag == false);
                    break;
                case 4:
                    System.out.print("Genre: ");
                    String genre = scan.next();
                    playlist.updateGenre(songSelection, genre);
                    break;
                case 5:
                    boolean ratingFlag = false;
                    do
                    {
                        try
                        {
                            System.out.print("Rating (1-5): ");
                            int rating = scan.nextInt();
                            playlist.updateRating(songSelection, rating);
                            ratingFlag = true;
                        }
                        catch (InvalidRatingException invalidLength)
                        {
                            System.out.print(invalidLength.toString());
                        }
                    }while (ratingFlag == false);
                    break;
                default:
                    System.out.println("\nPilihan tidak valid !\n");
                    runMenu();
            }
        }
    }

    //Menampilkan Daftar Putar; meminta pengguna untuk memilih Lagu yang akan dihapus dan menghapusnya dari Daftar Putar.
    public void removeSong()
    {
        if(playlist.getPlaylistSize() == 0)
        {
            System.out.println("\nPlaylist Kosong!");
        }
        else
        {
            viewPlaylist();
            boolean flag = false;
            do
            {
                System.out.print("\nPilih lagu terakhir untuk dihapus : ");
                int removeSelection = scan.nextInt();

                if(removeSelection < playlist.getPlaylistSize() || removeSelection > playlist.getPlaylistSize())
                {
                    System.out.print("Tidak valid[x] Pilih index terakhir untuk menghapus !\n");    
                }
                else
                {
                    playlist.removeSong(--removeSelection);
                    flag = true;  
                }
            } while(flag == false);
        }
    }
    public void removeindex(){
        if (playlist.getPlaylistSize()==0){
            System.err.println("\nPlaylist Kosong");
        }else{
            viewPlaylist();

                System.out.print("\nPilih lagu untuk dihapus! ");
                System.err.print("Index Harus Sama[!] Pilih Index sesuai dengan data :\n"); 
                int removeSelection = scan.nextInt();   
                playlist.removeSong(removeSelection);     
        }

    }
    //Tulis konten Daftar Putar ke file bernama daftar putar.
    public void savePlaylist()
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("playlist");

            ObjectOutputStream outObjectStream = new ObjectOutputStream(fileOutputStream);

            outObjectStream.writeObject(playlist);

            outObjectStream.flush();
            outObjectStream.close();
        }
        catch(FileNotFoundException fnfException)
        {
            System.out.println("Tidak ada file");
        }
        catch(IOException ioException)
        {
            System.out.println("bad IO");
        }

    }

    //Membaca konten file yang berisi Daftar Putar.
    public void loadPlaylist()
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream("playlist");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            playlist = (Playlist)objectInputStream.readObject();

            objectInputStream.close();
        }
        catch(FileNotFoundException fnfException)
        {
            System.out.println("Tidak ada File");
        }
        catch(IOException ioException)
        {
            System.out.println("IO tidak bagus");
        }

        catch(ClassNotFoundException cnfException)
        {
            System.out.println("Playlist tidak tersedia.");
        }

    }


}

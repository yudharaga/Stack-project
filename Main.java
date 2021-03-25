package projectjava;

/**
 *
 * @author Arzan-PC
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main( String[] arg)
    {
        Menu menu = new Menu();

        menu.loadPlaylist(); 
        menu.runMenu();

    }

}


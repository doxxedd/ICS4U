/*
* Author: Daniel.D
* Date: 18-01-2021
* Description: This class is responsible for reading or writing information to a file with a specified path
*/
package GuessWho;

import java.io.*;
import java.util.*;

public class FileManager{

    //This method takes in a path (.txt file name) and scans every line in that txt file. Then returns all the data scanned in an array
    public static String[] readAllLines(String path) throws Exception {

        List<String> lines = new ArrayList<String>();

        File file = new File(path);
        Scanner fileInput = new Scanner(file);

        while(fileInput.hasNext()) {
            lines.add(fileInput.nextLine());
        }

        fileInput.close();

        return lines.toArray(new String[lines.size()]);
    }

    //This method takes in a path (.txt file name) and a string array of what to write in a text file. Writes the array of strings to that file.
    public static void writeAllLines(String path, String[] lines) throws Exception {
        PrintWriter output = new PrintWriter(path);

        for (String line : lines) {
            output.println(line);
        }
        
        output.close();
    }
}
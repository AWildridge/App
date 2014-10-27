package org.appname.data;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author AJ Wildridge
 */
public class WebPageParser {

    private static void loadPage(String page) {
        try {
            URLConnection connection = new URL(page).openConnection();
            connection.connect();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    line = line.trim();
                    FileWriter outFile = new FileWriter("./data/tests.txt");
                    PrintWriter out = new PrintWriter(outFile);
                    out.println(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

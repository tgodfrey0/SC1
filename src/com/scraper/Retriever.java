package com.scraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * The Retriever class contains the methods to retrieve the HTML from the webpage and then parse that HTML.
 */
public class Retriever {
    /**
     * The getContent method retrieves the HTML from the webpage.
     * @param username The username parameter is a string of the username of the person.
     * @return line - The line which contains the name is returned.
     */

    public String getContent(String username){
        try {
            String line;

            URL url = new URL("https://www.ecs.soton.ac.uk/people/" + username);
            System.out.println(url);

            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            while((line = bufferedReader.readLine()) != null){
                if(line.contains("property=\"name\"")){
                    return line;
                }
            }
            bufferedReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * The getName method parses the required line from the HTML and return the name of the person.
     * @param line The line parameter is a string which contains the HTML line in which the name is contained.
     * @return name - A string of the person's name is returned.
     */
    public String getName(String line){
        String[] components;
        String name = null;
        components = line.split(">");
        for(int i = 0; i < components.length; i++) {
            if (components[i].contains("property=\"name\"")) {
                name = components[i+1].split("<")[0];
                break;
            }
        }
        return name;
    }

}

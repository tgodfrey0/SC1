package com.scraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Retriever {

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

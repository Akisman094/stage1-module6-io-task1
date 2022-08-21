package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class FileReader
{

    public Profile getDataFromFile(File file)
    {
        Profile profile;

        try (InputStream inputStream = new FileInputStream(file))
        {
            //Read file and save lines
            String fileContent = new String(inputStream.readAllBytes());
            String[] lines = fileContent.split("\r\n");

            //Parse lines
            String name = lines[0].split(" ")[1];
            Integer age = Integer.parseInt(lines[1].split(" ")[1]);
            String email = lines[2].split(" ")[1];
            Long phone = Long.parseLong(lines[3].split(" ")[1]);

            //Create profile
            profile = new Profile(name, age, email, phone);
        } catch (IOException e)
        {
            profile = null;
        }

        return profile;
    }
}

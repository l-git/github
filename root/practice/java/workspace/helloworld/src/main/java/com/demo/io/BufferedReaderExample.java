package com.demo.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class BufferedReaderExample
{
    public static void main(String[] args)
    {
        BufferedReader bufferedReader = null;
 
        try
        {
 
            String currLine;
 
            bufferedReader = new BufferedReader(new FileReader("E:\\txt\\1.txt"));
 
            while ((currLine = bufferedReader.readLine()) != null)
            {
                System.out.println(currLine);
            }
 
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (bufferedReader != null)
                    bufferedReader.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
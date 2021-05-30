import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandlerXML
{
  // Writes the given string to a file with the given file name
  public static void writeToTextFile(String fileName, String str) throws FileNotFoundException
  {
    writeText(fileName, str, false);
  }

  // Appends the given string to a file with the given file name
  public static void appendToTextFile(String fileName, String str) throws FileNotFoundException
  {
    writeText(fileName, str, true);
  }

  // writeToTextFile and appendToTextFile are almost identical - only the boolean in the constructor
  // of the FileOutputStream differs. So I made this private method that both methods call
  private static void writeText(String fileName, String str, boolean append)
      throws FileNotFoundException
  {
    PrintWriter writeToFile = null;

    try
    {
      FileOutputStream fileOutStream = new FileOutputStream(fileName, append);
      writeToFile = new PrintWriter(fileOutStream);
      writeToFile.println(str);
    }
    finally
    {
      if (writeToFile != null)
      {
        writeToFile.close();
      }
    }
  }

  private static void writeText(String fileName, String[] strs, boolean append)
      throws FileNotFoundException
  {
    PrintWriter writeToFile = null;

    try
    {
      FileOutputStream fileOutStream = new FileOutputStream(fileName, append);
      writeToFile = new PrintWriter(fileOutStream);

      for (int i = 0; i < strs.length; i++)
      {
        writeToFile.println(strs[i]);
      }
    }
    finally
    {
      if (writeToFile != null)
      {
        writeToFile.close();
      }
    }
  }
}


import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Scratch
{
  private static final List<String> sitesList = new ArrayList<>();
  private static final List<String> transformedSitesList = new ArrayList<>();

  public static void main(final String[] args) throws InterruptedException
  {
    readSitesFromFile("data/originalSites.txt");
    convertListToScenarioExample(sitesList);
    createEmptyFile("data/convertedSites.txt");
    saveSitesToFile("data/convertedSites.txt");
  }

  private static void readSitesFromFile(final String filePath)
  {
    try
    {
      final FileReader reader = new FileReader(filePath);
      final BufferedReader bufferedReader = new BufferedReader(reader);
      String line;
      while ((line = bufferedReader.readLine()) != null)
      {
        sitesList.add(line.toString());
      }
      reader.close();
    }
    catch (final IOException e)
    {
      e.printStackTrace();
    }
  }

  private static void convertListToScenarioExample(final List<String> siteList)
  {
    for (final String site : sitesList)
    {
      transformedSitesList.add("| " + site + " |");
    }
  }

  private static void createEmptyFile(final String filename)
  {
    try
    {
      final File newTextFile = new File(filename);
      new FileWriter(newTextFile, false).close();
    } catch (final IOException iox)
    {
      iox.printStackTrace();
    }
  }


  private static void saveSitesToFile(final String filePath) throws InterruptedException
  {
    for (final String site : transformedSitesList)
    {
      System.out.println(site + '\n');
      try
      {
        final File newTextFile = new File(filePath);
        final FileWriter fw = new FileWriter(newTextFile, true);
        fw.write(site + '\n');
        fw.close();
      }
      catch (final IOException iox)
      {
        iox.printStackTrace();
      }
    }
  }

}
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;


class Scratch
{
  private static final List<String> dataTransferedON = new ArrayList<>();
  private static final List<String> dataTransferedOFF = new ArrayList<>();

  public static void main(final String[] args) throws InterruptedException
  {
    readSitesFromFile("target/AA_ON.txt", dataTransferedON);
    readSitesFromFile("target/AA_OFF.txt", dataTransferedOFF);
    int sum_AA_ON = getTotalSum(dataTransferedON);
    int sum_AA_OFF = getTotalSum(dataTransferedOFF);
    createReportFile("target/dataTranferedReport.txt", sum_AA_ON, sum_AA_OFF);
  }

  private static void readSitesFromFile(final String filePath, List<String> dataTransfered)
  {
    try
    {
      final FileReader reader = new FileReader(filePath);
      final BufferedReader bufferedReader = new BufferedReader(reader);
      String line;
      while ((line = bufferedReader.readLine()) != null)
      {
        dataTransfered.add(line.toString().split("DATA_RECEIVED:")[1]);
      }
      reader.close();
    }
    catch (final IOException e)
    {
      e.printStackTrace();
    }
  }

  private static int getTotalSum(List<String> dataTransfered)
  {
    int total = 0;
    for (final String dataT : dataTransfered)
    {
      try
      {
        int number = Integer.parseInt(dataT);
        total = total + number;
      }
      catch (NumberFormatException ex)
      {
        ex.printStackTrace();
      }
    }
    return total;
  }

  private static void createReportFile(final String filePath, final int sumON, final int sumOFF) throws InterruptedException
  {
    float percentGain = 100 - ((sumON * 100.0f) / sumOFF);
    String formattedString = String.format("%.02f", percentGain);
    int diference = sumON - sumOFF;
    try
    {
      final File newTextFile = new File(filePath);
      final FileWriter fw = new FileWriter(newTextFile);
      fw.write("*********** DATA TRANSFERRED WITH AA ON AND AA OFF ***********" + "\n\n\n");
      fw.write("TOTAL DATA TRANSFERRED FOR THE SAMPLED SITES WITH AA ON: " + sumON + "\n");
      fw.write("TOTAL DATA TRANSFERRED FOR THE SAMPLED SITES WITH AA OFF: " + sumOFF + "\n\n\n");
      fw.write("TOTAL DIFERENCE: " + diference + "\n");
      fw.write("PERCENTAGE GAIN: " + formattedString + "\n");
      fw.close();
    }
    catch (final IOException iox)
    {
      iox.printStackTrace();
    }
  }

}
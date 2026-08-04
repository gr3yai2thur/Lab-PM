  package pm25.io;

  import java.io.*;
  import pm25.ui.GridPanel;

  public class dataFileLoader {
      final String filePath = "C:\\Java_GUI\\src\\PM2_5\\pm2.5_69.txt";

      public void loaderFile(GridPanel gridPanel) {
          try (BufferedReader bfr = new BufferedReader(new FileReader(filePath))) {
              int i = 0;
              String line;

              while ((line = bfr.readLine()) != null) {
                  String[] msg = line.trim().split("\\s+");

                  for (int j = 0; j < gridPanel.cols; j++) {
                      gridPanel.pm25[i][j] = Integer.parseInt(msg[j]);
                  }
                  i++;
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }
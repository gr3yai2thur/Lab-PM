package pm25.io;

import java.io.*;
import java.awt.*;
import pm25.model.CityGrid;

public class dataFileLoader {

    public void loaderFile(CityGrid cityGrid) {
        try{
            FileDialog fd = new FileDialog((Frame)null, "Select PM2.5 data file (.txt)", FileDialog.LOAD);
            fd.setVisible(true);
 
            String filePath;
            if (fd.getFile() == null) {
                filePath = "C:\\\\Java_GUI\\\\src\\\\PM2_5\\\\pm2.5_69.txt";
            } else {
                filePath = fd.getDirectory() + fd.getFile();
            }

            int i = 0;
            String line;
            BufferedReader bfr = new BufferedReader(new FileReader(filePath));
            while ((line = bfr.readLine()) != null) {
                String[] msg = line.trim().split("\\s+");

                for (int j = 0; j < cityGrid.cols; j++) {
                    cityGrid.pm25[i][j] = Integer.parseInt(msg[j]);
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
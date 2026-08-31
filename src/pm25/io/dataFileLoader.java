package pm25.io;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import pm25.model.CityGrid;

public class dataFileLoader {
    public boolean loaderFile(CityGrid cityGrid) {
        try {
            FileDialog fd = new FileDialog((Frame)null, "Select PM2.5 data file (.txt)", FileDialog.LOAD);
            fd.setVisible(true);
 
            if (fd.getFile() == null) {
                return false;
            }

            String filePath = fd.getDirectory() + fd.getFile();
            cityGrid.clearLoadedData();

            int i = 0;
            int cols = 0;
            String line;
            BufferedReader bfr = new BufferedReader(new FileReader(filePath));
            while ((line = bfr.readLine()) != null) {
                String[] msg = line.trim().split("\\s+");

                if (i == 0) {
                    cols = msg.length;
                }

                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < msg.length; j++) {
                    try {
                        if(Integer.parseInt(msg[j]) >= 1 && Integer.parseInt(msg[j]) <= 250){
                            row.add(Integer.parseInt(msg[j]));
                        }
                        else{
                            row.add(-1);
                        }
                    } catch (Exception e) {
                        row.add(-1);
                    }
                }
                cityGrid.loadDataRow(row);
                i++;
            }
            bfr.close();
            int rows = i;

            cityGrid.setGridSize(rows, cols);
            
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

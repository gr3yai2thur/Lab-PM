package pm25.io;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import pm25.model.CityGrid;

public class dataFileLoader {
    public int rows;
    public int cols;
    
    public boolean loaderFile(CityGrid cityGrid) {
        try {
            FileDialog fd = new FileDialog((Frame)null, "Select PM2.5 data file (.txt)", FileDialog.LOAD);
            fd.setVisible(true);
 
            if (fd.getFile() == null) {
                return false;
            }

            String filePath = fd.getDirectory() + fd.getFile();
            cityGrid.pm25.clear();
            cityGrid.B4pm25.clear();
            cityGrid.people.clear();
            cityGrid.B4people.clear();

            int i = 0;
            String line;
            BufferedReader bfr = new BufferedReader(new FileReader(filePath));
            while ((line = bfr.readLine()) != null) {
                String[] msg = line.trim().split("\\s+");

                if (i == 0) {
                    cols = msg.length;
                }

                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < msg.length; j++) {
                    row.add(Integer.parseInt(msg[j]));
                }
                cityGrid.pm25.add(row);
                cityGrid.B4pm25.add(row);

                ArrayList<Integer> peopleRow = new ArrayList<>();
                for (int j = 0; j < msg.length; j++) {
                    peopleRow.add(0);
                }
                cityGrid.people.add(peopleRow);
                cityGrid.B4people.add(peopleRow);
                i++;
            }
            rows = i;

            cityGrid.rows = rows;
            cityGrid.cols = cols;
            
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

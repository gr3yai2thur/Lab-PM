package pm25.io;

import pm25.model.CityGrid;
import pm25.ui.GridPanel;

import java.awt.*;
import java.io.*;

public class dataFileLoader {

    File selectedFile;

    public void selectFile(CityGrid cityGrid, GridPanel gridPanel) {
        FileDialog fileDialog = new FileDialog((Frame) null, "Select file: ", FileDialog.LOAD);
        fileDialog.setVisible(true);

        String fileName = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        if (fileName != null) {
            selectedFile = new File(directory, fileName);
            readFile(selectedFile, cityGrid, gridPanel);
        } else {
            System.out.println("None select file");
            System.exit(0);
        }
    }

    void readFile(File file, CityGrid cityGrid, GridPanel gridPanel) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            for (int i = 0; ; i++) {
                String line = br.readLine();
                if (line == null) break;
                String[] msg = line.trim().split("\\s+");

                final int r = i;
                for (int j = 0; j < msg.length; j++) {
                    final int c = j;
                    cityGrid.pm25[i][j] = Integer.parseInt(msg[j]);
                    Button btn = new Button(msg[j]);
                    btn.addActionListener(e -> gridPanel.onClick(r, c));
                    gridPanel.table.add(btn);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
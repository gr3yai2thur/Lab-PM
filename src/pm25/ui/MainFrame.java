package pm25.ui;

import pm25.io.dataFileLoader;
import pm25.model.CityGrid;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    CityGrid cityGrid = new CityGrid();
    GridPanel gridPanel = new GridPanel(cityGrid);
    dataFileLoader loader = new dataFileLoader();

    public MainFrame() {
        if (loader.loaderFile(cityGrid)) {
            gridPanel.buildTable();
        }
        new ControlPanel(gridPanel, cityGrid);

        setTitle("Pseudo Rain Simulator");
        setSize(1600, 900);
        setLayout(new BorderLayout());

        gridPanel.data.setPreferredSize(new Dimension(200, 40));

        gridPanel.table.setBackground(Color.decode("#043f5a"));
        gridPanel.data.setBackground(Color.decode("#89CFEF"));

        gridPanel.table.setBorder(
            BorderFactory.createLineBorder(Color.decode("#000000"), 1)
        );

        add(gridPanel.table, BorderLayout.CENTER);
        add(gridPanel.data, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}

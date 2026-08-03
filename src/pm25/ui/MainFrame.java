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
        installComponent();
    }

    public void installComponent() {

        loader.selectFile(cityGrid, gridPanel);

        setTitle("Pseudo Rain Simulator");
        setSize(1600, 900);
        setLayout(new BorderLayout());

        gridPanel.data.setPreferredSize(new Dimension(200, 900));

        gridPanel.table.setBackground(Color.decode("#89CFEF"));
        gridPanel.data.setBackground(Color.decode("#89CFEF"));

        add(gridPanel.table, BorderLayout.CENTER);
        add(gridPanel.data, BorderLayout.WEST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
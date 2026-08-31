package pm25.ui;

import pm25.io.dataFileLoader;
import pm25.model.CityGrid;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CityGrid cityGrid = new CityGrid();
    private GridPanel gridPanel = new GridPanel(cityGrid);
    private dataFileLoader loader = new dataFileLoader();

    public MainFrame() {
        if (loader.loaderFile(cityGrid)) {
            gridPanel.buildTable();
        }
        new ControlPanel(gridPanel, cityGrid);

        setTitle("Pseudo Rain Simulator");
        setSize(1600, 900);
        setLayout(new BorderLayout());

        gridPanel.getData().setPreferredSize(new Dimension(200, 40));

        gridPanel.getTable().setBackground(Color.decode("#F8FAFC"));
        gridPanel.getData().setBackground(Color.decode("#E2E8F0"));

        gridPanel.getData().setBorder(
            BorderFactory.createLineBorder(Color.decode("#E2E8F0"), 2)
        );

        add(gridPanel.getTable(), BorderLayout.CENTER);
        add(gridPanel.getData(), BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}

package pm25.ui;

import javax.swing.*;
import java.awt.*;

import pm25.model.CityGrid;

public class GridPanel {

    CityGrid cityGrid;

    public JButton[][] buttons;
    public JPanel table = new JPanel();
    public JPanel data = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));

    public GridPanel(CityGrid cityGrid) {
        this.cityGrid = cityGrid;
    }

    public void buildTable() {
        if (table.getComponentCount() > 0) {
            table.removeAll();
        }

        buttons = new JButton[cityGrid.rows][cityGrid.cols];
        table.setLayout(new GridLayout(cityGrid.rows, cityGrid.cols));

        for (int i = 0; i < cityGrid.rows; i++) {
            for (int j = 0; j < cityGrid.cols; j++) {
                final int r = i;
                final int c = j;
                JButton btn = new JButton(String.valueOf(cityGrid.pm25.get(i).get(j)));
                buttons[i][j] = btn;

                // เอาไว้สร้าง UI button ใหม่
                // btn.setContentAreaFilled(false);
                // btn.setFocusPainted(false);
                // btn.setBorderPainted(false);
                
                btn.setMargin(new Insets(0, 0, 0, 0));
                btn.addActionListener(e -> new DetailDialog(cityGrid, r, c));
                table.add(btn);
            }
        }
        table.revalidate();
        table.repaint();
    }

    public void refreshPM25() {
        for (int i = 0; i < cityGrid.rows; i++) {
            for (int j = 0; j < cityGrid.cols; j++) {
                buttons[i][j].setText(String.valueOf(cityGrid.pm25.get(i).get(j)));
            }
        }
    }

    public void refreshPeopleColor() {
        for (int i = 0; i < cityGrid.rows; i++) {
            for (int j = 0; j < cityGrid.cols; j++) {
                buttons[i][j].setBackground(cityGrid.getPeopleColor(i, j));
                buttons[i][j].setOpaque(true);
            }
        }
        table.repaint();
    }
}

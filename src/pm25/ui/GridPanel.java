package pm25.ui;

import javax.swing.*;
import java.awt.*;

import pm25.model.CityGrid;

public class GridPanel{

    CityGrid cityGrid;

    JButton[][] buttons = new JButton[20][40];
    public JPanel table = new JPanel(new GridLayout(20, 40));
    public JPanel data = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

    public GridPanel(CityGrid cityGrid) {
        this.cityGrid = cityGrid;
    }

    public void buildTable(){
        for(int i=0; i<cityGrid.rows; i++){
            for(int j=0; j<cityGrid.cols; j++){
                final int r = i;
                final int c = j;
                JButton btn = new JButton(String.valueOf(cityGrid.pm25[i][j]));
                buttons[i][j] = btn;
                btn.setMargin(new Insets(0, 0, 0, 0));
                btn.addActionListener(e -> new DetailDialog(cityGrid, r, c));
                table.add(btn);
            }
        }
    }

    public void refreshPM25() {
      for (int i = 0; i < cityGrid.rows; i++) {
          for (int j = 0; j < cityGrid.cols; j++) {
              buttons[i][j].setText(String.valueOf(cityGrid.pm25[i][j]));
          }
      }
  }
}
package pm25.ui;

import javax.swing.*;
import pm25.model.CityGrid;
import java.awt.*;

public class GridPanel extends CityGrid{

    public JPanel table = new JPanel(new GridLayout(20, 40));
    public JPanel data = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

    public void buildTable(){
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                final int r = i;
                final int c = j;
                JButton btn = new JButton(String.valueOf(pm25[i][j]));
                btn.setMargin(new Insets(0, 0, 0, 0));
                btn.addActionListener(e -> new DetailDialog(this, r, c));
                table.add(btn);
            }
        }
    }
}
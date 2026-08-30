package pm25.ui;

import javax.swing.*;
import java.awt.*;

import pm25.model.CityGrid;

public class GridPanel {
    private CityGrid cityGrid;
    private JButton[][] buttons;
    private JButton pseudoButton;
    private JPanel table = new JPanel();
    private JPanel data = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));

    //ให้ CityGrid ที่ใส่มาเป็นตัวเดียวกับ Attribute ของ Class
    public GridPanel(CityGrid cityGrid) {
        this.cityGrid = cityGrid;
    }

    public JPanel getTable() {
        return table;
    }

    public JButton getButton(int i, int j){
        return buttons[i][j];
    }

    public JPanel getData() {
        return data;
    }

    public void setPseudoButton(JButton pseudoButton) {
        this.pseudoButton = pseudoButton;
    }

    public void resetPseudoButton() {
        pseudoButton.setText("Pseudo rain(off)");
        pseudoButton.setBackground(UIManager.getColor("Button.background"));
    }

    //สร้างตารางปุ่ม
    public void buildTable() {

        //เช็คจำนวนปุ่มบนจอตอน Reset File
        if (table.getComponentCount() > 0) {
            table.removeAll();
        }

        //เก็บปุ่มไว้ใน Array ตามจำนวนบรรทัดและแถวของไฟล์
        buttons = new JButton[cityGrid.getRows()][cityGrid.getCols()];
        table.setLayout(new GridLayout(cityGrid.getRows(), cityGrid.getCols()));

        for (int i = 0; i < cityGrid.getRows(); i++) {
            for (int j = 0; j < cityGrid.getCols(); j++) {
                final int r = i;
                final int c = j;
                JButton btn = new JButton(String.valueOf(cityGrid.getPm25(i, j)));
                buttons[i][j] = btn;

                // เอาไว้สร้าง UI button ใหม่
                // btn.setContentAreaFilled(false);
                // btn.setFocusPainted(false);
                // btn.setBorderPainted(false);
                
                //แก้ข้อมูลเป็น ...
                btn.setMargin(new Insets(0, 0, 0, 0));
                btn.addActionListener(e -> {
                    if (cityGrid.isPseudoOn()) {
                        if (cityGrid.getPeople(r, c) == 0) {
                            new PseudoAlert();
                            cityGrid.setPseudoOn(false);
                            resetPseudoButton();
                            return;
                        }

                        cityGrid.pseudoRain(r, c);
                        cityGrid.setSickPercent();
                        cityGrid.setSickPeople();
                        cityGrid.setGoodPeople();
                        cityGrid.setPseudoOn(false);
                        resetPseudoButton();
                        refreshPM25();
                        refreshColor();
                    } else {
                        new DetailDialog(cityGrid, this, r, c);
                    }
                });
                table.add(btn);
            }
        }
        table.revalidate();
        table.repaint();
    }

    //refresh ค่าฝุ่นหลังจากทำ event ต่างๆ
    public void refreshPM25() {
        for (int i = 0; i < cityGrid.getRows(); i++) {
            for (int j = 0; j < cityGrid.getCols(); j++) {
                buttons[i][j].setText(String.valueOf(cityGrid.getPm25(i, j)));
            }
        }
    }

    //refresh สีปุ่มหลังจากทำ event ต่างๆ
    public void refreshColor() {
        for (int i = 0; i < cityGrid.getRows(); i++) {
            for (int j = 0; j < cityGrid.getCols(); j++) {
                buttons[i][j].setBackground(cityGrid.getColor(i, j));
                buttons[i][j].setOpaque(true);
            }
        }
        table.repaint();
    }
}

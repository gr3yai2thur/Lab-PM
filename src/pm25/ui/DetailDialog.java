package pm25.ui;

import pm25.model.CityGrid;

import javax.swing.*;

public class DetailDialog extends JFrame {

    //ข้อมูลต่างๆหลังกดปุ่ม
    public DetailDialog(CityGrid cityGrid, int i, int j) {
        setTitle("Details");
        setSize(560, 380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //แผงรายละเอียด
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        if (cityGrid.getPeople(i, j) == 0) {
            ta.setText(String.valueOf("Please set people first."));
        } else {
            ta.setText(String.valueOf("PM2.5 Value: " + cityGrid.getPm25(i, j)) + "\n");
            ta.append(String.valueOf("People In City: " + cityGrid.getPeople(i, j) + "\n"));
            ta.append(String.valueOf("Sick Percent In City: " + cityGrid.getSickPercent(i, j)) + "\n");
            ta.append(String.valueOf("Sick People In City: " + cityGrid.getSickPeople(i, j)) + "\n");
            ta.append(String.valueOf("Good Percent In City: " + cityGrid.getGoodPeople(i, j)) + "\n");

            ta.append("\n----------Before Nature/Pseudo Rain----------\n\n");

            ta.append(String.valueOf("PM2.5 Value: " + cityGrid.getBeforePm25(i, j)) + "\n");
            ta.append(String.valueOf("People In City: " + cityGrid.getBeforePeople(i, j) + "\n"));
            ta.append(String.valueOf("Sick Percent In City: " + cityGrid.getBeforeSickPercent(i, j)) + "\n");
            ta.append(String.valueOf("Sick People In City: " + cityGrid.getBeforeSickPeople(i, j)) + "\n");
            ta.append(String.valueOf("Good Percent In City: " + cityGrid.getBeforeGoodPeople(i, j)) + "\n");
        }
        add(ta);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}

package pm25.ui;

import pm25.model.CityGrid;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

public class DetailDialog extends JFrame {

    //ข้อมูลต่างๆหลังกดปุ่ม
    public DetailDialog(CityGrid cityGrid, GridPanel gridPanel, int i, int j) {
        setTitle("Details");
        setSize(560, 380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        //แผงรายละเอียด
        JTextArea ta = new JTextArea();

        //รูปภาพ
        JLabel imageLabel = new JLabel();

        ta.setEditable(false);
        ta.setFont(new Font("Consolas", Font.BOLD, 14));

        if (cityGrid.getPeople(i, j) == 0) {
            ta.setText(String.valueOf("Please set people first."));
        } else {
            ta.setText(" -----------Before Nature/Pseudo Rain-----------\n\n");
            
            ta.append(String.valueOf(" PM2.5 Value: " + cityGrid.getBeforePm25(i, j)) + "\n");
            ta.append(String.valueOf(" People In City: " + cityGrid.getBeforePeople(i, j) + "\n"));
            ta.append(String.valueOf(" Sick Percent In City: " + cityGrid.getBeforeSickPercent(i, j)) + "\n");
            ta.append(String.valueOf(" Sick People In City: " + cityGrid.getBeforeSickPeople(i, j)) + "\n");
            ta.append(String.valueOf(" Good People In City: " + cityGrid.getBeforeGoodPeople(i, j)) + "\n");

            ta.append("\n -----------After Nature/Pseudo Rain-----------\n\n");

            ta.append(String.valueOf(" PM2.5 Value: " + cityGrid.getPm25(i, j)) + "\n");
            ta.append(String.valueOf(" People In City: " + cityGrid.getPeople(i, j) + "\n"));
            ta.append(String.valueOf(" Sick Percent In City: " + cityGrid.getSickPercent(i, j)) + "\n");
            ta.append(String.valueOf(" Sick People In City: " + cityGrid.getSickPeople(i, j)) + "\n");
            ta.append(String.valueOf(" Good People In City: " + cityGrid.getGoodPeople(i, j)) + "\n");
            

            imageLabel.setPreferredSize(new Dimension(150, 200));
            int pm25 = cityGrid.getPm25(i, j);
            String imagePath;
            if (pm25 >= 151) {
                imagePath = "src\\pm25\\image\\angry.png";
            } else if (pm25 >= 101) {
                imagePath = "src\\pm25\\image\\bad.png";
            } else if (pm25 >= 51) {
                imagePath = "src\\pm25\\image\\better.png";
            } else {
                imagePath = "src\\pm25\\image\\good.png";
            }

            Image rawImage = new ImageIcon(imagePath).getImage();
            Image scaledImage = rawImage.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
        }

        add(imageLabel, BorderLayout.WEST);
        add(ta, BorderLayout.CENTER);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}

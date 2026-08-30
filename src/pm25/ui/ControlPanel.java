package pm25.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import pm25.model.CityGrid;

public class ControlPanel {

    //แผงควยคุมด้านล่าง
    ControlPanel(GridPanel gridPanel, CityGrid cityGrid) {
        SetPeopleDialog setPeopleDialog = new SetPeopleDialog();
        NatureRainDialog natureRainDialog = new NatureRainDialog();
        LoaderFileDialog loaderFileDialog = new LoaderFileDialog();

        //ปุ่ม setPeople
        JButton setPeople = new JButton("Set People");
        setPeople.setPreferredSize(new Dimension(140, 25));

        //เพิ่ม Listener
        setPeople.addActionListener(e -> {
            setPeopleDialog.choiceDialog(cityGrid, gridPanel);
        });

        //ปุ่มฝนธรรมชาติ
        JButton nature = new JButton("Nature Rain");
        nature.setPreferredSize(new Dimension(140, 25));

        //เพิ่ม Listener
        nature.addActionListener(e -> {
            natureRainDialog.natureDialog(cityGrid, gridPanel);
        });

        //ปุ่มฝนเทียม
        JButton pseudo = new JButton("Pseudo rain(off)");
        pseudo.setPreferredSize(new Dimension(140, 25));
        gridPanel.setPseudoButton(pseudo);
        
        //เพิ่ม Listener
        pseudo.addActionListener(e -> {
            if (!cityGrid.isPseudoOn()) {
                cityGrid.setPseudoOn(true);
                pseudo.setText("Pseudo rain(on)");
                pseudo.setBackground(Color.decode("#00FF99"));
            } else {
                cityGrid.setPseudoOn(false);
                pseudo.setText("Pseudo rain(off)");
                pseudo.setBackground(UIManager.getColor("Button.background"));
            }
        });

        //ปุ่มโหลดไฟล์ทับ
        JButton load = new JButton("Loader File");
        load.setPreferredSize(new Dimension(140, 25));

        load.addActionListener(e -> {
            loaderFileDialog.loaderFile(cityGrid, gridPanel);
        });

        //เพิ่มเข้า JPanel data
        gridPanel.getData().add(setPeople);
        gridPanel.getData().add(pseudo);
        gridPanel.getData().add(nature);
        gridPanel.getData().add(load);
    }
}

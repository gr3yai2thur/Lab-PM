package pm25.ui;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.*;

import pm25.model.CityGrid;

public class SetPeopleDialog extends JFrame{
    public void choiceDialog(CityGrid cityGrid){
        JFrame choice = new JFrame();
        choice.setTitle("Start with Random?");
        choice.setSize(300, 100);
        choice.setLayout(new FlowLayout());

        JButton random = new JButton("Random");
        JButton fixed = new JButton("Fixed");

        random.addActionListener(e -> {
            choice.dispose();
            setRandomPeople(cityGrid);
        });

        fixed.addActionListener(e -> {
            choice.dispose();
            setFixedPeople(cityGrid);
        });
        choice.add(new JLabel("Do u wanna start with random People?"));
        choice.add(random);
        choice.add(fixed);


        choice.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        choice.setLocationRelativeTo(this);
        choice.setVisible(true);
    }

    public void setRandomPeople(CityGrid cityGrid){
        JFrame randomFrame = new JFrame();
        randomFrame.setTitle("Random");
        randomFrame.setSize(350, 150);
        randomFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        randomFrame.add(new JLabel("Min:"));
        JTextArea min = new JTextArea(1, 10);
        randomFrame.add(min);
        randomFrame.add(new JLabel("Max:"));
        JTextArea max = new JTextArea(1, 10);
        randomFrame.add(max);
        JButton random = new JButton("Apply");
        JLabel randomError = new JLabel();
        randomError.setForeground(Color.RED);

        random.addActionListener(e -> {
            try {
                int minValue = Integer.parseInt(min.getText().trim());
                int maxValue = Integer.parseInt(max.getText().trim());

                if (minValue < 0 || maxValue < 0 || minValue > maxValue) {
                    randomError.setText("Value no negative, and min more than max");
                    return;
                }

                cityGrid.setPeople(minValue, maxValue);
                randomFrame.dispose();
            } catch (NumberFormatException exception) {
                randomError.setText("Letter cant input, please enter a whole number");
            }
        });

        randomFrame.add(random);
        randomFrame.add(randomError);

        randomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        randomFrame.setLocationRelativeTo(this);
        randomFrame.setVisible(true);
    }

    public void setFixedPeople(CityGrid cityGrid){
        JFrame fixedFrame = new JFrame();
        fixedFrame.setTitle("Fixed");
        fixedFrame.setSize(320, 150);
        fixedFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        fixedFrame.add(new JLabel("Value:"));
        JTextArea ta = new JTextArea(1, 10);
        fixedFrame.add(ta);
        JButton fixed = new JButton("Apply");
        JLabel fixedError = new JLabel();
        fixedError.setForeground(Color.RED);

        fixed.addActionListener(e -> {
            try {
                int value = Integer.parseInt(ta.getText().trim());

                if (value < 0) {
                    fixedError.setText("Value no negative");
                    return;
                }

                cityGrid.setPeople(value);
                fixedFrame.dispose();
            } catch (NumberFormatException exception) {
                fixedError.setText("Letter cant input, please enter a whole number");
            }
        });

        fixedFrame.add(fixed);
        fixedFrame.add(fixedError);
        fixedFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fixedFrame.setLocationRelativeTo(this);
        fixedFrame.setVisible(true);
    }

    // public static void main(String[] args) {
    //     SetPeopleDialog sP = new SetPeopleDialog();
    //     sP.setFixedPeople();
    // }
}

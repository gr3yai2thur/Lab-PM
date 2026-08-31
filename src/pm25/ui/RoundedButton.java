package pm25.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.UIManager;

public class RoundedButton extends JButton {

    public RoundedButton(String text) {
        super(text);
        setBackground(UIManager.getColor("Button.background"));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setClip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 10, 10));
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g2);

        g2.setClip(null);
        g2.setColor(new Color(0xADADAD));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);

        g2.dispose();
    }
}

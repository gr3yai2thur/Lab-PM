package pm25.util;

import java.awt.*;



public class ColorUtil {
    public Color getColor(int percent){
        if(percent >= 30)       return Color.RED;
        else if(percent >= 20)  return Color.ORANGE;
        else if(percent >= 10)  return Color.YELLOW;
        else                    return Color.GREEN;
    }

    public void setColor(Button btn, int percent){
        btn.setBackground(getColor(percent));
    }
}

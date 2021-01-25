package client.Constants;

import java.awt.Color;

/**
 * Setting board and pawns colors.
 */
public enum Colors {
    BLACK(new Color(38, 38, 36)),
    WHITE(Color.WHITE),
    RED(new Color(110, 52, 4)),
    PURPLE(new Color(145, 67, 3)),
    ORANGE(new Color(255, 255, 240)),
    YELLOW(new Color(230, 230, 218));

    private Color color;

    Colors(Color color){
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public static Color getMyDefaultColor(int ID){
        if(ID==1){
            return RED.getColor();
        }
        else if(ID==2){
            return ORANGE.getColor();
        }
        return null;
    }

    public static Color getFocusedColor(int ID){
        if(ID==1){
            return PURPLE.getColor();
        }
        else if(ID==2){
            return YELLOW.getColor();
        }
        return null;
    }
}

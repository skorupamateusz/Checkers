package client.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import client.Model.Square;
import client.Constants.*;
import client.Handler.*;

public class SquarePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private Square square;
    private Border defaultBorder = BorderFactory.createEtchedBorder(WHEN_FOCUSED, Color.BLACK, Color.gray);
    private Border thickBorder = BorderFactory.createLineBorder(Colors.PURPLE.getColor(),5);
    private boolean focused;
    private MouseHandler handler;

    public SquarePanel(Square s){
        this.square = s;
        this.focused = false;
        handler = new MouseHandler();

        setListener();
    }

    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponents(g2);

        g2.setColor(Colors.BLACK.getColor());
        if(square.getIsFilled()){
            g2.fillRect(0, 0, getWidth(), getHeight());
        }

        int squarePlayerID = square.getPlayerID();
        if(isClicked()){
            g2.setColor(Colors.getFocusedColor(squarePlayerID));
            paint(g2);
        }else{
            if(squarePlayerID==1 || squarePlayerID == 2){
                if(focused){
                    g2.setColor(Colors.getFocusedColor(squarePlayerID));
                }else{
                    g2.setColor(Colors.getMyDefaultColor(squarePlayerID));
                }
                paint(g2);
            }
        }

        //Hover effect
        if(square.isPossibleToMove()){
            if(focused){
                setBorder(thickBorder);
            }else{
                setBorder(null);
            }
        }else{
            setBorder(null);
        }

        //King
        if(square.isKing() && square.getIsFilled()){
            g2.setColor(Color.BLUE);
            g2.setFont(new Font("Arial",Font.BOLD,25));
            g2.drawString("K", getWidth()/2-8, getHeight()/2+8);
        }
    }

    public void setListener(){
        if(square.isPossibleToMove() || square.getPlayerID()==SessionVariable.myID.getValue()){
            this.removeMouseListener(handler);
            this.addMouseListener(handler);
        }else{
            this.removeMouseListener(handler);
        }
    }

    public void setListener(Mouse MyListener){
        setListener();
        if(square.isPossibleToMove() || square.getPlayerID()==SessionVariable.myID.getValue()){
            this.removeMouseListener(MyListener);
            this.addMouseListener(MyListener);
        }else{
            this.removeMouseListener(MyListener);
        }
    }

    public Square getSquare(){
        return this.square;
    }

    public boolean isClicked(){
        return this.square.isSelected();
    }

    private void paint(Graphics2D g2){
        int padding= 24;
        g2.fillOval(padding/2, padding/2, getWidth()-padding, getHeight()-padding);
    }

    /**
     * Mouse Listener.
     */
    class MouseHandler extends MouseAdapter {

        public void mouseEntered(MouseEvent e){
            super.mouseEntered(e);
            focused = true;
            repaint();
        }

        public void mouseExited(MouseEvent e){
            super.mouseExited(e);
            focused = false;
            repaint();
        }

        public void mousePressed(MouseEvent e) {
        }
    }
}
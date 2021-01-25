package client.Handler;

import client.Model.Square;
import client.View.SquarePanel;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    private SquarePanel squarePanel;
    private Controller controller;

    public void setController(Controller c){
        this.controller = c;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        try{
            if(controller.isHisTurn()){
                ToggleSelectPiece(e);
            }else{
                JOptionPane.showMessageDialog(null, "Not your turn.",
                        "Error occurred.", JOptionPane.ERROR_MESSAGE, null);
            }
        }catch(Exception ex){
            System.out.println("Error occurred.");
        }
    }

    private void ToggleSelectPiece(MouseEvent e){
        try{
            squarePanel = (SquarePanel) e.getSource();
            Square s = squarePanel.getSquare();

            if(s.isSelected()){
                System.out.println("Deselect - "+s.getSquareID());
                controller.squareDeselected();
            }
            else{
                System.out.println("Select - "+s.getSquareID());
                controller.squareSelected(s);
            }
        }catch(Exception ex){
            System.out.println("Error occurred.");
        }
    }
}
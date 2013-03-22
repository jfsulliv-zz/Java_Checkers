package test;
import javax.swing.JFrame;

import userInterface.GUI.*;

public class GamePanelTest{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel panel1 = new GamePanel();
        frame.add(panel1);
        frame.setSize(925, 600);
        frame.setVisible(true);
        }
    }




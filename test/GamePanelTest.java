package test;
import javax.swing.JFrame;

import userInterface.view.*;

public class GamePanelTest{
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel panel1 = new GamePanel();
        frame.add(panel1);
        frame.setSize(925, 608);
        frame.setVisible(true);
        frame.setResizable(false);
        }
    }




package Swing;

import javax.swing.*;  
import java.awt.event.*;
 
class Main extends JFrame implements ActionListener{

    JButton load = new JButton("Load");
    JButton save = new JButton("Save");
    JButton exit = new JButton("Exit"); 
    JPanel pane = new JPanel();



    public Main (){
        super("Swing example 1"); 
        setSize(800, 600);

        pane.add(load);
        pane.add(save);
        pane.add(exit);

        add(pane);
        load.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        // String comm = e.getActionCommand();
        // System.out.println(comm);
        Object src = e.getSource();
        if (src ==  exit){
            System.out.println("Exit");
            
        }
    }

    public static void main(String[] args){
        new Main();
    }
}
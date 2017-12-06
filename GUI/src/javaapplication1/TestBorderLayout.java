package javaapplication1;
/**
  Title:           Programming Assignment #1 GUI version
  Semester:        COP3337 – Fall 2017
  @author          5793866
   Instructor:     C. Charters
  
   Due Date:      11/29/2017
    This program creates and prints different star patterns dictated by different
    * implementations of for loops Using GUI's. An outer for loop takes care of the amount 
    * of lines in the pattern to be printed as well as being directly proportional
    * to the design printed in the inner loop.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * The purpose of this class is to create graphical user interface to display 
 * three different patterns of stars formation with for loops. Every patter will
 * have its own button for the user to click on and display it!
 * @author cadelmonterde
 */
public class TestBorderLayout {

    JPanel star = new JPanel();
    JFrame frame = new JFrame("Stars And Stuff");
    JTextArea text = new JTextArea();
    
    /**
     * The main class is responsible for calling the method that creates the 
     * graphical user interface.
     * @param args 
     */
    public static void main(String[] args) {
        new TestBorderLayout();
    }

    /**
     * The TestBorderLayout method takes care of building the GUI as well as it's
     * functionality. It also calls some of our public methods that determine/execute
     * the functionality of our buttons.
     */
    public TestBorderLayout() {
        /**
         * The invokeLater method creates a new thread just for the GUI so that 
         * the Interface stays responsive while we take care of calculations on a
         * different thread outside of the Event dispatching thread. All button 
         * declarations, panels and frame building happen in this method.
         */
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              
                JButton pattern1 = new JButton("Pattern 1");
                pattern1.setFont(new Font("Arial", Font.TRUETYPE_FONT, 16));
                pattern1.setBackground(new Color(96,109,109));
                pattern1.setOpaque(true);
                pattern1.setBorderPainted(false);
                JButton pattern2 = new JButton("Pattern 2");
                pattern2.setFont(new Font("Arial", Font.TRUETYPE_FONT, 16));
                pattern2.setBackground(new Color(96,109,109));
                pattern2.setOpaque(true);
                pattern2.setBorderPainted(false);
                JButton pattern3 = new JButton("Pattern 3");
                pattern3.setFont(new Font("Arial", Font.TRUETYPE_FONT, 16));
                pattern3.setBackground(new Color(96,109,109));
                pattern3.setOpaque(true);
                pattern3.setBorderPainted(false);
                JPanel buttonPane = new JPanel();
                buttonPane.setOpaque(false);
                text.setForeground(Color.yellow);
                text.setFont(new Font("Serif", Font.PLAIN, 24));
                text.setOpaque(false);
                
                buttonPane.add(pattern1);
                buttonPane.add(pattern2);
                buttonPane.add(pattern3);
                star.setOpaque(false);
                starPattern1(pattern1);
                starPattern2(pattern2);
                starPattern3(pattern3);
                
                try {
                    frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("stars.jpg")))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(star,BorderLayout.NORTH);
                frame.add(buttonPane, BorderLayout.SOUTH);
                frame.pack();
                frame.setResizable(false);
                frame.setSize(350, 300);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
            }
        });
    }
    /**
     * The starPattern1 method, Prints a Right Triangle stars, It does this with
     * two for-loops it builds a string with stars on the inner loop and a line on
     * the other loop once the outer-loop is done we add the string we built to 
     * our JtextArea and add that component to our JPanel.
     * @param pattern1 
     */
    public void starPattern1(JButton pattern1)
    {
        pattern1.addActionListener((ActionEvent event) -> {
            //                JTextArea text = new JTextArea();
            String build = "";
            for (int i = 0; i <= 5; i++) {
                for (int j = 0; j < i; j++) {
                    build += "*";
                    
                }
                build += "\n";
                
            }
            text.setText(build);
            star.add(text);
            SwingUtilities.updateComponentTreeUI(frame);
//                pattern1.setEnabled(false);
        });

    }
    
    /**
     * The starPattern1 method, Prints a Left Triangle of stars, It does this with
     * three for-loops it builds a string with spaces on the first inner loop 
     * and stars on the second inner-loop and finally a new line on
     * the other loop once the outer-loop is done we add the string we built to 
     * our JtextArea and add that component to our JPanel.
     * @param pattern2 
     */
    public void starPattern2(JButton pattern2)
    {
        pattern2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
//                JTextArea text = new JTextArea();
                String build = "";
                for (int i = 0; i < 5; i++) {
                    for (int k = 0; k < i; k++) {
                        build += "";
                    }
                    for (int j = 5; j > i; j--) {
                        build += "*";
                    }

                    build += "\n";
                }
                text.setText(build);
                star.add(text);
                SwingUtilities.updateComponentTreeUI(frame);
//                pattern2.setEnabled(false);
            }
        });
    }
    
    /**
     * The starPattern1 method, Prints a pyramid Triangle of stars, It does this with
     * three for-loops it builds a string with two spaces on the first inner loop 
     * and stars on the second inner-loop and finally a new line on
     * the other loop once the outer-loop is done we add the string we built to 
     * our JtextArea and add that component to our JPanel.
     * @param pattern3 
     */
    public void starPattern3(JButton pattern3)
    {
        pattern3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
//                JTextArea text = new JTextArea();
                String build = "";
                for (int i = 0; i < 8; i++) {
                    for (int k = 8; k > i + 1; k--) {

                        build += "  ";
                    }

                    for (int j = 1; j <= 2 * i - 1; j++) {
                        build += "*";
                    }
                    build += "\n";
                }
                text.setText(build);
                star.add(text);
                SwingUtilities.updateComponentTreeUI(frame);
//                pattern3.setEnabled(false);
            }
        });

    }

}
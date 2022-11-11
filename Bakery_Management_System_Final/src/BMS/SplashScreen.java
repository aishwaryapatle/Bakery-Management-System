package BMS;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class SplashScreen extends JWindow{

	static boolean isRegistered;
    private static JProgressBar progressBar = new JProgressBar();
    private static SplashScreen execute;
    private static int count;
    private static JLabel msg;
    private static javax.swing.Timer timer1;

    public SplashScreen() {

        Container container = getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        
        JLabel image = new JLabel(new ImageIcon("D:/Project/Images/Bakery1.png"));
        image.setSize(662, 471);
        container.add(image);
        
//        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(19, 19, 662, 471);
        panel.setLayout(null);
        container.add(panel);
        

        msg = new JLabel();
        msg.setFont(new Font("Times New Roman", Font.BOLD, 14));
        msg.setForeground(Color.BLACK);
        msg.setBounds(60, 490, 280, 30);
        container.add(msg);

        progressBar.setMaximum(50);
        progressBar.setBounds(60, 520, 580, 15);
        container.add(progressBar);
        loadProgressBar();
        
        
        setSize(700, 550);
        setBackground(new Color(255, 255, 255));
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    private void loadProgressBar() {
        ActionListener al = new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;

                progressBar.setValue(count);

                System.out.println(count);
                msg.setText("LOADING..."+Integer.toString(count)+"%");

                if (count == 100) {

                    setVisible(false);
                    dispose();
                    Login_Page_Frame.Login_Page_Frame_Code();
                    timer1.stop();
                }
                
            }
            

//            private void createFrame() throws HeadlessException {
//                JFrame frame = new JFrame();
//                frame.setSize(500, 500);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setVisible(true);
//            }
        };
        
        timer1 = new javax.swing.Timer(50, al);
        timer1.start();
        
    }
}

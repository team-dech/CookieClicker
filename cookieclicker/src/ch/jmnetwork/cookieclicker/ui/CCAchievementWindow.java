package ch.jmnetwork.cookieclicker.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CCAchievementWindow
{
    // ======================================//
    // VARIABLES
    // ======================================//
    
    JFrame ccui;
    Point mouseDownPoint;
    JFrame jframe = new JFrame();
    JLabel achievementName = new JLabel();
    JLabel achievementDescription = new JLabel();
    JButton exitButton = new JButton();
    
    public CCAchievementWindow(String achievementname, String achievementdescription)
    {
        achievementName.setText(achievementname);
        achievementDescription.setText(achievementdescription);
        this.ccui = CCUserInterface.jframe;
        init();
        jframe.setVisible(true);
    }
    
    private void init()
    {
        // ======================================//
        // SETTNGS
        // ======================================//
        
        jframe.setSize(500, 200);
        jframe.setTitle("Achievement received!");
        jframe.setLocation((int) ccui.getLocationOnScreen().getX() + 250, (int) ccui.getLocationOnScreen().getY() - 210);
        jframe.setUndecorated(true);
        jframe.setLayout(null);
        jframe.setOpacity(0.8F);
        jframe.setIconImage(CCUserInterface.cookie);
        addJFrameMouseListener();
        
        achievementName.setBounds(20, 20, 480, 50);
        achievementName.setForeground(Color.red);
        achievementName.setFont(new Font("Arial", Font.BOLD, 24));
        achievementName.setText("<html><strong>" + achievementName.getText() + "</strong></html>");
        achievementDescription.setBounds(20, 60, 480, 20);
        
        exitButton.setText("OK");
        exitButton.setBounds(440, 170, 50, 20);
        exitButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                System.out.println("closing achievement window");
                jframe.setVisible(false);
            }
        });
        
        // ======================================//
        // ADD TO THE PANE
        // ======================================//
        
        jframe.getContentPane().add(exitButton);
        jframe.getContentPane().add(achievementName);
        jframe.getContentPane().add(achievementDescription);
        
    }
    
    private void addJFrameMouseListener()
    {
        jframe.addMouseListener(new MouseListener()
        {
            
            @Override
            public void mouseReleased(MouseEvent arg0)
            {
                mouseDownPoint = null;
            }
            
            @Override
            public void mousePressed(MouseEvent arg0)
            {
                mouseDownPoint = arg0.getPoint();
            }
            
            @Override
            public void mouseExited(MouseEvent arg0)
            {
            }
            
            @Override
            public void mouseEntered(MouseEvent arg0)
            {
            }
            
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
            }
        });
        
        jframe.addMouseMotionListener(new MouseMotionListener()
        {
            
            @Override
            public void mouseMoved(MouseEvent e)
            {
            }
            
            @Override
            public void mouseDragged(MouseEvent e)
            {
                Point currentCoords = e.getLocationOnScreen();
                jframe.setLocation(currentCoords.x - mouseDownPoint.x, currentCoords.y - mouseDownPoint.y);
            }
        });
    }
}

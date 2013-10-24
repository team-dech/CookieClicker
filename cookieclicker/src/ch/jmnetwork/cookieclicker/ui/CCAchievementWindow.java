package ch.jmnetwork.cookieclicker.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.IllegalComponentStateException;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
        achievementName.setHorizontalAlignment(SwingConstants.CENTER);
        achievementName.setText(achievementname);
        achievementDescription.setText(achievementdescription);
        this.ccui = CCUserInterface.jframe;
        init();
        jframe.setOpacity(0F);
        jframe.setVisible(true);
        
        new Thread(new VisibilityThread(jframe)).start();
    }
    
    private void init()
    {
        // ======================================//
        // SETTNGS
        // ======================================//
        
        jframe.setSize(500, 200);
        jframe.setTitle("Achievement aquired!");
        try
        {
            jframe.setLocation((int) ccui.getLocationOnScreen().getX() + 250, (int) ccui.getLocationOnScreen().getY() - 210);
        }
        catch (IllegalComponentStateException e)
        {
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            jframe.setLocation(d.width - 550, d.height - 250);
        }
        
        jframe.setUndecorated(true);
        jframe.getContentPane().setLayout(null);
        jframe.setOpacity(1.0F);
        jframe.setIconImage(CCUserInterface.cookie);
        try
        {
            jframe.setContentPane(new ImagePanel(ImageIO.read(new File("AchievementBackground.png"))));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        addJFrameMouseListener();
        
        achievementName.setBounds(20, 5, 480, 50);
        achievementName.setForeground(Color.red);
        achievementName.setFont(new Font("Arial", Font.BOLD, 24));
        achievementName.setText("<html><strong>" + achievementName.getText() + "</strong></html>");
        achievementDescription.setBounds(20, 60, 480, 20);
        
        exitButton.setText("");
        exitButton.setBounds(420, 160, 70, 30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setFocusPainted(false);
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
    
    class VisibilityThread implements Runnable
    {
        JFrame jf;
        
        public VisibilityThread(JFrame JFrame)
        {
            jf = JFrame;
        }
        
        @Override
        public void run()
        {
            for (float i = 0F; i <= 1.0F; i += 0.05F)
            {
                jf.setOpacity(i);
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            
        }
        
    }
}

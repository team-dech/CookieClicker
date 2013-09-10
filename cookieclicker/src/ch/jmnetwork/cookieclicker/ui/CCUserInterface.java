package ch.jmnetwork.cookieclicker.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import ch.jmnetwork.cookieclicker.CookieManager;

public class CCUserInterface
{
    // ======================================//
    // VARIABLES
    // ======================================//
    
    private static CookieManager cookiemanager;
    
    private static JFrame jframe;
    private static JButton cookie_button;
    private static JLabel randomJlabel;
    
    public CCUserInterface(CookieManager cookieManager)
    {
        cookiemanager = cookieManager;
        
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    init();
                    jframe.setVisible(true);
                }
                catch (Exception e)
                {
                }
            }
        });
    }
    
    private void init()
    {
        // ======================================//
        // TRY TO SET SYSTEM LOOK AND FEEL
        // ======================================//
        
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            System.out.println("FAIL: Unable to set system look'n'feel");
        }
        
        // ======================================//
        // DEFINE ALL VARIABLES
        // ======================================//
        
        jframe = new JFrame();
        cookie_button = new JButton();
        randomJlabel = new JLabel();
        
        // ======================================//
        // COMPONENT SETTINGS
        // ======================================//
        
        jframe.setTitle("Java Cookie Clicker by TH3ON1YN00B and domi1819");
        jframe.setSize(700, (20 + 265 + 60));
        jframe.getContentPane().setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        
        cookie_button.setBounds(20, 20, 265, 265);
        cookie_button.setIcon(new ImageIcon("cookie.png", "This is a cookie"));
        cookie_button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                cookiemanager.addCookies(1);
                updateUI();
            }
        });
        
        randomJlabel.setText("0");
        randomJlabel.setFont(Font.getFont("Arial"));
        randomJlabel.setBounds(300, 20, 300, 50);
        
        // ======================================//
        // ADD COMPONENTS TO THE PANE
        // ======================================//
        
        jframe.getContentPane().add(cookie_button);
        jframe.getContentPane().add(randomJlabel);
    }
    
    public void updateUI()
    {
        // ======================================//
        // UPDATE THE UI CONTENT
        // ======================================//
        
        if (randomJlabel != null)
        {
            randomJlabel.setText(cookiemanager.getCurrentCookies() + "");
        }
        
    }
}

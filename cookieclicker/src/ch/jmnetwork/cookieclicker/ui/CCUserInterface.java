package ch.jmnetwork.cookieclicker.ui;

import ch.jmnetwork.cookieclicker.CookieClickerMain;
import ch.jmnetwork.cookieclicker.CookieManager;
import ch.jmnetwork.cookieclicker.helper.EnumHelper;
import ch.jmnetwork.cookieclicker.helper.Helper;
import ch.jmnetwork.cookieclicker.helper.HelperClicker;
import ch.jmnetwork.cookieclicker.lib.Reference;
import ch.jmnetwork.cookieclicker.util.CryptedSLHandler;
import ch.jmnetwork.cookieclicker.util.NumberHelper;
import ch.jmnetwork.cookieclicker.util.SaveLoadHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class CCUserInterface {
    // ======================================//
    // VARIABLES
    // ======================================//

    private boolean run = false;
    private NumberHelper nh = new NumberHelper();

    private static CookieManager cookiemanager;
    private CryptedSLHandler cslhandler;

    private final static String FONT = "Arial";
    public final static Image cookie = Toolkit.getDefaultToolkit().getImage("cookie.png");
    private final static Image cookie_small = Toolkit.getDefaultToolkit().getImage("cookie_small.png");
    private final static ImageIcon cookieImageIcon = new ImageIcon(cookie);
    private final static ImageIcon cookie_smallImageIcon = new ImageIcon(cookie_small);
    private static String currentInfoMessage = "";

    public static JFrame jframe;
    private static JPanel contentPane;
    private static JLabel infoLabel;
    private static JButton cookie_button;
    private static JLabel currentCookiesLabel;
    private static JLabel cookieRateLabel;
    private static JLabel cookiesHandmade;
    private static JLabel cookiesHandmadePerSec;
    private static JButton pointerBuyButton;
    private static JButton grandmaBuyButton;
    private static JLabel totalCookies;
    private static HashMap<EnumHelper, JButton> buttonMap = new HashMap<>();

    public CCUserInterface(CookieManager cookieManager, SaveLoadHandler slhandler, CryptedSLHandler cslhandler) {
        cookiemanager = cookieManager;
        this.cslhandler = cslhandler;

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    init();
                    jframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void init() {
        // ======================================//
        // TRY TO SET SYSTEM LOOK AND FEEL
        // ======================================//

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("FAIL: Unable to set system look'n'feel");
        }

        // ======================================//
        // DEFINE ALL VARIABLES
        // ======================================//

        jframe = new JFrame();
        contentPane = new JPanel();
        infoLabel = new JLabel();
        cookie_button = new JButton();
        currentCookiesLabel = new JLabel();
        cookieRateLabel = new JLabel();
        cookiesHandmade = new JLabel();
        cookiesHandmadePerSec = new JLabel();
        pointerBuyButton = new JButton();
        grandmaBuyButton = new JButton();
        totalCookies = new JLabel();

        // ======================================//
        // COMPONENT SETTINGS
        // ======================================//

        jframe.setTitle("Java Cookie Clicker by TH3ON1YN00B and domi1819 - Version " + Reference.VERSION);
        jframe.setSize(1000, (265 + 80));
        jframe.setContentPane(contentPane);
        jframe.getContentPane().setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.setIconImage(cookie);
        if (new File("BackgroundNew.png").exists()) {
            try {
                jframe.setContentPane(new ImagePanel(ImageIO.read(new File("BackgroundNew.png"))));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cslhandler.save();
                System.exit(0);
            }
        });

        contentPane.getInputMap().put(KeyStroke.getKeyStroke("typed x"), "cheatUI");
        contentPane.getActionMap().put("cheatUI", new CheatAction());

        infoLabel.setText("");
        infoLabel.setFont(Font.getFont(FONT));
        infoLabel.setBounds(40 + 265, 270, 300, 50);
        infoLabel.setForeground(Color.RED);

        cookie_button.setBounds(20, 20, 265, 265);
        cookie_button.setBorder(BorderFactory.createEmptyBorder());
        cookie_button.setContentAreaFilled(false);
        cookie_button.setFocusPainted(false);
        cookie_button.setIcon(new ImageIcon("cookie.png", "This is a cookie"));
        cookie_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cookiemanager.addHandmadeCookies(HelperClicker.cookiesPerClick());
                updateUI();

                cslhandler.save();
            }
        });
        cookie_button.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent arg0) {
                if (arg0.getButton() == MouseEvent.BUTTON1) cookie_button.setIcon(cookieImageIcon);
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                if (arg0.getButton() == MouseEvent.BUTTON1) cookie_button.setIcon(cookie_smallImageIcon);
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }

            public void mouseEntered(MouseEvent arg0) {
            }

            public void mouseClicked(MouseEvent arg0) {
            }
        });

        currentCookiesLabel.setText("0");
        currentCookiesLabel.setFont(Font.getFont(FONT));
        currentCookiesLabel.setBounds(300, 20, 300, 50);

        cookieRateLabel.setText("");
        cookieRateLabel.setFont(Font.getFont(FONT));
        cookieRateLabel.setBounds(300, 30, 300, 50);

        cookiesHandmade.setText("HANDMADE_HERE");
        cookiesHandmade.setFont(Font.getFont(FONT));
        cookiesHandmade.setBounds(300, 40, 300, 50);

        cookiesHandmadePerSec.setText("CPS_H");
        cookiesHandmadePerSec.setFont(Font.getFont(FONT));
        cookiesHandmadePerSec.setBounds(300, 50, 300, 50);

        // ======================================//
        // ALL HELPERS
        // ======================================//

        int _cnt = 0;
        for (EnumHelper helper : EnumHelper.values()) {
            JButton btn = new JButton();
            btn.setText(helper.name());
            btn.setBounds(600, _cnt * 22 + 20, 350, 20);
            btn.setEnabled(false);
            btn.setToolTipText(""); //TODO tooltip for helpers
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO buy handling
                }
            });
            jframe.getContentPane().add(btn);
            _cnt++;
        }

//        pointerBuyButton.setText("POINTERS_HERE");
//        pointerBuyButton.setFont(Font.getFont(FONT));
//        pointerBuyButton.setBounds(600, 20, 350, 20);
//        pointerBuyButton.setEnabled(false);
//        pointerBuyButton.setToolTipText(Helper.helpers[0].productivity + " Cookies / s");
//        pointerBuyButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                if (cookiemanager.buyPrice(Helper.getPriceForHelper(0))) {
//                    Helper.helpers[0].onBought();
//                }
//            }
//        });


        totalCookies.setText("TOTAL_HERE");
        totalCookies.setFont(Font.getFont(FONT));
        totalCookies.setBounds(300, 70, 300, 40);

        // ======================================//
        // ADD COMPONENTS TO THE PANE
        // ======================================//

        jframe.getContentPane().add(cookie_button);
        jframe.getContentPane().add(currentCookiesLabel);
        jframe.getContentPane().add(cookieRateLabel);
        jframe.getContentPane().add(cookiesHandmade);
        jframe.getContentPane().add(cookiesHandmadePerSec);
        jframe.getContentPane().add(pointerBuyButton);
        jframe.getContentPane().add(grandmaBuyButton);
        jframe.getContentPane().add(infoLabel);
        jframe.getContentPane().add(totalCookies);
    }

    public void updateUI() {
        // ======================================//
        // UPDATE THE UI CONTENT
        // ======================================//

        if (run || (totalCookies != null && cookiesHandmadePerSec != null && currentCookiesLabel != null && cookieRateLabel != null && pointerBuyButton != null && grandmaBuyButton != null && cookiesHandmade != null)) {
            run = true;

            // ======================================//
            // SET BUTTON / LABEL TEXTS
            // ======================================//

            currentCookiesLabel.setText("Current Cookies: " + nh.addApostropheToNumber(cookiemanager.getCurrentCookies()));
            cookieRateLabel.setText("Current Cookie Rate: " + onlyOneAfterComma(Helper.getCookieRate()));
            cookiesHandmade.setText("Handmade Cookies: " + nh.addApostropheToNumber(cookiemanager.getHandmadeCookies()));
            cookiesHandmadePerSec.setText("Handmade Cookies / s: " + CookieClickerMain.handmadePerSec);
            pointerBuyButton.setText(Helper.owned[0] + " Pointers | Buy for " + nh.addApostropheToNumber(Helper.getPriceForHelper(0)));
            totalCookies.setText("All-Time Cookies: " + nh.addApostropheToNumber(cookiemanager.getTotalCookies()));

            // ======================================//
            // ENABLE / DISABLE BUTTONS
            // ======================================//
            
            /* POINTERS */
            pointerBuyButton.setEnabled(cookiemanager.getCurrentCookies() >= Helper.getPriceForHelper(0));
        }
    }

    public void setInfoMessage(String message) {
        infoLabel.setText("<html><strong>" + message + "</strong></html>");
        currentInfoMessage = message;
    }

    public String getInfoMessage() {
        return currentInfoMessage;
    }

    private float onlyOneAfterComma(float input) {
        return (float) (Math.floor(input * 10F) / 10F);
    }

    private class CheatAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ACTIN");
            CheatAddCookiesDialog dialog = new CheatAddCookiesDialog(cookiemanager);
            dialog.pack();
            dialog.setVisible(true);
        }
    }
}

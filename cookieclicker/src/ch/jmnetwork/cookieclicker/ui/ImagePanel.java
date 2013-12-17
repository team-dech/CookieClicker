package ch.jmnetwork.cookieclicker.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

public class ImagePanel extends JComponent
{
    
    private static final long serialVersionUID = -761984349598852211L;
    private Image image;
    
    public ImagePanel(Image image)
    {
        this.image = image;
    }
    
    @Override
    protected void paintComponent(Graphics arg0)
    {
        arg0.drawImage(image, 0, 0, null);
    }
    
}

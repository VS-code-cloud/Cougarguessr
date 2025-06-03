import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel {
    private Image image;

    /*public void setImage(String imagePath) {
        image = new ImageIcon(imagePath).getImage();
        repaint();
    }*/
    public ImagePanel()
    {
        this.setBackground(Color.ORANGE);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}

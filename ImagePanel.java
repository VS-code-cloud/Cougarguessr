import java.awt.*;
import java.io.File;
import javax.swing.*;

public class ImagePanel extends JPanel {
    private Image image;

    public void setImage(String imagePath) {
    File file = new File(imagePath);
    if (!file.exists()) {
        System.out.println("Image not found: " + file.getAbsolutePath());
    } else {
        System.out.println("Loaded image: " + file.getAbsolutePath());
    }

    image = new ImageIcon(imagePath).getImage();
    repaint();
}

    public ImagePanel()
    {
       this.setBackground(Color.ORANGE);
    }
   @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (image != null) {
        g.setColor(Color.BLACK);
        g.drawString("Drawing image...", 10, 20); 
        g.drawImage(image, 0, 0, 600, 400, this); 
    } else {
        g.setColor(Color.RED);
        g.drawString("Image is null", 10, 20);
    }
}

}

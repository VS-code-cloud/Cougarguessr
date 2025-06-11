import java.awt.*;
import javax.swing.JPanel;      

public class SchoolMapPanel extends JPanel
{
    int floor = 0;
    Image finalImg;
    public SchoolMapPanel(int f)
    {
        this.setBackground(Color.GREEN);
        floor=f;
        Image img = (f==0 ? Toolkit.getDefaultToolkit().createImage("cougarguessr-photo/MontyFloorOne.png") : Toolkit.getDefaultToolkit().createImage("cougarguessr-photo/MontyFloorTwo.png"));
        finalImg = img.getScaledInstance(540, 720, Image.SCALE_DEFAULT);

    }
    public void paintComponent(Graphics g)
    {
    // Draw the previously loaded image to Component.
        g.drawImage(finalImg, 0, 0, this);
    }
}

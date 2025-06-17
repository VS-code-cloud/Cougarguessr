import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
public class SchoolMapPanel extends JPanel
{
    int floor = 0;
    Image finalImg;
    RoundManager roundManager;
    public SchoolMapPanel(int f, RoundManager r)
    {
        this.setBackground(Color.GREEN);
        floor=f;
        Image img = (f==0 ? Toolkit.getDefaultToolkit().createImage("cougarguessr-photo/MontyFloorOne.png") : Toolkit.getDefaultToolkit().createImage("cougarguessr-photo/MontyFloorTwo.png"));
        finalImg = img.getScaledInstance(540, 720, Image.SCALE_DEFAULT);
        roundManager=r;
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                roundManager.updateWithGuess(x, y, floor);
            }
        });
    }
    public void paintComponent(Graphics g)
    {
    // Draw the previously loaded image to Component.
        g.drawImage(finalImg, 0, 0, this);
    }
}

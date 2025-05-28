import java.awt.BorderLayout;
import javax.swing.JFrame;

public class GameController{

    public GameController()
    {

    }

    public void startGame()
    {
        JFrame frame = new JFrame();

        frame.setSize(1600, 1000);
        frame.setTitle("CougarGuessr");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

        ImagePanel ip = new ImagePanel();
        frame.setLayout(new BorderLayout());
        frame.add(ip, BorderLayout.NORTH);
        
    }
}
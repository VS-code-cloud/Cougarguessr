import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class GameController{

    public GameController()
    {

    }

    public void startGame()
    {
        JFrame frame = new JFrame();
        JPanel startScreen = new JPanel();
        frame.setSize(1600, 1000);
        frame.setTitle("CougarGuessr");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(null);
        
        ImagePanel ip = new ImagePanel();
        SchoolMapPanel mp = new SchoolMapPanel(this);
        
        ip.setBounds(0, 0, 1600, 200);
        mp.setBounds(0, 200, 1600, 800);
        
        startScreen.setBounds(0, 0, 1600, 1000);
        startScreen.setLayout(null);

        
        //frame.setLayout(new BorderLayout());
        JButton startButton = new JButton("<html>Start<br/>Game</html>");
        startButton.setFont(new Font("Arial", Font.PLAIN, 40));
        startButton.setBounds(400, 300, 400, 200);
        startButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game started");
                frame.remove(startScreen);
                frame.add(ip);
                frame.add(mp);
                frame.revalidate(); 
                frame.repaint();    
            }
        });
        startScreen.add(startButton);
        frame.setLayout(null);
        frame.add(startScreen);
        frame.setVisible(true);
        
    }
    
    public void handleGuess(int x, int y, String floor) {
        System.out.println("Guess received: (" + x + ", " + y + ") on floor: " + floor);
        // TODO: Compare with correct LocationPoint, score it, etc.
    }

}

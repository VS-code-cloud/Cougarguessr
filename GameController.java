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
        
        frame.setVisible(true);
        
        ImagePanel ip = new ImagePanel();
        SchoolMapPanel mp = new SchoolMapPanel();
        
        //frame.setLayout(new BorderLayout());
        JButton startButton = new JButton("<html>Start<br/>Game</html>");
        startButton.setFont(new Font("Arial", Font.PLAIN, 40));
        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game started");
                startScreen.setVisible(false);
                frame.add(ip/*, BorderLayout.NORTH*/);
                frame.add(mp/*, BorderLayout.CENTER*/);
            }
        });
        startScreen.add(startButton);
        frame.add(startScreen);
    }
}
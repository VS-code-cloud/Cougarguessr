import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class GameController{

private JFrame frame;
private JPanel startScreen;
private ImagePanel ip;
private SchoolMapPanel mp;
private RoundManager roundManager;


    public GameController()
    {

    }

    public void startGame() {
    JFrame frame = new JFrame();  
    JPanel startScreen = new JPanel();
    frame.setSize(1600, 1000);
    frame.setTitle("CougarGuessr");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);

   
    ImagePanel ip = new ImagePanel();
    SchoolMapPanel mp = new SchoolMapPanel(); 
    roundManager = new RoundManager();
    
   
    startScreen.setLayout(null);
    startScreen.setBounds(0, 0, 1600, 1000);

    JButton startButton = new JButton("<html>Start<br/>Game</html>");
    startButton.setFont(new Font("Arial", Font.PLAIN, 40));
    startButton.setBounds(600, 400, 400, 200);  
    startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Game started");
            frame.remove(startScreen);
            //ip bounds in 4:3 ratio
            ip.setBounds(50, 250, 600, 450);
            mp.setBounds(500, 500, 1550, 800);
            frame.add(ip);
            frame.add(mp);
            startNewRound();  
            frame.revalidate();
            frame.repaint();
        }
    });

    startScreen.add(startButton);
    frame.add(startScreen);
    frame.setVisible(true);
}

public void startNewRound() {
    if (roundManager.hasNextRound()) {
        LocationPoint lp = roundManager.getNextRound();
       // ip.setImage(lp.getImagePath());
    } else {
        System.out.println("Game over!");
    }
}


}
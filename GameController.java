import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameController {

    private JFrame frame;
    private JPanel startScreen;
    private ImagePanel ip;
    private SchoolMapPanel mp0;
    private SchoolMapPanel mp1;
    private RoundManager roundManager;

    public void startGame() {
        frame = new JFrame();
        startScreen = new JPanel();

        frame.setSize(1900, 1075);
        frame.setTitle("CougarGuessr");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        ip = new ImagePanel();
        SchoolMapPanel mp0 = new SchoolMapPanel(0);
        SchoolMapPanel mp1 = new SchoolMapPanel(1);
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
                JTextArea topText = new JTextArea("CougarGuessr - Click the maps on the right to guess where you are!", 100, 100);
                ip.setBounds(0, 500, 600, 400);
                mp0.setBounds(710, 100, 540, 720);
                mp1.setBounds(1350, 100, 540, 720);
                
                frame.add(ip);
                frame.add(mp0);
                frame.add(mp1);
                frame.add(topText);
                
                ip.setImage("cougarguessr-photo/i1.jpeg");

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
            ip.setImage(lp.getImagePath());
        } else {
            System.out.println("Game over!");
        }
    }
}


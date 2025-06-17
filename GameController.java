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
    Timer timer;
    boolean ending = false;
    private RoundManager roundManager;
    JTextArea topText = new JTextArea(
        """
        CougarGuessr - Click the maps on the right to guess where you are!
        Round: 
        Score: 
        Time remaining: 30 seconds                          
        """,
        100, 
        100
    );
                
    public void startGame() {
        frame = new JFrame();
        startScreen = new JPanel();

        frame.setSize(1900, 1075);
        frame.setTitle("CougarGuessr");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        ip = new ImagePanel();
        roundManager = new RoundManager(this);
        SchoolMapPanel mp0 = new SchoolMapPanel(0, roundManager);
        SchoolMapPanel mp1 = new SchoolMapPanel(1, roundManager);

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
                ip.setBounds(0, 500, 600, 400);
                mp0.setBounds(650, 100, 540, 720);
                mp1.setBounds(1250, 100, 540, 720);
                topText.setEditable(false);
                topText.setBounds(50, 50, 500, 200);
                frame.add(ip);
                frame.add(mp0);
                frame.add(mp1);
                frame.add(topText);
                ip.setImage("cougarguessr-photo/i1.jpeg");
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
        if (roundManager.getRound()<=5) {
            LocationPoint lp = roundManager.getNextRound();
            ip.setImage(lp.getImagePath());
            if (this.timer!=null) {
                timer.stop();
            }
            startTimer(topText);
        } else {
            System.out.println("Game over!");
        }
    }
    public void endGame() {
        ending=true;
    }
    public void startTimer(JTextArea topText) {
        timer = new Timer(1000, new ActionListener() {
            int count = 31;

            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count<=0) {
                    timer.stop();
                }
                topText.setText("""
                    CougarGuessr - Click the maps on the right to guess where you are!
                    Round:"""+" "+roundManager.getRound()+"""
                    
                    Score:"""+" "+roundManager.getScore()+"""
                    
                    Time remaining:"""+" "+count+" "+"""
                    seconds                          
                    """);
                if (ending) {
                    timer.stop();
                }
            }
        });
        timer.start();
    }
}


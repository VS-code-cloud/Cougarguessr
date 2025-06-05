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

    public GameController() {
        // No special setup in constructor yet
    }

    public void startGame() {
        // ✅ Use class variables — no shadowing!
        frame = new JFrame();
        startScreen = new JPanel();

        frame.setSize(1600, 1000);
        frame.setTitle("CougarGuessr");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Manual layout

        // Initialize panels
        ip = new ImagePanel();
        SchoolMapPanel mp0 = new SchoolMapPanel(0);
        SchoolMapPanel mp1 = new SchoolMapPanel(1);
        roundManager = new RoundManager(); // unused for now

        // Setup start screen
        startScreen.setLayout(null);
        startScreen.setBounds(0, 0, 1600, 1000);

        JButton startButton = new JButton("<html>Start<br/>Game</html>");
        startButton.setFont(new Font("Arial", Font.PLAIN, 40));
        startButton.setBounds(600, 400, 400, 200);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game started");

                // Remove the start screen
                frame.remove(startScreen);

                // Set bounds for game components
                ip.setBounds(50, 400, 600, 400);      // Image on left
                mp0.setBounds(700, 300, 375, 500);    // Bottom floor map
                mp1.setBounds(1100, 300, 375, 500);   // Top floor map

                // Add game components
                frame.add(ip);
                frame.add(mp0);
                frame.add(mp1);

                // Load test image (confirm it's visible)
                ip.setImage("cougarguessr-photo/i1.jpeg");

                frame.revalidate();
                frame.repaint();
            }
        });

        // Add button to start screen
        startScreen.add(startButton);
        frame.add(startScreen);
        frame.setVisible(true);
    }

    // Placeholder for future round logic
    public void startNewRound() {
        if (roundManager.hasNextRound()) {
            LocationPoint lp = roundManager.getNextRound();
            ip.setImage(lp.getImagePath());
        } else {
            System.out.println("Game over!");
        }
    }
}


import javax.swing.JPanel;             
import java.awt.Color;                
import java.awt.Dimension;            
import java.awt.event.MouseListener;   
import java.awt.event.MouseEvent;      


public class SchoolMapPanel extends JPanel implements MouseListener {
	private GameController controller;

	public SchoolMapPanel(GameController controller) {
	
		this.controller = controller;
	    setBackground(Color.GREEN);
	    setPreferredSize(new Dimension(533, 850)); 
	    addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	    int x = e.getX();
	    int y = e.getY();
	    controller.handleGuess(x, y, "bottom"); 
	    }
	
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}





}

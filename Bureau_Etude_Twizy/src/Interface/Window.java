package Interface;
import main.Main;
import javax.swing.JFrame;

public class Window extends JFrame{


	public Window(String str) {
		super(str);
		this.properties();
		this.setVisible(true);
	}
	
	private void properties() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		//app.setTitle("TWIZZY_APP");
		this.setSize(1000,1275);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.add(Main.panel);
	}


}

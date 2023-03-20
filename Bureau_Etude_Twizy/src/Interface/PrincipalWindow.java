package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class PrincipalWindow extends JFrame {

	JButton btnLeft = new JButton();
	JButton btnRight = new JButton();
	JButton btnNewImg = new JButton("New Image");
	JButton btnNewVid = new JButton("New Video");

	public PrincipalWindow() {
		super("Twizzy");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		this.add(UpComponent(), BorderLayout.NORTH);
		this.add(leftComponent(), BorderLayout.WEST);
		this.add(rightComponent());
	}

	private JPanel UpComponent() {
		JPanel downComponent = new JPanel();

		downComponent.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));

		btnNewImg.setPreferredSize(new Dimension(200, 50));
		btnNewVid.setPreferredSize(new Dimension(200, 50));
		btnNewImg.addActionListener((e) -> btnNewImgListener(e));
		btnNewVid.addActionListener((e) -> btnNewVidListener(e));
		// downComponent.setBackground(Color.green);
		downComponent.add(btnNewImg);
		downComponent.add(btnNewVid);
		downComponent.setPreferredSize(new Dimension(0, 100));
		return downComponent;
	}

	private void btnNewImgListener(ActionEvent e) {
		System.out.println("btn NewImg pressed");
	}

	private void btnNewVidListener(ActionEvent e) {
		System.out.println("btn NewVid pressed");
	}

	private JPanel rightComponent() {
		JPanel rightComponent = new JPanel();
		JLabel img=new JLabel();
		ImageIcon right = new ImageIcon(getClass().getResource("/icons/next.png"));
		ImageIcon left = new ImageIcon(getClass().getResource("/icons/previous.png"));
		ImageIcon p1=new ImageIcon(getClass().getResource("/res/images/p3.jpg"));
		// rightComponent.setBackground(Color.yellow);
		rightComponent.setLayout(new BorderLayout());
		btnRight.setIcon(right);
		btnLeft.setIcon(left);
		btnRight.addActionListener((e) -> btnRightListener(e));
		btnLeft.addActionListener((e) -> btnLeftListener(e));
		img.setIcon(p1);
		
		
		rightComponent.add(btnLeft, BorderLayout.WEST);
		rightComponent.add(btnRight, BorderLayout.EAST);
		rightComponent.add(img,BorderLayout.CENTER);
		return rightComponent;
	}

	private void btnLeftListener(ActionEvent e) {
		System.out.println("btn left pressed");
	}

	private void btnRightListener(ActionEvent e) {
		System.out.println("btn right pressed");
	}

	private JPanel leftComponent() {
		JPanel leftComponent = new JPanel();
		JLabel img=new JLabel();
		
		ImageIcon ref110=new ImageIcon(getClass().getResource("/res/images/ref110.jpg"));
		leftComponent.setPreferredSize(new Dimension(300, 0));
		leftComponent.setLayout(new GridLayout(2,1,10,10));
		
		img.setIcon(ref110);
		
		leftComponent.add(img);
		// leftComponent.setBackground(Color.red);
		return leftComponent;
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		// apply a look
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		// start my window
		PrincipalWindow myWindow = new PrincipalWindow();
		myWindow.setVisible(true);

	}

}

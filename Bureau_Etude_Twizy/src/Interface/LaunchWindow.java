package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.concurrent.Flow;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class LaunchWindow extends JFrame {

	JButton btnOpenCv = new JButton("Reconnaissance par OpenCV");
	JButton btnDL = new JButton("Reconnaisance par Deep Learning");

	public LaunchWindow() {
		super("Home page Twizzy");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1920, 1080);
		this.setLocationRelativeTo(null);

		JPanel contentpane = (JPanel) this.getContentPane();
		contentpane.setLayout(new BorderLayout());

		contentpane.add(titleContent(), BorderLayout.NORTH);
		contentpane.add(namesContent(), BorderLayout.SOUTH);
		contentpane.add(centerContent());

	}

	private JPanel titleContent() {
		JPanel titlepan = new JPanel();
		titlepan.setPreferredSize(new Dimension(0, 100));
		JLabel title = new JLabel();

		title.setText("Projet Twizzy: Reconnaissance des panneaux routiéres");
		title.setForeground(Color.black);
		title.setFont(new Font("BOLD", Font.PLAIN, 40));

		titlepan.add(title);
		// titlepan.setBackground(Color.red);
		return titlepan;
	}

	private JPanel namesContent() {
		JPanel namespan = new JPanel();
		namespan.setPreferredSize(new Dimension(0, 100));
		namespan.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel names = new JLabel();
		names.setText("Réalisé par: BEN RAIES Sabri, JARDAK Mariem, BAZZAZI Med Tahar, ELAMRI seifeddine");
		// names.setForeground(Color.black);
		names.setFont(new Font("Comic Sans", Font.CENTER_BASELINE, 20));
		namespan.add(names);
		// namespan.setBackground(Color.green);
		return namespan;
	}

	private JPanel centerContent() {

		btnOpenCv.addActionListener((e) -> btnOpenCvListener(e));
		btnDL.addActionListener((e) -> btnDLListener(e));

		btnOpenCv.setFont(new Font("Comic Sans", Font.BOLD, 20));
		btnDL.setFont(new Font("Comic Sans", Font.BOLD, 20));

		JPanel imgpan = new JPanel();
		JPanel btnpan = new JPanel();
		JPanel globalpan = new JPanel();
		globalpan.setLayout(null);
		btnpan.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0));

		imgpan.setBounds(295, 0, 1000, 491);
		btnpan.setBounds(295, 491, 1000, 150);
		btnOpenCv.setPreferredSize(new Dimension(400, 100));
		btnDL.setPreferredSize(new Dimension(400, 100));

		ImageIcon traficrecognitionimg = new ImageIcon(getClass().getResource("/icons/trafficRecognition.png"));
		JLabel traficrecognitionLabel = new JLabel();
		traficrecognitionLabel.setIcon(traficrecognitionimg);
		imgpan.add(traficrecognitionLabel);

		btnpan.add(btnOpenCv);
		btnpan.add(btnDL);

		globalpan.add(imgpan);
		globalpan.add(btnpan);

		return globalpan;

	}

	private void btnOpenCvListener(ActionEvent e) {
		System.out.println("btn OpenCv pressed");
		PrincipalWindow myWindow = new PrincipalWindow();
		myWindow.setVisible(true);
		dispose();
	}

	private void btnDLListener(ActionEvent e) {
		System.out.println("btn DL pressed");
	}

	/*
	 * public static void main(String[] args) throws UnsupportedLookAndFeelException
	 * { // apply a look UIManager.setLookAndFeel(new NimbusLookAndFeel()); // start
	 * my window LaunchWindow myLaunchWindow = new LaunchWindow();
	 * myLaunchWindow.setVisible(true);
	 * 
	 * }
	 */

}

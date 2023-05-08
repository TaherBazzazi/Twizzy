package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

import OpenCV.MainTraitementImage;
import OpenCV.TraitementImage;
import utilitaireAgreg.MaBibliothequeTraitementImage;

public class PrincipalWindow extends JFrame {
	static Path currentDirPath = Paths.get("");
	public static String currentDir = currentDirPath.toAbsolutePath().toString().replace("\\", "/");

	JButton btnLeft = new JButton();
	JButton btnRight = new JButton();

	ImageIcon roadImage;// =new ImageIcon(getClass().getResource("/res/images/p3.jpg"));
	JLabel roadImageLabel = new JLabel();

	static List<Integer> found;
	static List<Integer> found2=null;
	static List<Integer> found3=null;
	JLabel img1 = new JLabel();
	JLabel img2 = new JLabel();
	JPanel leftComponent = new JPanel();
	JLabel txt = new JLabel();
	test_video t=new test_video();
	VideoCapture camera ;
	ImageIcon image;


	Mat frame;
	public PrincipalWindow() {
		super("Twizzy");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1920, 1080);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setJMenuBar(createMenuBar());

		JPanel contentPane = (JPanel) this.getContentPane();
		// contentPane.setLayout(new BorderLayout());

		// this.add(UpComponent(), BorderLayout.NORTH);
		contentPane.add(createToolBar(), BorderLayout.NORTH);
		contentPane.add(leftComponent(), BorderLayout.WEST);
		contentPane.add(rightComponent());
		System.out.print(currentDir);



	}  

	private JToolBar createToolBar() {
		JToolBar toolbar = new JToolBar();
		JButton btnHome = new JButton(new ImageIcon(getClass().getResource("/icons/home.png")));
		JButton btnNewImg = new JButton(new ImageIcon(getClass().getResource("/icons/newImage.png")));
		JButton btnNewVid = new JButton(new ImageIcon(getClass().getResource("/icons/newVideo.png")));
		JButton btnHelp = new JButton(new ImageIcon(getClass().getResource("/icons/about.png")));
		JButton btnExit = new JButton(new ImageIcon(getClass().getResource("/icons/exit.png")));

		btnHome.addActionListener((e) -> btnHomeListener(e));
		btnNewImg.addActionListener((e) -> btnNewImgListener(e));
		btnNewVid.addActionListener((e) -> btnNewVidListener(e));
		btnHelp.addActionListener((e) -> btnHelpListener(e));
		btnExit.addActionListener((e) -> btnExitListener(e));

		btnHome.setToolTipText("Home");
		btnNewImg.setToolTipText("New image");
		btnNewVid.setToolTipText("New video");
		btnHelp.setToolTipText("Help");
		btnExit.setToolTipText("Exit");

		btnHome.setFocusable(false);
		btnNewImg.setFocusable(false);
		btnNewVid.setFocusable(false);
		btnHelp.setFocusable(false);
		btnExit.setFocusable(false);

		toolbar.add(btnHome);
		toolbar.add(btnNewImg);
		toolbar.add(btnNewVid);
		toolbar.add(btnHelp);
		toolbar.add(btnExit);

		return toolbar;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenu mnuHelp = new JMenu("Help");
		JMenu mnuExit = new JMenu("Exit");

		mnuFile.setMnemonic('F');
		mnuHelp.setMnemonic('H');
		mnuExit.setMnemonic('E');

		JMenuItem mnuNewImg = new JMenuItem("New Image...");
		mnuNewImg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
		mnuNewImg.setIcon(new ImageIcon(getClass().getResource("/icons/newImage.png")));

		JMenuItem mnuNewVid = new JMenuItem("New Video...");
		mnuNewVid.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
		mnuNewVid.setIcon(new ImageIcon(getClass().getResource("/icons/newVideo.png")));

		JMenuItem mnuHome = new JMenuItem("Home");
		mnuHome.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
		mnuHome.setIcon(new ImageIcon(getClass().getResource("/icons/home.png")));

		JMenuItem mnuH = new JMenuItem("Help...");
		mnuH.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
		mnuH.setIcon(new ImageIcon(getClass().getResource("/icons/about.png")));

		JMenuItem mnuE = new JMenuItem("Exit");
		mnuE.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK));
		mnuE.setIcon(new ImageIcon(getClass().getResource("/icons/Exit.png")));

		mnuHome.addActionListener((e) -> btnHomeListener(e));

		mnuNewImg.addActionListener((e) -> btnNewImgListener(e));
		mnuNewVid.addActionListener((e) -> btnNewVidListener(e));
		mnuH.addActionListener((e) -> btnHelpListener(e));
		mnuE.addActionListener((e) -> btnExitListener(e));

		mnuFile.add(mnuNewImg);
		mnuFile.addSeparator();
		mnuFile.add(mnuNewVid);
		mnuFile.addSeparator();
		mnuFile.add(mnuHome);

		mnuHelp.add(mnuH);
		mnuExit.add(mnuE);

		menuBar.add(mnuFile);
		menuBar.add(mnuHelp);
		menuBar.add(mnuExit);

		return menuBar;
	}

	private void btnHomeListener(ActionEvent e) {
		LaunchWindow myLaunchWindow = new LaunchWindow();
		myLaunchWindow.setVisible(true);
		dispose();
	}

	private void btnNewImgListener(ActionEvent e) {
		System.out.println("btn NewImg pressed");
		JFileChooser imgChooser = new JFileChooser();
		
		imgChooser.setCurrentDirectory(new File("/res/images"));
		int response = imgChooser.showOpenDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {
			//resize image before display
			roadImage = new ImageIcon(imgChooser.getSelectedFile().getAbsolutePath());
			Image img = roadImage.getImage();
			Image resizedImage = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
			ImageIcon resizedIcon = new ImageIcon(resizedImage);
			roadImageLabel.setIcon(resizedIcon);


			found=MainTraitementImage.img(imgChooser.getSelectedFile().getAbsolutePath());
			System.out.print(MainTraitementImage.img(imgChooser.getSelectedFile().getAbsolutePath()));
			this.leftComponent();
		}	
	}

	private void showvideo(String s) {

		frame = new Mat(); 
		camera = new VideoCapture(s);
		img1.setIcon(null);
		img2.setIcon(null);
		if (camera.isOpened()) {
			while (camera.read(frame)) {
				found=found2;
				found2=found3;
				found3= MainTraitementImage.img(frame);
				System.out.print(found);
				roadImage = new ImageIcon(test_video.Mat2bufferedImage(frame));
				roadImageLabel.setIcon(roadImage);

				if( (found!=null) && (found.equals(found2)) && (found.equals(found3)))
					leftComponent();
			}
		} else {
			System.out.println("can t open file");
		}
	}

	
	private void btnNewVidListener(ActionEvent e) {
		System.out.println("btn NewVid pressed");
		this.leftComponent();
		JFileChooser imgChooser = new JFileChooser();
		imgChooser.setCurrentDirectory(new File("/res/images"));
		int response = imgChooser.showOpenDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {
			SwingWorker <Void, Void> worker= new SwingWorker<Void , Void>(){
				@Override
				protected Void doInBackground() throws Exception {
					showvideo(imgChooser.getSelectedFile().getAbsolutePath());
					leftComponent();
					return null;
				}
			};
			worker.execute();
			this.leftComponent();
		}
	}

	private void btnHelpListener(ActionEvent e) {
		System.out.println("btn About pressed");
		JOptionPane.showMessageDialog(null, "Help Text Here", "Help", JOptionPane.INFORMATION_MESSAGE);
	}

	private void btnExitListener(ActionEvent e) {
		System.out.println("btn Exit pressed");
		this.dispose();
	}

	private JPanel rightComponent() {
		JPanel rightComponent = new JPanel();
		JPanel imgComponent = new JPanel();

		ImageIcon right = new ImageIcon(getClass().getResource("/icons/next.png"));
		ImageIcon left = new ImageIcon(getClass().getResource("/icons/previous.png"));

		// rightComponent.setBackground(Color.yellow);
		rightComponent.setLayout(new BorderLayout());
		imgComponent.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnRight.setIcon(right);
		btnLeft.setIcon(left);

		btnRight.addActionListener((e) -> btnRightListener(e));
		btnLeft.addActionListener((e) -> btnLeftListener(e));

		imgComponent.add(roadImageLabel);

		rightComponent.add(btnLeft, BorderLayout.WEST);
		rightComponent.add(btnRight, BorderLayout.EAST);
		rightComponent.add(imgComponent, BorderLayout.CENTER);
		return rightComponent;
	}

	private void btnLeftListener(ActionEvent e) {
		System.out.println("btn left pressed");
	}

	private void btnRightListener(ActionEvent e) {
		System.out.println("btn right pressed");
	}

	private JPanel leftComponent() {
		
		ImageIcon refdouble = new ImageIcon(getClass().getResource("/res/images/refdouble.jpg"));
		ImageIcon ref30 = new ImageIcon(getClass().getResource("/res/images/ref30.jpg"));
		ImageIcon ref50 = new ImageIcon(getClass().getResource("/res/images/ref50.jpg"));
		ImageIcon ref70 = new ImageIcon(getClass().getResource("/res/images/ref70.jpg"));
		ImageIcon ref110 = new ImageIcon(getClass().getResource("/res/images/ref110.jpg"));
		ImageIcon ref90 = new ImageIcon(getClass().getResource("/res/images/ref90.jpg"));
		leftComponent.setPreferredSize(new Dimension(254, 0));
		leftComponent.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		System.out.print(found);
		
		txt.setText("Panneau(x) Détecté(s):");
		txt.setForeground(Color.black);
		txt.setFont(new Font("BOLD", Font.PLAIN, 20));
		if(found != null) {
			if (found.size()==1) {
				switch (found.get(0)) {
				case 1:
					img1.setIcon(ref50);

					break;
				case 2:

					img1.setIcon(ref70);

					break;
				case 3:
					img1.setIcon(ref90);

					break;
				case 4:
					img1.setIcon(ref110);

					break;
				case 5:
					img1.setIcon(refdouble);

					break;
				case 0:
					img1.setIcon(ref30);

					break;
				default:
					img1.setIcon(null);
					break;
				}
				img2.setIcon(null);

			}
			else if (found.size()>1) {
				switch (found.get(0)) {
				case 1:
					img1.setIcon(ref50);

					break;
				case 2:

					img1.setIcon(ref70);

					break;
				case 3:
					img1.setIcon(ref90);

					break;
				case 4:
					img1.setIcon(ref110);

					break;
				case 5:
					img1.setIcon(refdouble);

					break;
				case 0:
					img1.setIcon(ref30);
					break;
				default:
					img1.setIcon(null);
					break;
				}	
				switch ((int)found.get(1)) {
				case 1:
					img2.setIcon(ref50);

					break;
				case 2:

					img2.setIcon(ref70);

					break;
				case 3:
					img2.setIcon(ref90);

					break;
				case 4:
					img2.setIcon(ref110);

					break;
				case 5:
					img2.setIcon(refdouble);

					break;
				case 0:
					img2.setIcon(ref30);
					break;
				default:
					img2.setIcon(null);
					break;
				}

			}}

		txt.setText("Panneau(x) Détecté(s):");
		txt.setForeground(Color.black);
		txt.setFont(new Font("BOLD", Font.PLAIN, 20));
		leftComponent.add(txt);
		leftComponent.add(img1);
		leftComponent.add(img2);

		return leftComponent;
	}

	/*
	 * public static void main() throws UnsupportedLookAndFeelException { // apply
	 * alook UIManager.setLookAndFeel(new NimbusLookAndFeel()); // start my window
	 * PrincipalWindow myWindow = new PrincipalWindow(); myWindow.setVisible(true);
	 * 
	 * }
	 */

}
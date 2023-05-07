package Interface;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

import OpenCV.MainTraitementImage;

public class test_video {
	static Mat frame;
	static VideoCapture camera;
	JLabel vidpanel;
	static JFrame jframe ;
	static int found;
	ImageIcon image;
	static MatOfByte bytemat;
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	static {
		try {
			System.load("C:/Users/abgad/Downloads/opencv/build/x64/vc14/bin/opencv_ffmpeg2413_64.dll");
		} catch (UnsatisfiedLinkError e) {
			System.err.println("Native code library failed to load.\n" + e);
			System.exit(1);
		}
	}
	static Path currentDirPath = Paths.get("");
	public static String currentDir = currentDirPath.toAbsolutePath().toString().replace("\\", "/");

	static Mat imag = null;
	public test_video() {
		jframe = new JFrame("Display Video");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vidpanel = new JLabel();

		jframe.setContentPane(vidpanel);
		jframe.setSize(1920, 1080);
		//jframe.setVisible(true);

		frame = new Mat();
		camera = new VideoCapture(currentDir + "/res/Videos/video1.mp4");
		//ImageIcon image;
		bytemat = new MatOfByte();
	}
	
	/*
	 * public void video() {
	 * 
	 * File f = new File("/src/res/Videos/video1.avi");
	 * System.out.println(f.getAbsolutePath()); JFrame jframe = new
	 * JFrame("Display Video");
	 * jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); JLabel vidpanel = new
	 * JLabel();
	 * 
	 * jframe.setContentPane(vidpanel); jframe.setSize(1920, 1080);
	 * jframe.setVisible(true);
	 * 
	 * Mat frame = new Mat(); VideoCapture camera = new VideoCapture(currentDir +
	 * "/res/Videos/video2.avi");
	 * 
	 * 
	 * if (camera.isOpened()) { while (camera.read(frame)) { found =
	 * MainTraitementImage.img(frame); System.out.print(found);
	 * 
	 * image = new ImageIcon(Mat2bufferedImage(frame)); vidpanel.setIcon(image);
	 * vidpanel.repaint(); }
	 * 
	 * } else { System.out.println("can t open file"); } // camera.release(); }
	 */

	public static BufferedImage Mat2bufferedImage(Mat image) {
		//MatOfByte bytemat = new MatOfByte();
		Highgui.imencode(".jpg", image, bytemat);
		byte[] bytes = bytemat.toArray();
		InputStream in = new ByteArrayInputStream(bytes);
		BufferedImage img = null;
		try {
			img = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	/*
	 * public static int identifiepanneau(Mat objetrond){ double [] scores=new
	 * double [6]; int indexmax=-1; if (objetrond!=null){
	 * scores[0]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,
	 * "ref30.jpg");
	 * scores[1]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,
	 * "ref50.jpg");
	 * scores[2]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,
	 * "ref70.jpg");
	 * scores[3]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,
	 * "ref90.jpg");
	 * scores[4]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,
	 * "ref110.jpg");
	 * scores[5]=MaBibliothequeTraitementImage.tauxDeSimilitude(objetrond,
	 * "refdouble.jpg");
	 * 
	 * double scoremax=scores[0];
	 * 
	 * for(int j=1;j<scores.length;j++){ if
	 * (scores[j]>scoremax){scoremax=scores[j];indexmax=j;}}
	 * 
	 * 
	 * } return indexmax; }
	 */

}
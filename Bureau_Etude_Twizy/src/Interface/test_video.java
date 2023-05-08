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


}
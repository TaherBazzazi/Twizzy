package tpopencv;

import java.awt.List;
import org.opencv.core.Point;
import org.opencv.core.Rect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfInt4;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.FeatureDetector;
import org.opencv.features2d.Features2d;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

public class principale {	
	public static void main(String[] args) {
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	
	/*
	Mat m;
	m=utile.LectureImage("images\\opencv.png"); 
	for(int i=0; i< m.height(); i++) {
		for (int j=0; j < m.width(); j++) {
			double BGR[]= m.get(i, j);
			if (BGR[0]==255 && BGR[1]==255 && BGR[2]==255)
				System.out.print(".");
			else
				System.out.print("+");
		}
		System.out.println();	
	}*/
	
	/*
	Mat m=utile.LectureImage("images\\bgr.png");
	Vector<Mat> channels = new Vector<Mat>();
	Core.split(m,channels);
	
	//BGR order
	for (int i =0 ; i < channels.size();i++) {
		utile.ImShow(Integer.toString(i), channels.get(i));
	}*/
	
	/*
	Mat m=utile.LectureImage("images\\bgr.png");
	Vector<Mat> channels = new Vector<Mat>();
	Core.split(m,channels);
	
	//BGR order
	Mat dst = Mat.zeros(m.size(), m.type());
	Vector<Mat> chans = new Vector<Mat>();
	Mat empty = Mat.zeros(m.size(), CvType.CV_8UC1);
	for (int i=0; i<channels.size();i++) {
		utile.ImShow(Integer.toString(i), channels.get(i));
		chans.removeAllElements();
		for(int j=0; j <channels.size();j++) {
			if (j != i) {
				chans.add(empty);
			} else {
				chans.add(channels.get(i));
			}
		}
		Core.merge(chans, dst);  
		utile.ImShow(Integer.toString(i), dst);	
		}
	*/
	/*
	Mat m=utile.LectureImage("images\\hsv.png");
	Mat output = Mat.zeros(m.size(),m.type());
	Imgproc.cvtColor(m, output, Imgproc.COLOR_BGR2HSV);
	utile.ImShow("HSV", output);
	Vector<Mat> channels = new Vector<Mat>();
	Core.split(output,channels);
	double hsv_values [][] = { {1,255,255}, {179,1,255},{179,0,1}};
	for ( int i=0; i<3 ; i++) {
		utile.ImShow(Integer.toString(i)+"-HSV", channels.get(i));
		Mat chans[] = new Mat[3];
		for (int j=0; j<3 ; j++) {
			Mat empty = Mat.ones(m.size(), CvType.CV_8UC1);
			Mat comp = Mat.ones(m.size(), CvType.CV_8UC1);
			Scalar v = new Scalar (hsv_values[i][j]);
			Core.multiply(empty, v, comp);
			chans[j]= comp;
		}
	chans[i] = channels.get(i);
	Mat dst = Mat.zeros(output.size(), output.type());
	Mat res = Mat.ones(dst.size(), dst.type());
	Core.merge(Arrays.asList(chans), dst);
	Imgproc.cvtColor(dst,res,Imgproc.COLOR_HSV2BGR);
	utile.ImShow(Integer.toString(i), res);
	} */
	
	Mat m=utile.LectureImage("images\\Billard_Balls.jpg");
	Mat output = Mat.zeros(m.size(),m.type());
	Imgproc.cvtColor(m, output, Imgproc.COLOR_BGR2HSV);
	utile.ImShow("HSV", output);
	
	Mat ball = null;
	Mat chans[]= new Mat[3];
	for (int i=0; i<3;i++)
		{chans[i]= new Mat();}
	
	Core.inRange(output, new Scalar(0,100,100), new Scalar(10,255,255), chans[0]);
	Core.inRange(output, new Scalar(160,100,100), new Scalar(179,255,255), chans[1]);
	Core.bitwise_or(chans[0], chans[1], chans[2]);
	Imgproc.GaussianBlur(chans[2], chans[2], new Size(9,9),2,2);
	utile.ImShow("CercleRouge", chans[2]);
	
	int thresh = 100;
	Mat canny_output = new Mat();
	ArrayList<MatOfPoint> contours = new ArrayList <MatOfPoint>();
	
	MatOfInt4 hierarchy = new MatOfInt4();
	Imgproc.Canny(chans[2],canny_output, thresh, 2*thresh);
	Imgproc.findContours(canny_output, contours, hierarchy, 
			Imgproc.RETR_EXTERNAL,Imgproc.CHAIN_APPROX_SIMPLE);
	Mat drawing= Mat.zeros(canny_output.size(), CvType.CV_8UC3);
	Random rand = new Random();
	for ( int i=0; i<contours.size();i++) {
		Scalar color= new Scalar(rand.nextInt(255-0+1), rand.nextInt(255-0+1),
				rand.nextInt(255-0+1));
		Imgproc.drawContours(drawing, contours, i, color);
		
	}
	utile.ImShow("Contours", drawing);
	
	MatOfPoint2f matOfPoint2f = new MatOfPoint2f();
	float[] radius = new float[1];
	Point center = new Point();
	for ( int c=0; c< contours.size(); c++) {
		MatOfPoint contour = contours.get(c);
		double contourArea = Imgproc.contourArea(contour);
		matOfPoint2f.fromList(contour.toList());
		Imgproc.minEnclosingCircle(matOfPoint2f, center, radius);
		if ((contourArea/(Math.PI*radius[0]*radius[0]))>= 0.8){
			Core.circle(m, center, (int)radius[0], new Scalar(0,255,0),2);
			Rect rect= Imgproc.boundingRect(contour);
			Core.rectangle(m, new Point(rect.x,rect.y),
					new Point(rect.x+rect.width,rect.y+rect.height),
					new Scalar(0,255,0),2);
			Mat tmp = m.submat(rect.y,rect.y+rect.height,rect.x,rect.x+rect.width);
			ball = Mat.zeros(tmp.size(),tmp.type());
			tmp.copyTo(ball);
			utile.ImShow("Ball",ball);
			
			//mise à l'échelle
			Mat sroadSign = Highgui.imread("images\\Ball_three.png");
			Mat sObject= new Mat();
			
			Imgproc.resize(ball, sObject, sroadSign.size());
			Mat grayObject = new Mat(sObject.rows(),sObject.cols(),sObject.type());
			Imgproc.cvtColor(sObject, grayObject, Imgproc.COLOR_BGRA2GRAY);
			Core.normalize(grayObject, grayObject, 0 , 255 , Core.NORM_MINMAX);
				
			Mat graySign = new Mat (sroadSign.rows(),sroadSign.cols(),sroadSign.type());
			Imgproc.cvtColor(sroadSign, graySign,Imgproc.COLOR_BGRA2GRAY);
			Core.normalize(graySign, graySign, 0 , 255 , Core.NORM_MINMAX);
			
			
	//Extraction des descripteurs et des keypoints
			FeatureDetector orbDetector = FeatureDetector.create(FeatureDetector.SURF);
			DescriptorExtractor orbExtractor = DescriptorExtractor.create(DescriptorExtractor.SURF);

			MatOfKeyPoint objectKeypoints = new MatOfKeyPoint();
			orbDetector.detect(grayObject, objectKeypoints);

			MatOfKeyPoint signKeypoints = new MatOfKeyPoint();
			orbDetector.detect(graySign, signKeypoints);

			Mat objectDescriptor = new Mat(ball.rows(),ball.cols(), ball.type());
			orbExtractor.compute(grayObject, objectKeypoints, objectDescriptor);

			Mat signDescriptor =  new Mat(sroadSign.rows(), sroadSign.cols(), sroadSign.type());
			orbExtractor.compute(graySign, signKeypoints, signDescriptor);
			
	//Faire le matching
			MatOfDMatch matchs = new MatOfDMatch();
			DescriptorMatcher matcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE);
			matcher.match(objectDescriptor,signDescriptor,matchs);
			System.out.println(matchs.dump());
			Mat matchedImage= new Mat(sroadSign.rows(),sroadSign.cols()*2,sroadSign.type());
			Features2d.drawMatches(sObject, objectKeypoints, sroadSign, signKeypoints,
					matchs, matchedImage);
			utile.ImShow("match",matchedImage);
		}	
	}
	utile.ImShow("cercles rouges", m);
	
/*//mise à l'échelle
		Mat sroadSign = Highgui.imread("images\\Ball_three.png");
		Mat sObject= new Mat();
		
		Imgproc.resize(ball, sObject, sroadSign.size());
		Mat grayObject = new Mat(sObject.rows(),sObject.cols(),sObject.type());
		Imgproc.cvtColor(sObject, grayObject, Imgproc.COLOR_BGRA2GRAY);
		Core.normalize(grayObject, grayObject, 0 , 255 , Core.NORM_MINMAX);
			
		Mat graySign = new Mat (sroadSign.rows(),sroadSign.cols(),sroadSign.type());
		Imgproc.cvtColor(sroadSign, graySign,Imgproc.COLOR_BGRA2GRAY);
		Core.normalize(graySign, graySign, 0 , 255 , Core.NORM_MINMAX);
		
		
//Extraction des descripteurs et des keypoints
		FeatureDetector orbDetector = FeatureDetector.create(FeatureDetector.ORB);
		DescriptorExtractor orbExtractor = DescriptorExtractor.create(DescriptorExtractor.ORB);

		MatOfKeyPoint objectKeypoints = new MatOfKeyPoint();
		orbDetector.detect(grayObject, objectKeypoints);

		MatOfKeyPoint signKeypoints = new MatOfKeyPoint();
		orbDetector.detect(graySign, signKeypoints);

		Mat objectDescriptor = new Mat(ball.rows(),ball.cols(), ball.type());
		orbExtractor.compute(grayObject, objectKeypoints, objectDescriptor);

		Mat signDescriptor =  new Mat(sroadSign.rows(), sroadSign.cols(), sroadSign.type());
		orbExtractor.compute(graySign, signKeypoints, signDescriptor);
		
//Faire le matching
		MatOfDMatch matchs = new MatOfDMatch();
		DescriptorMatcher matcher = DescriptorMatcher.create(DescriptorMatcher.BRUTEFORCE);
		matcher.match(objectDescriptor,signDescriptor,matchs);
		System.out.println(matchs.dump());
		Mat matchedImage= new Mat(sroadSign.rows(),sroadSign.cols()*2,sroadSign.type());
		Features2d.drawMatches(sObject, objectKeypoints, sroadSign, signKeypoints,
				matchs, matchedImage);
		utile.ImShow("match",matchedImage);*/

	}		
}
	


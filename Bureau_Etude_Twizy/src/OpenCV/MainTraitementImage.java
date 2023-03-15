package OpenCV;

import java.util.Arrays;
import java.util.List;

import org.opencv.core.*;
import org.opencv.highgui.*;
import OpenCV.TraitementImage;

public class MainTraitementImage {

	public static void main(String[] args) {
		//Ouverture le l'image et saturation des rouges
				System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
				Mat m=Highgui.imread("res/images/p10.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
				TraitementImage.afficheImage("Image testee", m);
				Mat transformee=TraitementImage.transformeBGRversHSV(m);
				
				//la methode seuillage est ici extraite de l'archivage jar du meme nom 
				Mat saturee=TraitementImage.seuillage(transformee, 6, 170, 110);
				
				TraitementImage.afficheImage("Image apres seuillage", saturee);
				
				Mat objetrond = null;
				//Creation d'une liste des contours a partir de l'image saturee
				List<MatOfPoint> ListeContours= TraitementImage .ExtractContours(saturee);
				int i=0;
				double [] scores=new double [6];
				//Pour tous les contours de la liste
				
				for (MatOfPoint contour: ListeContours  ){
					i++;
					
					objetrond=TraitementImage.DetectForm(m,contour);
					//System.out.println(objetrond);

					if (objetrond!=null){
						TraitementImage.afficheImage("Objet rond detecte", objetrond);
						scores[0]=TraitementImage.Similitude(objetrond,"res/images/ref30.jpg");
						scores[1]=TraitementImage.Similitude(objetrond,"res/images/ref50.jpg");
						scores[2]=TraitementImage.Similitude(objetrond,"res/images/ref70.jpg");
						scores[3]=TraitementImage.Similitude(objetrond,"res/images/ref90.jpg");
						scores[4]=TraitementImage.Similitude(objetrond,"res/images/ref110.jpg");
						scores[5]=TraitementImage.Similitude(objetrond,"res/images/refdouble.jpg");


						//recherche de l'index du maximum et affichage du panneau detect 
						double scoremax=-1;
						int indexmax=0;
						for(int j=0;j<scores.length;j++){
							if (scores[j]>scoremax){scoremax=scores[j];indexmax=j;}}	
						if(scoremax<0){System.out.println("Aucun Panneau d t ct ");}
						else{switch(indexmax){
						case -1:;break;
						case 0:System.out.println("Panneau 30 detecte");break;
						case 1:System.out.println("Panneau 50 detecte");break;
						case 2:System.out.println("Panneau 70 detecte");break;
						case 3:System.out.println("Panneau 90 detecte");break;
						case 4:System.out.println("Panneau 110 detecte");break;
						case 5:System.out.println("Panneau interdiction de depasser detecte");break;
						}}

					}
				}	


			}

	
}

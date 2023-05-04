package OpenCV;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.highgui.Highgui;

import utilitaireAgreg.MaBibliothequeTraitementImage;

public class MainTraitementImage {
	static Path currentDirPath = Paths.get("");
	public static String currentDir = currentDirPath.toAbsolutePath().toString().replace("\\", "/");

	public static void main(String[] args) {

		// Ouverture le l'image et saturation des rouges
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m = Highgui.imread(currentDir + "/res/images/p10.jpg", Highgui.CV_LOAD_IMAGE_COLOR);

		TraitementImage.afficheImage("Image teste", m);
		Mat transformee = TraitementImage.transformeBGRversHSV(m);
		// la methode seuillage est ici extraite de l'archivage jar du meme nom
		Mat saturee = MaBibliothequeTraitementImage.seuillage(transformee, 6, 170, 110);
		Mat objetrond = null;

		// Cr�ation d'une liste des contours � partir de l'image satur�e
		List<MatOfPoint> ListeContours = MaBibliothequeTraitementImage.ExtractContours(saturee);
		int i = 0;
		double[] scores = new double[6];
		// Pour tous les contours de la liste
		for (MatOfPoint contour : ListeContours) {
			i++;
			objetrond = MaBibliothequeTraitementImage.DetectForm(m, contour);
			if (objetrond != null) {
				TraitementImage.afficheImage("Objet rond détecté", objetrond);
				scores[0] = TraitementImage.Similitude(objetrond, currentDir + "/res/images/ref30.jpg");
				scores[1] = TraitementImage.Similitude(objetrond, currentDir + "/res/images/ref50.jpg");
				scores[2] = TraitementImage.Similitude(objetrond, currentDir + "/res/images/ref70.jpg");
				scores[3] = TraitementImage.Similitude(objetrond, currentDir + "/res/images/ref90.jpg");
				scores[4] = TraitementImage.Similitude(objetrond, currentDir + "/res/images/ref110.jpg");
				scores[5] = TraitementImage.Similitude(objetrond, currentDir + "/res/images/refdouble.jpg");

				// recherche de l'index du maximum et affichage du panneau detect�
				double scoremax = -1;
				int indexmax = 0;
				for (int j = 0; j < scores.length; j++) {
					if (scores[j] > scoremax) {
						scoremax = scores[j];
						indexmax = j;
					}
				}
				if (scoremax < 0) {
					System.out.println("Aucun Panneau détecté");
				} else {
					switch (indexmax) {
					case -1:
						;
						break;
					case 0:
						System.out.println("Panneau 30 détecté");
						break;
					case 1:
						System.out.println("Panneau 50 détecté");
						break;
					case 2:
						System.out.println("Panneau 70 détecté");
						break;
					case 3:
						System.out.println("Panneau 90 détecté");
						break;
					case 4:
						System.out.println("Panneau 110 détecté");
						break;
					case 5:
						System.out.println("Panneau interdiction de dépasser détecté");
						break;
					case 6:
						System.out.println("Panneau passage à niveau muni de barrières détecté");
						break;

					}
				}

			}
		
		}

	}
}
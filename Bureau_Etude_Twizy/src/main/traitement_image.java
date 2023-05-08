package res.images;
import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import OpenCV.MainTraitementImage;

public class traitement_image {
	static Path currentDirPath = Paths.get("");
	public static String currentDir = currentDirPath.toAbsolutePath().toString().replace("\\", "/");

	
	
	  @Test public void testp1(){ 
		  List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p1.jpg") ; 
	  Integer comp=val.get(0); 
	  System.out.println(comp);
	  assertTrue(comp.equals(2)); }
	  
	  @Test public void testp2(){ 
	List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p2.jpg") ;
	  Integer comp=val.get(0); 
	  System.out.println(comp); 
	  assertTrue(comp.equals(2));
	  
	  
	  }
	  
	  @Test public void testp3(){ 
		 List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p3.jpg") ; 
	  Integer comp=val.get(0); 
	  System.out.println(comp); 
	  assertTrue(comp.equals(4));
	  
	  
	  }
	  
	  @Test public void testp4(){ 
		  List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p4.jpg") ; 
	  Integer
	  comp=val.get(0); 
	  System.out.println(comp); 
	  assertTrue(comp.equals(0));
	   }
	  
	  @Test public void testp5(){ 
		  List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p5.jpg") ; 
	  Integer comp=val.get(0); 
	  System.out.println(comp); 
	  assertTrue(comp.equals(4));
	  
	  
	  }
	  
	  @Test public void testp6(){ 
		  List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p6.jpg") ; 
	  Integer comp=val.get(0); 
	  System.out.println(comp); 
	  assertTrue(comp.equals(0));
	  
	  
	  }
	  
	  @Test public void testp7(){ 
	List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p7.jpg") ; 
	  Integer comp=val.get(0); 
	  System.out.println(comp); 
	  assertTrue(comp.equals(1));
	  
	  
	  }
	  
	  @Test public void testp8(){ 
		  List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p8.jpg") ; 
	  Integer comp=val.get(0); 
	  System.out.println(comp); assertTrue(comp.equals(3));
	  
	  
	  }
	  
	  @Test public void testp9(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p9.jpg") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(0));
	  
	  
	  }
	  
	  @Test public void testp10() { List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p10.jpg") ; Integer
	  comp=val.get(0); Integer comp2=val.get(1); System.out.println(comp);
	  assertTrue(comp.equals(0)); assertTrue(comp2.equals(5));
	  
	  }
	  
	  @Test public void testp11(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p11.jpg") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(2)); }
	  
	  @Test public void testp12(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p12.jpg") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(1));
	  
	  
	  }
	  
	  @Test public void testp13(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p13.jpg") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(4));
	  
	  
	  }
	  
	  @Test public void testp14(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p14.jpg") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(1));
	  
	  
	  }
	  
	  @Test public void testp15(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p15.jpg") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(4));
	  
	  
	  }
	  
	  @Test public void testp16(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p16.jpg") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(0));
	  
	  
	  }
	  
	  @Test public void testp17(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p17.jpg") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(5));
	  
	  }
	  
	  
	  @Test public void testp18(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p18.png") ; Integer
	  comp=val.get(0); Integer comp2=val.get(1); System.out.println(comp);
	  assertTrue(comp.equals(3)); assertTrue(comp2.equals(3));
	  
	  }
	  
	  @Test public void testp19(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p19.png") ; Integer
	  comp=val.get(0); Integer comp2=val.get(1); System.out.println(comp);
	  assertTrue(comp.equals(4)); assertTrue(comp2.equals(4));
	  
	  }
	  
	  @Test public void testp20() { List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p20.png") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(3)); }
	  
	  @Test public void testp21(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p21.png") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(0));
	  
	  
	  }
	  
	  @Test public void testp22(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p22.png") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(2));
	  
	  }
	  
	  
	  @Test public void testp23(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p23.png") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(2)); }
	  
	  @Test public void testp24(){ List<Integer> val=new ArrayList<Integer>();
	  val=MainTraitementImage.img(currentDir +"/res/images/p24.png") ; Integer
	  comp=val.get(0); System.out.println(comp); assertTrue(comp.equals(2));
	  
	  }
	 
	  @Test public void testnull(){ 
		  List<Integer> val=new ArrayList<Integer>();
		  val=MainTraitementImage.img(currentDir +"/res/images/route.jpg") ;
		  assertTrue(val.size()==0);
		  
		  }
	  
	 
}
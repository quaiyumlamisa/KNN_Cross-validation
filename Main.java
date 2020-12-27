package cv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
//import java.util.Scanner;
import java.util.Scanner;



public class Main
{
	
	
	
	public static void main(String[]args) throws FileNotFoundException, IOException
	{
		
		
		File file= new File("D://iris.txt");
		int j=0;
		
		 
		data[] Db= new data[150];
		data[] Db1= new data[150];
		
		int size;
		int fold;
		int knn;
		Double accuracy=0.0;
		
		System.out.println("Enter number of fold:");
		Scanner sc=new Scanner(System.in);
		fold=sc.nextInt();
		
		System.out.println("Enter value of k:");
	
		knn=sc.nextInt();
		
		
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String st=" ";
			
			
			
			
			while((st=br.readLine())!= null)
			{
			
				String[] s=st.split(",");
			
			
				
				double foo1 =Double.parseDouble(s[0]);
				double foo2 =Double.parseDouble(s[1]);
				double foo3 =Double.parseDouble(s[2]);
				double foo4 =Double.parseDouble(s[3]);
				String foo5=s[4];   
				
				
				 Db[j]=new data(foo1,foo2,foo3,foo4,foo5);
				 j++;	
				
			}
			
			
			

}
		
		
		Random rand = new Random();  		
		 
		for (int i=0; i<Db.length; i++)
		{
		    int randomPosition = rand.nextInt(Db.length);
		    Db1[i] = Db[i];
		    Db[i] = Db[randomPosition];
		    Db[randomPosition] = Db1[i];
		}
		
	
		
		
		
		
		size=Db.length;
	    int folddata=size/fold;
	  
	    Double []arr=new Double[fold];
		
		
		KNN kn= new KNN(fold,size);
		
		for(int i=0;i<fold;i++)
		{
			
			KNN tr=new KNN(i,Db,knn,folddata,i*folddata,i*folddata+folddata) ;
			
		    arr[i]=tr.distance();
			
			
		}
		
		
		
		
		
		for(int i=0;i<fold;i++)
		{
			accuracy+=arr[i];
		}
		
		System.out.println("Accuracy: "+(accuracy/fold)*100 +"%");
			
	
}
}

package cv;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class KNN
{
data[] db=new data[150];
	
	int size;
	
	double dist;
	double sum;
	int knn;
	int k;
	Double acc=0.0;
	Double avg=0.0;
	int folddata;
	
	int foldno;

	Map< Double,String> map=new HashMap<Double,String>();  
	Map< Double,String> map1=new HashMap<Double,String>(); 
	
	int t1;
	int t2;
	Main kn=new Main();
	
	public KNN()
	{
		
		
	}
	
	public KNN(int fold2,int size)
	{
		this.k=fold2;
		this.size=size;
		// TODO Auto-generated constructor stub
	}
	
	public KNN(int fold,data[] db,int knn, int folddata,int a, int b)
	{
		this.foldno=fold;
		this.db=db;
		this.knn=knn;
		this.folddata=folddata;
		this.t1=a;
		this.t2=b;
	}
	
	
	public static <K extends Comparable, V> Map<K,V> sortByKeys(Map<K,V> map)
    {
        Map<K, V> treeMap = new TreeMap<>(new Comparator<K>() {
            @Override
            public int compare(K a, K b) {
                return b.compareTo(a);
            }
        });
 
        treeMap.putAll(map);
 
        return treeMap;
    }
	

	
	
	
	Double [] fold=new Double[k];


	

	
	public Double distance()
	{
		 String f;
		 sum=0;
	
		for(int i=t1;i<t2;i++)
		{
			f=" ";
			map.clear(); 
			map1.clear();
			
			 for(int i1=0;i1<150;i1++)
				{   
				    dist=0.0;
					if(i1<t1 || i1>=t2)
					{
					 
					
					   dist=Math.sqrt((db[i1].getA()-db[i].getA())*(db[i1].getA()-db[i].getA())
							         +(db[i1].getB()-db[i].getB())*(db[i1].getB()-db[i].getB())
							         +(db[i1].getC()-db[i].getC())*(db[i1].getC()-db[i].getC())
							         +(db[i1].getD()-db[i].getD())*(db[i1].getD()-db[i].getD()));
					  // System.out.println(dist);
					   map.put(dist,db[i1].getE());
					   
					   
					}
					
					
					
				}
			 
			 Map<Double, String> sortedMap = new TreeMap<Double, String>(map);
				
				 
				 
					
					for (Map.Entry mapElement : sortedMap.entrySet()) 
					{ 
			            Double key = (Double)mapElement.getKey(); 
			  
			            String value = (String)mapElement.getValue() ; 
			  
			          
			        } 
					
					
			    	 System.out.println();
					
					  
					 for (Map.Entry mapElement : sortedMap.entrySet())
					 { 
						     Double key = (Double) Math.pow((double) mapElement.getKey(),-1); 
				  
				           
						     String value = (String)mapElement.getValue() ; 
						     map1.put(key, value);
				           
				       
				     }
					 
					 
					
				      Map<Double, String> weightedMap = new TreeMap<Double, String>(map1);
				 
				     int size=sortedMap.size();
					
					 
					 Double[] value = new Double[3]; 
					 
					 for (int ik = 0; ik < value.length; ik++) {
						    value[ik] = (double) 0;
						}
					 
					 int s=0;
					 map1 = sortByKeys(map1);

					 
					 for (Map.Entry mapElement : map1.entrySet())
					 { 
						   
						    Double key = (Double)mapElement.getKey(); 
						  
				            String value1 = (String)mapElement.getValue() ; 
				         
				            
				            if(value1.equals("Iris-setosa"))
				            {
				            
				            	
				            	value[0]=value[0]+key;
				           
				            }
				            	
				            
				            if(value1.equals("Iris-versicolor"))
				            {
				            	
				            	value[1]=value[1]+key;
				             
				            }
				            
				            if(value1.equals("Iris-virginica"))
				            {
				            	
				            	value[2]=value[2]+key;
				              
				            }
				  
				            
				            
				            s++;
				      
				            
				            if(s==knn)
				            	break;
				     }
					 
					 
				
					 
					 
					 
					
					
					 
					 
					 if( value[0]> value[1] && value[0] > value[2])
						          f= "Iris-setosa";

				      else if (value[1] > value[2] )
				                  f= "Iris-versicolor";

				      else
				                  f="Iris-virginica";
					 
					 
				  	
					 
					 if(f.equals(db[i].getE()))
					 {
						 
						 sum=sum+1;
					 }
					
					 
					// System.out.println("sum is: "+sum);
					 
					
					 
					
		
		}
		
		 avg=sum/folddata;
		// System.out.println("avg is: "+avg);
		
		
		 
		 
		 return avg;
		 
		
		
	}
	

}

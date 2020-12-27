package cv;

public class data
{
	 double a;
	 double b;
	 double c;
	 double d;
	 String e;
	 
	 data()
	    {
	    	
	    }
	 
	
	     
	     data (double i,double j,double k,double l,String m)
	     {
	        this.a=i;
	        this.b=j;
	        this.c=k;
	        this.d=l;
	        this.e=m;
	     }



		


		public double getA() {
			return a;
		}



		public void setA(double a) {
			this.a = a;
		}



		public double getB() {
			return b;
		}



		public void setB(double b) {
			this.b = b;
		}



		public double getC() {
			return c;
		}



		public void setC(double c) {
			this.c = c;
		}



		public double getD() {
			return d;
		}



		public void setD(double d) {
			this.d = d;
		}



		public String getE() {
			return e;
		}



		public void setE(String e) {
			this.e = e;
		}



		@Override
		public String toString() {
			return "data [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + "]";
		}



		
		

	     


}

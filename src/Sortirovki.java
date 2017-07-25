import java.util.Random;
public class Sortirovki {
	static int count = 0;
	static int count1 = 0;
	static int count2 = 0;
    public static int ARRAY_LENGTH = 15000;
    private static int[] array = new int[ARRAY_LENGTH];
    private static int[] barray = new int[ARRAY_LENGTH];
    private static Random generator = new Random();
    public static void initArray() {
        for (int i=0; i<ARRAY_LENGTH; i++) {
            array[i] = generator.nextInt(100);
        }
    }
    public static void copy (){
	for (int k=0; k<ARRAY_LENGTH; k++)
		barray[k] = array[k];
    }
      public static void selectionSort (){
    	long before = System.currentTimeMillis();
    	for (int k = 0; k < ARRAY_LENGTH; k++) {
		    int min = barray[k]; 
		    int imin = k; 
		    for (int j = k+1; j < ARRAY_LENGTH; j++) 
		    {

		        if (barray[j] < min) {
		            min = barray[j];
		            imin = j;
		        }
		    }
		    if (k != imin) {
		        int temp = barray[k];
		        barray[k] = barray[imin];
		        barray[imin] = temp;
		        count ++;
		    }
			for (int s=0; s<ARRAY_LENGTH; s++)
				array[s] = barray[s];   
		}
    	long after = System.currentTimeMillis();
    	long diff = after - before;
    	System.out.println("Vremya = "+diff);
       	System.out.println(count);
		//for (int k = 0; k < ARRAY_LENGTH ; k++)
		//System.out.println(barray[k]);
    }
    public static void bubbleSort () {
        long before1 = System.currentTimeMillis();
        for(int i=0;i<ARRAY_LENGTH-1;i++)
        {
        	 for(int j=i+1;j<ARRAY_LENGTH;j++)
        	 {
        	  if(barray[i]>barray[j])
        	  {
        	       int t=barray[i];
        	       barray[i]=barray[j];
        	       barray[j]=t;
            	  }
    	         	 }
        	 count1 ++;
        	}
		for (int s=0; s<ARRAY_LENGTH; s++)
			array[s] = barray[s];  
    	long after1 = System.currentTimeMillis();
    	long diff1 = after1 - before1;
    	System.out.println("Vremya = "+diff1);
    	System.out.println(count1);
		//for (int k = 0; k < ARRAY_LENGTH ; k++)
		//System.out.println(barray[k]);
    	 }
    public static void quickSort() {
    	int i = 0;
        int j = ARRAY_LENGTH-1;
        int x = barray[(i-(i-j))/2];
        long before2 = System.currentTimeMillis();
        do {
            while(barray[i] < x) ++i;
            while(barray[j] > x) --j;
            if(i <= j){
                int temp = barray[i];
                barray[i] = barray[j];
                barray[j] = temp;
                i++; j--;
                count2 ++;
            }
        } while(i <= j);
		for (int s=0; s<ARRAY_LENGTH; s++)
			array[s] = barray[s];  
    	long after2 = System.currentTimeMillis();
    	long diff2 = after2 - before2;
    	System.out.println("Vremya = "+diff2);
    	System.out.println(count2);
		//for (int k = 0; k < ARRAY_LENGTH ; k++)
		//System.out.println(barray[k]);
    }	
    public static void main(String[] args) {
		initArray();
		copy ();
		selectionSort ();
		bubbleSort ();
		quickSort();
		}
}

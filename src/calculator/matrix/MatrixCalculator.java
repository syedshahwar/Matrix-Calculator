package calculator.matrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MatrixCalculator {
	
	private static int max = 100;
    
	int i =0, j = 0 , k =0;
    static int[] rows = new int[max];	// no. of rows in matrices
    static int[] cols =new int[max];	// no. of cols in matrices
    static String[] lines = new String[max];	//to read lines from file
    static float matrices[][] = new float[max][max];  //store all matrices in matrix format
    
    private String path;
    
    public MatrixCalculator()
    {
    	
    }
    public MatrixCalculator(String f_path)
    {
        path = f_path;
    }
    
    // translate the data into matrix form that is get from file
    public void FormMatrices() throws IOException
    {
	           
        try{
            
            ReadFile file = new ReadFile(path);
            lines = file.OpenFile();
            
           
           
            // tokenizing the data on the basis of delimiters to get no. of rows and columns in matrices
            for(k=0;k<lines.length;k++)
            {
                //System.out.println(lines[k]);
            	
            	//tokenzing on basis of ";" that differentiate between rows of matrix
            	StringTokenizer st = new StringTokenizer(lines[k],";");
                while (st.hasMoreTokens()) 
                {
                	//tokenzing on basis of space that differentiate between columns of matrix
                    StringTokenizer st2 = new StringTokenizer(st.nextToken());
                    while (st2.hasMoreTokens()) 
                    {
                    	st2.nextToken(); 
                    	j++; 
                    }
                    cols[k] = j; 	// storing the no. of columns in matrix
                    i++; 
                    j=0;
                }
                rows[k]=i;			//storing the no. of rows in matrix
                i=0;
            }
            
          // for(int x=0 ; x<lines.length ; x++)
            //	System.out.println("rows="+rows[x]+ "cols="+cols[x] );
            	
          
           
            i = j = 0; 
            String val = "";
            
            // storing the data in matrices[][] after tokenization on the basis of delimiters
            for(k=0;k<lines.length;k++)
            {
                 //System.out.println(lines[i]);
            	StringTokenizer st = new StringTokenizer(lines[k],";");
                while (st.hasMoreTokens()) 
                {
                    StringTokenizer st2 = new StringTokenizer(st.nextToken());
                    while (st2.hasMoreTokens()) 
                    {
                    	val = st2.nextToken(); 
                    	matrices[i][j] = Float.valueOf(val).floatValue(); // storing the data in matrices[][] after converting into float
                    	j++; 
                    }
                    //cols[k] = j; 
                    i++; 
                    j=0;
                }
               // rows[k]=i;
            }
            
        
            
        }
        
        catch(IOException e){
            System.out.println( e.getMessage() );
        }
        
        
    }
    
    public static void main(String[] args) throws IOException {
		
        String fileName;
        fileName = "SampleFile.txt";
        
        MatrixCalculator mc = new MatrixCalculator(fileName);
        mc.FormMatrices();
        
        
        UnitTests ut = new UnitTests();
    
        ut.Test1();
        
        ut.Test2();
        
        ut.Test3();
        
 }
    
}

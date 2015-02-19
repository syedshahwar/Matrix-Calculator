package calculator.matrix;


public class UnitTests {
    
    private static int max = 100;
    static float matrices[][] = new float[max][max];
    
    int r=0, c=0 , c1=0;
    int r1=0, r2=0;
    int i =0 , j=0;
    
    int totalMatrices=0;		//total rows in all matrices
    
    MatrixCalculator mc;
    
    public UnitTests()
    {
        mc = new MatrixCalculator();
        matrices = mc.matrices;
        
        totalMatrices = mc.lines.length;
        
        r=mc.rows[0];		//rows in 1st matrix
        c=mc.cols[0]; 		//columns in 1st matrix
        c1=mc.cols[1];		//columns in 2nd matrix
        
        
    }
    
    public void Test1()
    {
        System.out.println("-> Unit Test 1 : Multiply 2 matrices\n");
        
        /*
        totalrows =mc.lines.length * mc.rows[0];
        
        for (i=0; i<totalrows; i++)
        {
        
        for (j=0; j<(mc.cols[0]); j++)
        { System.out.print("m["+i+"]["+j+"] = " + matrices[i][j] + "   "); }
        System.out.println();
        }
        */
        
        // As we are nultiplying two matrices, so ensuring there must be at least two matrices in file
        if(totalMatrices<2)
        {
            System.out.println("There are fewer matrices than 2 in the file");
        }
        
        // checking the multiplcation is possible or not
        else if(mc.cols[0]!=mc.rows[1])
        {
            System.out.println("Orders of matices are not valid to multiply the matrix i.e cols of 1st matrix != rows of second matrix\n");
            
        }
        
        else
        {
           
            float  product[][] = new float[r][c1];
            
            float m1[][]= new float[r][mc.cols[0]];
            float m2[][]= new float[mc.rows[1]][c1];
            
            
            for (i = 0 ; i < r ; i++ )
                for ( j = 0 ; j < mc.cols[0] ; j++ )
                    m1[i][j]=matrices[i][j];
                /*
                for (i = 0 ; i < r ; i++ )
                for ( j = 0 ; j < mc.cols[0] ; j++ )
                System.out.println(m1[i][j]);
                */
            r1=r;
            while(r1<(r+mc.rows[1]))
            {
            	for (i = 0 ; i < mc.rows[1] ; i++ )
                {
            		for ( j = 0 ; j < mc.cols[1] ; j++ )
                    {
            			m2[i][j]=matrices[r1][j];
                    } 
                    r1++;
                }
            }
                /*
                for (i = 0 ; i < mc.rows[1] ; i++ )
                for ( j = 0 ; j < mc.cols[1] ; j++ )
                System.out.println(m2[i][j]);
                */
                
           //multiplying two matrices 
           for (int i=0; i<mc.rows[0]; i++)
           {
        	   for (int j=0; j<mc.cols[1]; j++)
               {
        		   for (int k=0; k<mc.cols[0]; k++)
                   {
        			   product[i][j] += m1[i][k] * m2[k][j];
                            
                    }
                }
            }
              
            // printing the resultant matrix
            System.out.println("Resultant Product Matrix:");
            for (i=0; i<r; i++)
            {
            	for (j=0; j<c1; j++)
                {
            		System.out.print(product[i][j] + "   "); 
                }
                    System.out.println();
                
            }
    	}
            System.out.println("-------------------------\n");
 	}

    public void Test2()
    {
        System.out.println("-> Unit Test 2 :  Add 3 matrices\n");
        
        
        // As we are adding three matrices, so ensuring there must be at least three matrices in file
        if(totalMatrices<3)
        {
            System.out.println("There are fewer matrices than 3 in the file");
        }
        
        // checking if addition is possible or not
        else if(mc.rows[0]!=mc.rows[1] || mc.rows[0]!=mc.rows[2] || mc.cols[0]!=mc.cols[0] || mc.cols[0]!=mc.cols[2])
        {
            System.out.println("Matrix Size Mismatch, so addition of matrices is not possible\n");
        }
        else
        {
            
            float  sum[][] = new float[r][c];
            
            //intializing summatrix with zero
            for (i = 0 ; i < r ; i++ )
                for ( j = 0 ; j < c ; j++ )
                    sum[i][j]=0;
                
                //adding first matirx to sum
                for (i = 0 ; i < r ; i++ )
                    for ( j = 0 ; j < c ; j++ )
                        sum[i][j] = sum[i][j] + matrices[i][j];
                    
                    
                //adding second matirx to sum
                r1=r;
                    
                while(r1<(r+mc.rows[1]))
                {
                	for (i = 0 ; i < r ; i++ )
                    {
                		for ( j = 0 ; j <c ; j++ )
                        {
                			sum[i][j] = sum[i][j] + matrices[r1][j];
                        }
                        r1++;
                    }
                 }
                    
                 //adding third matirx to sum
                 r2=r+mc.rows[1];
                    
                 while(r2<(r+mc.rows[1]+mc.rows[2]))
                 {
                     for (i = 0 ; i < r ; i++ )
                     {
                         for ( j = 0 ; j <c ; j++ )
                         {
                             sum[i][j] = sum[i][j] + matrices[r2][j];
                         }
                         r2++;
                     }
                     
                 }

                 // printing the resultant matrix
                 System.out.println("Resultant Sum Matrix:");
                 for (i=0; i<r; i++)
                 {
                     for (j=0; j<c; j++)
                     {
                         System.out.print(sum[i][j] + "   ");
                     }
                     System.out.println();
                 }
        	}
                
        System.out.println("\n-------------------------\n");
    }
            
    public void Test3()
    {
        System.out.println("-> Unit Test 3 : Multiply 2 matrices and then add a 3rd one to the result\n");
        
        // As we are nultiplying and then adding, so ensuring there must be at least three matrices in file
        if(totalMatrices<3)
        {
            System.out.println("There are fewer matrices than 3 in the file");
        }
        
        // checking the multiplcation is possible or not
        else if(mc.cols[0]!=mc.rows[1])
        {
            System.out.println("Orders of matices are not valid to multiply the matrix i.e cols of 1st matrix != rows of second matrix\n");
            
        }
        
        else
        {
           
            float  product[][] = new float[r][c1];
            
            float m1[][]= new float[r][mc.cols[0]];
            float m2[][]=new float[mc.rows[1]][c1];
            
            
            for (i = 0 ; i < r ; i++ )
                for ( j = 0 ; j < mc.cols[0] ; j++ )
                    m1[i][j]=matrices[i][j];
                
                r1=r;
                while(r1<(r+mc.rows[1]))
                {
                    for (i = 0 ; i < mc.rows[1] ; i++ )
                    {
                        for ( j = 0 ; j < mc.cols[1] ; j++ )
                        {
                            m2[i][j]=matrices[r1][j];
                        }
                        
                        r1++;
                    }
                }
                
                // multiplaying the matrices
                for (int i=0; i<mc.rows[0]; i++)
                {
                    for (int j=0; j<mc.cols[1]; j++)
                    {
                        for (int k=0; k<mc.cols[0]; k++)
                        {
                            product[i][j] += m1[i][k] * m2[k][j];
                            
                        }
                    }
                }
                
                // checking if addition is possible or not
                if(r!=mc.rows[2] || c1!=mc.cols[2])
                {
                    System.out.println("Matrix Size Mismatch, so addition of matrices is not possible\n");
                }
                
                else
                {
                    r2=r+mc.rows[1];
                    
                    while(r2<(r+mc.rows[1]+mc.rows[2]))
                    {
                        for (i = 0 ; i < r ; i++ )
                        {
                            for ( j = 0 ; j <c ; j++ )
                            {
                                product[i][j] = product[i][j] + matrices[r2][j];
                            }
                            r2++;
                        }
                        
                    }
                    
                    //printing the resultant matrix
                    
                    System.out.println("Resultant Matrix:");
                    for (i=0; i<r; i++)
                    {
                        for (j=0; j<c1; j++)
                        {
                        	System.out.print(product[i][j] + "   "); 
                        }
                        System.out.println();
                    }
                }
            }
            System.out.println("\n-------------------------\n");
            
            
        }
        
    }          
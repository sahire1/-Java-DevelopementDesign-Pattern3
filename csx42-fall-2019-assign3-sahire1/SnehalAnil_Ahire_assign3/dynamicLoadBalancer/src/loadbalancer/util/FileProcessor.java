package loadbalancer.util;
import loadbalancer.entities.Service;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import loadbalancer.subject.Cluster;
import loadbalancer.entities.Operation;
import loadbalancer.entities.Machine;
import java.util.ArrayList;
import java.util.List;
import loadbalancer.entities.Trie;
import loadbalancer.observer.LoadBalancer;
//import org.apache.commons.lang3.ArrayUtils;
public class FileProcessor 
{
	public List<Machine> machines=new ArrayList<Machine>();
                          //  public List<Machine> machines2=new ArrayList<Machine>(); 
                            //public List<Machine> machines1=new ArrayList<Machine>();
                            public Trie temp=new Trie();
                            public Cluster c=new Cluster();
                            public LoadBalancer lb=new LoadBalancer();
	public String filter1(String OptIn)
	{ String ret="null";
		if(OptIn.equals("REQUEST"))
		{ ret="LoadBalancer";
			return ret;
		}else
		{
			ret="Cluster";
			return ret;
		}
//return ret;
	}
	//Reading no of lines in input
	public int readfile(String input)  
	{ 
	//Student reader
	//CITE CODE https://www.tutorialspoint.com/java/java_files_io.htm
	      FileInputStream in = null;
		  		  //System.out.println(input);

		try 
		{
         in = new FileInputStream(input);
		 BufferedReader reader = new BufferedReader(new FileReader(input));
		 int lines = 0;
		 while (reader.readLine() != null) lines++;
		 reader.close();
		 //System.out.println(lines);
		 return lines;	
		 /*int c;
         while ((c = in.read()) != -1)
		 {  //CITE http://www.avajava.com/tutorials/lessons/how-do-i-write-the-contents-of-a-file-to-standard-output.html
		 //System.out.write(c);
		 return 0;
		 }*/
		}
		catch(IOException e) {
		e.printStackTrace();
			}
		 finally {
         if (in != null) 
		 {
					 try{
					in.close();
					 }
				 catch(IOException e) {
										e.printStackTrace();
											}
         }
				}
				return 0;
	}
	//------
	
	public Operation[] readfile1(String input,int linesIn)  
	{
		
		Operation[] o=new Operation[linesIn];
		 String OpT="null";
		// Service name.
		 
		  //CITED CODE https://www.journaldev.com/709/java-read-file-line-by-line
		BufferedReader reader;
		try {
					reader = new BufferedReader(new FileReader(input));
					String line = reader.readLine();
					//int i=1;
					int conum=0;
					while (line != null) 
					{
           String argn1="null";
		 String argn2="null";
		 String argn3="null";
						o[conum]=new Operation();
						//System.out.println(line);
						// read next line
						//L1 has cname
										String[] l1 = line.split(" ");
										//check output
									//L2 has capacity and timing
										//String[] l2=l1[1].split(";");
										
									
										
										for(int j=0;j<l1.length;j++)
										{
										//name=l1[j].charAt(0);
										if(j==0)
										{
											//System.out.println("j"+j+l1[j]);
											OpT=l1[j];
											o[conum].OpType=OpT;
										}
										if(j==1)
										{
											//System.out.println("argn1"+j+l1[j]);
											argn1=l1[j];
											o[conum].argnames1=argn1;
											
										}
										if(j==2)
										{
										//	System.out.println("argn2"+j+l1[j]);
											argn2=l1[j];
											o[conum].argnames2=argn2;
											
										}
										if(j==3)
										{
											//System.out.println("argn3"+j+l1[j]);
											argn3=l1[j];
											o[conum].argnames3=argn3;
											
										}
											//int ascii =(int)name.charAt(0);
											//System.out.println(name);
											/*
											if(ascii>64 && ascii <89)
											{
												
											}
											else
											{
												System.out.println("Input value is not a valid course name, give value between A and Z ");
											}
											*/
											//System.out.println(name);
											//System.out.println(l1[j]);
										
											
											
										}
										//co[conum].course(cap,time,name);
										//after 1 service has been read
										
                                    
                                                  // System.out.println("bf fil"); 
													String ret=filter1(OpT);
													if(ret.equals("Cluster"))
										{ System.out.println("Cluster operation"); 
                            String empty = new String();
													//System.out.println("argn2"+argn2);
                                                                                                      
                                                                                            
															if(argn2.equals("null"))
															{
                               //System.out.println("op");
                               System.out.println("came here 1 input");
      															machines=c.processinput2(OpT,argn1,machines);
                                  // for(Machine m :machines)
                                    //{  
                                   // Machine m=(Machine)machines.get(i);
                                  
                                    //System.out.println("m  after pinput2 gethostname"+m.gethostname());
                                    //}
                                                     
                                                                                                                                                            
															}
															else if(!argn3.equals("null"))
                             { 
                             
                             System.out.println("argn1In  "+argn1);
                                 System.out.println("argn2In  "+argn2);
                                 System.out.println("argn3In  "+argn3);
                             System.out.println("came here 3 input");
                             
                                  // for(Machine m :machines)
                                   // {  
                                   // Machine m=(Machine)machines.get(i);
                                  
                                   // System.out.println("m  before pinput gethostname"+m.gethostname());
                                    //}
          													machines=c.processinput(OpT,argn1,argn2,argn3,machines);
                                            //Cluster c=new Cluster();
                                       
                                    //   String ret1=temp.search(argn1);
                                     //  System.out.println("ret from fp"+ret1);                                                                                                    
                                                                                                                                                        
                							}	
                              else
                                {
                                 System.out.println("came here 2 input");
                               machines=c.processinput1(OpT,argn1,argn2,machines);
                                }							
						}
              else
              {
             System.out.println("ikda");
              temp=c.gettrie();
             lb.requestprocessor(argn1,temp);
              
              }
													line = reader.readLine();
													conum++;

					}
			
			reader.close();
			
			} catch (IOException e) 
				{
					e.printStackTrace();
				}
				finally
				{
					
				}
			 
				
		return o;
				//return 0;
	}
	
	
	
	
	//read student pref course
	
	
	
	
	
}



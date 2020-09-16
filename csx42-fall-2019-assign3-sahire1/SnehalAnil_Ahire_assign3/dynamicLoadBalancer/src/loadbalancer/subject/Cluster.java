package loadbalancer.subject;
import java.util.Map;
import loadbalancer.entities.Machine;
import java.util.ArrayList;
import java.util.List;
import loadbalancer.entities.Service;
import loadbalancer.entities.Trie;
import loadbalancer.observer.ServiceManager;
public class Cluster
{
//	private Map<String, Machine> machines;
  //public i=0;
//	public List<Machine> machines=new ArrayList<Machine>();
  public Trie t=new Trie();
  //public List<Machine> machines_copy=new ArrayList<Machine>();

public Trie gettrie()
{
return t;
}
	public List<Machine> processinput2(String OpTIn,String argn1In,List<Machine> machines)
	{
 
		if(OpTIn.equals("SERVICE_OP__REMOVE_SERVICE"))
		{
		System.out.println("REMOVE_SERVICE");
    //delete from trie
    	//machines_copy=machines;
   //  Object[] array=machines.toArray();
          for(int i=0;i<machines.size();i++)
                {  
                
                for(int j=0;j<machines.get(i).hostedServices.size();j++)
                 {
                 
                
                   if(machines.get(i).hostedServices.get(j).getname().equals(argn1In))
                   {
                   //remove from another list
                   machines.get(i).hostedServices.remove(j);
                 //  m.hostedServices.remove(s);
                   t.delete_entire(machines.get(i).hostedServices.get(j).getname());
                   }
                   
                 }
                }
                
                //for array
                
               
     
     
     return machines;
		}else if(OpTIn.equals("CLUSTER_OP__SCALE_UP"))
		{
   
       System.out.println("argnIn"+argn1In);
       Machine a=new Machine();
       a.hostname=argn1In;
       machines.add(a);
       System.out.println("added");
       return machines;
  // for(int i=0;i<machines.size();i++){
    //System.out.println(machines.get(i).gethostname());
  //} 
			
		}else if(OpTIn.equals("CLUSTER_OP__SCALE_DOWN"))
		{
   
   //take service names and put in somewhere
      for(int i=0;i<machines.size();i++)
                    {  
                    //  Machine temp=new Machine();
                     // temp=machines.get(i);
          
                           if(machines.get(i).gethostname().equals(argn1In))
                           {
                           machines.remove(argn1In);
                           t.delete_machine(argn1In);
                           }
                       }
                       
                       return machines;
		
    }
    return machines;
	}
	public List<Machine> processinput1(String OpTIn,String argn1In,String argn2In,List<Machine> machines)
	{

		 if(OpTIn.equals("SERVICE_OP__REMOVE_INSTANCE"))
		{
        
        String hosts[]=argn2In.split(",");
         for(int j=0;j<hosts.length;j++)
      			{
             // delete_instance(hosts[j]);
              for(int i=0;i<machines.size();i++)
              {  
              
               
			              if(machines.get(i).gethostname().equals(hosts[j]))
	                       {
                            for(int k=0;k<machines.get(i).hostedServices.size();k++)
              
                              {
                                            // Service temp=new Service();

                                               if(machines.get(i).hostedServices.get(k).getname().equals(argn1In))
                                               {
                                              // m.hostedServices.remove(s);
                                                machines.get(i).hostedServices.remove(k);
                                                t.delete_instance(argn1In);
                                               //akhri toh mark inactive in service manager
                                               }
                                             }
                                               
                        }
                         
            }
           
        			//return machines;
  		  }
        return machines;
        }   else if(OpTIn.equals("SERVICE_OP__ADD_INSTANCE"))
          {
          System.out.println("add instance");
          int check=0,check1=0;
          for(Machine m :machines)
              {
              //check if that service is there or not
              for(Service s :m.hostedServices)
              
                              {
                                            // Service temp=new Service();

                                               if(s.getname().equals(argn1In))
                                               {
                                               check=1;
                                               System.out.println("Can add");
                                               }
                                               
                              }
                  //if(m.)
                    }
                    String hosts[]=argn2In.split(",");
                    for(int j=0;j<hosts.length;j++)
              			{
                    
                      for(Machine m :machines)
                        {  
                       // Machine m=(Machine)machines.get(i);
                      
                      //  System.out.println("m  in pinput1 gethostname"+m.gethostname());
        			              if(m.gethostname().equals(hosts[j]))
        	                       {
                                 System.out.println("hai");
                                 check1=1;
                                }
                            
                            
                            }
                 }
                              
              //}
              if(check==0)
              { //cant add service as it is not added at all
               System.out.println("Cant add");
              }
              else if(check1==0)
              {System.out.println("Cant add");
              }
              else
            {
                Service s=new Service();
              // String hosts[]=argn2In.split(",");
               for(int j=0;j<hosts.length;j++)
      			{
             System.out.println("h  "+hosts[j]);
              
                for(Machine m :machines)
                {  
               // Machine m=(Machine)machines.get(i);
              
              //  System.out.println("m  in pinput1 gethostname"+m.gethostname());
			              if(m.gethostname().equals(hosts[j]))
	                       {
                         System.out.println("hai");
                        
                        // s.URL=argn2In;
                        
                         s.name=argn1In;
                         m.hostedServices.add(s);
                         t.insert(s.name,argn2In);   
                         }
                  
                	//write to results that this service exits
                }   
              }    
                              
         }
           return machines;
      }  

  
	
return machines;
 } //end of method
 
	public List<Machine> processinput(String OpTIn,String argn1In,String argn2In,String argn3In,List<Machine> machines)
	{
 //System.out.println("hai");
 
		if(OpTIn.equals("SERVICE_OP__ADD_SERVICE"))
		{
  
              Service s=new Service();
             // ServiceManager sm=new ServiceManager();
             // sm.URL=argn1In;
              
         String hosts[]=argn3In.split(",");
         for(int j=0;j<hosts.length;j++)
      			{
            // System.out.println("h  "+hosts[j]);
              
             // sm.hostnames.add(hosts[j]);
              
              
                for(Machine m :machines)
                {  
               // Machine m=(Machine)machines.get(i);
              
               // System.out.println("m  in pinput gethostname"+m.gethostname());
			              if(m.gethostname().equals(hosts[j]))
	                       {
                         System.out.println("hai");
                        
                         s.URL=argn2In;
                         s.name=argn1In;
                        // s.key=s.requestkey();
                         m.hostedServices.add(s);
                         
                         
                                 //put in trie
                               //  System.out.println("argn1In  "+argn1In);
                                 //System.out.println("argn2In  "+argn2In);
                                 //System.out.println("argn3In  "+argn3In);
                                   t.insert(s.name,argn3In); 
                                // String ret=t.search(argn1In);
                                 //System.out.println("ret from c"+ret);
                          }
                          else
                          {
                          }
                  
                	//write to results that this service exits
                }   
              } 
                return machines;  
              }
                       
              
              
              
                return machines;
              }
	
} //end of life of class
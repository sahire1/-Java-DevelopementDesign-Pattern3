package loadbalancer.observer;
import loadbalancer.subject.Cluster;
import loadbalancer.observer.ServiceManager;
import loadbalancer.entities.Service;
import loadbalancer.entities.Trie;
public class LoadBalancer
{
	//private Trie ServiceURLAndHostnameFetcher;
	  //public List<Service,ServiceManager> msrtosrm=new ArrayList<Service,ServiceManager>();
     /* public List<Service> gethostedServices()
     { return msrtosm;
     }
     
     public void mapthem(Service sIn,ServiceManager smIn)
     {
     msrtosrm.add(sIn,smIn);
     
     }
      */
     public void requestprocessor(String argn1In,Trie tempIn)
         {
        // Cluster c=new Cluster();
         //Trie temp=new Trie();
         //temp=c.gettrie();
         String ret=tempIn.search(argn1In);
         System.out.println("ret from lb"+ret);
         }
        
         
      	
}
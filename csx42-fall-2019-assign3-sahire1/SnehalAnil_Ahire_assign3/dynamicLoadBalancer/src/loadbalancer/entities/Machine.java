package loadbalancer.entities;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import loadbalancer.entities.Service;

public class Machine
{
	public String hostname;
		// Service name to hosted services.
	public List<Service> hostedServices=new ArrayList<Service>();;
     public String gethostname()
     { return hostname;
     }
     public List<Service> gethostedServices()
     { return hostedServices;
     }
}
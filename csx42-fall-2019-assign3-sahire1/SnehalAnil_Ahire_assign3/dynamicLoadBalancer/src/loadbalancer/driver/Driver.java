package loadbalancer.driver;
import loadbalancer.util.FileProcessor;
import loadbalancer.entities.Operation;
import java.io.FileNotFoundException;
import loadbalancer.entities.Trie;


public class Driver {
	//create a waitlist 
	//public String waitlist=new String();
	public static void main(String[] args) throws FileNotFoundException {

		
		if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}") ) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			System.exit(0);
		}
		
		FileProcessor f=new FileProcessor();
			int a=f.readfile(args[0]);
			System.out.println("lines"+a);
			Operation[] o=f.readfile1(args[0],a);
      //Trie t=new Trie();
      //t.insert("binghamton");
      //t.insert("ballon");
  //f.filter1()
		//Read 1st file
		
		//counting number of courses in the preference list
			//Results r=new Results();
				//r.write(args[1],so);
				//r.write1(so);
		
		
		
	}
}

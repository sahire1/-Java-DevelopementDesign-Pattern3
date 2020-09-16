package loadbalancer.entities;
import java.util.ArrayList;
import java.util.List;
public class Trie
{
public int count=-1;
public class node
    {
    boolean isword;
    node[] arr;
    //node next;
    char data;
    public List<String> h=new ArrayList<String>();
    public node()
    { this.arr=new node[37];
    }
        
    }
    public node root;
    public Trie()
    { root=new node();
    }


public void insert(String word,String hostnames)
{
//node root=new node();
//root.isword=false;
node a=new node();
a=root;
//System.out.println("hi");
int index;
System.out.println(word.length());
        for(int i=0;i<word.length();i++)
{
        char c=word.charAt(i);
       // System.out.println("c"+c);
        if(c=='.')
       {
       index=27;
       
       }else if(c=='0')
       { index=28;
       }
       else if(c=='1')
       { index=29;
       }
       else if(c=='2')
       { index=30;
       }
       else if(c=='3')
       { index=31;
       }
       else if(c=='4')
       { index=32;
       }
       else if(c=='5')
       { index=33;
       }
       else if(c=='6')
       { index=34;
       }
       else if(c=='7')
       { index=35;
       }
       else if(c=='8')
       { index=36;
       }else if(c=='9')
       { index=37;
       }
       else
       {
         index=c-'a';
         }
      //  System.out.println("i"+i);
        // System.out.println("index"+index);
        
     //   System.out.println("arr"+a.arr[index]);
        if(a.arr[index]==null)
        { 
       // System.out.println("null");
        node temp=new node();
        temp.data=c;
        a.arr[index]=temp;
        a=temp;
      //  System.out.println("placing  "+c+"  at"+index);
        
        }
        else
        {
      //  System.out.println("not null");
        a=a.arr[index];
     //   System.out.println("placing  "+c+"  at"+index);
        }
  
}
 a.isword=true;
        //System.out.println("a"+a);
       
        
        String hosts[]=hostnames.split(",");
            for(int j=0;j<hosts.length;j++)
            {
                  a.h.add(hosts[j]);
                  
          //  a.h.add()
            }
         //   System.out.println("isword "+a.isword);
           System.out.println("Added to trie");

}


public String search(String argn1In)
{
//System.out.println("This is from search");
int index;
      node a=root;
       for(int i=0;i<argn1In.length();i++)
      {
       char c=argn1In.charAt(i);
        //System.out.println("c  "+c);
        //int index=c-'a';
        if(c=='.')
       {
       index=27;
       
       }else if(c=='0')
       { index=28;
       }
       else if(c=='1')
       { index=29;
       }
       else if(c=='2')
       { index=30;
       }
       else if(c=='3')
       { index=31;
       }
       else if(c=='4')
       { index=32;
       }
       else if(c=='5')
       { index=33;
       }
       else if(c=='6')
       { index=34;
       }
       else if(c=='7')
       { index=35;
       }
       else if(c=='8')
       { index=36;
       }else if(c=='9')
       { index=37;
       }
       else
       {
         index=c-'a';
         }
        
        if(a.arr[index]==null)
        { System.out.println("pehla");
        return "false";
        }
        else
        { a=a.arr[index];
        }
      
      }
      if(a.isword)
      {
      
          if(count==a.h.size())
          {
          count=-1;
          }
          count++;
          System.out.println("Increased count"+count);
          return a.h.get(count);
          
          
      //return "false";
      }
      else
      { System.out.println("dusra");
      return "false";  
      }
     
    
      }

    public void delete_entire(String argn1In)
    {
    
    //int check=0;
      //node a=new node();
      int index;
      node a=root;
       for(int i=0;i<argn1In.length();i++)
      {
       char c=argn1In.charAt(i);
       // System.out.println("c"+c);
       
       if(c=='.')
       {
       index=27;
       
       }else if(c=='0')
       { index=28;
       }
       else if(c=='1')
       { index=29;
       }
       else if(c=='2')
       { index=30;
       }
       else if(c=='3')
       { index=31;
       }
       else if(c=='4')
       { index=32;
       }
       else if(c=='5')
       { index=33;
       }
       else if(c=='6')
       { index=34;
       }
       else if(c=='7')
       { index=35;
       }
       else if(c=='8')
       { index=36;
       }else if(c=='9')
       { index=37;
       }
       else
       {
         index=c-'a';
         }
        //int index=c-'a';
        if(a.arr[index]==null)
        { //return "false";
        }
        else
        { a=a.arr[index];
        }
      
      }
      if(a.isword)
      {node b=root;
        for(int i=0;i<argn1In.length();i++)
            {
                   char c=argn1In.charAt(i);
                   // System.out.println("c"+c);
                     index=c-'a';
                    if(b.arr[index]==null)
                    { 
                    
                    }
                    else
                    { 
                    // node temp=new node();
                    b.arr[index]=null;
                   
                    }
            
            }
             if(b.isword==true)
             {
            // b.isword==false;
             for(String hm :b.h)
              {
              b.h.remove(hm);
              }
              b.isword=false;
             }
            
            
      
      
      }
    }
    public void delete_instance(String argn1In)
    {
    //assumed argn1n is the hostname
    node a=new node();
             for(int i=0;i<argn1In.length();i++)
            {
             char c=argn1In.charAt(i);
             // System.out.println("c"+c);
              int index=c-'a';
              if(a.arr[index]==null)
              { //return "false";
              }
              else
              { a=a.arr[index];
              }
            
            }
              if(a.isword==true)
              {
                  for(String hm :a.h)
                  {
                      if(hm.equals(argn1In))
                      {
                              a.h.remove(hm);
                      }
                  }
              }
    
    
    
    }
        
        
        public void delete_machine(String argn1In)
    {
    
    //int check=0;
      node a=new node();
       for(int i=0;i<argn1In.length();i++)
      {
       char c=argn1In.charAt(i);
       // System.out.println("c"+c);
        int index=c-'a';
        if(a.arr[index]==null)
        { //return "false";
        }
        else
        { a=a.arr[index];
        }
      
      }
      if(a.isword==true)
      {
             for(String hm :a.h)
              {
                  if(a.h.equals(argn1In))
                  {  a.h.remove(hm); }
              }
             
      }
    }
     
    
    




}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksheet_3_source_code;
import java.lang.*;
import java.util.Scanner;
import java.lang.reflect.*;


/**
 *
 * @author dileeparajapaksa
 */
public class WORKSHEET_3_Source_Code {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            int methodsCount=0;
            int paramCount=0;
            double mean= 0;
            int maximum =0;
        
            
            
        try
        {
            //(a) Prompt the user to input the name of the Java class
            System.out.print("Please enter the name of the class : ");
            Scanner sc = new Scanner(System.in);
            
            //(b) Load the class using forName() method
            Class _class = Class.forName(sc.nextLine());
            Class _supperClass = _class.getSuperclass();
            Class _superSuperClass = _supperClass.getSuperclass(); 
            Class _supersupersuperClass = _superSuperClass.getSuperclass();
            
            
        
            
            
            System.out.println("================================================");
            System.out.println("Class Name : "+ _class.getName());
            System.out.println("Superclass Name : "+ _supperClass.getName());
            System.out.println("Super Super class Name : "+ _superSuperClass.getName());
                        System.out.println("Super Super Super class Name : "+ _supersupersuperClass.getName());
            System.out.println("________________________________________________");
            
            System.out.println("* Feilds");
            
            Field[] _fields = _class.getFields();
             for(Field f : _fields)
            {
                
                int modifierInt = f.getModifiers();
                
                if(Modifier.isPublic(modifierInt))
                {
                    System.out.print("+ ");
                    System.out.println(f.getName());
  
                }
                if(f.getName()=="a")
                {
                    f.set(_class, "WWWW");
                    System.err.println(f.get(_class));
                }
                
            }
            
            
            
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("* Methods");

            //(c) Output list of all methods that takes single int as parameter
            Method[] _methods = _class.getMethods();
            methodsCount= _methods.length;
            
            
            for(Method m : _methods)
            {
                paramCount+=m.getParameterCount();
                 System.out.println(m.getName()+"  : Param Count -->"+m.getParameterCount());
                if(m.getParameterCount()==1)
                {
                    Class[] _parmTypes = m.getParameterTypes();
                    
                    for(Class c: _parmTypes)
                    {
                        if(c.equals(int.class))
                        {
                            System.out.println(m.getName());
                            
                            
                            
                        }
                    }
                }
                
            }
            
            //(d) Ask user to selecte a method and then enter value parameter 
            
            System.out.println("Please enter a method name you want to try out :");
            String methodName = sc.nextLine();
            
            System.out.println("Give a actually value to the method parameter : ");
            int methodParmValue = sc.nextInt();
         
            double time_start= 0;
            double time_end = 0;
            for(Method m: _methods)
            {
                if(m.getName().equals(methodName))
                {
                    Object obj = new Object();   
                    
                    time_start= System.currentTimeMillis();
                    obj = m.invoke(obj, methodParmValue);
                    time_end = System.currentTimeMillis();
                    
                    System.out.println("Value returend by the method "+m.getName()+ " :"+obj);
                    System.out.println("Time to execute the method : "+ (time_end-time_start));
                }
            }
            
            
            System.out.println("================================================");
      
        }
        catch(ClassNotFoundException clsnfe)
        {
            System.out.print("Cannot find the class in the direcotry !");
        }
        catch(IllegalAccessException iae)
        {
            System.out.print("Illegal Access to object");
  
        }
        catch (InvocationTargetException ite)
        {
            System.out.print("Invocation Target Exception");
        }
        
        
        
    }
    
}

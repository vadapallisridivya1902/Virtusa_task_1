
package sridivya;

import java.io.*;
import java.io.FileWriter;
import java.util.*;
import java.util.Map.Entry;

public class StudentUsingTreeMap {

    static TreeMap<Integer,Student> students = new TreeMap<Integer,Student>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option=0;
        boolean flag=true;
        while(flag){
            System.out.println("\n\n1. Create new Student");
            System.out.println("0. Exit\n");
            System.out.print("Enter Your Choice : ");
            
            option = sc.nextInt();
            
            switch(option){
                case 1:{
                    System.out.println("Enter student Id : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter student first name : ");
                    String fname = sc.nextLine();
                    System.out.println("Enter student last name : ");
                    String lname = sc.nextLine();
                    System.out.println("Enter student email Id : ");
                    String email = sc.nextLine();
                    
                    Student student = new Student(id,fname,lname,email);
                    
                    if(students.containsKey(id)){
                        System.out.println("Student with Student Id "+id+" aldready exists...");
                    }
                    else{
                        students.put(id,student);
    	
		 String values = "";
                 BufferedWriter bufferedWriter = null;
                 FileWriter fileWriter =null;
		  try {

			  for(Entry<Integer,Student> record : students.entrySet()) {
                                Student s = record.getValue();
				  values += s.toString();
			  }
				fileWriter = new FileWriter("StudentDetails.txt");
				bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(values);
				bufferedWriter.close(); 
				
			   flag = true; 
			} 
			catch (IOException e) {
				System.out.println(e);
			}
		    catch(Exception e) {
		    	System.out.println(e);
		    }
		  finally {
			  try{
		      fileWriter.close();
			  bufferedWriter.close();
			  }
	            catch (Exception e){ 	
	            }
		  }
                        System.out.println("Student added successfully...");
                    }
                    
                    break;
                }
                
                case 0:{
                    System.out.println("Exiting...");
                    flag = false;
                    break;
                }
                default:{
                    System.out.println("Invalid Option...");
                }
            }
    }
    
}
}


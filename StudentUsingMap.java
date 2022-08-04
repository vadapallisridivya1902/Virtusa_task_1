
package sridivya;

import java.util.*;
import java.util.Map.Entry;

public class StudentUsingMap {

    static HashMap<Integer,Student> students = new HashMap<Integer,Student>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option=0;
        boolean flag=true;
        while(flag){
            System.out.println("\n\n1. Create new Student");
            System.out.println("2. Search student using id");
            System.out.println("3. Search student using name and email");
            System.out.println("4. Sort students by name and email");
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
                        System.out.println("Student added successfully...");
                    }
                    
                    break;
                }
                case 2:{
                    
                    System.out.println("Enter student Id : ");
                    int id = sc.nextInt();
                    
                    if(students.containsKey(id)){
                        System.out.println("Student found...\n");
                        System.out.println(students.get(id).toString());
                    }
                    else{
                        System.out.println("Student not found...");
                    }
                    break;
                }
                case 3:{
                    sc.nextLine();
                    System.out.println("Enter student first name : ");
                    String fname = sc.nextLine();
                    System.out.println("Enter student last name : ");
                    String lname = sc.nextLine();
                    System.out.println("Enter student email Id : ");
                    String email = sc.nextLine();
                    
                    boolean isFound = false;
                    for(Entry<Integer,Student> entry: students.entrySet()){
                        Student s = entry.getValue();
                        if(s.getFirstName().equals(fname) && s.getLastName().equals(lname)&& s.getEmail().equals(email)){
                            System.out.println("Student found...\n");
                            isFound = true;
                            System.out.println(s.toString());
                        }
                    }
                    if(!isFound){
                        System.out.println("Student not found...");
                    }
                    break;
                }
                case 4:{
                   Comparator<Entry<Integer, Student>> valueComparator = new Comparator<Entry<Integer, Student>>() {
            
                        public int compare(Entry<Integer, Student> e1, Entry<Integer, Student> e2) {
                            Student v1 = e1.getValue();
                            Student v2 = e2.getValue();
                            int value = v1.getFirstName().compareTo(v2.getFirstName());
                            if(value!=0){
                                return value;
                            }
                            value = v1.getLastName().compareTo(v2.getLastName());
                            if(value!=0){
                                return value;
                            }
                            value = v1.getEmail().compareTo(v2.getEmail());
                            return value;
                            
                        }
                    };
        
                    Set<Entry<Integer, Student>> entries = students.entrySet();
                    List<Entry<Integer, Student>> listOfEntries 
                              = new ArrayList<Entry<Integer, Student>>(entries);

                    // sorting HashMap by values using comparator
                    Collections.sort(listOfEntries, valueComparator);

                    LinkedHashMap<Integer, Student> sortedByValue 
                                = new LinkedHashMap<Integer, Student>(listOfEntries.size());

                    // copying entries from List to Map
                    for(Entry<Integer, Student> entry : listOfEntries){
                        sortedByValue.put(entry.getKey(), entry.getValue());
                    }

                    System.out.println("HashMap after sorting entries by values ");
                    Set<Entry<Integer, Student>> entrySetSortedByValue = sortedByValue.entrySet();

                    for(Entry<Integer, Student> mapping : entrySetSortedByValue){
                        System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
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

package sridivya;

import java.util.*;

public class SriDivya {

    static ArrayList<Student> students = new ArrayList<Student>();

    public static Student getStudent(int id){
        for(Student s : students){
            if(s.getStudentId()==id){
                return s;
            }
        }
        return null;
    }
    public static Student getStudent(String fname, String lname){
        for(Student s : students){
            if(s.getFirstName().equals(fname) && s.getLastName().equals(lname)){
                return s;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option=0;
        boolean flag=true;
        while(flag){
            System.out.println("\n\n1. Create new Student");
            System.out.println("2. Search a student");
            System.out.println("3. Show with for loop");
            System.out.println("4. Show with while loop");
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

                    if(getStudent(id)!=null){
                        System.out.println("Student with Student Id "+id+" aldready exists...");
                    }
                    else{
                        students.add(student);
                        System.out.println("Student added successfully...");
                    }

                    break;
                }
                case 2:{
                    sc.nextLine();
                    System.out.println("Enter student first name : ");
                    String fname = sc.nextLine();
                    System.out.println("Enter student last name : ");
                    String lname = sc.nextLine();
                    Student s = getStudent(fname,lname);
                    if(s!=null){
                        System.out.println("Student found...\n");
                        System.out.println(s.toString());
                    }
                    else{
                        System.out.println("Student not found...");
                    }

                    break;
                }
                case 3:{

                    System.out.println("\nStudents : ");
                    for(Student s : students){
                        System.out.println(s.toString());
                    }
                    break;
                }
                case 4:{

                    System.out.println("\nStudents : ");
                    Iterator<Student> itr = students.iterator();
                    while(itr.hasNext()){
                        Student s = itr.next();
                        System.out.println(s.toString());
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

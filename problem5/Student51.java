package sridivya;

public class Student51 {

    private int studentId;
    private String firstName;
    private String lastName;
    private String email;

    public Student() {
    }

    public Student(int studentId, String firstName, String lastName, String email) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public String toString(){
        String student;
        student = "\nStudent Id : "+studentId+"\nFirst Name : "+firstName+"\nLast Name : "+lastName+"\nEmail Id : "+email+"\n";
        return student;
    }
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

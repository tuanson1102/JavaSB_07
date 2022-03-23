package vn.techmaster.myfirstweb.model;

public class Student {
    private String studentSNumber;
    private String name;
    private String course;
    public Student(String studentSNumber, String name, String course) {
        this.studentSNumber = studentSNumber;
        this.name = name;
        this.course = course;
    }
    public String getStudentSNumber() {
        return studentSNumber;
    }
    public void setStudentSNumber(String studentSNumber) {
        this.studentSNumber = studentSNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }

}

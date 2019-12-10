package com.cpsc411.homework_2.model;

import java.util.ArrayList;

public class StudentDB { //This is a singleton
    private static final StudentDB ourInstance = new StudentDB();
    public static StudentDB getInstance() {
        return ourInstance;
    }


    private ArrayList<Student> mStudentList; //this holds the list of students in our DB

    private StudentDB() {
        createStudentObjects();
    }

    public ArrayList<Student> getStudentList() {return mStudentList; }

    protected void createStudentObjects() {
        Student student = new Student("Hee", "Yoo", "11111111");
        ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC 481","B+"));
        courses.add(new CourseEnrollment("CPSC 471", "A"));
        student.setCourses(courses);
        mStudentList = new ArrayList<Student>();
        mStudentList.add(student);

        student = new Student("Justin", "Yoo", "2222222");
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC 368", "B"));
        courses.add(new CourseEnrollment("CPSC 440", "C+"));
        //courses.add(new CourseEnrollment("CPSC 411", "A"));
        mStudentList.add(student);
    }

    public void setStudentList(ArrayList<Student> studentList) {
        mStudentList = studentList;
    }
}

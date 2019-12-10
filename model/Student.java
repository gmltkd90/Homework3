package com.cpsc411.homework_2.model;

import org.json.JSONObject;

import java.util.ArrayList;

public class Student {
    protected String mFirstName; // naming convention member items starts with a lowercase m
    protected  String mLastName;
    protected String mCWID;
    protected ArrayList<CourseEnrollment> mCourses;

    //Constructor
    public Student(String fName, String lName, String CWID) {
        mFirstName = fName;
        mLastName = lName;
        mCWID = CWID;
    }

    public Student() {
        mFirstName = "Empty";
        mLastName = "Empty";
        mCWID = "Empty";
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getCwid() {
        return mCWID;
    }

    public void setCwid(String CWID) {
        mCWID = CWID;
    }

    public ArrayList<CourseEnrollment> getCourses() {
        return mCourses;
    }

    public void setCourses(ArrayList<CourseEnrollment> courses) {
        mCourses = courses;
    }

    public void fromJsonObj(JSONObject obj) throws Exception {
        mFirstName = obj.getString("First Name");
        mLastName = obj.getString("Last Name");
        mCWID = obj.getString("CWID");
    }

    public JSONObject toJsonObject() throws Exception {
        JSONObject jObj = new JSONObject();
        jObj.put("First Name", mFirstName);
        jObj.put("Last Name", mLastName);
        jObj.put("CWID", mCWID);
        return jObj;
    }
}

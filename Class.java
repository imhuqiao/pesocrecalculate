/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pescorecalculate;

/**
 *
 * @author HQ-Alien
 */
public class Class {
    private int id;
    int currentGrade;
    int grade;
    int excellentNum = 0;
    int goodNum = 0;
    int passNum = 0;
    int failedNum = 0;
    int viaNum = 0;
    int unTestNum = 0;
    int totalNum = 0;
    private Major majorBelong;
    private College collegeBelong;
    private University universityBelong;
    int studentNum = 0;
    Student student[] = new Student[60 + 5];
    
    public Class() {
    }
    
    public Class(int id,int grade,int currentGrade, Major major) {
        this.id = id;
        this.grade = grade;
        this.currentGrade = currentGrade;
        this.majorBelong = major;
    }

    public int getTotalNum() {
        totalNum = this.excellentNum +this.goodNum + this.passNum
                 + this.failedNum + this.unTestNum;
        return totalNum;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Major getMajorBelong() {
        return majorBelong;
    }

    public void setMajorBelong(Major majorBelong) {
        this.majorBelong = majorBelong;
    }

    public College getCollegeBelong() {
        return collegeBelong;
    }

    public void setCollegeBelong(College collegeBelong) {
        this.collegeBelong = collegeBelong;
    }

    public University getUniversityBelong() {
        return universityBelong;
    }

    public void setUniversityBelong(University universityBelong) {
        this.universityBelong = universityBelong;
    }
    
    public void setBelong(University universityBelong, College collegeBelong, Major majorBelong){
        this.setUniversityBelong(universityBelong);
        this.setCollegeBelong(collegeBelong);
        this.setMajorBelong(majorBelong);
        this.majorBelong.setBelong(universityBelong,collegeBelong);
    }
    
    public void addStudent(Student student){
        this.student[studentNum] = student;
    }
    public String toString(){
        return id + "班";
    }
}

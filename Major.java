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
public class Major {
    private int id;
    private String name;
    int currentGrade;
    int grade;
    int excellentNum = 0;
    int goodNum = 0;
    int passNum = 0;
    int failedNum = 0;
    int viaNum = 0;
    int unTestNum = 0;
    int totalNum = 0;
    private College collegeBelong;
    private University universityBelong;
    int classNum = 0;
    private Class classX[] = new Class[20 + 5];

    public int getTotalNum() {
        totalNum = this.excellentNum +this.goodNum + this.passNum
                 + this.failedNum + this.unTestNum;
        return totalNum;
    }
    public Major(){
    }
    public Major(int id, String name,int grade,int currentGrade, College college){
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.currentGrade = currentGrade;
        this.collegeBelong = college;
    }
    
    public boolean isExistClass(int classId){
        for(int i=0;i<classNum;i++){
            if(classX[i].getId() == classId)
                return true;
        }
        return false;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class[] getClassX() {
        return classX;
    }
    public Class getClassX(int classId) {
        for(int i=0;i<classNum;i++){
            if(classX[i].getId() == classId)
                return classX[i];
        }
        return null;
    }
    public void setClassX(Class[] classX) {
        this.classX = classX;
    }

    public College getCollegeBelong() {
        return collegeBelong;
    }

    public void setCollegeBelong(College collegeBelong) {
        this.collegeBelong = collegeBelong;
    }

    public void addClass(int id,int grade,int currentGrade, Major major){
        getClassX()[classNum++] = new Class(id,grade,currentGrade, major);
    }
    public void setBelong(University universityBelong, College collegeBelong){
        this.setUniversityBelong(universityBelong);
        this.setCollegeBelong(collegeBelong);
        this.getCollegeBelong().setUniversityBelong(universityBelong);
    }
    public String toString(){
        return name;
    }

    public University getUniversityBelong() {
        return universityBelong;
    }

    public void setUniversityBelong(University universityBelong) {
        this.universityBelong = universityBelong;
    }
}

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
public class College {
    private int id;
    private String name;
    int excellentNum[] = new int[4];
    int goodNum[] = new int[4];
    int passNum[] = new int[4];
    int failedNum[] = new int[4];
    int viaNum[] = new int[4];
    int unTestNum[] = new int[4];
    int totalGradeNum[] = new int[4];
    int totalExcellentNum = 0;
    int totalGoodNum = 0;
    int totalPassNum = 0;
    int totalFailedNum = 0;
    int totalViaNum = 0;
    int totalUnTestNum = 0;
    int totalNum = 0;
    int majorNum = 0;
    private University universityBelong;
    private Major majorX[] = new Major[20 + 5];

    {
        for(int i=0;i<4;i++){
            excellentNum[i] = 0;
            goodNum[i] = 0;
            passNum[i] = 0;
            failedNum[i] = 0;
            viaNum[i] = 0;
            unTestNum[i] = 0;
        }
    }
    public int getTotalExcellentNum() {
        totalExcellentNum = 0;
        for(int i =0; i<4;i++){
            totalExcellentNum += excellentNum[i];
        }
        return totalExcellentNum;
    }

    public int getTotalGoodNum() {
        totalGoodNum = 0;
        for(int i =0; i<4;i++){
            totalGoodNum += goodNum[i];
        }
        return totalGoodNum;
    }

    public int getTotalPassNum() {
        totalPassNum =0;
        for(int i =0; i<4;i++){
            totalPassNum += passNum[i];
        }
        return totalPassNum;
    }

    public int getTotalFailedNum() {
        totalFailedNum = 0;
        for(int i =0; i<4;i++){
            totalFailedNum += failedNum[i];
        }
        return totalFailedNum;
    }

    public int getTotalViaNum() {
        totalViaNum = 0;
        for(int i =0; i<4;i++){
            totalViaNum += viaNum[i];
        }
        return totalViaNum;
    }

    public int getTotalUnTestNum() {
        totalUnTestNum = 0;
        for(int i =0; i<4;i++){
            totalUnTestNum += unTestNum[i];
        }
        return totalUnTestNum;
    }
    public int getTotalGradeNum(int currentGrade){
        totalGradeNum[currentGrade] = this.excellentNum[currentGrade] +this.goodNum[currentGrade]
                 + this.passNum[currentGrade] + this.failedNum[currentGrade] 
                 + this.unTestNum[currentGrade];
        return totalGradeNum[currentGrade];
    }

    public int getTotalNum() {
        totalNum = this.getTotalExcellentNum() +this.getTotalGoodNum() + this.getTotalPassNum()
                 + this.getTotalFailedNum() + this.getTotalUnTestNum();
        return totalNum;
    }
    public College(){}
    public College(int collegeId, String collegeName, University universityBelong){
        this.setId(collegeId);
        this.setName(collegeName);
        this.setUniversityBelong(universityBelong);
    }
    
    public boolean isExistMajor(int majorId){
        for(int i=0;i<majorNum;i++){
            if(majorX[i].getId() == majorId)
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

    public Major[] getMajorX() {
        return majorX;
    }

    public Major getMajorX(int majorId) {
        for(int i=0;i<majorNum;i++){
            if(majorX[i].getId() == majorId)
                return majorX[i];
        }
        return null;
    }
    public void setMajorX(Major[] majorX) {
        this.majorX = majorX;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addMajor(int majorId, String majorName,int grade, int currentGrade, College college){
        getMajorX()[majorNum++] = new Major(majorId, majorName,grade,currentGrade, college);
    }

    public University getUniversityBelong() {
        return universityBelong;
    }

    public void setUniversityBelong(University universityBelong) {
        this.universityBelong = universityBelong;
    }
    public String toString(){
        return name;
    }
}

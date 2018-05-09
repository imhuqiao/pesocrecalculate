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
public class University {
    private int id;
    private String name;
    boolean calculated = false;
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
    int collegeNum = 0;
    private College collegeX[] = new College[20 + 5];
    Student student[] = new Student[50000 + 5];
    Major major[] = new Major[500 + 5];
    public University(){}
    public University(int id, String name){
        this.setId(id);
        this.setName(name);
    }
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
        totalPassNum = 0;
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
    
    
    public boolean isExistCollege(int collegeId){
        for(int i=0;i<collegeNum;i++){
            if(collegeX[i].getId() == collegeId)
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

    public College[] getCollegeX() {
        return collegeX;
    }
    public College getCollegeX(int collegeId){
        for(int i=0;i<collegeNum;i++){
            if(collegeX[i].getId() == collegeId)
                return collegeX[i];
        }
        return null;
    }
    public void setCollegeX(College[] collegeX) {
        this.collegeX = collegeX;
    }
    public void addCollege(int collegeId, String collegeName,University university){
        getCollegeX()[collegeNum++] = new College(collegeId, collegeName, university);
    }
    public String toString(){
        return name;
    }
    
}

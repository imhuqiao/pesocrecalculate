/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pescorecalculate;
import java.text.DecimalFormat;
/**
 *
 * @author HQ-Alien
 */
public class Student {
	
	public Student(){
		
	}
	public Student(int currentGrade,int sex,double height,double weight,double spiroIndex, double fiftyMeters, double longJump, 
			double sitAndReach, double eightHundredRuning , double oneThousandRuning, double upOrDown, double pullUp){
		this.currentGrade = currentGrade;
		this.sex = sex;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.bMI=weight/height/height;
		this.bMI=Double.valueOf(df.format(this.bMI+0.0000001));
		this.spiroIndex = spiroIndex;
		this.fiftyMeters = fiftyMeters;
		this.longJump = longJump;
		this.sitAndReach = sitAndReach;
		this.eightHundredRuning = eightHundredRuning;
		this.oneThousandRuning = oneThousandRuning;
		this.upOrDown = upOrDown;
		this.pullUp = pullUp;
	}

	public void setScore(double height,double weight,double spiroIndex, double fiftyMeters, double longJump, 
			double sitAndReach, double eightHundredRuning , double oneThousandRuning, double upOrDown, double pullUp){
                this.height = height;
		this.weight = weight;
                if(weight!=0&&height!=0){
                    this.bMI=weight/height/height;
                    this.bMI=Double.valueOf(df.format(this.bMI + 0.0000001));   
                }
		this.spiroIndex = spiroIndex;
		this.fiftyMeters = fiftyMeters;
		this.longJump = longJump;
		this.sitAndReach = sitAndReach;
		this.eightHundredRuning = eightHundredRuning;
		this.oneThousandRuning = oneThousandRuning;
		this.upOrDown = upOrDown;
		this.pullUp = pullUp;
        }
        public void setInformation(String name, String studentId,int grade,int currentGrade,int sex,University universityBelong, College collegeBelong, Major majorBelong, Class classBelong){
            this.setUniversityBelong(universityBelong);
            this.setCollegeBelong(collegeBelong);
            this.setMajorBelong(majorBelong);
            this.setClassBelong(classBelong);
            this.classBelong.setBelong(universityBelong,collegeBelong, majorBelong);
            this.currentGrade = currentGrade;
            this.sex = sex;
            this.name = name;
            this.studentId = studentId;
            this.grade = grade;
        }
        
        public int getCurrentGrade() {
            return currentGrade;
        }

        public void setCurrentGrade(int currentGrade) {
            this.currentGrade = currentGrade;
        }
        DecimalFormat df = new DecimalFormat("####0.0");
        String studentId;
        private int currentGrade;//大一为0，大四为3
	private boolean testOrNot = true;
        private University universityBelong;
        private College collegeBelong;
        private Major majorBelong;
        private Class classBelong;
	private int grade;
	private int sex;//0为男，1为女
	private String name;
	private double height;
	private double weight;
	private double bMI;
	private int bMIMark;
	private String bMIEvaluate;
	private double spiroIndex;
	private int spiroIndexMark;
	private String spiroIndexEvaluate;
	private double fiftyMeters;//以负数存储
	private int fiftyMetersMark;
	private String fiftyMetersEvaluate;
	private double longJump;
	private int longJumpMark;
	private String longJumpEvaluate;
	private double sitAndReach;
	private int sitAndReachMark;
	private String sitAndReachEvaluate;
	private double eightHundredRuning;//以负数存储
	private int eightHundredRuningMark;
	private String eightHundredRuningEvaluate;
        private int eightHundredRuningExtraMark;
	private double oneThousandRuning;//以负数存储
	private int oneThousandRuningMark;
	private String oneThousandRuningEvaluate;
        private int oneThousandRuningExtraMark;
	private double upOrDown;
	private int upOrDownMark;
	private String upOrDownEvaluate;
	private double pullUp;
	private int pullUpMark;
	private String pullUpEvaluate;
	private int upOrDownExtraMark;
	private int pullUpExtraMark;
	private double finalStandandMark;
	private double finalTotalMark;
	private String finalEvaluate;

        public boolean isTestOrNot() {
            return testOrNot;
        }

        public void setTestOrNot(boolean testOrNot) {
            this.testOrNot = testOrNot;
        }

        public University getUniversityBelong() {
            return universityBelong;
        }

        public void setUniversityBelong(University universityBelong) {
            this.universityBelong = universityBelong;
        }
        public College getCollegeBelong() {
            return collegeBelong;
        }

        public void setCollegeBelong(College collegeBelong) {
            this.collegeBelong = collegeBelong;
        }

        public Major getMajorBelong() {
            return majorBelong;
        }

        public void setMajorBelong(Major majorBelong) {
            this.majorBelong = majorBelong;
        }

        public Class getClassBelong() {
            return classBelong;
        }

        public void setClassBelong(Class classBelong) {
            this.classBelong = classBelong;
        }
        
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getbMI() {
		return bMI;
	}
	public void setbMI(double bMI) {
		this.bMI = bMI;
	}
	public int getbMIMark() {
		return bMIMark;
	}
	public void setbMIMark(double bMIMark) {
		this.bMIMark = (int)bMIMark;
	}
	public String getbMIEvaluate() {
		return bMIEvaluate;
	}
	public void setbMIEvaluate(String bMIEvaluate) {
		this.bMIEvaluate = bMIEvaluate;
	}
	public double getSpiroIndex() {
		return spiroIndex;
	}
	public void setSpiroIndex(double spiroIndex) {
		this.spiroIndex = spiroIndex;
	}
	public int getSpiroIndexMark() {
		return spiroIndexMark;
	}
	public void setSpiroIndexMark(double spiroIndexMark) {
		this.spiroIndexMark = (int)spiroIndexMark;
	}
	public String getSpiroIndexEvaluate() {
		return spiroIndexEvaluate;
	}
	public void setSpiroIndexEvaluate(String spiroIndexEvaluate) {
		this.spiroIndexEvaluate = spiroIndexEvaluate;
	}
	public double getFiftyMeters() {
		return fiftyMeters;
	}
	public void setFiftyMeters(double fiftyMeters) {
		this.fiftyMeters = fiftyMeters;
	}
	public int getFiftyMetersMark() {
		return fiftyMetersMark;
	}
	public void setFiftyMetersMark(double fiftyMetersMark) {
		this.fiftyMetersMark = (int)fiftyMetersMark;
	}
	public String getFiftyMetersEvaluate() {
		return fiftyMetersEvaluate;
	}
	public void setFiftyMetersEvaluate(String fiftyMetersEvaluate) {
		this.fiftyMetersEvaluate = fiftyMetersEvaluate;
	}
	public double getLongJump() {
		return longJump;
	}
	public void setLongJump(double longJump) {
		this.longJump = longJump;
	}
	public int getLongJumpMark() {
		return longJumpMark;
	}
	public void setLongJumpMark(double longJumpMark) {
		this.longJumpMark = (int)longJumpMark;
	}
	public String getLongJumpEvaluate() {
		return longJumpEvaluate;
	}
	public void setLongJumpEvaluate(String longJumpEvaluate) {
		this.longJumpEvaluate = longJumpEvaluate;
	}
	public double getSitAndReach() {
		return sitAndReach;
	}
	public void setSitAndReach(double sitAndReach) {
		this.sitAndReach = sitAndReach;
	}
	public int getSitAndReachMark() {
		return sitAndReachMark;
	}
	public void setSitAndReachMark(double sitAndReachMark) {
		this.sitAndReachMark = (int)sitAndReachMark;
	}
	public String getSitAndReachEvaluate() {
		return sitAndReachEvaluate;
	}
	public void setSitAndReachEvaluate(String sitAndReachEvaluate) {
		this.sitAndReachEvaluate = sitAndReachEvaluate;
	}

        public double getEightHundredRuning() {
            return eightHundredRuning;
        }

        public void setEightHundredRuning(double eightHundredRuning) {
            this.eightHundredRuning = eightHundredRuning;
        }

        public int getEightHundredRuningMark() {
            return eightHundredRuningMark;
        }

        public void setEightHundredRuningMark(double eightHundredRuningMark) {
            this.eightHundredRuningMark = (int)eightHundredRuningMark;
        }

        public String getEightHundredRuningEvaluate() {
            return eightHundredRuningEvaluate;
        }

        public void setEightHundredRuningEvaluate(String eightHundredRuningEvaluate) {
            this.eightHundredRuningEvaluate = eightHundredRuningEvaluate;
        }
	public int getEightHundredRuningExtraMark() {
		return eightHundredRuningExtraMark;
	}
	public void setEightHundredRuningExtraMark(double eightHundredRuningExtraMark) {
		this.eightHundredRuningExtraMark = (int)eightHundredRuningExtraMark;
	}

        public double getOneThousandRuning() {
            return oneThousandRuning;
        }

        public void setOneThousandRuning(double oneThousandRuning) {
            this.oneThousandRuning = oneThousandRuning;
        }

        public int getOneThousandRuningMark() {
            return oneThousandRuningMark;
        }

        public void setOneThousandRuningMark(double oneThousandRuningMark) {
            this.oneThousandRuningMark = (int)oneThousandRuningMark;
        }

        public String getOneThousandRuningEvaluate() {
            return oneThousandRuningEvaluate;
        }

        public void setOneThousandRuningEvaluate(String oneThousandRuningEvaluate) {
            this.oneThousandRuningEvaluate = oneThousandRuningEvaluate;
        }
	public int getOneThousandRuningExtraMark() {
		return oneThousandRuningExtraMark;
	}
	public void setOneThousandRuningExtraMark(double oneThousandRuningExtraMark) {
		this.oneThousandRuningExtraMark = (int)oneThousandRuningExtraMark;
	}
        
	public double getUpOrDown() {
		return upOrDown;
	}
	public void setUpOrDown(double upOrDown) {
		this.upOrDown = upOrDown;
	}
	public int getUpOrDownMark() {
		return upOrDownMark;
	}
	public void setUpOrDownMark(double upOrDownMark) {
		this.upOrDownMark = (int)upOrDownMark;
	}
	public String getUpOrDownEvaluate() {
		return upOrDownEvaluate;
	}
	public void setUpOrDownEvaluate(String upOrDownEvaluate) {
		this.upOrDownEvaluate = upOrDownEvaluate;
	}
	public int getUpOrDownExtraMark() {
		return upOrDownExtraMark;
	}
	public void setUpOrDownExtraMark(double upOrDownExtraMark) {
		this.upOrDownExtraMark = (int)upOrDownExtraMark;
	}

        public int getPullUpExtraMark() {
            return pullUpExtraMark;
        }

        public void setPullUpExtraMark(double pullUpExtraMark) {
            this.pullUpExtraMark = (int)pullUpExtraMark;
        }

        public double getPullUp() {
            return pullUp;
        }

        public void setPullUp(double pullUp) {
            this.pullUp = pullUp;
        }

        public int getPullUpMark() {
            return pullUpMark;
        }

        public void setPullUpMark(double pullUpMark) {
            this.pullUpMark = (int)pullUpMark;
        }

        public String getPullUpEvaluate() {
            return pullUpEvaluate;
        }

        public void setPullUpEvaluate(String pullUpEvaluate) {
            this.pullUpEvaluate = pullUpEvaluate;
        }

        public double getFinalStandandMark() {
            return finalStandandMark;
        }

        public void setFinalStandandMark(double finalStandandMark) {
            this.finalStandandMark = finalStandandMark;
        }

        public double getFinalTotalMark() {
            return finalTotalMark;
        }

        public void setFinalTotalMark(double finalTotalMark) {
            this.finalTotalMark = finalTotalMark;
        }
	public void setFinalMark() {
		double tempMark;
		tempMark = this.bMIMark * 0.15 + this.spiroIndexMark * 0.15 + this.fiftyMetersMark *0.2 + this.sitAndReachMark * 0.1 
				+ this.longJumpMark *0.1 + this.upOrDownMark * 0.1 + this.pullUpMark * 0.1 + this.eightHundredRuningMark * 0.2
                                + this.oneThousandRuningMark * 0.2;
                this.setFinalStandandMark(Double.valueOf(df.format(tempMark + 0.000001)));
                tempMark += this.upOrDownExtraMark + this.pullUpExtraMark + this.eightHundredRuningExtraMark + this.oneThousandRuningExtraMark;
                this.setFinalTotalMark(Double.valueOf(df.format(tempMark + 0.000001)));
	}
	public String getFinalEvaluate() {
		return finalEvaluate;
	}
	public void setFinalEvaluate(String finalEvaluate) {
		this.finalEvaluate = finalEvaluate;
	}
	public void evaluate() {
		// TODO Auto-generated method stub
		this.setbMIEvaluate(getEvaluate("BMI",this.bMI,this.sex));
		this.setSpiroIndexEvaluate(getEvaluate(" ",this.spiroIndexMark,this.sex));
		this.setFiftyMetersEvaluate(getEvaluate(" ",this.fiftyMetersMark,this.sex));
		this.setLongJumpEvaluate(getEvaluate(" ",this.longJumpMark,this.sex));
		this.setSitAndReachEvaluate(getEvaluate(" ",this.sitAndReachMark,this.sex));
		this.setEightHundredRuningEvaluate(getEvaluate(" ",this.eightHundredRuningMark,this.sex));
		this.setOneThousandRuningEvaluate(getEvaluate(" ",this.oneThousandRuningMark,this.sex));
		this.setUpOrDownEvaluate(getEvaluate(" ",this.upOrDownMark,this.sex));
		this.setPullUpEvaluate(getEvaluate(" ",this.pullUpMark,this.sex));
		this.setFinalEvaluate(getEvaluate(" ",this.finalTotalMark,this.sex));
	}
	public String getEvaluate(String name,double mark,int sex){
		if(name.equals("BMI")){
			if(mark>=28){
				return "肥胖";
			}else if(mark>=24){
				return "超重";
			}else if(sex ==0 && mark >=17.9 ){
				return "正常";
			}else if(sex ==1 && mark >=17.2 ){
				return "正常";
			}
			return "低体重";
		}else{
			if(mark >= 90 ){
				return "优秀";
			}else if(mark >= 80){
				return "良好";
			}else if(mark >= 60){
				return "及格";
			}
			return "不及格";
		}
	}   

    boolean ok() {
        if(height==0)return false;
        if(weight==0)return false;
        if(spiroIndexMark==0)return false;
        if(fiftyMetersMark==0)return false;
        if(longJumpMark==0)return false;
        if(sitAndReachMark==0)return false;
        if(eightHundredRuningMark==0 && oneThousandRuningMark==0)return false;
        if(upOrDown==0 && pullUp==0)return false;
        return true;
    }

}

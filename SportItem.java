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
public class SportItem {
	
	private String itemName;
	private int levelNum;
	public SportItem(){
		
	}
	public SportItem(String name){
		this.itemName = name;
	}
	Rules rules[][] = new Rules[4][2];
	
	public void setRules(int grade,int sex,int levelNum,double[] standard,double[] mark){
		this.rules[grade][sex] = new Rules(levelNum);
		this.rules[grade][sex].setStandard(standard);
		this.rules[grade][sex].setMark(mark);
		this.levelNum = levelNum;
	}
	public double calculate(int grade,int sex,double score){
		return this.rules[grade][sex].calculate(score);
	}
	
	public int getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}   
}

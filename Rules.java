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
public class Rules {
	private double standard[] ;
	private double mark[];
	int levelNum;
	public Rules(){
		
	}
	public Rules(int levelNum){
		this.levelNum = levelNum;
	}
	double calculate(double score){
		for(int i=0;i<this.levelNum;i++){
			if(score >= standard[i]){
				return mark[i];
			}
		}
		return mark[this.levelNum];
	}
	public double[] getStandard() {
		return standard;
	}
	public void setStandard(double standard[]) {
		this.standard = standard;
	}
	public double[] getMark() {
		return mark;
	}
	public void setMark(double[] mark) {
		// TODO Auto-generated method stub
		this.mark = mark;
	}
    
}

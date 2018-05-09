/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pescorecalculate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
/**
 *
 * @author HQ-Alien
 */
public class Start {

    Workbook book;
    Sheet sheet;
    WritableWorkbook wtbook;
    WritableSheet outsheet;

    public void start(SportItem item[],University university,String inAddress, String outAddress) throws BiffException, IOException, RowsExceededException, WriteException {
        // TODO Auto-generated method stub
        Student student[] = university.student;
        this.setStandardAndMark(item);
        this.doData(university,inAddress,outAddress,item);
    }
    
    /**
     * 设置评分标准和相应分数
     * @param item 
     */
    void setStandardAndMark(SportItem[] item) {
		// TODO Auto-generated method stub
        /**
         * BMI
         */
        item[0].setItemName("BMI");
        item[0].setLevelNum(4);
        double bmiMark[] = {60, 80, 100, 80};
        double bmiStandard00[] = {28.0, 24.0, 17.9, 0};
        item[0].setRules(0, 0, item[0].getLevelNum(), bmiStandard00, bmiMark);
        item[0].setRules(1, 0, item[0].getLevelNum(), bmiStandard00, bmiMark);
        item[0].setRules(2, 0, item[0].getLevelNum(), bmiStandard00, bmiMark);
        item[0].setRules(3, 0, item[0].getLevelNum(), bmiStandard00, bmiMark);
        double bmiStandard01[] = {28.0, 24.0, 17.2, 0};
        item[0].setRules(0, 1, item[0].getLevelNum(), bmiStandard01, bmiMark);
        item[0].setRules(1, 1, item[0].getLevelNum(), bmiStandard01, bmiMark);
        item[0].setRules(2, 1, item[0].getLevelNum(), bmiStandard01, bmiMark);
        item[0].setRules(3, 1, item[0].getLevelNum(), bmiStandard01, bmiMark);

        /**
         * spiroIndex 
		 * 肺活量
         */
        item[1].setItemName("spiroIndex");
        item[1].setLevelNum(20);
        double spiroIndexMark[] = {100, 95, 90, 85, 80, 78, 76, 74, 72, 70, 68, 66, 64, 62, 60, 50, 40, 30, 20, 10, 10};//评分
		//男
        double spiroIndexStandard00[] = {5040, 4920, 4800, 4550, 4300, 4180, 4060, 3940, 3820, 3700, 3580, 3460, 3340, 3220, 3100, 2940, 2780, 2620, 2460, 2300};
        item[1].setRules(0, 0, item[1].getLevelNum(), spiroIndexStandard00, spiroIndexMark);
        double spiroIndexStandard10[] = {5040, 4920, 4800, 4550, 4300, 4180, 4060, 3940, 3820, 3700, 3580, 3460, 3340, 3220, 3100, 2940, 2780, 2620, 2460, 2300};
        item[1].setRules(1, 0, item[1].getLevelNum(), spiroIndexStandard10, spiroIndexMark);
        double spiroIndexStandard20[] = {5140, 5020, 4900, 4650, 4400, 4280, 4160, 4040, 3920, 3800, 3680, 3560, 3440, 3320, 3200, 3030, 2860, 2690, 2520, 2350};
        item[1].setRules(2, 0, item[1].getLevelNum(), spiroIndexStandard20, spiroIndexMark);
        double spiroIndexStandard30[] = {5140, 5020, 4900, 4650, 4400, 4280, 4160, 4040, 3920, 3800, 3680, 3560, 3440, 3320, 3200, 3030, 2860, 2690, 2520, 2350};
        item[1].setRules(3, 0, item[1].getLevelNum(), spiroIndexStandard30, spiroIndexMark);

        //女
        double spiroIndexStandard01[] = {3400, 3350, 3300, 3150, 3000, 2900, 2800, 2700, 2600, 2500, 2400, 2300, 2200, 2100, 2000, 1960, 1920, 1880, 1840, 1800};
        item[1].setRules(0, 1, item[1].getLevelNum(), spiroIndexStandard01, spiroIndexMark);
        double spiroIndexStandard11[] = {3400, 3350, 3300, 3150, 3000, 2900, 2800, 2700, 2600, 2500, 2400, 2300, 2200, 2100, 2000, 1960, 1920, 1880, 1840, 1800};
        item[1].setRules(1, 1, item[1].getLevelNum(), spiroIndexStandard11, spiroIndexMark);
        double spiroIndexStandard21[] = {3450, 3400, 3350, 3200, 3050, 2950, 2850, 2750, 2650, 2550, 2450, 2350, 2250, 2150, 2050, 2010, 1970, 1930, 1890, 1850};
        item[1].setRules(2, 1, item[1].getLevelNum(), spiroIndexStandard21, spiroIndexMark);
        double spiroIndexStandard31[] = {3450, 3400, 3350, 3200, 3050, 2950, 2850, 2750, 2650, 2550, 2450, 2350, 2250, 2150, 2050, 2010, 1970, 1930, 1890, 1850};
        item[1].setRules(3, 1, item[1].getLevelNum(), spiroIndexStandard31, spiroIndexMark);

        /**
         * fiftyMeters 
		 * 50米
         */
        item[2].setItemName("fiftyMeter");
        item[2].setLevelNum(20);
        double fiftyMetersMark[] = {100, 95, 90, 85, 80, 78, 76, 74, 72, 70, 68, 66, 64, 62, 60, 50, 40, 30, 20, 10, 10};//评分
		//男
        double fiftyMetersStandard00[] = {-6.7, -6.8, -6.9, -7.0, -7.1, -7.3, -7.5, -7.7, -7.9, -8.1, -8.3, -8.5, -8.7, -8.9, -9.1, -9.3, -9.5, -9.7, -9.9, -10.1};
        item[2].setRules(0, 0, item[2].getLevelNum(), fiftyMetersStandard00, fiftyMetersMark);
        double fiftyMetersStandard10[] = {-6.7, -6.8, -6.9, -7.0, -7.1, -7.3, -7.5, -7.7, -7.9, -8.1, -8.3, -8.5, -8.7, -8.9, -9.1, -9.3, -9.5, -9.7, -9.9, -10.1};
        item[2].setRules(1, 0, item[2].getLevelNum(), fiftyMetersStandard10, fiftyMetersMark);
        double fiftyMetersStandard20[] = {-6.6, -6.7, -6.8, -6.9, -7.0, -7.2, -7.4, -7.6, -7.8, -8.0, -8.2, -8.4, -8.6, -8.8, -9.0, -9.2, -9.4, -9.6, -9.8, -10.0};
        item[2].setRules(2, 0, item[2].getLevelNum(), fiftyMetersStandard20, fiftyMetersMark);
        double fiftyMetersStandard30[] = {-6.6, -6.7, -6.8, -6.9, -7.0, -7.2, -7.4, -7.6, -7.8, -8.0, -8.2, -8.4, -8.6, -8.8, -9.0, -9.2, -9.4, -9.6, -9.8, -10.0};
        item[2].setRules(3, 0, item[2].getLevelNum(), fiftyMetersStandard30, fiftyMetersMark);

        //女
        double fiftyMetersStandard01[] = {-7.5, -7.6, -7.7, -8.0, -8.3, -8.5, -8.7, -8.9, -9.1, -9.3, -9.5, -9.7, -9.9, -10.1, -10.3, -10.5, -10.7, -10.9, -11.1, -11.3};
        item[2].setRules(0, 1, item[2].getLevelNum(), fiftyMetersStandard01, fiftyMetersMark);
        double fiftyMetersStandard11[] = {-7.5, -7.6, -7.7, -8.0, -8.3, -8.5, -8.7, -8.9, -9.1, -9.3, -9.5, -9.7, -9.9, -10.1, -10.3, -10.5, -10.7, -10.9, -11.1, -11.3};
        item[2].setRules(1, 1, item[2].getLevelNum(), fiftyMetersStandard11, fiftyMetersMark);
        double fiftyMetersStandard21[] = {-7.4, -7.5, -7.6, -7.9, -8.2, -8.4, -8.6, -8.8, -9.0, -9.2, -9.4, -9.6, -9.8, -10.0, -10.2, -10.4, -10.6, -10.8, -11.0, -11.2};
        item[2].setRules(2, 1, item[2].getLevelNum(), fiftyMetersStandard21, fiftyMetersMark);
        double fiftyMetersStandard31[] = {-7.4, -7.5, -7.6, -7.9, -8.2, -8.4, -8.6, -8.8, -9.0, -9.2, -9.4, -9.6, -9.8, -10.0, -10.2, -10.4, -10.6, -10.8, -11.0, -11.2};
        item[2].setRules(3, 1, item[2].getLevelNum(), fiftyMetersStandard31, fiftyMetersMark);

        /**
         * longJump
		 * 跳远
         */
        item[3].setItemName("longJump");
        item[3].setLevelNum(20);
        double longJumpMark[] = {100, 95, 90, 85, 80, 78, 76, 74, 72, 70, 68, 66, 64, 62, 60, 50, 40, 30, 20, 10, 10};//评分
		//男
        double longJumpStandard00[] = {273, 268, 263, 256, 248, 244, 240, 236, 232, 228, 224, 220, 216, 212, 208, 203, 198, 193, 188, 183};
        item[3].setRules(0, 0, item[3].getLevelNum(), longJumpStandard00, longJumpMark);
        double longJumpStandard10[] = {273, 268, 263, 256, 248, 244, 240, 236, 232, 228, 224, 220, 216, 212, 208, 203, 198, 193, 188, 183};
        item[3].setRules(1, 0, item[3].getLevelNum(), longJumpStandard10, longJumpMark);
        double longJumpStandard20[] = {275, 270, 265, 258, 250, 246, 242, 238, 234, 230, 226, 222, 218, 214, 210, 205, 200, 195, 190, 185};
        item[3].setRules(2, 0, item[3].getLevelNum(), longJumpStandard20, longJumpMark);
        double longJumpStandard30[] = {275, 270, 265, 258, 250, 246, 242, 238, 234, 230, 226, 222, 218, 214, 210, 205, 200, 195, 190, 185};
        item[3].setRules(3, 0, item[3].getLevelNum(), longJumpStandard30, longJumpMark);

        //女
        double longJumpStandard01[] = {207, 201, 195, 188, 181, 178, 175, 172, 169, 166, 163, 160, 157, 154, 151, 146, 141, 136, 131, 126};
        item[3].setRules(0, 1, item[3].getLevelNum(), longJumpStandard01, longJumpMark);
        double longJumpStandard11[] = {207, 201, 195, 188, 181, 178, 175, 172, 169, 166, 163, 160, 157, 154, 151, 146, 141, 136, 131, 126};
        item[3].setRules(1, 1, item[3].getLevelNum(), longJumpStandard11, longJumpMark);
        double longJumpStandard21[] = {208, 202, 196, 189, 182, 179, 176, 173, 170, 167, 164, 161, 158, 155, 152, 147, 142, 137, 132, 127};
        item[3].setRules(2, 1, item[3].getLevelNum(), longJumpStandard21, longJumpMark);
        double longJumpStandard31[] = {208, 202, 196, 189, 182, 179, 176, 173, 170, 167, 164, 161, 158, 155, 152, 147, 142, 137, 132, 127};
        item[3].setRules(3, 1, item[3].getLevelNum(), longJumpStandard31, longJumpMark);

        /**
         * sitAndReach
		 * 坐位体前屈
         */
        item[4].setItemName("sitAndReach");
        item[4].setLevelNum(20);
        double sitAndReachMark[] = {100, 95, 90, 85, 80, 78, 76, 74, 72, 70, 68, 66, 64, 62, 60, 50, 40, 30, 20, 10, 10};//评分
		//男
        double sitAndReachStandard00[] = {24.9, 23.1, 21.3, 19.5, 17.7, 16.3, 14.9, 13.5, 12.1, 10.7, 9.3, 7.9, 6.5, 5.1, 3.7, 2.7, 1.7, 0.7, -0.3, -1.3};
        item[4].setRules(0, 0, item[4].getLevelNum(), sitAndReachStandard00, sitAndReachMark);
        double sitAndReachStandard10[] = {24.9, 23.1, 21.3, 19.5, 17.7, 16.3, 14.9, 13.5, 12.1, 10.7, 9.3, 7.9, 6.5, 5.1, 3.7, 2.7, 1.7, 0.7, -0.3, -1.3};
        item[4].setRules(1, 0, item[4].getLevelNum(), sitAndReachStandard10, sitAndReachMark);
        double sitAndReachStandard20[] = {25.1, 23.3, 21.5, 19.9, 18.2, 16.8, 15.4, 14.0, 12.6, 11.2, 9.8, 8.4, 7.0, 5.6, 4.2, 3.2, 2.2, 1.2, 0.2, -0.8};
        item[4].setRules(2, 0, item[4].getLevelNum(), sitAndReachStandard20, sitAndReachMark);
        double sitAndReachStandard30[] = {25.1, 23.3, 21.5, 19.9, 18.2, 16.8, 15.4, 14.0, 12.6, 11.2, 9.8, 8.4, 7.0, 5.6, 4.2, 3.2, 2.2, 1.2, 0.2, -0.8};
        item[4].setRules(3, 0, item[4].getLevelNum(), sitAndReachStandard30, sitAndReachMark);

        //女
        double sitAndReachStandard01[] = {25.8, 24.0, 22.2, 20.6, 19.0, 17.7, 16.4, 15.1, 13.8, 12.5, 11.2, 9.9, 8.6, 7.3, 6.0, 5.2, 4.4, 3.6, 2.8, 2.0};
        item[4].setRules(0, 1, item[4].getLevelNum(), sitAndReachStandard01, sitAndReachMark);
        double sitAndReachStandard11[] = {25.8, 24.0, 22.2, 20.6, 19.0, 17.7, 16.4, 15.1, 13.8, 12.5, 11.2, 9.9, 8.6, 7.3, 6.0, 5.2, 4.4, 3.6, 2.8, 2.0};
        item[4].setRules(1, 1, item[4].getLevelNum(), sitAndReachStandard11, sitAndReachMark);
        double sitAndReachStandard21[] = {26.3, 24.4, 22.4, 21.0, 19.5, 18.2, 16.9, 15.6, 14.3, 13.0, 11.7, 10.4, 9.1, 7.8, 6.5, 5.7, 4.9, 4.1, 3.3, 2.5};
        item[4].setRules(2, 1, item[4].getLevelNum(), sitAndReachStandard21, sitAndReachMark);
        double sitAndReachStandard31[] = {26.3, 24.4, 22.4, 21.0, 19.5, 18.2, 16.9, 15.6, 14.3, 13.0, 11.7, 10.4, 9.1, 7.8, 6.5, 5.7, 4.9, 4.1, 3.3, 2.5};
        item[4].setRules(3, 1, item[4].getLevelNum(), sitAndReachStandard31, sitAndReachMark);

        /**
         * longRuning 
		 * 长跑
         */
        item[5].setItemName("longRuning");
        item[5].setLevelNum(20);
        double longRuningMark[] = {100, 95, 90, 85, 80, 78, 76, 74, 72, 70, 68, 66, 64, 62, 60, 50, 40, 30, 20, 10, 10};//评分
		//男
        double longRuningStandard00[] = {-3.17, -3.22, -3.27, -3.34, -3.42, -3.47, -3.52, -3.57, -4.02, -4.07, -4.12, -4.17, -4.22, -4.27, -4.32, -4.52, -5.12, -5.32, -5.52, -6.12};
        item[5].setRules(0, 0, item[5].getLevelNum(), longRuningStandard00, longRuningMark);
        double longRuningStandard10[] = {-3.17, -3.22, -3.27, -3.34, -3.42, -3.47, -3.52, -3.57, -4.02, -4.07, -4.12, -4.17, -4.22, -4.27, -4.32, -4.52, -5.12, -5.32, -5.52, -6.12};
        item[5].setRules(1, 0, item[5].getLevelNum(), longRuningStandard10, longRuningMark);
        double longRuningStandard20[] = {-3.15, -3.20, -3.25, -3.32, -3.40, -3.45, -3.50, -3.55, -4.00, -4.05, -4.10, -4.15, -4.20, -4.25, -4.30, -4.50, -5.10, -5.30, -5.50, -6.10};
        item[5].setRules(2, 0, item[5].getLevelNum(), longRuningStandard20, longRuningMark);
        double longRuningStandard30[] = {-3.15, -3.20, -3.25, -3.32, -3.40, -3.45, -3.50, -3.55, -4.00, -4.05, -4.10, -4.15, -4.20, -4.25, -4.30, -4.50, -5.10, -5.30, -5.50, -6.10};
        item[5].setRules(3, 0, item[5].getLevelNum(), longRuningStandard30, longRuningMark);

        //女
        double longRuningStandard01[] = {-3.18, -3.24, -3.30, -3.37, -3.44, -3.49, -3.54, -3.59, -4.04, -4.09, -4.14, -4.19, -4.24, -4.29, -4.34, -4.44, -4.54, -5.04, -5.14, -5.24};
        item[5].setRules(0, 1, item[5].getLevelNum(), longRuningStandard01, longRuningMark);
        double longRuningStandard11[] = {-3.18, -3.24, -3.30, -3.37, -3.44, -3.49, -3.54, -3.59, -4.04, -4.09, -4.14, -4.19, -4.24, -4.29, -4.34, -4.44, -4.54, -5.04, -5.14, -5.24};
        item[5].setRules(1, 1, item[5].getLevelNum(), longRuningStandard11, longRuningMark);
        double longRuningStandard21[] = {-3.16, -3.22, -3.28, -3.35, -3.42, -3.47, -3.52, -3.57, -4.02, -4.07, -4.12, -4.17, -4.22, -4.27, -4.32, -4.42, -4.52, -5.02, -5.12, -5.22};
        item[5].setRules(2, 1, item[5].getLevelNum(), longRuningStandard21, longRuningMark);
        double longRuningStandard31[] = {-3.16, -3.22, -3.28, -3.35, -3.42, -3.47, -3.52, -3.57, -4.02, -4.07, -4.12, -4.17, -4.22, -4.27, -4.32, -4.42, -4.52, -5.02, -5.12, -5.22};
        item[5].setRules(3, 1, item[5].getLevelNum(), longRuningStandard31, longRuningMark);

        /**
         * upOrDown
		 * 引体向上，仰卧起坐
         */
        item[6].setItemName("upOrDown");
        item[6].setLevelNum(20);
        double upOrDownMark[] = {100, 95, 90, 85, 80, 78, 76, 74, 72, 70, 68, 66, 64, 62, 60, 50, 40, 30, 20, 10, 10};//评分
		//男
        double upOrDownStandard00[] = {19, 18, 17, 16, 15, 15, 14, 14, 13, 13, 12, 12, 11, 11, 10, 9, 8, 7, 6, 5};
        item[6].setRules(0, 0, item[6].getLevelNum(), upOrDownStandard00, upOrDownMark);
        double upOrDownStandard10[] = {19, 18, 17, 16, 15, 15, 14, 14, 13, 13, 12, 12, 11, 11, 10, 9, 8, 7, 6, 5};
        item[6].setRules(1, 0, item[6].getLevelNum(), upOrDownStandard10, upOrDownMark);
        double upOrDownStandard20[] = {20, 19, 18, 17, 16, 16, 15, 15, 14, 14, 13, 13, 12, 12, 11, 10, 9, 8, 7, 6};
        item[6].setRules(2, 0, item[6].getLevelNum(), upOrDownStandard20, upOrDownMark);
        double upOrDownStandard30[] = {20, 19, 18, 17, 16, 16, 15, 15, 14, 14, 13, 13, 12, 12, 11, 10, 9, 8, 7, 6};
        item[6].setRules(3, 0, item[6].getLevelNum(), upOrDownStandard30, upOrDownMark);

        //女
        double upOrDownStandard01[] = {56, 54, 52, 49, 46, 44, 42, 40, 38, 36, 34, 32, 30, 28, 26, 24, 22, 20, 18, 16};
        item[6].setRules(0, 1, item[6].getLevelNum(), upOrDownStandard01, upOrDownMark);
        double upOrDownStandard11[] = {56, 54, 52, 49, 46, 44, 42, 40, 38, 36, 34, 32, 30, 28, 26, 24, 22, 20, 18, 16};
        item[6].setRules(1, 1, item[6].getLevelNum(), upOrDownStandard11, upOrDownMark);
        double upOrDownStandard21[] = {57, 55, 53, 50, 47, 45, 43, 41, 39, 37, 35, 33, 31, 29, 27, 25, 23, 21, 19, 17};
        item[6].setRules(2, 1, item[6].getLevelNum(), upOrDownStandard21, upOrDownMark);
        double upOrDownStandard31[] = {57, 55, 53, 50, 47, 45, 43, 41, 39, 37, 35, 33, 31, 29, 27, 25, 23, 21, 19, 17};
        item[6].setRules(3, 1, item[6].getLevelNum(), upOrDownStandard31, upOrDownMark);
        
        /**
         * upOrDownExtra
		 * 引体向上，仰卧起坐 加分
         */
        item[7].setItemName("upOrDownExtra");
        item[7].setLevelNum(10);
        double upOrDownExtraMark[] = {10,9,8,7,6,5,4,3,2,1,0};//评分
		//男
        double upOrDownExtraStandard00[] = {10,9,8,7,6,5,4,3,2,1};
        item[7].setRules(0, 0, item[7].getLevelNum(), upOrDownExtraStandard00, upOrDownExtraMark);
        double upOrDownExtraStandard10[] = {10,9,8,7,6,5,4,3,2,1};
        item[7].setRules(1, 0, item[7].getLevelNum(), upOrDownExtraStandard10, upOrDownExtraMark);
        double upOrDownExtraStandard20[] = {10,9,8,7,6,5,4,3,2,1};
        item[7].setRules(2, 0, item[7].getLevelNum(), upOrDownExtraStandard20, upOrDownExtraMark);
        double upOrDownExtraStandard30[] = {10,9,8,7,6,5,4,3,2,1};
        item[7].setRules(3, 0, item[7].getLevelNum(), upOrDownExtraStandard30, upOrDownExtraMark);

        //女
        double upOrDownExtraStandard01[] = {13,12,11,10,9,8,7,6,4,2};
        item[7].setRules(0, 1, item[7].getLevelNum(), upOrDownExtraStandard01, upOrDownExtraMark);
        double upOrDownExtraStandard11[] = {13,12,11,10,9,8,7,6,4,2};
        item[7].setRules(1, 1, item[7].getLevelNum(), upOrDownExtraStandard11, upOrDownExtraMark);
        double upOrDownExtraStandard21[] = {13,12,11,10,9,8,7,6,4,2};
        item[7].setRules(2, 1, item[7].getLevelNum(), upOrDownExtraStandard21, upOrDownExtraMark);
        double upOrDownExtraStandard31[] = {13,12,11,10,9,8,7,6,4,2};
        item[7].setRules(3, 1, item[7].getLevelNum(), upOrDownExtraStandard31, upOrDownExtraMark);
        
        /**
         * longRuningExtra
		 * 耐力跑加分
         */
        item[8].setItemName("longRuningExtra");
        item[8].setLevelNum(10);
        double longRuningExtraMark[] = {10,9,8,7,6,5,4,3,2,1,0};//评分
		//男
        double longRuningExtraStandard00[] = {35,32,29,26,23,20,16,12,8,4};
        item[8].setRules(0, 0, item[8].getLevelNum(), longRuningExtraStandard00, longRuningExtraMark);
        double longRuningExtraStandard10[] = {35,32,29,26,23,20,16,12,8,4};
        item[8].setRules(1, 0, item[8].getLevelNum(), longRuningExtraStandard10, longRuningExtraMark);
        double longRuningExtraStandard20[] = {35,32,29,26,23,20,16,12,8,4};
        item[8].setRules(2, 0, item[8].getLevelNum(), longRuningExtraStandard20, longRuningExtraMark);
        double longRuningExtraStandard30[] = {35,32,29,26,23,20,16,12,8,4};
        item[8].setRules(3, 0, item[8].getLevelNum(), longRuningExtraStandard30, longRuningExtraMark);

        //女
        double longRuningExtraStandard01[] = {50,45,40,35,30,25,20,15,10,5};
        item[8].setRules(0, 1, item[8].getLevelNum(), longRuningExtraStandard01, longRuningExtraMark);
        double longRuningExtraStandard11[] = {50,45,40,35,30,25,20,15,10,5};
        item[8].setRules(1, 1, item[8].getLevelNum(), longRuningExtraStandard11, longRuningExtraMark);
        double longRuningExtraStandard21[] = {50,45,40,35,30,25,20,15,10,5};
        item[8].setRules(2, 1, item[8].getLevelNum(), longRuningExtraStandard21, longRuningExtraMark);
        double longRuningExtraStandard31[] = {50,45,40,35,30,25,20,15,10,5};
        item[8].setRules(3, 1, item[8].getLevelNum(), longRuningExtraStandard31, longRuningExtraMark);
    }
    /**
     * 读取excel中的数据并存储到student中
     * @param student
     * @param inAddress
     * @throws FileNotFoundException
     * @throws IOException
     * @throws BiffException 
     */
    void doData(University university, String inAddress,String outAddress,SportItem item[]) throws FileNotFoundException, IOException, BiffException, WriteException {
        Student student[] = university.student;
        /**
         * 操作excel
         */
        InputStream fileAddress = new FileInputStream(inAddress);
        book = Workbook.getWorkbook(fileAddress);
        fileAddress.close();
        sheet = book.getSheet(0);
        int ROWS = sheet.getRows();
        int currentGrade = 0;
        int sex = 0;
        double height = 0;
        double weight = 0;
        double spiroIndex = 0;
        double fiftyMeters = 0;
        double longJump = 0;
        double sitAndReach = 0;
        double eightHundredRuning = 0;
        double oneThousandRuning = 0;
        double upOrDown = 0;
        double pullUp = 0;
        
        OutputStream writefileAddress = new FileOutputStream(outAddress);
        WorkbookSettings settings = new WorkbookSettings ();  
        //settings.setWriteAccess("");
        wtbook = Workbook.createWorkbook(writefileAddress, this.book, settings);
        //WritableWorkbook wtbook = Workbook.createWorkbook(writefileAddress, book);
        //WritableSheet outsheet = wtbook.createSheet("1651616", 0);
        outsheet = wtbook.getSheet(0);  
        //outsheet.getSettings().setSelected(true); 
        
        Label tempMark;
        outsheet.insertColumn(15);
        tempMark = new Label(15, 0, "总分等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(15);
        tempMark = new Label(15, 0, "总分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(15);
        tempMark = new Label(15, 0, "标准分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(15);
        tempMark = new Label(15, 0, "引体向上附加分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(15);
        tempMark = new Label(15, 0, "引体向上等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(15);
        tempMark = new Label(15, 0, "引体向上评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(14);
        tempMark = new Label(14, 0, "一分钟仰卧起坐附加分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(14);
        tempMark = new Label(14, 0, "一分钟仰卧起坐等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(14);
        tempMark = new Label(14, 0, "一分钟仰卧起坐评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(13);
        tempMark = new Label(13, 0, "1000米跑附加分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(13);
        tempMark = new Label(13, 0, "1000米跑等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(13);
        tempMark = new Label(13, 0, "1000米跑评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(12);
        tempMark = new Label(12, 0, "800米跑附加分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(12);
        tempMark = new Label(12, 0, "800米跑等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(12);
        tempMark = new Label(12, 0, "800米跑评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(11);
        tempMark = new Label(11, 0, "坐位体前屈等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(11);
        tempMark = new Label(11, 0, "坐位体前屈评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(10);
        tempMark = new Label(10, 0, "立定跳远等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(10);
        tempMark = new Label(10, 0, "立定跳远评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(9);
        tempMark = new Label(9, 0, "50米跑等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(9);
        tempMark = new Label(9, 0, "50米跑评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(8);
        tempMark = new Label(8, 0, "肺活量等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(8);
        tempMark = new Label(8, 0, "肺活量评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(7);
        tempMark = new Label(7, 0, "体重等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(7);
        tempMark = new Label(7, 0, "体重评分");
        outsheet.addCell(tempMark);
        
        jxl.write.Number bMIMark;
        Label bMIEvaluate;
        jxl.write.Number spiroIndexMark;
        Label spiroIndexEvaluate;
        jxl.write.Number fiftyMetersMark;
        Label fiftyMetersEvaluate; 
        jxl.write.Number longJumpMark;
        Label longJumpEvaluate;
        jxl.write.Number sitAndReachMark;
        Label sitAndReachEvaluate;
        jxl.write.Number oneThousandRuningExtraMark;
        jxl.write.Number eightHundredRuningExtraMark;
        jxl.write.Number oneThousandRuningMark;
        Label oneThousandRuningEvaluate;
        jxl.write.Number eightHundredRuningMark;
        Label eightHundredRuningEvaluate;
        jxl.write.Number pullUpMark;
        Label pullUpEvaluate;
        jxl.write.Number pullUpExtraMark;
        jxl.write.Number upOrDownMark;
        Label upOrDownEvaluate;
        jxl.write.Number upOrDownExtraMark;
        jxl.write.Number finalStandardMark;
        jxl.write.Number finalMark;
        Label finalEvaluate;
        //<editor-fold defaultstate="collapsed" desc="处理信息"> 
        for (int i = 1; i < ROWS; i++) {
            System.out.println(ROWS);
            student[i - 1] = new Student();
            Cell cellCurrentGrade = sheet.getCell(0, i);
            Cell cellSex = sheet.getCell(2, i);
            
            
            switch (cellSex.getContents()) {
                case "男":
                    sex = 0;
                    break;
                case "1":
                    sex = 0;
                    break;
                case "女":
                    sex = 1;
                    break;
                case "2":
                    sex = 1;
                    break;
                default:
                    break;
            }
            student[i-1].setSex(sex);
            System.out.println(i);
            switch (Integer.valueOf(cellCurrentGrade.getContents())) {
                case 41:
                    currentGrade = 0;
                    break;
                case 42:
                    currentGrade = 1;
                    break;
                case 43:
                    currentGrade = 2;
                    break;
                case 44:
                    currentGrade = 3;
                    break;
                default:
                    break;
            }
            
            //</editor-fold>
            
            Cell cellHeight = sheet.getCell(5, i);
            Cell cellWeight = sheet.getCell(6, i);
            Cell cellSpiroIndex = sheet.getCell(7, i);
            Cell cellFiftyMeters = sheet.getCell(8, i);
            Cell cellLongJump = sheet.getCell(9, i);
            Cell cellSitAndReach = sheet.getCell(10, i);
            Cell cellEightHundredRuning = sheet.getCell(11, i);
            Cell cellOneThousandRuning = sheet.getCell(12, i);
            Cell cellUpOrDown = sheet.getCell(13, i);
            Cell cellPullUp = sheet.getCell(14, i);
            
            //<editor-fold defaultstate="collapsed" desc="设置基本属性">\
            if(!"".equals(cellHeight.getContents()))
                height = Double.valueOf(cellHeight.getContents()) / 100;
            if(!"".equals(cellWeight.getContents()))
                weight = Double.valueOf(cellWeight.getContents());
            if(!"".equals(cellSpiroIndex.getContents()))
                spiroIndex = Double.valueOf(cellSpiroIndex.getContents());
            if(!"".equals(cellFiftyMeters.getContents()) && !" ".equals(cellFiftyMeters.getContents())){
                fiftyMeters = -Double.valueOf(cellFiftyMeters.getContents());//负数存储
            }
            if(!"".equals(cellLongJump.getContents()))
                longJump = Double.valueOf(cellLongJump.getContents());
            if(!"".equals(cellSitAndReach.getContents()))
                sitAndReach = Double.valueOf(cellSitAndReach.getContents());
            switch (sex) {
                case 0:
                    if(!"".equals(cellOneThousandRuning.getContents()) && !"0".equals(cellOneThousandRuning.getContents()) 
                            && !"中退".equals(cellOneThousandRuning.getContents())&& !" ".equals(cellOneThousandRuning.getContents())){
                        if(cellOneThousandRuning.getContents().contains(".."))
                            oneThousandRuning = -Double.valueOf(cellOneThousandRuning.getContents().replace("..", "."));//负数存储
                        else
                            oneThousandRuning = -Double.valueOf(cellOneThousandRuning.getContents());//负数存储
                    }
                    break;
                case 1:
                    if(!"".equals(cellEightHundredRuning.getContents()) && !"0".equals(cellEightHundredRuning.getContents()) 
                            && !"中退".equals(cellEightHundredRuning.getContents()) && !" ".equals(cellEightHundredRuning.getContents())){
                        eightHundredRuning = -Double.valueOf(cellEightHundredRuning.getContents());//负数存储
                    }
                    break;
                default:
                    break;
            }
            switch (sex) {
                case 0:
                    if(!"".equals(cellPullUp.getContents()))
                        pullUp = Double.valueOf(cellPullUp.getContents());
                    break;
                case 1:
                    if(!"".equals(cellUpOrDown.getContents()))
                        upOrDown = Double.valueOf(cellUpOrDown.getContents());
                    break;
                default:
                    break;
            }
            student[i - 1].setScore( height, weight, spiroIndex, fiftyMeters, longJump, sitAndReach, eightHundredRuning, oneThousandRuning, upOrDown, pullUp);
            //</editor-fold>
            if(!"".equals(cellHeight.getContents()) && !"".equals(cellWeight.getContents()))
                 student[i - 1].setbMIMark(item[0].calculate(student[i - 1].getCurrentGrade(), sex, student[i - 1].getbMI()));
            if(!"".equals(cellSpiroIndex.getContents()))
                student[i - 1].setSpiroIndexMark(item[1].calculate(student[i - 1].getCurrentGrade(), sex, student[i - 1].getSpiroIndex()));
            if(!"".equals(cellFiftyMeters.getContents()))
                student[i - 1].setFiftyMetersMark(item[2].calculate(student[i - 1].getCurrentGrade(), sex, student[i - 1].getFiftyMeters()));
            if(!"".equals(cellLongJump.getContents()))
                student[i - 1].setLongJumpMark(item[3].calculate(student[i - 1].getCurrentGrade(), sex, student[i - 1].getLongJump()));
            if(!"".equals(cellSitAndReach.getContents()))
                student[i - 1].setSitAndReachMark(item[4].calculate(student[i - 1].getCurrentGrade(), sex, student[i - 1].getSitAndReach()));
            
            double stand,score;
            stand =item[5].rules[student[i-1].getCurrentGrade()][student[i-1].getSex()].getStandard()[0];
            stand = (int)(-stand)*60 + (int)(-stand*100)%100;
            switch (sex) {
                case 0:
                    if(!"".equals(cellOneThousandRuning.getContents()))
                       student[i - 1].setOneThousandRuningMark(item[5].calculate(student[i - 1].getCurrentGrade(), sex, student[i - 1].getOneThousandRuning()));
                    score = student[i-1].getOneThousandRuning();
                    score = (int)(-score)*60 + (int)(-score*100)%100;
                    if(!"".equals(cellOneThousandRuning.getContents()))
                       student[i - 1].setOneThousandRuningExtraMark(item[8].calculate(student[i - 1].getCurrentGrade(), sex, stand-score));
                    break;
                case 1:
                    if(!"".equals(cellEightHundredRuning.getContents()))
                        student[i - 1].setEightHundredRuningMark(item[5].calculate(student[i - 1].getCurrentGrade(), sex, student[i - 1].getEightHundredRuning()));
                    score =student[i-1].getEightHundredRuning();
                    score = (int)(-score)*60 + (int)(-score*100)%100;
                    if(!"".equals(cellEightHundredRuning.getContents()))
                        student[i - 1].setEightHundredRuningExtraMark(item[8].calculate(student[i - 1].getCurrentGrade(), sex, stand-score));
                    break;
                default:
                    break;
            }
            
            stand =item[6].rules[student[i - 1].getCurrentGrade()][sex].getStandard()[0];
            switch (sex) {
                case 0:
                    if(!"".equals(cellPullUp.getContents()))
                        student[i - 1].setPullUpMark(item[6].calculate(student[i - 1].getCurrentGrade(), sex, student[i - 1].getPullUp()));
                    score =  student[i - 1].getPullUp();
                    if(!"".equals(cellPullUp.getContents()))
                        student[i - 1].setPullUpExtraMark(item[7].calculate(student[i - 1].getCurrentGrade(), sex,score-stand ));
                    break;
                case 1:
                    if(!"".equals(cellUpOrDown.getContents()))
                        student[i - 1].setUpOrDownMark(item[6].calculate(student[i - 1].getCurrentGrade(), sex, student[i - 1].getUpOrDown()));
                    score = student[i - 1].getUpOrDown();
                    if(!"".equals(cellUpOrDown.getContents()))
                        student[i - 1].setUpOrDownExtraMark(item[7].calculate(student[i - 1].getCurrentGrade(), sex,score-stand ));
                    break;
                default:
                    break;
            }
            /*if(!"".equals(cellHeight.getContents()) && !"".equals(cellWeight.getContents()) && !"".equals(cellSpiroIndex.getContents()) &&
                    !"".equals(cellFiftyMeters.getContents()) && !"".equals(cellLongJump.getContents()) && !"".equals(cellSitAndReach.getContents()) &&
                    !"".equals(cellOneThousandRuning.getContents()) && !"".equals(cellEightHundredRuning.getContents())
                    && !"".equals(cellPullUp.getContents()) && !"".equals(cellUpOrDown.getContents())){*/
            if(true){
                student[i - 1].setFinalMark();
                student[i - 1].evaluate();
            }
            /**
             * 写入excel
             */
            //address = input.next();
            //jxl.write.NumberFormat nf = new jxl.write.NumberFormat("####.##");    //设置数字格式
            //jxl.write.WritableCellFormat wcfN = new jxl.write.WritableCellFormat(nf); //设置表单格式   
            //jxl.write.Number bMIMark = new jxl.write.Number(11, i, student[i - 1].getbMIMark(),wcfN);
            if(!"".equals(cellHeight.getContents()) && !"".equals(cellWeight.getContents())){
                bMIMark = new jxl.write.Number(7, i, student[i - 1].getbMIMark());
                outsheet.addCell(bMIMark);
                bMIEvaluate = new Label(8, i, student[i - 1].getbMIEvaluate());
                outsheet.addCell(bMIEvaluate);
            }
            
            if(!"".equals(cellSpiroIndex.getContents())){
                spiroIndexMark = new jxl.write.Number(10, i, student[i - 1].getSpiroIndexMark());
                outsheet.addCell(spiroIndexMark);
                spiroIndexEvaluate = new Label(11, i, student[i - 1].getSpiroIndexEvaluate());
                outsheet.addCell(spiroIndexEvaluate);
            }
                
            if(!"".equals(cellFiftyMeters.getContents())){
                fiftyMetersMark = new jxl.write.Number(13, i, student[i - 1].getFiftyMetersMark());
                outsheet.addCell(fiftyMetersMark);
                fiftyMetersEvaluate = new Label(14, i, student[i - 1].getFiftyMetersEvaluate());
                outsheet.addCell(fiftyMetersEvaluate);
            }    
                
            if(!"".equals(cellLongJump.getContents())){
                longJumpMark = new jxl.write.Number(16, i, student[i - 1].getLongJumpMark());
                outsheet.addCell(longJumpMark);
                longJumpEvaluate = new Label(17, i, student[i - 1].getLongJumpEvaluate());
                outsheet.addCell(longJumpEvaluate);
            }
                
            if(!"".equals(cellSitAndReach.getContents())){
                sitAndReachMark = new jxl.write.Number(19, i, student[i - 1].getSitAndReachMark());
                outsheet.addCell(sitAndReachMark);
                sitAndReachEvaluate = new Label(20, i, student[i - 1].getSitAndReachEvaluate());
                outsheet.addCell(sitAndReachEvaluate);
            }
                
            if(!"".equals(cellEightHundredRuning.getContents()) || !"".equals(cellOneThousandRuning.getContents())){
                switch (sex) {
                    case 0:
                        oneThousandRuningMark = new jxl.write.Number(26, i, student[i - 1].getOneThousandRuningMark());
                        outsheet.addCell(oneThousandRuningMark);
                        oneThousandRuningEvaluate = new Label(27, i, student[i - 1].getOneThousandRuningEvaluate());
                        outsheet.addCell(oneThousandRuningEvaluate);
                        if(student[i - 1].getOneThousandRuningExtraMark() != 0){
                            oneThousandRuningExtraMark = new jxl.write.Number(28, i, student[i - 1].getOneThousandRuningExtraMark());
                            outsheet.addCell(oneThousandRuningExtraMark);
                        }
                        break;
                    case 1:
                        eightHundredRuningMark = new jxl.write.Number(22, i, student[i - 1].getEightHundredRuningMark());
                        outsheet.addCell(eightHundredRuningMark);
                        eightHundredRuningEvaluate = new Label(23, i, student[i - 1].getEightHundredRuningEvaluate());
                        outsheet.addCell(eightHundredRuningEvaluate);
                        if(student[i - 1].getEightHundredRuningExtraMark() != 0){
                            eightHundredRuningExtraMark = new jxl.write.Number(24, i, student[i - 1].getEightHundredRuningExtraMark());
                            outsheet.addCell(eightHundredRuningExtraMark);
                        }
                        break;
                    default:
                        break;
                }
            }
            
            if(!"".equals(cellUpOrDown.getContents()) || !"".equals(cellPullUp.getContents())){
                switch (sex) {
                    case 0:
                        pullUpMark = new jxl.write.Number(34, i, student[i - 1].getPullUpMark());
                        outsheet.addCell(pullUpMark);
                        pullUpEvaluate = new Label(35, i, student[i - 1].getPullUpEvaluate());
                        outsheet.addCell(pullUpEvaluate);
                        if(student[i - 1].getPullUpExtraMark() != 0){
                            pullUpExtraMark = new jxl.write.Number(36, i, student[i - 1].getPullUpExtraMark());
                            outsheet.addCell(pullUpExtraMark);
                        }
                        break;
                    case 1:
                        upOrDownMark = new jxl.write.Number(30, i, student[i - 1].getUpOrDownMark());
                        outsheet.addCell(upOrDownMark);
                        upOrDownEvaluate = new Label(31, i, student[i - 1].getUpOrDownEvaluate());
                        outsheet.addCell(upOrDownEvaluate);
                        if(student[i - 1].getUpOrDownExtraMark() != 0){
                            upOrDownExtraMark = new jxl.write.Number(32, i, student[i - 1].getUpOrDownExtraMark());
                            outsheet.addCell(upOrDownExtraMark);
                        }
                        break;
                    default:
                        break;
                }
            }
            if(student[i-1].ok()){
                finalStandardMark = new jxl.write.Number(37, i, student[i - 1].getFinalStandandMark());
                outsheet.addCell(finalStandardMark);
                finalMark = new jxl.write.Number(38, i, student[i - 1].getFinalTotalMark());
                outsheet.addCell(finalMark);
                finalEvaluate = new Label(39, i, student[i - 1].getFinalEvaluate());
                outsheet.addCell(finalEvaluate);
            }
            
        }
        ROWS = outsheet.getRows();
        System.out.println(ROWS);
        if(wtbook!= null)
            wtbook.write();
        wtbook.close();
        writefileAddress.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pescorecalculate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author HQ-Alien
 */
public class WriteData {;
    WritableWorkbook wtbook;
    WritableSheet outsheet;
    jxl.write.Number number;
    Label label;
    
    int currentGrade = 4;
    int excellentNum[] = new int[4];
    int goodNum[] = new int[4];
    int passNum[] = new int[4];
    int failedNum[] = new int[4];
    int viaNum[] = new int[4];
    int unTestNum[] = new int[4];
    int totalExcellentNum = 0;
    int totalGoodNum = 0;
    int totalPassNum = 0;
    int totalFailedNum = 0;
    int totalViaNum = 0;
    int totalUnTestNum = 0;
    int totalGradeNum = 0;
    int totalNum = 0;
    
    int MCexcellentNum = 0;
    int MCgoodNum = 0;
    int MCpassNum = 0;
    int MCfailedNum = 0;
    int MCviaNum = 0;
    int MCunTestNum = 0;
    
    DecimalFormat df = new DecimalFormat("####0");
    
    public void start(int type, Object object,Object filter) throws IOException, FileNotFoundException, WriteException{
        /**
         * 新建文件过滤器
         */
        FileFilter ffilter = new FileFilter(){
            @Override
            public boolean accept(File f) {
                if(f.toString().endsWith("xls")){
                 return true;
                }
                return f.isDirectory();
            }

            @Override
            public String getDescription() {
                return ".xls (03版Excel表格)";
            }
        };
        
        JFileChooser jfc = new JFileChooser();//新建打开窗口
        //jfc.setFileSelectionMode(FILES_AND_DIRECTORIES);
        jfc.setFileFilter(ffilter);
        String fileName = null;
        switch(type){
            case 0:
                if(((String)filter).equals("所有年级")){
                    fileName = ((University)object).toString()+"成绩分析";
                }else{
                    fileName = ((University)object).toString()+(String)filter+"级成绩分析";
                }
                break;
            case 1:
                if(((String)filter).equals("所有年级")){
                    fileName = ((College)object).toString()+"成绩分析";
                }else{
                    fileName = (String)filter+((College)object).toString()+"成绩分析";
                }
                break;
            case 2:
                if((filter).toString().equals("所有班级")){
                    fileName = ((Major)object).toString()+"成绩分析";
                }else{
                    fileName = ((Major)object).toString()+(filter).toString()+"成绩分析";
                }
                break;
        }
        jfc.setSelectedFile(new File(fileName));
        jfc.showSaveDialog(jfc);
        String strFile = null;
        if(jfc.getSelectedFile() != null){
            strFile =jfc.getSelectedFile().toString();
            String strDes = "";
            if(jfc.getFileFilter() != null){
                strDes = jfc.getFileFilter().getDescription();
                if(strDes != null)
                    if(!strDes.contains(" ")){
                        strDes = "";
                    }else{
                        strDes = strDes.substring(0, strDes.indexOf(" "));
                    }
            }
            if(!strFile.endsWith(".xls"))
                strFile += strDes;
        }
        switch(type){
            case 0:
                switch ((String)filter) {
                    case "所有年级":
                        currentGrade = 4;
                        break;
                    case "2011":
                        currentGrade = 3;
                        break;
                    case "2012":
                        currentGrade = 2;
                        break;
                    case "2013":
                        currentGrade = 1;
                        break;
                    case "2014":
                        currentGrade = 0;
                        break;
                }
                this.createSchoolFile((University)object, currentGrade, strFile);
                break;
            case 1:
                switch ((String)filter) {
                    case "所有年级":
                        currentGrade = 4;
                        break;
                    case "2011":
                        currentGrade = 3;
                        break;
                    case "2012":
                        currentGrade = 2;
                        break;
                    case "2013":
                        currentGrade = 1;
                        break;
                    case "2014":
                        currentGrade = 0;
                        break;
                }
                this.createCollegeFile((College)object, currentGrade, strFile);
                break;
            case 2:
                boolean isMajor;
                if((filter).toString().equals("所有班级")){
                    isMajor =true;
                    this.createMajorFile(isMajor,(Major)object, strFile);
                }else{
                    isMajor =false;
                    this.createMajorFile(isMajor,(Class)filter, strFile);
                }
                break;
            default:
                break;
        }
    }
    
    public void createMarkFile(Student student[], String outAddress) throws WriteException, FileNotFoundException, IOException{
        /**
         * 写入excel
         */
        /*
         //address = input.next();
         address = new String("C:/Users/HQ-Alien/Desktop/b.xls");
         */
        OutputStream writefileAddress = new FileOutputStream(outAddress);
        WorkbookSettings settings = new WorkbookSettings ();  
        //settings.setWriteAccess(null);
        wtbook = Workbook.createWorkbook(writefileAddress, settings);
        //wtbook = Workbook.createWorkbook(writefileAddress, this.book, settings);
        //WritableWorkbook wtbook = Workbook.createWorkbook(writefileAddress, book);
        //WritableSheet outsheet = wtbook.createSheet("1651616", 0);
        outsheet = wtbook.getSheet(0);  
        //outsheet.getSettings().setSelected(true); 
        
        Label tempMark;
        outsheet.insertColumn(19);
        tempMark = new Label(19, 0, "总分等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(19);
        tempMark = new Label(19, 0, "总分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(19);
        tempMark = new Label(19, 0, "标准分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(19);
        tempMark = new Label(19, 0, "引体向上附加分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(19);
        tempMark = new Label(19, 0, "引体向上等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(19);
        tempMark = new Label(19, 0, "引体向上评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(18);
        tempMark = new Label(18, 0, "一分钟仰卧起坐附加分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(18);
        tempMark = new Label(18, 0, "一分钟仰卧起坐等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(18);
        tempMark = new Label(18, 0, "一分钟仰卧起坐评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(17);
        tempMark = new Label(17, 0, "1000米跑附加分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(17);
        tempMark = new Label(17, 0, "1000米跑等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(17);
        tempMark = new Label(17, 0, "1000米跑评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(16);
        tempMark = new Label(16, 0, "800米跑附加分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(16);
        tempMark = new Label(16, 0, "800米跑等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(16);
        tempMark = new Label(16, 0, "800米跑评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(15);
        tempMark = new Label(15, 0, "坐位体前屈等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(15);
        tempMark = new Label(15, 0, "坐位体前屈评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(14);
        tempMark = new Label(14, 0, "立定跳远等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(14);
        tempMark = new Label(14, 0, "立定跳远评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(13);
        tempMark = new Label(13, 0, "50米跑等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(13);
        tempMark = new Label(13, 0, "50米跑评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(12);
        tempMark = new Label(12, 0, "肺活量等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(12);
        tempMark = new Label(12, 0, "肺活量评分");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(11);
        tempMark = new Label(11, 0, "体重等级");
        outsheet.addCell(tempMark);
        outsheet.insertColumn(11);
        tempMark = new Label(11, 0, "体重评分");
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
        
        //int ROWS = sheet.getRows();
        int ROWS = student[0].getUniversityBelong().getTotalNum();
        for (int i = 1; i < ROWS; i++) {
            if(!student[i - 1].isTestOrNot()){
                continue;
            }
            /**
             * 写入excel
             */
            //address = input.next();
            //jxl.write.NumberFormat nf = new jxl.write.NumberFormat("####.##");    //设置数字格式
            //jxl.write.WritableCellFormat wcfN = new jxl.write.WritableCellFormat(nf); //设置表单格式   
            //jxl.write.Number bMIMark = new jxl.write.Number(11, i, student[i - 1].getbMIMark(),wcfN);
            bMIMark = new jxl.write.Number(11, i, student[i - 1].getbMIMark());
            outsheet.addCell(bMIMark);
            bMIEvaluate = new Label(12, i, student[i - 1].getbMIEvaluate());
            outsheet.addCell(bMIEvaluate);

            spiroIndexMark = new jxl.write.Number(14, i, student[i - 1].getSpiroIndexMark());
            outsheet.addCell(spiroIndexMark);
            spiroIndexEvaluate = new Label(15, i, student[i - 1].getSpiroIndexEvaluate());
            outsheet.addCell(spiroIndexEvaluate);
            
            fiftyMetersMark = new jxl.write.Number(17, i, student[i - 1].getFiftyMetersMark());
            outsheet.addCell(fiftyMetersMark);
            fiftyMetersEvaluate = new Label(18, i, student[i - 1].getFiftyMetersEvaluate());
            outsheet.addCell(fiftyMetersEvaluate);

            longJumpMark = new jxl.write.Number(20, i, student[i - 1].getLongJumpMark());
            outsheet.addCell(longJumpMark);
            longJumpEvaluate = new Label(21, i, student[i - 1].getLongJumpEvaluate());
            outsheet.addCell(longJumpEvaluate);

            sitAndReachMark = new jxl.write.Number(23, i, student[i - 1].getSitAndReachMark());
            outsheet.addCell(sitAndReachMark);
            sitAndReachEvaluate = new Label(24, i, student[i - 1].getSitAndReachEvaluate());
            outsheet.addCell(sitAndReachEvaluate);

            
            switch (student[i - 1].getSex()) {
                case 0:
                    oneThousandRuningMark = new jxl.write.Number(30, i, student[i - 1].getOneThousandRuningMark());
                    outsheet.addCell(oneThousandRuningMark);
                    oneThousandRuningEvaluate = new Label(31, i, student[i - 1].getOneThousandRuningEvaluate());
                    outsheet.addCell(oneThousandRuningEvaluate);
                    if(student[i - 1].getOneThousandRuningExtraMark() != 0){
                        oneThousandRuningExtraMark = new jxl.write.Number(32, i, student[i - 1].getOneThousandRuningExtraMark());
                        outsheet.addCell(oneThousandRuningExtraMark);
                    }
                    break;
                case 1:
                    eightHundredRuningMark = new jxl.write.Number(26, i, student[i - 1].getEightHundredRuningMark());
                    outsheet.addCell(eightHundredRuningMark);
                    eightHundredRuningEvaluate = new Label(27, i, student[i - 1].getEightHundredRuningEvaluate());
                    outsheet.addCell(eightHundredRuningEvaluate);
                    if(student[i - 1].getEightHundredRuningExtraMark() != 0){
                        eightHundredRuningExtraMark = new jxl.write.Number(28, i, student[i - 1].getEightHundredRuningExtraMark());
                        outsheet.addCell(eightHundredRuningExtraMark);
                    }
                    break;
                default:
                    break;
            }
            
            switch (student[i - 1].getSex()) {
                case 0:
                    pullUpMark = new jxl.write.Number(38, i, student[i - 1].getPullUpMark());
                    outsheet.addCell(pullUpMark);
                    pullUpEvaluate = new Label(39, i, student[i - 1].getPullUpEvaluate());
                    outsheet.addCell(pullUpEvaluate);
                    if(student[i - 1].getPullUpExtraMark() != 0){
                        pullUpExtraMark = new jxl.write.Number(40, i, student[i - 1].getPullUpExtraMark());
                        outsheet.addCell(pullUpExtraMark);
                    }
                    break;
                case 1:
                    upOrDownMark = new jxl.write.Number(34, i, student[i - 1].getUpOrDownMark());
                    outsheet.addCell(upOrDownMark);
                    upOrDownEvaluate = new Label(35, i, student[i - 1].getUpOrDownEvaluate());
                    outsheet.addCell(upOrDownEvaluate);
                    if(student[i - 1].getUpOrDownExtraMark() != 0){
                        upOrDownExtraMark = new jxl.write.Number(36, i, student[i - 1].getUpOrDownExtraMark());
                        outsheet.addCell(upOrDownExtraMark);
                    }
                    break;
                default:
                    break;
            }

            finalStandardMark = new jxl.write.Number(41, i, student[i - 1].getFinalStandandMark());
            outsheet.addCell(finalStandardMark);
            finalMark = new jxl.write.Number(42, i, student[i - 1].getFinalTotalMark());
            outsheet.addCell(finalMark);
            finalEvaluate = new Label(43, i, student[i - 1].getFinalEvaluate());
            outsheet.addCell(finalEvaluate);
        }
        wtbook.write();
        wtbook.close();
        writefileAddress.close();
    }
    
    public void createSchoolFile(University university, int currentGrade, String outAddress) throws FileNotFoundException, IOException, WriteException{
        try ( 
            //currentGrade 0为大一，3为大四，4为所有年级
            OutputStream writefileAddress = new FileOutputStream(outAddress)) {
            WorkbookSettings settings = new WorkbookSettings ();
            wtbook = Workbook.createWorkbook(writefileAddress, settings);
            //outsheet = wtbook.getSheet(0);
            outsheet = wtbook.createSheet("sheet1", 0);
            
            double result[][] =new double[8][3];
            
            excellentNum = university.excellentNum;
            goodNum = university.goodNum;
            passNum = university.passNum;
            failedNum = university.failedNum;
            viaNum = university.viaNum;
            unTestNum = university.unTestNum;
            totalExcellentNum = university.getTotalExcellentNum();
            totalGoodNum = university.getTotalGoodNum();
            totalPassNum = university.getTotalPassNum();
            totalFailedNum = university.getTotalFailedNum();
            totalViaNum = university.getTotalViaNum();
            totalUnTestNum = university.getTotalUnTestNum();
            if(currentGrade<4)
                totalGradeNum = university.getTotalGradeNum(currentGrade);
            totalNum = university.getTotalNum();
            
            result[1][1] = (currentGrade ==  4)?totalExcellentNum:excellentNum[currentGrade];
            result[2][1] = (currentGrade ==  4)?totalGoodNum:goodNum[currentGrade];
            result[3][1] = (currentGrade ==  4)?totalPassNum:passNum[currentGrade];
            result[4][1] = (currentGrade ==  4)?totalFailedNum:failedNum[currentGrade];
            result[5][1] = (currentGrade ==  4)?totalUnTestNum:unTestNum[currentGrade];
            result[6][1] = (currentGrade ==  4)?totalViaNum:viaNum[currentGrade];
            result[7][1] = (currentGrade ==  4)?totalNum:totalGradeNum;
            result[1][2] = result[1][1] / result[7][1];
            result[2][2] = result[2][1] / result[7][1];
            result[3][2] = result[3][1] / result[7][1];
            result[4][2] = result[4][1] / result[7][1];
            result[5][2] = result[5][1] / result[7][1];
            result[6][2] = result[6][1] / result[7][1];
            result[7][2] = 1;
            if(result[7][1] == 0){
                for(int i = 1; i<=7; i ++){
                    result[i][2] = 0;
                }
            }
            label = new Label(0,0,university.toString()+"体测成绩分析");
            outsheet.addCell(label);
            outsheet.mergeCells(0, 0, 2, 0);
            label = new Label(0,2,"优秀");
            outsheet.addCell(label);
            label = new Label(0,3,"良好");
            outsheet.addCell(label);
            label = new Label(0,4,"及格");
            outsheet.addCell(label);
            label = new Label(0,5,"不及格");
            outsheet.addCell(label);
            label = new Label(0,6,"未测试");
            outsheet.addCell(label);
            label = new Label(0,7,"通过");
            outsheet.addCell(label);
            label = new Label(0,8,"总和");
            outsheet.addCell(label);
            label = new Label(1,1,"人数");
            outsheet.addCell(label);
            label = new Label(2,1,"比率");
            outsheet.addCell(label);
            
            for(int i =2; i<=8;i++){
                for(int j = 1; j<3;j++,df = new DecimalFormat("####0.00")){
                    number = new jxl.write.Number(j,i,Double.valueOf(df.format(result[i -1][j] + 0.000001)));
                    outsheet.addCell(number);
                }
            }
            wtbook.write();
            wtbook.close();
            writefileAddress.close();
        }
    }
    
    public void createCollegeFile(College college, int currentGrade, String outAddress) throws IOException, WriteException{
        try ( 
            //currentGrade 0为大一，3为大四，4为所有年级
            OutputStream writefileAddress = new FileOutputStream(outAddress)) {
            WorkbookSettings settings = new WorkbookSettings ();
            wtbook = Workbook.createWorkbook(writefileAddress, settings);
            //outsheet = wtbook.getSheet(0);
            outsheet = wtbook.createSheet("sheet1", 0);
            
            double result[][] =new double[8][3];
            
            excellentNum = college.excellentNum;
            goodNum = college.goodNum;
            passNum = college.passNum;
            failedNum = college.failedNum;
            viaNum = college.viaNum;
            unTestNum = college.unTestNum;
            totalExcellentNum = college.getTotalExcellentNum();
            totalGoodNum = college.getTotalGoodNum();
            totalPassNum = college.getTotalPassNum();
            totalFailedNum = college.getTotalFailedNum();
            totalViaNum = college.getTotalViaNum();
            totalUnTestNum = college.getTotalUnTestNum();
            if(currentGrade<4)
                totalGradeNum = college.getTotalGradeNum(currentGrade);
            totalNum = college.getTotalNum();
            
            result[1][1] = (currentGrade ==  4)?totalExcellentNum:excellentNum[currentGrade];
            result[2][1] = (currentGrade ==  4)?totalGoodNum:goodNum[currentGrade];
            result[3][1] = (currentGrade ==  4)?totalPassNum:passNum[currentGrade];
            result[4][1] = (currentGrade ==  4)?totalFailedNum:failedNum[currentGrade];
            result[5][1] = (currentGrade ==  4)?totalUnTestNum:unTestNum[currentGrade];
            result[6][1] = (currentGrade ==  4)?totalViaNum:viaNum[currentGrade];
            result[7][1] = (currentGrade ==  4)?totalNum:totalGradeNum;
            result[1][2] = result[1][1] / result[7][1];
            result[2][2] = result[2][1] / result[7][1];
            result[3][2] = result[3][1] / result[7][1];
            result[4][2] = result[4][1] / result[7][1];
            result[5][2] = result[5][1] / result[7][1];
            result[6][2] = result[6][1] / result[7][1];
            result[7][2] = 1;
            if(result[7][1] == 0){
                for(int i = 1; i<=7; i ++){
                    result[i][2] = 0;
                }
            }
            label = new Label(0,0,college.getUniversityBelong().toString()+college.toString()+"体测成绩分析");
            outsheet.addCell(label);
            outsheet.mergeCells(0, 0, 2, 0);
            label = new Label(0,2,"优秀");
            outsheet.addCell(label);
            label = new Label(0,3,"良好");
            outsheet.addCell(label);
            label = new Label(0,4,"及格");
            outsheet.addCell(label);
            label = new Label(0,5,"不及格");
            outsheet.addCell(label);
            label = new Label(0,6,"未测试");
            outsheet.addCell(label);
            label = new Label(0,7,"通过");
            outsheet.addCell(label);
            label = new Label(0,8,"总和");
            outsheet.addCell(label);
            label = new Label(1,1,"人数");
            outsheet.addCell(label);
            label = new Label(2,1,"比率");
            outsheet.addCell(label);
            
            for(int i =2; i<=8;i++){
                for(int j = 1; j<3;j++,df = new DecimalFormat("####0.00")){
                    number = new jxl.write.Number(j,i,Double.valueOf(df.format(result[i -1][j] + 0.000001)));
                    outsheet.addCell(number);
                }
            }
            wtbook.write();
            wtbook.close();
            writefileAddress.close();
        }
    }
    
    public void createMajorFile(boolean isMajor,Object object, String outAddress) throws IOException, WriteException{
        try ( 
            //currentGrade 0为大一，3为大四，4为所有年级
            OutputStream writefileAddress = new FileOutputStream(outAddress)) {
            WorkbookSettings settings = new WorkbookSettings ();
            wtbook = Workbook.createWorkbook(writefileAddress, settings);
            //outsheet = wtbook.getSheet(0);
            outsheet = wtbook.createSheet("sheet1", 0);
            Major major =null;
            Class classX = null;
            
            double result[][] =new double[8][3];
            
            if(isMajor){
                major =(Major)object;
                MCexcellentNum = major.excellentNum;
                MCgoodNum = major.goodNum;
                MCpassNum = major.passNum;
                MCfailedNum = major.failedNum;
                MCviaNum = major.viaNum;
                MCunTestNum = major.unTestNum;
                totalNum = major.getTotalNum();
            }else{
                classX =(Class)object;
                MCexcellentNum = classX.excellentNum;
                MCgoodNum = classX.goodNum;
                MCpassNum = classX.passNum;
                MCfailedNum = classX.failedNum;
                MCviaNum = classX.viaNum;
                MCunTestNum = classX.unTestNum;
                totalNum = classX.getTotalNum();
            }
            
            result[1][1] = MCexcellentNum;
            result[2][1] = MCgoodNum;
            result[3][1] = MCpassNum;
            result[4][1] = MCfailedNum;
            result[5][1] = MCunTestNum;
            result[6][1] = MCviaNum;
            result[7][1] = totalNum;
            result[1][2] = result[1][1] / result[7][1];
            result[2][2] = result[2][1] / result[7][1];
            result[3][2] = result[3][1] / result[7][1];
            result[4][2] = result[4][1] / result[7][1];
            result[5][2] = result[5][1] / result[7][1];
            result[6][2] = result[6][1] / result[7][1];
            result[7][2] = 1;
            if(result[7][1] == 0){
                for(int i = 1; i<=7; i ++){
                    result[i][2] = 0;
                }
            }
            if(isMajor){
                label = new Label(0,0,major.toString()+"体测成绩分析");
            }else{
                label = new Label(0,0,classX.getMajorBelong().toString()+classX.toString()+"体测成绩分析");
            }
            outsheet.addCell(label);
            outsheet.mergeCells(0, 0, 2, 0);
            label = new Label(0,2,"优秀");
            outsheet.addCell(label);
            label = new Label(0,3,"良好");
            outsheet.addCell(label);
            label = new Label(0,4,"及格");
            outsheet.addCell(label);
            label = new Label(0,5,"不及格");
            outsheet.addCell(label);
            label = new Label(0,6,"未测试");
            outsheet.addCell(label);
            label = new Label(0,7,"通过");
            outsheet.addCell(label);
            label = new Label(0,8,"总和");
            outsheet.addCell(label);
            label = new Label(1,1,"人数");
            outsheet.addCell(label);
            label = new Label(2,1,"比率");
            outsheet.addCell(label);
            
            for(int i =2; i<=8;i++){
                for(int j = 1; j<3;j++,df = new DecimalFormat("####0.00")){
                    number = new jxl.write.Number(j,i,Double.valueOf(df.format(result[i -1][j] + 0.000001)));
                    outsheet.addCell(number);
                }
            }
            wtbook.write();
            wtbook.close();
            writefileAddress.close();
        }
    }
    
    public void createClassFile(Class classX, String outAddress){
        
    }
}

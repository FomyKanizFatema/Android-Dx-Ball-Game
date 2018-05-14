package fomy.android.dxball;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class Stage {
	int numOfRow;
	int numOfColumn;
	Boolean brickExistance[][];
	String stage,stage1,stage2,stage3;
	Stage(){
		numOfRow=7;
		numOfColumn=13;
		//stage=Integer.toString(numOfRow)+Integer.toString(numOfColumn);
		stage1="all,brick1";
		stage2="prime,brick2";
		stage3="prime,brick3,odd,brick2";
	}
	
	public void setStageDesign(int numOfRow,int numOfColumn,String shape){
		if(shape.equals("Reactangle")){
			for(int i=0;i<numOfRow;i++){
				for(int j=0;j<numOfColumn;j++){
					brickExistance[i][j]=true;
				}
			}
		}
		
	}
	public void setStage1Content(String s){
		stage1=s;
	}
	public String getStage1Content(){
		return stage1;
	}
	public void setStage2Content(String s){
		stage2=s;
	}
	public String getStage2Content(){
		return stage2;
	}
	public void setNumOfRow(int r){
		numOfRow=r;
	}
	public int getNumOfRow(){
		return numOfRow;
	}
	public void setNumOfColumn(int c){
		numOfColumn=c;
	}
	public int getNumOfColumn(){
		return numOfColumn;
	}
	public Boolean[][] getStageDesign(){
		return brickExistance;
	}
	public void saveStage1Info(){
		FileOutputStream fout;
		String fileName="Stage1.txt";
		File file=new File(fileName);
		try{
			fout=new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fout.write(stage1.getBytes());
		}
		catch(Exception e){
			
		}
	}
	

public void saveStage2Info(){
	FileOutputStream fout;
	String fileName="Stage2.txt";
	File file=new File(fileName);
	try{
		fout=new FileOutputStream(file);
		if (!file.exists()) {
			file.createNewFile();
		}
		
		fout.write(stage2.getBytes());
	}
	catch(Exception e){
		 e.printStackTrace();
	}
}

public void saveStage3Info(){
	FileOutputStream fout;
	String fileName="Stage3.txt";
	File file=new File(fileName);
	try{
		fout=new FileOutputStream(file);
		if (!file.exists()) {
			file.createNewFile();
		}
		
		fout.write(stage3.getBytes());
	}
	catch(Exception e){
		
	}
}
//	public void saveStageInfo(){
//			   
//	    String fileStage1 = stage1;
//	    String fileStage2 = stage2;
//	    String fileStage3 = stage3;
//	    
//	    FileOutputStream outputStream;
//
//	    try {
//	    	
//	       openFileOutput("Stage 1").write(fileStage1.getBytes());
//	        outputStream.close();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	}
}

package fomy.android.dxball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Display;

public class Brick extends Objects{
	
	float brickLevelLeft,brickLevelRight,brickLevelWidth;
	float brickLevelHeight,brickLevelTop,brickLevelBottom;
	float brickTop,brickLeft,brickBottom,brickRight;
	float brickRowHeight,brickColumnWidth;
	float brickHeight, brickWidth;
	float canvasHeight,canvasWidth;
	Display display;
	float brickLevelStartX,brickLevelStartY;
	int countObject,numberOfBrick,numOfRow,numOfColumn;
	boolean[][] brickInRowColumn;
	float left,right,top,bottom;
	int point;
	int numOfStage;
	String color;
	
	public void brick_design_stage(Canvas canvas,int nOfRow,int nOfColumn,boolean nOfBrickInRowColumn[][],int noOfStage){
		numOfStage=noOfStage;
		canvasHeight=canvas.getHeight();
		canvasWidth=canvas.getWidth();
		
		numOfRow=nOfRow;
		numOfColumn=nOfColumn;
		brickInRowColumn=nOfBrickInRowColumn;
		
		
		
		//Define_BrickLevel
		brickLevelLeft=(float) (canvasWidth*0.035);
		brickLevelHeight=(float) ((canvasHeight*0.25));			
		brickLevelTop=(float) (canvasHeight*0.095);
		brickLevelBottom=brickLevelTop+brickLevelHeight;
		brickLevelWidth=(float) (canvasWidth*0.95);
		brickLevelRight=brickLevelWidth+brickLevelLeft;
		
		
		//Defining_Brick_Level_Ends
		
		//Width & Height of column & Row
		brickColumnWidth=(float) (brickLevelWidth/numOfColumn);
		brickRowHeight=(float) (brickLevelHeight*numOfRow);
		
		
		//Define brick height & width
		brickHeight=(float) (brickRowHeight*0.85);
		brickWidth=(float) (brickColumnWidth*0.85);
		
		for(int i=0;i<numOfRow;i++){
			for(int j=0;j<numOfColumn;j++){
				if(brickInRowColumn[i][j]==true){
					
				}
			}
			
		}
		
		
	}
	@Override
	public void draw(Canvas canvas, Paint paint) {	
			//paint.setColor(Color.YELLOW);		
				
	}
	
	public void setLeft(float l){
		left=l;
	}
	public void setTop(float t){
		top=t;
		}
	public void setRight(float r){
		right=r;
	}
	public void setBottom(float b){
		bottom=b;
	}
	public void setPoint(int p){
		point=p;
		}
	
	public float getLeft(){
		return left;
	}
	public float getTop(){
		return top;
		}
	public float getRight(){
		return right;
	}
	public float getBottom(){
		return bottom;
	}
	public int getPoint(){
		return point;
		}
	
	public void setColor(String c){
		this.color=c;
	}
	public String getColor(){
		return color;
	}

}

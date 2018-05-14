package fomy.android.dxball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.Display;

public class Brick1 extends Brick{
	String color;
	Paint paint;
	
	Brick1(float bLeft,float bTop,float bRight,float bBottom){
		top=bTop;
		bottom=bBottom;
		left=bLeft;
		right=bRight;
		Log.i("Brick Creation","Successfull");
		color="Yellow";
		
	}
	public void draw(Canvas canvas,Paint paint){
		//this.paint=paint;
		canvas.drawRect(left, top, right, bottom, paint);
		Log.i("Brick postion",Float.toString(left));
	}
	
	public void setColor(String c){
		this.color=c;
		if(c=="Green")
		this.paint.setColor(Color.rgb(51, 204, 51));
		else{
			this.paint.setColor(Color.rgb(255, 204, 0));
		}
			
	}
	public String getColor(){
		return color;
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
}

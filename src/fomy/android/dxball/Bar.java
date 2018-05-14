package fomy.android.dxball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Bar extends Objects {
 float barWidth,barHeight,barLeft,barTop,barRight,barBottom;
 float canvasWidth,canvasHeight;
 float dx;
 boolean barDraggedLeft,barDraggedRight;
	 Bar(Canvas canvas){
		 canvasWidth=canvas.getWidth();
			canvasHeight=canvas.getHeight();
			barWidth=(float) (canvasWidth*0.15);
			barHeight=(float) (canvasHeight*0.007*1.5);
			barLeft=(float) (canvasWidth*0.5-barWidth);
			barRight=barLeft+barWidth;
			barTop=(float) (canvasHeight*0.9);
			barBottom=barTop+barHeight;	
			dx=5;
			barDraggedLeft=false;
			barDraggedRight=false;
		 Log.i("Bar Creation","Successfull");
		
				 
	 }
	 
	@Override
	public void draw(Canvas canvas, Paint paint) {
			////Bar///
			if(get_if_bar_dragged_left()==true){
				bar_drag_left(getDX());
				set_if_bar_dragged_left(false);
			}
			if (get_if_bar_dragged_right()==true){
				bar_drag_Right(getDX());
				set_if_bar_dragged_right(false);
			}
			paint.setColor(Color.rgb(255, 163, 26));
			canvas.drawRect(barLeft, barTop,barRight, barBottom, paint);
			///Bar Ends///
	}

	
	public void bar_drag_left(float touchPoint){
		barLeft=barLeft-touchPoint;
		barRight=barRight-touchPoint;
	}
	public void bar_drag_Right(float touchPoint){
		barLeft=barLeft+touchPoint;
		barRight=barRight+touchPoint;
	}
	public void setDX(float newDX){
		dx=newDX;
	}
	public float getDX(){
		return dx;
	}
	public void barPositionChange(){
		barLeft=barLeft+dx;
		barRight=barRight+dx;
	}
	public void set_if_bar_dragged_left(boolean d){
		barDraggedLeft=d;
	}
	public boolean get_if_bar_dragged_left(){
		return barDraggedLeft;
	}
	public void set_if_bar_dragged_right(boolean d){
		barDraggedRight=d;
	}
	public boolean get_if_bar_dragged_right(){
		return barDraggedRight;
	}
	public void setLeft(float l){
		barLeft=l;
		barRight=l+barWidth;
	}
	public void setTop(float t){
		barTop=t;
		}
	public void setRight(float r){
		barRight=r;
		barLeft=r-barWidth;
	}
	public void setBottom(float b){
		barBottom=b;
	}
	
	
	public float getLeft(){
		return barLeft;
	}
	public float getTop(){
		return barTop;
		}
	public float getRight(){
		return barRight;
	}
	public float getBottom(){
		return barBottom;
	}
	
	public void setWidth(float w){
		barWidth=w;
	}
	
	
	public float getWidth(){
		return barWidth;
	}
	
	public void setHeight(float h){
		barHeight=h;
	}
	
	
	public float getHeight(){
		return barHeight;
	}
	
}

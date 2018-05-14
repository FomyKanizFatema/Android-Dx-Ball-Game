package fomy.android.dxball;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class GameCanvas extends View {
	Paint paint;
	//List<Objects> obj;
	List<Brick> brickList;
	
	
	int stage,numberOfBricks;
	boolean isFirstTime;
	WindowManager w;
	
	float brickLevelLeft,brickLevelRight,brickLevelWidth;
	float brickLevelHeight,brickLevelTop,brickLevelBottom;
	float brickTop,brickLeft,brickBottom,brickRight;
	float brickRowHeight,brickColumnLength;
	float brickHeight, brickWidth;
	float canvasHeight,canvasWidth;
	Display display;
	float brickLevelStartX,brickLevelStartY;
	int countObject;
	Ball ball;
	Bar bar;
	boolean ballTouched;
	int score,leftLife,level;
	float top,left,right,bottom;
	
	float headerLeft;
	float headerWidth;
	float headerRight;
	float headerTop;
	float headerHeight;
	float headerBottom;
	
	//Score
	
	float scoreBoardLeft;
	float scoreBoardWidth;
	float scoreBoardRight;
	
	float lifeBoardLeft;
	float lifeBoardWidth;
	float lifeBoardRight;
	int noOfStage;
	
	int numberOfBrick,numOfRow,numOfColumn;
	boolean[][] brickInRowColumn;	
	int point;
	int numOfStage;
	public GameCanvas(Context context) {
		super(context);
		paint=new Paint();
		brickList=new ArrayList<Brick>();
		isFirstTime=true;
		stage=1;
		countObject=0;
		leftLife=3;
		score=0;
		level=1;
		ballTouched=false;
		noOfStage=1;
		
		
	}
	
	
	public void createObjects(Canvas canvas){
		if(isFirstTime==true){
			
			//Canvas
			 canvasWidth=canvas.getWidth();
			 canvasHeight=canvas.getHeight();
			
			//Header
			 headerLeft=(float) (canvasWidth*0.035);
			 headerWidth=(float) (canvasWidth*0.92);
			 headerRight=headerLeft+headerWidth;
			 headerTop=(float) (canvasHeight*0.043);
			 headerHeight=(float) ((canvasHeight*0.030));
			 headerBottom=headerTop+headerHeight;
			
			//Score
			
			 scoreBoardLeft=headerLeft;
			 scoreBoardWidth=(float)(headerWidth*0.35);
			 scoreBoardRight=scoreBoardLeft+scoreBoardWidth;
			
			//LifeBoard
			 lifeBoardRight=headerRight;
			 lifeBoardWidth=(float) (headerWidth*0.35);
			 lifeBoardLeft=lifeBoardRight-lifeBoardWidth;
			
			 
			
			//BrickLevel
			brickLevelLeft=(float) (canvasWidth*0.035);
			brickLevelWidth=(float) (canvasWidth*0.95);
			brickLevelRight=brickLevelWidth+brickLevelLeft;			
			brickLevelHeight=(float) ((canvasHeight*0.25));			
			brickLevelTop=(float) (canvasHeight*0.105);
			brickLevelBottom=brickLevelTop+brickLevelHeight;
			
			
//			switch(noOfStage){
//			case 1:
//				
//				
//			}
			
			brickRowHeight=(float) (brickLevelHeight*0.20);
			brickColumnLength=(float) (brickLevelWidth*0.20);
			
			brickHeight=(float) (brickRowHeight*0.85);
			brickWidth=(float) (brickColumnLength*0.85);
			
			
			//BrickColumnLength 90% brickWidth+10% Blank Space 
			paint.setColor(Color.YELLOW);		
			for(float j=brickLevelTop;j+brickRowHeight<=brickLevelBottom;j=j+brickRowHeight){
				if(brickLeft+brickWidth>=brickLevelRight||brickTop+brickHeight>=brickLevelBottom)
					break;
				top=j;
				bottom=top+brickHeight;
				for(float i=brickLevelLeft;i+brickColumnLength<=brickLevelRight;i=i+brickColumnLength){		
				left=i;			
				right=left+brickWidth;	
				
				brickList.add(new Brick1(left,top,right,bottom));
				countObject++;
				}
				
			}
			//create ball,bar,bricks;
			bar=new Bar(canvas);
			ball=new Ball(bar);
			ballTouched=false;
		//	ball.set_if_ball_touched(false);
			
			
			
			
			
			isFirstTime=false;
		}
	}

 public void drawTopBar(Canvas canvas,int score,int leftLife){
	 
	 paint.setColor(Color.WHITE);
	// canvas.drawRect(scoreBoardLeft, headerTop, scoreBoardRight, headerBottom, paint);
	// canvas.drawRect(lifeBoardLeft, headerTop, lifeBoardRight, headerBottom, paint);

	 paint.setColor(Color.rgb(244, 171, 163));
	// paint.setTextAlign(Align.CENTER);
	 paint.setTextSize(21);
	 String scoreText="Score: "+Integer.toString(score);
	 String lifeText="Life: "+Integer.toString(leftLife);
	 String levelText="Level: "+Integer.toString(level);
	 
	canvas.drawText(scoreText, 0, scoreText.length(),(float)( scoreBoardLeft+ scoreBoardWidth*0.05), (float)(headerTop+headerHeight*0.9), paint);
	// paint.setTextAlign(Align.CENTER);
	 paint.setTextSize(25);
	 paint.setColor(Color.WHITE);	 
	 canvas.drawText(levelText, 0, levelText.length(), (float)(headerWidth*0.45),(float)(headerTop), paint);
	// paint.setTextAlign(Align.CENTER);
	 paint.setTextSize(21);
	
	 paint.setTextAlign(Align.LEFT);
	 paint.setColor(Color.rgb(202, 163, 244));
	 canvas.drawText(lifeText, 0, lifeText.length(), (float)( lifeBoardLeft+ scoreBoardWidth*0.05), (float)(headerTop+headerHeight*0.9), paint);
	 
	 
	 
 }
public void drawGameOver(Canvas canvas,int score){
	String gameOver="Game Over!!!";
	Log.i("TAG",Integer.toString(score));
	String scr="Score: "+Integer.toString(score);
	paint.setTextSize(35);
	paint.setColor(Color.WHITE);	
	canvas.drawText(gameOver, 0, gameOver.length(), (float)(canvasWidth*0.32),(float)(canvasHeight*0.40), paint);
	canvas.drawText(scr, 0, scr.length(), (float)(canvasWidth*0.35),(float)(canvasHeight*0.50), paint);
}
 
 

		public void checkLife(){
			if(ball.get_if_life_Decreased()==true){
				leftLife--;
				
				ball=new Ball(bar);
				
				ball.set_if_life_decreased(false);
				ball.set_if_ball_touched(false);
				
			}
		}
		public boolean onTouchEvent(MotionEvent event)
		{
			float touch_X=event.getX();
			float touch_Y=event.getY();
			int eventAction=event.getAction();
			if(ball.get_if_ball_touched()==false){
				switch(eventAction){
				case MotionEvent.ACTION_UP:
					ballTouched=true;
					ball.set_if_ball_touched(true);
					break;
				}
			}
			else{
				if(touch_Y>=bar.getTop()-20&& touch_Y<=bar.getBottom()+20){
					{
						
						Log.i("Touch Point ", Float.toString(touch_X));
						Log.i("Mid Point ", Float.toString(brickLevelWidth/2));
						
						if(touch_X<=bar.getLeft()+bar.getWidth() && bar.getLeft()-20>0){
							bar.setDX(20);							
							bar.set_if_bar_dragged_left(true);
							
							
							
						}
						else if(touch_X>bar.getRight()-bar.getWidth()&& bar.getLeft()+20<canvasWidth){
							bar.setDX(20);
							bar.set_if_bar_dragged_right(true);	
							
							
						}
//						if(ball.getY()+ball.getRadius()>=bar.getTop()&& ball.getY()-ball.getRadius()<bar.getBottom()){
//							ball.setDX(-ball.getDX());
//							ball.setDY(-ball.getDY());
//							ball.setX(ball.getX()+ball.getDX());
//							ball.setY(ball.getY()+ball.getDY());
//						}
						//ball.ball_bar_collision(bar, ball, leftLife, brickLevelTop);
														
					
					
				}
			}
			}
			return true;
			
	}
		boolean isGameOver=false;
		
	protected void onDraw(Canvas canvas){
		String scr=" ";
		
		canvas.drawRGB(16,10,28);
		
		createObjects(canvas);
		paint.setStyle(Style.FILL);
		
		
		
			checkLife();
		
			if(leftLife>0){
		
				for(int i=0;i<brickList.size();i++){
	//				if(i%6==0){
	//					paint.setColor(Color.rgb(51, 204, 51));	
	//					brickList.get(i).setColor("Green");
	//				}
	//				else{
					paint.setColor(Color.rgb(255, 204, 0));
	//				}
					brickList.get(i).draw(canvas, paint);
				}
				
				bar.draw(canvas, paint);
				score=ball.brick_ball_collision(brickList,ball,score);
				 scr="Score: "+Integer.toString(score);
				ball. ball_bar_collision(bar,ball,leftLife,brickLevelTop);
				drawTopBar(canvas,score,leftLife);
				ball.draw(canvas, paint);
			}
		
		else{
			drawGameOver(canvas,score);
		}
		
		//brickList.remove(5);
		invalidate();
		
		
	}
	
	

}

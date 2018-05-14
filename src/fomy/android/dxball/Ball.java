package fomy.android.dxball;


import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Ball extends Objects {
	
	float x,y,dx,dy,radius;
	float canvasWidth,canvasHeight;
	Bar b;	
	float p;
	boolean firstTime;
	int leftLife;
	boolean isLifeDecreased,isCollided,isBalltouched,firstCollision;
	int count;
	
	
	public Ball(Bar bar) {
		firstCollision=false;
		count=1;
		isLifeDecreased=false;
		isCollided=false;
		b=bar;
		firstTime=true;				
		dx=5;
		dy=5;
		radius=15;
		x=(bar.getLeft()+bar.getRight())/2;
		y=bar.getTop()-radius;
		Log.i("Ball Creation","Successfull");
	}

	@Override
	public void draw(Canvas canvas, Paint paint) {
		
		canvasWidth=canvas.getWidth();
		canvasHeight=canvas.getHeight();
		
		if(get_if_ball_touched()==true){
			positionChange();
		}
		paint.setColor(Color.WHITE);
		canvas.drawCircle(x, y, radius, paint);
		Log.i("Ball postion",Float.toString(x));
	
	}
	
	public void set_if_ball_touched(boolean yes){
		isBalltouched=yes;
	}
	public boolean get_if_ball_touched(){
		return isBalltouched;
	}
	public void positionChange(){
		
		if(firstCollision==false){
			y=y-dy;
			x=x;
			
		}
		if(firstTime==false){
			if (this.getY()+this.getRadius()>=b.getTop()&& this.getY()-this.getRadius()<b.getBottom()
					&& this.getX()-radius>=b.getLeft()-10&&this.getX()+radius<b.getRight()+10){
				dy=-dy;
				dx=-dx;
			}
			if(x>canvasWidth-radius||x<radius){
				dx=-dx;
				firstCollision=true;
			}
			
						
			else if(y-radius<(float) (canvasHeight*0.095)){
				dy=-dy;
				firstCollision=true;
			}
							
			
			else if(y-radius>canvasHeight-radius){			
				//firstCollision=true;
				set_if_life_decreased(true);
				
			}	
			x=x+dx;
			y=y-dy;
			
		}
		firstTime=false;
		}
	public boolean set_if_collided(boolean yes)		{
		if(yes=true)
			firstCollision=true;
		else
			firstCollision=false;
		return isCollided;
	}
	public boolean get_if_collided(){
		return isCollided;
	}
	
	public int brick_ball_collision(List<Brick>br,Ball ball,int score){	
		
		
		for(int i=0;i<br.size();i++){
			
			
			if (((ball.getY() - ball.getRadius()) <= br.get(i).getBottom()) && 
					((ball.getY() + ball.getRadius()) >= br.get(i).getTop()) && 
					((ball.getX()) >= br.get(i).getLeft()) && ((ball.getX()) <= br.get(i).getRight())) {
					
				
					score=score+10;
					br.remove(i)	;
					ball.firstCollision=true;
					ball.setDX(-ball.getDX());
					ball.setDY(-ball.getDY());
				
					//Add Score}
				}
			 
			else if(((ball.getY()) <= br.get(i).getBottom()) && ((ball.getY()) >= br.get(i).getTop())
					&& ((ball.getX() + ball.getRadius()) >= br.get(i).getLeft()) && 
					((ball.getX() - ball.getRadius()) <= br.get(i).getRight())) {
				
					Log.i("Collision?","yes");
					score=score+10;
					br.remove(i)	;
					ball.firstCollision=true;
					ball.setDX(-ball.getDX());
					ball.setDY(-ball.getDY());
					//Add score
		}
			else{
				Log.i("Collision?","no");
			}
			
					
			
		}
		return score;
}
	
	public void set_if_life_decreased(boolean yes){
		isLifeDecreased=yes;
	}
	public boolean get_if_life_Decreased(){
		return isLifeDecreased;
	}
	
	public int ball_bar_collision(Bar bar,Ball ball, int life,float brickLevelTop){
		
		float ballBottom=ball.getX()+ball.getRadius();
		float ballTop=ball.getX()-ball.getRadius();
		float ballRight=ball.getX()+ball.getRadius();
		float ballLeft=ball.getX()-ball.getRadius();
		
		float ballDX,ballDY;
		
			if (ballBottom>=bar.getTop()&&ballTop<=bar.getBottom()&&ballLeft>=bar.getLeft()&&ballRight<=bar.getRight()){
				ballDX=-ball.getDX();
				ballDY=-ball.getDY();
				
				ball.setDX(ballDX);
				ball.setDY(ballDY);
				
				ball.setX(ball.getX()+ballDX);
				ball.setY(ball.getY()+ballDY);
				
			}
			else if(ballBottom>bar.getBottom()){
				life--;		
				count++;
			}
			else if(x>canvasWidth-radius||x<radius){
				ballDX=-ball.getDX();
				ball.setDX(ballDX);
				ball.setX(ball.getX()+ballDX);
			
			}
			else if(y< brickLevelTop){
				ballDY=-ball.getDY();
				ball.setDY(ballDY);
				ball.setY(ball.getY()+ballDY);
			}
		return life;
	}
	
	public void setX(float newX){
		x=newX;
	}
	public float getX(){
		return x;
	}
	public void setY(float newY){
		y=newY;
	}
	public float getY(){
		return y;
	}
	
	public void setDX(float newDX){
		dx=newDX;
	}
	public float getDX(){
		return dx;
	}
	public void setDY(float newDY){
		dy=newDY;
	}
	public float getDY(){
		return dy;
	}
	
	public void setRadius(float r){
		radius=r;
	}
	public float getRadius(){
		return radius;
	}
}

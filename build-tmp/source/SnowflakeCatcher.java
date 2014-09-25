import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake[] snow;
public void setup()
{
  size(300,300);
  background(0);
  snow = new SnowFlake[200];
  for( int i = 0; i< snow.length; i++)
  {
    snow[i] = new SnowFlake();
  }
}
public void draw()
{
  for( int i = 0; i<snow.length; i++)
  {
    snow[i].erase();
    snow[i].lookDown();
    snow[i].move();
    snow[i].wrap();
    snow[i].show();
  }
}
public void mouseDragged()
{
 
  
  if(mouseButton == LEFT)
  {
    
    fill(255,0,0);
    stroke(255, 0, 0);
    ellipse(mouseX, mouseY, 15,15);
    stroke(0);
  }
  if( mouseButton == RIGHT)
  {
    
    fill(0);
    stroke(0);
    ellipse(mouseX, mouseY, 25,25);
  }
}

public void keyPressed()
{
  if ( key == 'b')
  {
    background(0);
    redraw();
  }
}

class SnowFlake
{
  int snowX, snowY;
  boolean isMoving;
  SnowFlake()
  {
    snowX = (int)(Math.random()*275)+10;
    snowY = (int)(Math.random()*301);
    isMoving = true;
  }
  public void show()
  {
    fill(255); 
    stroke(0);
    ellipse( snowX, snowY, 5, 5);
  }
  public void lookDown()
  {
    if( (snowY>0 || 300<snowY)  && get(snowX,snowY+5)!=color(0))
    {
      isMoving = false;
    }
    else 
    {
       isMoving = true;  
    }
  }
  public void erase()
  {
     fill(0);
     ellipse( snowX, snowY, 7,7);
  }
  public void move()
  {
    if( isMoving == true)
    {
      snowY++;
    }
    else
    {
      snowY = snowY;
    }
  }
  public void wrap()
  {
    if( snowY > 290)
    {
      snowX = (int)(Math.random()*275)+10;
       snowY = (int)(Math.random()*11);
    }
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

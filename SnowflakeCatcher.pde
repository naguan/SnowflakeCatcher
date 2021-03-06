SnowFlake[] snow;
void setup()
{
  size(300,300);
  background(0);
  snow = new SnowFlake[200];
  for( int i = 0; i< snow.length; i++)
  {
    snow[i] = new SnowFlake();
  }
}
void draw()
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
void mouseDragged()
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

void keyPressed()
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
  void show()
  {
    fill(255); 
    stroke(0);
    ellipse( snowX, snowY, 5, 5);
  }
  void lookDown()
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
  void erase()
  {
     fill(0);
     ellipse( snowX, snowY, 7,7);
  }
  void move()
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
  void wrap()
  {
    if( snowY > 290)
    {
      snowX = (int)(Math.random()*275)+10;
       snowY = (int)(Math.random()*11);
    }
  }
}


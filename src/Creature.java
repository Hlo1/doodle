public abstract class Creature extends Entity{

    protected float speed;
    public static final float defaultspeed = 0.8f;
    public static final int defaultwidth = 32, defaultheight =32;
    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler , x, y, width, height);
        speed = defaultspeed;
        xMove = 0 ;
        yMove = 0;
    }

    public void move(){
        if(!checkEntityCollision(xMove,0f))
            moveX();
        if(!checkEntityCollision(0f, yMove))
            moveY();
    }

    public void moveX(){
        if (xMove > 0){
            int cx = (int) (x + xMove + bounds.x + bounds.width) / Tiles.tileswidth;
            if(!collisionWithTiles(cx,(int)((y + bounds.y) / Tiles.tilesheight))
            && !collisionWithTiles(cx, (int)((y + bounds.y + bounds.height) /Tiles.tilesheight))){
                x += xMove;
            }
        } else if(xMove < 0){
            int cx = (int) (x + xMove + bounds.x ) / Tiles.tileswidth;
            if(!collisionWithTiles(cx,(int)((y + bounds.y) / Tiles.tilesheight))
                    && !collisionWithTiles(cx, (int)((y + bounds.y + bounds.height) /Tiles.tilesheight))){
                x += xMove;
            }
        }
    }

    public void moveY(){
        if(yMove < 0){
            int cy = (int) (y + yMove +bounds.y) / Tiles.tilesheight;
            if(!collisionWithTiles((int) (x+ bounds.x +bounds.width) / Tiles.tileswidth, cy)
                    && !collisionWithTiles( (int)((x + bounds.x ) /Tiles.tileswidth),cy)){
                y += yMove;
            }
        }
         else if(yMove > 0){
                int cy = (int) (y + bounds.y + yMove + bounds.height) / Tiles.tilesheight;
                if(!collisionWithTiles((int) (x+ bounds.x + bounds.width) / Tiles.tileswidth, cy)
                        && !collisionWithTiles( (int)((x + bounds.x ) /Tiles.tileswidth),cy)){
                    y += yMove;
                }

            }
        }

    protected boolean collisionWithTiles(int x, int y){
        return handler.getWorld().getTile(x, y).isSolid();
    }

    

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}

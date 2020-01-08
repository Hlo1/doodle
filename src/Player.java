import java.awt.*;

public class Player extends Creature  {
    public Player(Handler handler, float x, float y){
        super(handler, x, y, 16, 16);

        bounds.x = 0;
        bounds.y = 0;
        bounds.height = 16;
        bounds.width = 16;
        health = 1;
    }
    public void update(){
        getInput();
        move();
        handler.getGameCamera().focusonEntity(this);
    }
    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().len)
            yMove = -speed;
        if(handler.getKeyManager().xuong)
            yMove = speed;
        if(handler.getKeyManager().trai)
            xMove = -speed;
        if(handler.getKeyManager().phai)
            xMove = speed;
    }
    public void render(Graphics g){
        g.drawImage(Asset.player,(int) (x - handler.getGameCamera().getxOffset()) ,(int) (y- handler.getGameCamera().getyOffset()), width, height,null);
        //g.setColor(Color.red);
        //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
          //      (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }

    @Override
    public void die() {

    }

}

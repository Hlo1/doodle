import java.awt.*;

public class Enemies extends Creature {

    public Enemies(Handler handler, float x, float y) {
        super(handler, x, y, 20,20);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 20;
        bounds.height = 20;
        health = 1;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.boss,(int) (x - handler.getGameCamera().getxOffset()) ,
                (int) (y- handler.getGameCamera().getyOffset()), width, height,null);
    }


    @Override
    public void update() {
        getInput();
        move();
    }


    private void getInput(){
        double a = Math.random()*4;
        if(a>0 && a<1){
            yMove = -speed;
        }else if(a>=1 && a<2){
            yMove = speed;
        }else if(a>=2 && a<3){
            xMove = -speed;
        }else{
            xMove = speed;
        }
    }


    @Override
    public void die() {

    }
}

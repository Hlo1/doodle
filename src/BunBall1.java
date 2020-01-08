import java.awt.*;
public class BunBall1 extends Creature {
    public BunBall1(Handler handler, float x, float y) {
        super(handler, x, y, 16, 16);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 16;
        bounds.height = 16;
        yMove = speed-10;
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.balls, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {

    }

    public void dealDamage(){
        for(Entity e: handler.getWorld().getEntityManager().getEntities()) {
            if(e.equals(this))
                continue;
            if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(xMove, yMove)))
                e.hurt(2);
            return;
        }
    }

    @Override
    public void update() {
        Input();
        move();
        dealDamage();
    }

    private void Input() {
        int cy = (int) (y + yMove + bounds.y) / Tiles.tilesheight;
        if (collisionWithTiles((int) (x + bounds.x + bounds.width) / Tiles.tileswidth, cy)
                || collisionWithTiles((int) ((x + bounds.x) / Tiles.tileswidth), cy)) {
            yMove = speed;
        }
        int gy = (int) (y + bounds.y + yMove + bounds.height) / Tiles.tilesheight;
        if (collisionWithTiles((int) (x + bounds.x + bounds.width) / Tiles.tileswidth, gy)
                || collisionWithTiles((int) ((x + bounds.x) / Tiles.tileswidth), gy)) {
            yMove = -speed;
        }
    }
}
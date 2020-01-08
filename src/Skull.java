import java.awt.*;

public class Skull extends Creature {
    public Skull(Handler handler, float x, float y) {
        super(handler, x, y, 12, 12);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 12;
        bounds.height = 12;
        xMove=speed-10;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.skull, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {

    }

    @Override
    public void update() {
        dealDamege();
        Input();
        move();
    }

    public void dealDamege(){
        for(Entity e: handler.getWorld().getEntityManager().getEntities()) {
            if(e.equals(this))
                continue;
            if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(xMove, yMove)))
                e.hurt(1);
            return;
        }
    }

    private void Input() {
        int cx = (int) (x + xMove + bounds.x + bounds.width) / Tiles.tileswidth;
        if(collisionWithTiles(cx,(int)((y + bounds.y) / Tiles.tilesheight))
                || collisionWithTiles(cx, (int)((y + bounds.y + bounds.height) /Tiles.tilesheight))) {
            xMove = -speed;
        }
        int gx = (int) (x + xMove + bounds.x ) / Tiles.tileswidth;
        if(collisionWithTiles(gx,(int)((y + bounds.y) / Tiles.tilesheight))
                || collisionWithTiles(gx, (int)((y + bounds.y + bounds.height) /Tiles.tilesheight))){
            xMove = +speed;
        }
    }
}

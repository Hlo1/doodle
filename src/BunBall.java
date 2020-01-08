import java.awt.*;

public class BunBall extends Creature {
    private long lastAttackTimer, attackCooldown = 9000, attackTiner = attackCooldown;
    public BunBall(Handler handler, float x, float y) {
        super(handler, x, y, 16, 16);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 16;
        bounds.height = 16;
        xMove=speed-10;
    }

    public void dealDamege(){
        attackTiner += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTiner<attackCooldown)
            return;
        for(Entity e: handler.getWorld().getEntityManager().getEntities()) {
            if(e.equals(this))
                continue;
            if (e.getCollisionBounds(0, 0).intersects(getCollisionBounds(xMove, yMove)))
                e.hurt(20000);
                return;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.balls, (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    @Override
    public void die() {

    }

    @Override
    public void update() {
        Input();
        move();
        dealDamege();
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
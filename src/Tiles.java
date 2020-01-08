import java.awt.*;
import java.awt.image.BufferedImage;

public class Tiles {
    public static Tiles[] tiles = new Tiles[300];
    public static Tiles wallTiles = new WallTiles(0);
    public static Tiles grassTiles = new GrassTiles(1);
    protected BufferedImage texture;
    protected final int id;
    public static final int tileswidth = 32, tilesheight =32;
    public Tiles(BufferedImage texture, int id){
        this.id = id;
        this.texture = texture;

        tiles[id] = this;
    }
    public void update(){

    }
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, tileswidth,tilesheight,null);
    }
    public boolean isSolid(){
        return false;
    }

    public int getId() {
        return id;
    }

}

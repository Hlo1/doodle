import java.awt.image.BufferedImage;

public class Asset {
    public static BufferedImage player, wall, balls, boss, grass,skull;
    public static void init(){
        player = ImageLoader.loadImage("Untitled.png");
        wall = ImageLoader.loadImage("wAll.png");
        balls = ImageLoader.loadImage("BunBall.png");
        boss = ImageLoader.loadImage("bOSS.png");
        grass = ImageLoader.loadImage("Grass.png");
        skull = ImageLoader.loadImage(("skull.png"));
    }
}

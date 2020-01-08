import java.awt.*;

public class World {
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private EntityManager entityManager;
    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler,500,580));
        entityManager.addEntity(new Skull(handler,330,556));
        entityManager.addEntity(new Skull(handler,550,396));
        entityManager.addEntity(new Skull(handler,550,263));
        entityManager.addEntity(new Enemies(handler,450,50));
        entityManager.addEntity(new Enemies(handler,65,65));
        entityManager.addEntity(new Enemies(handler,65,600));
        entityManager.addEntity(new Enemies(handler,503,500));
        entityManager.addEntity(new BunBall1(handler,224,540));
        entityManager.addEntity(new Skull(handler,454,263));
        loadWorld(path);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void update(){
        entityManager.update();
    }

    public void render(Graphics g){
        int xStart = (int) Math.max(0, handler.getGameCamera().xOffset / Tiles.tileswidth);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().xOffset+handler.getWidth()) / Tiles.tileswidth +1);
        int yStart = (int) Math.max(0, handler.getGameCamera().yOffset / Tiles.tilesheight);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().yOffset+handler.getHeight()) / Tiles.tilesheight +1);
        for(int y = yStart;y < yEnd;y++){
            for(int x = xStart;x < xEnd;x++){
                getTile(x, y).render(g, (int) (x * Tiles.tileswidth - handler.getGameCamera().getxOffset()) , (int) ( y * Tiles.tilesheight - handler.getGameCamera().getyOffset()));
            }
        }
        entityManager.render(g);
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public Tiles getTile(int x, int y){
        if(x<0 || y<0 || x >= width || y >= height)
            return  Tiles.grassTiles;
        Tiles t = Tiles.tiles[tiles[x][y]];
        return t;
    }

    private void loadWorld(String path){
        String file = Tienich.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Tienich.parseInt(tokens[0]);
        height = Tienich.parseInt(tokens[1]);
        spawnX = Tienich.parseInt(tokens[2]);
        spawnY = Tienich.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0;y < height;y++){
            for(int x = 0;x < width;x++){
                tiles[x][y] = Tienich.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }
}

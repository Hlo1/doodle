import java.awt.*;

public class GameState extends State {
    private World world;
    public GameState(Handler handler ){
        super(handler);
        world = new World(handler,"C:\\Users\\pc\\IdeaProjects\\PacmanGame\\src\\w1.txt ");
        handler.setWorld(world);
    }
    public void update(){
        world.update();
    }
    public void render(Graphics g){
        world.render(g);
    }
}

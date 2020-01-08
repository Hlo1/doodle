public class WallTiles extends Tiles {

    public WallTiles( int id) {
        super(Asset.wall , id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}

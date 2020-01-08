public class GrassTiles extends Tiles {
    public GrassTiles( int id) {
        super(Asset.grass , id);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}

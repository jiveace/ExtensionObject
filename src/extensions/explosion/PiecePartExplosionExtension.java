package extensions.explosion;

import subjects.PiecePart;

public class PiecePartExplosionExtension implements PartExplosionExtension {

    PiecePart part;

    public PiecePartExplosionExtension(PiecePart part) {
        this.part = part;
    }

    public String createExplosionReport() {
        return String.format("#%d: %s", part.getPartNumber(), part.getName());
    }
}

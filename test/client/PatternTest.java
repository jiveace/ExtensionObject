package client;

import data.Bootstrap;
import extensions.PartExtension;
import extensions.embossing.PartEmbossmentExtension;
import extensions.explosion.PartExplosionExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subjects.Part;

import static org.junit.jupiter.api.Assertions.*;

class PatternTest {
    Bootstrap bootstrap;

    @BeforeEach
    void setUp() {
        bootstrap = new Bootstrap();
        bootstrap.createParts();
    }

    @Test
    public void runPiecePartExplosion() {
        PartExplosionExtension explosion = getPartExplosionExtension(bootstrap.screw);
        assertEquals("#123456: Screw", explosion.createExplosionReport());
    }

    @Test
    public void runAssemblyExplosion() {
        PartExplosionExtension explosion = getPartExplosionExtension(bootstrap.hingedShockPad);
        assertEquals("#444444: Hinged Shock Pad\n" +
                "Hinge,Hinge,Shock Pad", explosion.createExplosionReport());
    }

    @Test
    public void runPiecePartEmbossment() {
        UnsupportedOperationException exception= assertThrows(UnsupportedOperationException.class, () -> {
            getPartExtension(bootstrap.nut, "embossment");
        });
        assertEquals("Part 234567 (Nut) does not support the 'embossment' extension.", exception.getMessage());
    }

    @Test
    public void runAssemblyEmbossment() {
        PartEmbossmentExtension explosion = getPartEmbossmentExtension(bootstrap.hingedShockPad);
        assertEquals("Feeble Example \u00a9\nPart number 444444", explosion.produceEmbossmentTemplate());
    }


    private PartExplosionExtension getPartExplosionExtension(Part part) {
        return (PartExplosionExtension) getPartExtension(part, "explosion");
    }

    private PartEmbossmentExtension getPartEmbossmentExtension(Part part) {
        return (PartEmbossmentExtension) getPartExtension(part, "embossment");
    }

    private PartExtension getPartExtension(Part part, String key) throws UnsupportedOperationException{
        PartExtension extension = part.getExtensions().get(key);
        if (extension == null) {
            throw new UnsupportedOperationException(String.format("Part %d (%s) does not support the '%s' extension.",part.getPartNumber(), part.getName(), key));
        } else {
            return extension;
        }
    }
}
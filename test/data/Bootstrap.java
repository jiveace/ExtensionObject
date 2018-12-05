package data;

import extensions.embossing.AssemblyEmbossmentExtension;
import extensions.explosion.AssemblyExplosionExtension;
import extensions.explosion.PiecePartExplosionExtension;
import subjects.Assembly;
import subjects.PiecePart;

import java.util.Arrays;

public class Bootstrap {

    public PiecePart screw;
    public PiecePart nut;
    public PiecePart spring;
    public PiecePart plate;
    public PiecePart nugget;

    public Assembly mixedBag;
    public Assembly hinge;
    public Assembly shockPad;

    public Assembly hingedShockPad;

    public void createParts() {
        screw = new PiecePart("Screw", 123456L);
        nut = new PiecePart("Nut", 234567L);
        spring = new PiecePart("Spring", 345678L);
        plate = new PiecePart("Plate", 456789L);
        nugget = new PiecePart("Nugget", 567890L);

        mixedBag = new Assembly("Mixed Bag", 111111L, Arrays.asList(screw, screw, screw, screw, nut, nut, nut, nut));
        hinge = new Assembly("Hinge", 222222L, Arrays.asList(nugget, spring, nugget));
        shockPad = new Assembly("Shock Pad", 333333L, Arrays.asList(spring, spring, spring, spring, plate, plate));

        hingedShockPad = new Assembly("Hinged Shock Pad", 444444L, Arrays.asList(hinge, hinge, shockPad));

        PiecePartExplosionExtension screwExplosionExtension = new PiecePartExplosionExtension(screw);
        PiecePartExplosionExtension nutExplosionExtension = new PiecePartExplosionExtension(nut);
        PiecePartExplosionExtension springExplosionExtension = new PiecePartExplosionExtension(spring);
        PiecePartExplosionExtension plateExplosionExtension = new PiecePartExplosionExtension(plate);
        PiecePartExplosionExtension nuggetExplosionExtension = new PiecePartExplosionExtension(nugget);

        AssemblyExplosionExtension mixedBagExplosionExtension = new AssemblyExplosionExtension(mixedBag);
        AssemblyExplosionExtension hingeExplosionExtension = new AssemblyExplosionExtension(hinge);
        AssemblyExplosionExtension shockExplosionExtension = new AssemblyExplosionExtension(shockPad);

        AssemblyExplosionExtension hingedShockPadExplosionExtension = new AssemblyExplosionExtension(hingedShockPad);

        AssemblyEmbossmentExtension mixedBagEmbossmentExtension = new AssemblyEmbossmentExtension(mixedBag);
        AssemblyEmbossmentExtension hingeEmbossmentExtension = new AssemblyEmbossmentExtension(hinge);
        AssemblyEmbossmentExtension shockEmbossmentExtension = new AssemblyEmbossmentExtension(shockPad);

        AssemblyEmbossmentExtension hingedShockPadEmbossmentExtension = new AssemblyEmbossmentExtension(hingedShockPad);

        screw.getExtensions().put("explosion", screwExplosionExtension);
        nut.getExtensions().put("explosion", nutExplosionExtension);
        spring.getExtensions().put("explosion", springExplosionExtension);
        plate.getExtensions().put("explosion", plateExplosionExtension);
        nugget.getExtensions().put("explosion", nuggetExplosionExtension);

        mixedBag.getExtensions().put("explosion", mixedBagExplosionExtension);
        hinge.getExtensions().put("explosion", hingeExplosionExtension);
        shockPad.getExtensions().put("explosion", shockExplosionExtension);
        mixedBag.getExtensions().put("embossment", mixedBagEmbossmentExtension);
        hinge.getExtensions().put("embossment", hingeEmbossmentExtension);
        shockPad.getExtensions().put("embossment", shockEmbossmentExtension);

        hingedShockPad.getExtensions().put("explosion", hingedShockPadExplosionExtension);
        hingedShockPad.getExtensions().put("embossment", hingedShockPadEmbossmentExtension);
    }
}

package extensions.explosion;

import subjects.Assembly;
import subjects.Part;

public class AssemblyExplosionExtension implements PartExplosionExtension{

    Assembly assembly;

    public AssemblyExplosionExtension(Assembly assembly) {
        this.assembly = assembly;
    }

    public String createExplosionReport() {
        String report = "";
        report += String.format("#%d: %s\n", assembly.getPartNumber(), assembly.getName());
        for (Part subPart: assembly.subParts) {
            report += subPart.getName() + ",";
        }
        return removeTrailingComma(report);
    }

    private String removeTrailingComma(String input) {
        return input.substring(0, input.length() - 1);
    }
}

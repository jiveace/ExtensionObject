package extensions.embossing;

import subjects.Assembly;

public class AssemblyEmbossmentExtension implements PartEmbossmentExtension{

    Assembly assembly;

    public AssemblyEmbossmentExtension(Assembly assembly) {
        this.assembly = assembly;
    }

    @Override
    public String produceEmbossmentTemplate() {
        return "Feeble Example \u00a9\nPart number " + assembly.getPartNumber();
    }
}

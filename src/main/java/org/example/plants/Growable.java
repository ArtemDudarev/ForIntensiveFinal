package org.example.plants;

import java.util.List;

public interface Growable {
    public boolean isGrowing(double tempEcosystem, double humidityEcosystem, double waterEcosystem, double lightEcosystem, List<String> allResEcosystem);
}

package org.example.animals;

import java.util.List;

public interface Eatable<T> {
    boolean isEating(double tempEcosystem, double waterEcosystem,  List<T> allResEcosystem);
}

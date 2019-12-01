package utils;

import java.util.Random;

@FunctionalInterface
public interface BooleanGenerator {
    Random random = new Random();

    boolean generate();
}

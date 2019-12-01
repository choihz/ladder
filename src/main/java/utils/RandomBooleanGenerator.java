package utils;

public class RandomBooleanGenerator implements BooleanGenerator {
    @Override
    public boolean generate() {
        return random.nextBoolean();
    }
}

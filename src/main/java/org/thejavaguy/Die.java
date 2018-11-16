package org.thejavaguy;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class Die {
    private final PRNG.Smart rng;

    public Die(PRNG.Smart rng) {
        this.rng = rng;
    }

    public int roll() {
        return rng.nextInt(new IntRange(1, 6));
    }

    public static void main(String[] args) {
        Die die = new Die(new XorshiftPlus.Smart(new XorshiftPlus()));
        die.roll();
    }
}

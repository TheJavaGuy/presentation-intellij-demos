package org.thejavaguy;

/**
 * @author Ivan Milosavljevic (TheJavaGuy)
 */
public final class Outer {
    private final Inner inner;

    public Outer(Inner inner) {
        this.inner = inner;
    }

    private static class Inner {
        private int id;

        public Inner(int id) {
            this.id = id;
        }
    }

    interface Identifiable {
        int id();
    }
}

enum Cars {
    BMW,
    AUDI,
    YUGO
}

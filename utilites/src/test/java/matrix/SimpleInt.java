package matrix;

public class SimpleInt {
    final int v;

    public SimpleInt(int v) {
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        return v == ((SimpleInt) o).v;
    }
}

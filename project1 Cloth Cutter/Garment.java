

public class Garment {
    private int X;
    private int Y;
    private int width;
    private int height;
    private String label;

    public Garment(int x, int y, int w, int h, String name) {
        this.X = x;
        this.Y = y;
        this.width = w;
        this.height = h;
        this.label = name;
    }

    public int xCoordinate() {

        return X;
    }

    public int yCoordinate() {

        return this.Y;
    }

    public int width() {

        return this.width;
    }

    public int height() {

        return this.height;
    }

    public String label() {

        return this.label;
    }

    public String toString() {

        return this.label + " at (" + this.X + ", " + this.Y + ")";
    }
}
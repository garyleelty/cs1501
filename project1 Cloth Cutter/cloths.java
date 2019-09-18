public class cloths {
    private int value;		// the optimized value
    private int cut;		// the type of cut to me made (zero represents no cut made)
    private int location;   // the location of the cut, or the location of the pattern in the ArrayList of patterns

    private static final int NONE = 0;
    private static final int VERTICAL = 1;
    private static final int HORIZONTAL = 2;
    public cloths(int v, int c, int l) {
        this.value		= v;
        this.cut   		= c;
        this.location 	= l;
    }
    public int value() {

        return this.value;
    }

    public int cut() {

        return this.cut;
    }

    public int location(){

        return this.location;
    }
}

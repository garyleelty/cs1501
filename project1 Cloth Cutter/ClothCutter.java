
import java.util.ArrayList;

public class ClothCutter {
	private int originalWidth;
	private int originalHeight;
	private ArrayList<Pattern> patterns;
	public ArrayList<Cut> cuts;
	public ArrayList<Garment> garments;
	private cloths[][] memo;
	private int money;
	private static final int NONE = 0;
	private static final int ve = 1;
	private static final int ho = 2;
	
	public ClothCutter( int w, int h, ArrayList<Pattern> p ) {
		this.originalWidth 	= w;
		this.originalHeight = h;
		this.patterns 		= p;
		this.memo 			= new cloths[w][h];
		this.cuts 			= new ArrayList<Cut>();
		this.garments		= new ArrayList<Garment>();
	}
	public int optimize() {
		money= optimize(this.originalWidth, this.originalHeight).value();
		if( money < 0 )
			 money= 0;
		this.makeCuts();
		return money;
	}	
	private cloths optimize(int width, int height) {
		
		if(memo[width-1][height-1] != null)
			return memo[width-1][height-1];
			
		int bV = -1;
		cloths oC = new cloths(-1,NONE,0);

		for(int tempt=0 ; tempt<patterns.size() ; tempt++) {
			Pattern p = patterns.get(tempt);
			if((p.width() <= width) && (p.height() <= height) && (p.value() > bV))
			{
				bV = p.value();
				oC = new cloths(bV, NONE, tempt);
			}
		}

		if(bV < 0) {
			memo[width-1][height-1] = oC;
			return oC;
		}
		

		int tempV;

		for(int tempt=1 ; tempt < height ; tempt++) {
			tempV = optimize(width,tempt).value() + optimize(width,height-tempt).value();
			if( tempV > bV ) {
				bV = tempV;
				oC = new cloths(bV, ho, tempt);
			}
		}
		for(int tempt=1 ; tempt < width ; tempt++) {
			tempV  	= optimize(tempt,height).value() + optimize(width-tempt,height).value();
			if( tempV > bV ) {
				bV = tempV;
				oC = new cloths(bV, ve, tempt);
			}
		}
		memo[width-1][height-1] = oC;
		return oC;
	}
	private void makeCuts() {
	    makeCuts(0,0,this.originalWidth,this.originalHeight);
	}
	private void makeCuts(int x, int y, int width, int height) {
		cloths cloth = optimize(width,height);

		if(cloth.cut() == NONE) {
			Pattern pattern = this.patterns.get( cloth.location() );
			this.garments.add(  new Garment( x, y, pattern.width(), pattern.height(), pattern.name() )  );
		}
		else if(cloth.cut() == ve) {
			this.cuts.add(  new Cut( x+cloth.location() , y, x+cloth.location() , y+height)  );
			makeCuts(x, y, cloth.location(), height);
			makeCuts(x+cloth.location(), y, width-cloth.location(), height);
		}
		else {
			this.cuts.add(  new Cut( x, y+cloth.location(), x+width, y+cloth.location())  );
			makeCuts(x, y, width, cloth.location() );
			makeCuts(x, y+cloth.location(), width, height-cloth.location() );
		}
	}	
	public int value() {

		return money;
	}
	public ArrayList<Garment> garments() {

		return garments;
	}
	public ArrayList<Cut> cuts() {

		return cuts;
	}
}


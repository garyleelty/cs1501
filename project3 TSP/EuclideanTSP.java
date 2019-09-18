import java.util.ArrayList;

public class EuclideanTSP {
	//ArrayList<City> cities = new ArrayList<City>();
	//ArrayList<Edge> MST = new ArrayList<Edge>();
	
    public static ArrayList<Edge> MST(ArrayList<City> c){
    	ArrayList<City> cities = new ArrayList<City>();
    	ArrayList<City> treeCities = new ArrayList<City>();
    	ArrayList<Edge> MST = new ArrayList<Edge>();
    	cities.addAll(c);
    	treeCities.add(cities.remove(0));
    	for(City city : c){
			cities.add(city);
		}
    	while(!cities.isEmpty()) {
    		Edge lightestEdge = null;
			double minDistance = Double.MAX_VALUE;	// minimum distance 

			for(City start : treeCities){		// for each city in tree

				for(City end : cities){		// for each city not in to tree

					double distance = dist(start, end);		// get the distance from start to end

					if( distance < minDistance ){	// if distance is a new minimum
						lightestEdge = new Edge(start, end);
						minDistance = distance;		// set new minimum distance
					}
				}
			}
			cities.remove(lightestEdge.city2);					// remove end from city array
			treeCities.add(lightestEdge.city2);
			MST.add(lightestEdge);		// add edge to tree (grow the tree with lightest edge possible)
    	}
		return MST;
        
    }
	public static ArrayList<City> MSTTour(ArrayList<Edge> mST) {
		ArrayList<Edge> MST = new ArrayList<Edge>();
		ArrayList<City> MSTTour = new ArrayList<City>();
		
		for(Edge edge : mST){
			MST.add(edge);
		}
		
		return MSTTour(MST.get(0).city1, MST, MSTTour);
	}
	private static ArrayList<City> MSTTour(City city1, ArrayList<Edge> mST, ArrayList<City> mSTTour) {

		mSTTour.add(city1);
		
		for(Edge edge : mST){
			City parent = edge.city1;
			City child = edge.city2;
			if( parent.equals(city1) && !mSTTour.contains(child)){		// for each child not already in tour
				mSTTour = MSTTour(edge.city2, mST, mSTTour);
			}
		}
		return mSTTour;
	}
	public static String weight(ArrayList<Edge> mST){
		double weight = 0;
		for(Edge edge : mST){
			weight += dist(edge.city1 , edge.city2);
		}
		return Double.toString(weight);
	}
	public static String length(ArrayList<City> mSTTour) {
		double length = 0;
		for(int n=0; n<mSTTour.size()-1;n++) {
			length += dist( mSTTour.get(n) , mSTTour.get(n+1));
		}
		return Double.toString(length);
	}

	public static double dist(City a, City b) {
		double aX = a.x;
		double aY = a.y;
		double bX = b.x;
		double bY = b.y;
		double x = bX - aX;
		double y = bY - aY;
		
		return Math.sqrt(Math.pow(x , 2.0)+Math.pow(y , 2.0));
	}

	

}

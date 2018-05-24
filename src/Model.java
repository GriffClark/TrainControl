import java.util.ArrayList;
//TODO each station should only be able to connect to n number of other stations 
public class Model {
	
	private ArrayList<Station> stations = new ArrayList<Station>();
	private static Model singleModel = null;
	private TrackController trackController;
	private TrainController trainController;

	public Model() {
		trackController = new TrackController();
		trainController = new TrainController();
	}
	
	public void addTrackNode (Station trackNode, double distanceModifier) {  
		//FIXME these need to create perfect triangles instead of impossible geometry
		/*
		 * in order to create sound shapes, each node needs to make a perfect triangle with each possible pair of other nodes. This is only relevant for nodes 3+,-->
		 *  and 1 and 2 can be n distance apart
		 * 
		 * Create variable c that will be at random distance n determined by feeding a random number between b and c, where b is a point in the triangle a b c
		 * using distance n, calculate distance between c and a
		 * using the relation between c and a/b, triangles can be made with c , a , and R, where R is the remaining nodes in the network. Add pairs to a temp ArrayList<TrackDistancePair>
		 * this math will then be verified by using c, b and, R. Add pairs to a temp ArrayList<TrackDistancePair>
		 * 		if something does not check out, report an error to start? 
		 * After node is verified to be possible, add all values of temp to tdPairs 
		 */
		if(stations.size() > 0) {
			stations.add(trackNode);
				for(int i = 0; i < stations.size() - 1; i++) { //should loop through the whole thing except the one that was just added (distance to self = 0)
					TrackDistancePair newTD = new TrackDistancePair(stations.get(i), trackNode, (Math.random() * 100) * distanceModifier); 
					trackController.addTrack(new Track(newTD)); //makes the trackController aware of new connection 
				}
		}
		
		else
			stations.add(trackNode);
	}
	
//	public void overrideNode(Station node1, Station node2, double newDistance) {
//		//finds the TrackDistancePair with both nodes and creates a new distance between them
//		String ref1 = node1.getName() + "-" + node2.getName();
//		String ref2 = node2.getName() + "-" + node2.getName();
//		for(int i = 0; i < tdPairs.size(); i++) {
//			if(tdPairs.get(i).getStr().equals(ref1) || tdPairs.get(i).getStr().equals(ref2)) {
//				tdPairs.get(i).setDistanceBetween(newDistance);
//				break;
//			}
//		}
//		
//	}

	
	public ArrayList<Station> getTrackNodes() {
		return stations;
	}

	public void setTrackNodes(ArrayList<Station> trackNodes) {
		this.stations = trackNodes;
	}


	
	public void addTrain(String name, double accel, double maxV, int maxPassengers) {
		trainController.addTrian(new Train(name, accel, maxV, maxPassengers));
	}

	
	public static Model getModel() {
		if (singleModel == null) {	       
			singleModel = new Model();
	     }
	     return Model.singleModel; 
     }
	
	
	
	public TrackController getTrackController() {
		return trackController;
	}

	public void setTrackController(TrackController trackController) {
		this.trackController = trackController;
	}

	public TrainController getTrainController() {
		return trainController;
	}

	public void setTrainController(TrainController trainController) {
		this.trainController = trainController;
	}

	public static void main (String[] args) {
		
	}

}

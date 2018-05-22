import java.util.ArrayList;

public class Model {
	
	private ArrayList<TrackNode> trackNodes = new ArrayList<TrackNode>();
	private static Model singleModel = null;
	private TrackController trackController;
	private TrainController trainController;
	private ArrayList<TrackDistancePair> tdPairs = new ArrayList<TrackDistancePair>(); 
	
	public Model() {
		trackController = new TrackController();
		trainController = new TrainController();
	}
	
	public TrackDistancePair findTdPair(TrackNode node1, TrackNode node2) {
		for(int i = 0; i < tdPairs.size(); i++) {
			if(tdPairs.get(i).getStr().equals(node1 + "-" + node2) || tdPairs.get(i).getStr().equals(node2 + "-" + node1)) {
				return tdPairs.get(i);
			}
		}
		System.out.println("error in findTdPair");
		return null;
	}
	
	public void addTrackNode (TrackNode trackNode, double distanceModifier) { 
		if(trackNodes.size() > 0) {
			trackNodes.add(trackNode);
				for(int i = 0; i < trackNodes.size() - 1; i++) { //should loop through the whole thing except the one that was just added (distance to self = 0)
					TrackDistancePair newTD = new TrackDistancePair(trackNodes.get(i), trackNode, (Math.random() * 100) * distanceModifier); //FIXME this will create imperfect triangles that will be impossible in real life
					tdPairs.add(newTD); //creates a new TrackDistancePair 
					trackController.addTrack(new Track(newTD)); //makes the trackController aware of new connection 
				}
		}
		
		else
			trackNodes.add(trackNode);
	}
	
	public void overrideNode(TrackNode node1, TrackNode node2, double newDistance) {
		//finds the TrackDistancePair with both nodes and creates a new distance between them
		String ref1 = node1.getName() + "-" + node2.getName();
		String ref2 = node2.getName() + "-" + node2.getName();
		for(int i = 0; i < tdPairs.size(); i++) {
			if(tdPairs.get(i).getStr().equals(ref1) || tdPairs.get(i).getStr().equals(ref2)) {
				tdPairs.get(i).setDistanceBetween(newDistance);
				break;
			}
		}
		
	}

	
	public ArrayList<TrackNode> getTrackNodes() {
		return trackNodes;
	}

	public void setTrackNodes(ArrayList<TrackNode> trackNodes) {
		this.trackNodes = trackNodes;
	}

	public ArrayList<TrackDistancePair> getTdPairs() {
		return tdPairs;
	}

	public void setTdPairs(ArrayList<TrackDistancePair> tdPairs) {
		this.tdPairs = tdPairs;
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

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
	
	public void createStations (int numStations, int numConnections, double distanceModifier) {  
		
		//generate stations
		for(int i = 0; i < numStations; i++) {
			Station s = new Station();
			s.setName("Station" + i);
			stations.add(s);
		}
		
		//generate connections
		for(int i = 0; i < stations.size(); i++) {
			for(int j = 0; j < numConnections; j++) {
				stations.get(i).addConnection(stations.get((int)(Math.random() * stations.size())));
				//do I have to worry about stations having the same connection twice? I don't think so
			}
		}
				
		for(int i = 0 ; i < stations.size(); i++) {
			//first station will have two connections for simplicity right now
			/* find the other station that it connects to
			 * create a track that is of length n connecting it to the connected station
			 * 	if a track already exists, do not that make that connection --> is there a faster way to see if a station already exists than looping/
			 * through the list of stations one at a time and seeing if they are the same?
			 */
			
			for(int j = 0; j< stations.get(i).getConnections().size(); j++) {
				if(trackController.getActiveTracks().size() < 2) {
					Track t = new Track((stations.get(i)), stations.get(i).getConnections().get(j), Math.random() * distanceModifier);
					trackController.addTrack(t);
				} //end if loop for first two tracks
				else {
					//figure out how to add additional tracks based on angles and triangles and shit
				}
				
			
			}
			
		}
		
		
		//find distance between stations
		//going to hardcode two initial values because they don't matter that much
		
		for(int i = 0; i < stations.size(); i++) {
			for(int j = 0; j < stations.get(i).getNumConnections(); j++) { //loops through each connection for each station
				Track t = new Track(stations.get(i), stations.get(i).getConnections().get(j)); //TODO test this line to see if it is pulling a each station that t should be connecting
				if(t.getLength() == 0) { //0 is defualt set so the track has not been defined yet
					//TODO figure out how to define these lengths 
					trackController.addTrack(t);
				}
				//if the if loop above isn't hit, that means that the track has already been initialized and no action needs to be taken
			}
		}
		
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

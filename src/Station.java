import java.util.ArrayList;
public class Station {
	private ArrayList<TrackDistancePair> connections = new ArrayList<TrackDistancePair>();
	private int maxConnections;
	private String name;

	public Station() {
		// default tracks will have same number of connections
		maxConnections = 5;
	}
	
	public void addConnection(Station self, Station other, double d) {
		TrackDistancePair t = new TrackDistancePair(self, other, d);
		connections.add(t);
	}
	
	public boolean isConnectedTo(Station otherStation) {
		for(int i = 0; i < connections.size(); i++) {
			if(connections.get(i).getNode2() == otherStation || connections.get(i).getNode1() == otherStation) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<TrackDistancePair> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<TrackDistancePair> connections) {
		this.connections = connections;
	}

	public int getNumConnections() {
		return maxConnections;
	}

	public void setNumConnections(int numConnections) {
		this.maxConnections = numConnections;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}

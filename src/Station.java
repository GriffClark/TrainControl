import java.util.ArrayList;
public class Station {
	private ArrayList<Station> connections = new ArrayList<Station>();
	private int maxConnections;
	private String name;

	public Station() {
		// default tracks will have same number of connections
		maxConnections = 5;
	}
	
	public void addConnection(Station other) {
		connections.add(other);
	}
	
	public boolean isConnectedTo(Station otherStation) {
		for(int i = 0; i < connections.size(); i++) {
			if(connections.get(i).equals(otherStation) ) { //FIXME is this correct operator 
				return true;
			}
		}
		return false;
	}

	public ArrayList<Station> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<Station> connections) {
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

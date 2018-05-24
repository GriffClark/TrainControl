public class Track {
	private Train train;
	private Station node1, node2;
	private String name;
	private double length;
	
	public void addTrain (Train train) {
		if(train == null) {
			this.train = train;
		}	
	}
		
	public boolean getIsOccupied() {
		if(train != null) {
			return true;
		}
		return false;
	}
		
	public void removeTrain() {
		train = null;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Track(Station node1, Station node2) {
		this.node1 = node1;
		this.node2 = node2;
		this.name = node1.getName() + " -- " + node2.getName();
	}
	
}

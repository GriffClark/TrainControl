public class Track {
	private TrackDistancePair td;
	private Train train;
	private String name;
	
	public Track(TrackDistancePair td) {
		this.td = td;
		name = this.td.getStr();
	}
	
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

	public TrackDistancePair getTd() {
		return td;
	}

	public void setTd(TrackDistancePair td) {
		this.td = td;
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
	
}

import java.util.ArrayList;

public class TrackController {
	private ArrayList<Track> activeTracks = new ArrayList<Track>();
	
	public TrackController() {
		
	}

	public ArrayList<Track> getActiveTracks() {
		return activeTracks;
	}

	public void setActiveTracks(ArrayList<Track> activeTracks) {
		this.activeTracks = activeTracks;
	}
	
	public void addTrack(Track y) {
		activeTracks.add(y);
	}
	
	public void addTrack(TrackDistancePair y) {
		activeTracks.add(new Track(y));
	}
	
	public boolean isTrackOpen(TrackDistancePair tdPair) {
		for(int i = 0; i < activeTracks.size(); i++) {
			if(activeTracks.get(i).getName().equals(tdPair.getStr())) {
				if(activeTracks.get(i).getIsOccupied() == false) {
					return true;
				}
				else
					return false;
			}
		}
		System.out.println("isTrackOpen could not find track. Defualt return false");
		return false;
	}

}

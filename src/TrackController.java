import java.util.ArrayList;

public class TrackController {
	private ArrayList<Track> activeTracks = new ArrayList<Track>();
	
	public TrackController() {
		
	}

	public ArrayList<Track> getActiveTracks() {
		return activeTracks;
	}
	
	public double getDistanceTo(Station past, Station target) {
		if(past.isConnectedTo(target)) {
			for(int i = 0; i < activeTracks.size(); i++) {
				if(activeTracks.get(i).getName().equals(past.getName() + " -- " + target.getName() || activeTracks.get(i).getName().equals(target.getName() + " -- " + past.getName() )
			}
		}
	}

	public void setActiveTracks(ArrayList<Track> activeTracks) {
		this.activeTracks = activeTracks;
	}
	
	public void addTrack(Track y) {
		activeTracks.add(y);
	}
	
	public void addTrack(Tack y) {
		activeTracks.add(new Track(y));
	}
	
	public boolean isTrackOpen(Track track) {
		return track.getIsOccupied();
	}

}

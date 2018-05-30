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
				String str = activeTracks.get(i).getName();
				if(str.equals(past.getName() + target.getName()) || str.equals(target.getName() + past.getName())) {
				return activeTracks.get(i).getLength();
					//if there is a direct track, find that track and return the length of it
				}
			}
		} //close if statement 
		//this is going to have to route you through multiple stations, but checking all possible solutions is impossible
		
		return 0; 
	}

	public void setActiveTracks(ArrayList<Track> activeTracks) {
		this.activeTracks = activeTracks;
	}
	
	
	public void addTrack(Track y) {
		activeTracks.add(y);
	}
	
	public boolean isTrackOpen(Track track) {
		return track.getIsOccupied();
	}

}

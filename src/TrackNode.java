
public class TrackNode {
	
	public enum TrackNodeTypes{
		STATION, SWITCH
	}
	
	
	
	private TrackNodeTypes t;
	private String name;

	public TrackNode(String name, TrackNodeTypes t) {
		
	}
	
	public String getName() {
		return name;
	}

}

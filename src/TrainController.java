import java.util.ArrayList;
public class TrainController {
	
	protected class Request{
		private Train train;
		private TrackNode tn;
		
		public Request(Train train, TrackNode tn) {
			this.train = train;
			this.tn = tn;
		}

		public Train getTrain() {
			return train;
		}

		public void setTrain(Train train) {
			this.train = train;
		}

		public TrackNode getTn() {
			return tn;
		}

		public void setTn(TrackNode tn) {
			this.tn = tn;
		}
		
	}
	private ArrayList<Train> trains = new ArrayList<Train>();
	private ArrayList<Request> queue = new ArrayList<Request>();
	
	public void addTrian(Train t) {
		trains.add(t);
	}
	public void makeRequest(TrackNode tn)
}
//Needs a queue of trains waiting to use a given track
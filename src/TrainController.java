import java.util.ArrayList;
public class TrainController {
	
	private ArrayList<Train> onControl  = new ArrayList<Train>();
	private ArrayList<Request> queue = new ArrayList<Request>();
	
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
	
	public void addTrian(Train t) {
		onControl.add(t);
	}
	
	public void makeRequest(TrackNode tn, Train self) { //TODO this is not accounting for passenger load/unload time
		/**
		 * the end result of calling this method should be a route that TrainController can tell the train to follow by setting destinations for the train and controlling its speed
		 */
		for(int i = 0; i < onControl.size(); i++) {
			//routing
			TrackDistancePair tdPair = Model.getModel().findTdPair(self.getCurrentLocation(), tn);
			if(Model.getModel().getTrackController().isTrackOpen(tdPair) == true) {
				//if the track is open
				
				if(onControl.get(i).getDestination().equals(self.getDestination())) {
					
					if(onControl.get(i).timeToDestination() >= self.timeToDestination()) {
						//the other train on it's current course can get there faster 	
					}
					else {
						//you can get there faster	
					}
				}
				else {
					//go there
				}
			}
			else {
				//track is not open. Find alternate routes or if it is faster to queue for the current track 
			}
		} // end for loop
			
	}
}
//TODO Needs a queue of trains waiting to use a given track
import java.util.ArrayList;

public class Train {
	
	public class Route{
		
	}
	
private double accel, maxV, v;
private String name;
private int numPassengers, maxPassengers;
private Station targetLocation;
private double distanceToLocation;
private ArrayList<Station> pastDestinations = new ArrayList<Station>();

private Station lastDestination = pastDestinations.get(pastDestinations.size()-1);


	public Train(String name, double accel, double maxV, int maxPassengers) {
		this.name = name;
		this.accel = accel;
		this.v = 0;
		this.maxPassengers = maxPassengers;
		numPassengers = 0; //trains are empty by default 
		
	}
	
	public Train(String name) {
		switch(name) {
		//TODO make this so that you can put in the name of a type of train you want and it will make it
		}
	}
	
	
	public Station getLastDestination() {
		return lastDestination;
	}

	public void setLastDestination(Station lastDestination) {
		this.lastDestination = lastDestination;
	}

	public void fillTrain() {
		if(v==0) {
			while(numPassengers < maxPassengers) {
				numPassengers++;
				//TODO make this take a bit of time
			}
		}
		else
			System.out.println("error cannot fill train while v > 0");
		
	}

	public Station getDestination() {
		return targetLocation;
	}

	public void setDestination(Station destination) {
		this.targetLocation = destination;
	}

	public void addToConductor(Train self) {
		Model.getModel(). getTrainController().addTrian(self);
		//XXX this needs to be called after each train is initialized so that it can be manipulated by TrainController
	}
	
	public void makeRequest(Train self) {
		if(targetLocation != null && v == 0 /*not already moving somewhere*/) {
			Model.getModel().getTrainController().makeRequest(targetLocation, self);
		}
		
	}
	
	public Station getCurrentLocation() {
		return pastDestinations.get(pastDestinations.size() - 1);
	}
	
	public ArrayList<Station> getPastDestinations() {
		return pastDestinations;
	}

	public void setPastDestinations(ArrayList<Station> pastDestinations) {
		this.pastDestinations = pastDestinations;
	}

	public void getRandomDestination(int howManyRecentsRemoved) {
		//this clause ensures that trains are traveling to new destinations 
		Station[] modifiers = new Station[howManyRecentsRemoved];
			for(int i = 0; i < howManyRecentsRemoved; i++) {
				modifiers[i] = pastDestinations.get(pastDestinations.size() - i - 1);
				//gets the most recent destinations
		}
		ArrayList<Station> localNodes = Model.getModel().getTrackNodes();
		for(int i = 0; i < modifiers.length; i++) {
			localNodes.remove(modifiers[i]); 
			//removes the most recent destinations from localNodes
		}
		//TODO this whole block from start to here can be written much better
		
		int r = (int) (Math.random() * localNodes.size());
		this.targetLocation = localNodes.get(r);
		distanceToLocation = Model.getModel().getTrackController().getDistanceTo(lastDestination, targetLocation)
	}

	public double timeToDestination() { //going to be used when routing trains 
		double tA /* time to accelerate to maxV*/ = maxV/accel;
		double dA /* Distance traveled during acceleration*/ = accel * Math.pow(tA, 2);
		
		//if the train will never reach its full speed...
		if(distanceToLocation < dA) {
			return (Math.sqrt(4.0 * distanceToLocation / accel)); // time needed to accelerate to the halfway point then flip burn
		}
		else
			return 2*tA + (distanceToLocation-dA)/maxV; // time to accelerate to maxV plus travel at maxV plus decelerate to destination (found solutions online for both of these)
	}
	
	public void makeMove() {
		/* train can accelerate
		 * train can decelerate
		 * train can stay at current speed
		 * train wants to get to destination as quickly as possible
		 * when distanceToLocation == 0 v must == 0
		 */
		//TODO write this
	}
	
	public double getAccel() {
		return accel;
	}

	public void setAccel(double accel) {
		this.accel = accel;
	}


	public double getMaxV() {
		return maxV;
	}

	public void setMaxV(double maxV) {
		this.maxV = maxV;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumPassengers() {
		return numPassengers;
	}


	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}


	public int getMaxPassengers() {
		return maxPassengers;
	}


	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
	
	

}



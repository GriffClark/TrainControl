
public class TrackDistancePair{
	private TrackNode node1, node2;
	private String str;
	private double distanceBetween;
	public TrackDistancePair(TrackNode node1, TrackNode node2, double distanceBetween) {
		str = node1.getName() + "-" + node2.getName();
		this.distanceBetween = distanceBetween;
	}
	public TrackNode getNode1() {
		return node1;
	}
	public void setNode1(TrackNode node1) {
		this.node1 = node1;
	}
	public TrackNode getNode2() {
		return node2;
	}
	public void setNode2(TrackNode node2) {
		this.node2 = node2;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public double getDistanceBetween() {
		return distanceBetween;
	}
	public void setDistanceBetween(double distanceBetween) {
		this.distanceBetween = distanceBetween;
	}
}



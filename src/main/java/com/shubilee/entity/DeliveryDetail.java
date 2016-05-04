package com.shubilee.entity;

public class DeliveryDetail {

	private TrackMessage trackMessage;
	
	private Location location;
	
	private DeliveryEstimate deliveryEstimate;


	public TrackMessage getTrackMessage() {
		return trackMessage;
	}

	public void setTrackMessage(TrackMessage trackMessage) {
		this.trackMessage = trackMessage;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public DeliveryEstimate getDeliveryEstimate() {
		return deliveryEstimate;
	}

	public void setDeliveryEstimate(DeliveryEstimate deliveryEstimate) {
		this.deliveryEstimate = deliveryEstimate;
	}


	

}

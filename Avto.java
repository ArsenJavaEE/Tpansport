ackage mypac1;

public class Avto extends Transport {

	public Avto(String typeOfTransport, int maxWeight, int maxVolume,
			int transportSpeed, int possibleDeliveryDay) {
		super(typeOfTransport, maxWeight, maxVolume, transportSpeed,
				possibleDeliveryDay);

	}

	public void showTransport() {
		super.showBasicTransportInfo();
	}

}

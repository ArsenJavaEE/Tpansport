package mypac1;

public class Avia extends Transport {
	/** категория опасности груза, для авиа транспорта */
	private String hazardRatingOfGoods;

	// конструкторы
	public Avia(String typeOfTransport, int maxWeight, int maxVolume,
			int transportSpeed, int possibleDeliveryDay,
			String hazardRatingOfGoods) {
		super(typeOfTransport, maxWeight, maxVolume, transportSpeed,
				possibleDeliveryDay);
		this.hazardRatingOfGoods = hazardRatingOfGoods;

	}

	// геттеры и сеттеры
	public String getHazardRatingOfGoods() {
		return hazardRatingOfGoods;
	}

	public void setHazardRatingOfGoods(String hazardRatingOfGoods) {
		this.hazardRatingOfGoods = hazardRatingOfGoods;
	}

	/** переопределенный метод вывода информации о транспорте */
	@Override
	public void showTransport() {
		super.showBasicTransportInfo();
		System.out.println("Категория опасности груза для авиатранспорта: "
				+ getHazardRatingOfGoods());
	}

}

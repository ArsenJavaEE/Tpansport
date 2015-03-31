package mypac1;

import java.util.ArrayList;

public class Transport implements Movable {
	/** название транспорта */
	private String typeOfTransport;
	/** максимальный вес перевозимый транспортом */
	private int maxWeight;
	/** максимальный объем перевозимый транспортом */
	private int maxVolume;
	/** средняя скорость транспорта */
	private int transportSpeed;
	/** день следующей возможной отправки данным транспортом */
	private int possibleDeliveryDay;
	/** список хранящий транспорт */
	private static ArrayList<Transport> myTransport = new ArrayList<Transport>();
	/** список хранящий грузы */
	private static ArrayList<Goods> myGoods = new ArrayList<Goods>();

	// конструкторы транспорта
	public Transport() {

	};

	public Transport(String typeOfTransport, int maxWeight, int maxVolume,
			int transportSpeed, int possibleDeliveryDay) {
		super();
		this.typeOfTransport = typeOfTransport;
		this.maxWeight = maxWeight;
		this.maxVolume = maxVolume;
		this.transportSpeed = transportSpeed;
		this.possibleDeliveryDay = possibleDeliveryDay;
	}

	// геттеры и сеттеры
	public static ArrayList<Transport> getMyTransport() {
		return myTransport;
	}

	public static void setMyTransport(ArrayList<Transport> myTransport) {
		Transport.myTransport = myTransport;
	}

	public static ArrayList<Goods> getMyGoods() {
		return myGoods;
	}

	public static void setMyGoods(ArrayList<Goods> myGoods) {
		Transport.myGoods = myGoods;
	}

	public String getTypeOfTransport() {
		return typeOfTransport;
	}

	public void setTypeOfTransport(String typeOfTransport) {
		this.typeOfTransport = typeOfTransport;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public int getMaxVolume() {
		return maxVolume;
	}

	public void setMaxVolume(int maxVolume) {
		this.maxVolume = maxVolume;
	}

	public int getTransportSpeed() {
		return transportSpeed;
	}

	public void setTransportSpeed(int transportSpeed) {
		this.transportSpeed = transportSpeed;
	}

	public int getPossibleDeliveryDay() {
		return possibleDeliveryDay;
	}

	public void setPossibleDeliveryDay(int possibleDeliveryDay) {
		this.possibleDeliveryDay = possibleDeliveryDay;
	}

	/** метод добавления транспорта в список */
	public void addTransport(Transport addingTransport) {
		getMyTransport().add(addingTransport);

	}

	/** метод добавления груза в список */
	public void addGoods(Goods addingGoods) {
		getMyGoods().add(addingGoods);

	}

	/** вывод общей для всех видов транспорта информации */
	public void showBasicTransportInfo() {
		System.out.println("Наименование транспорта: " + getTypeOfTransport());
		System.out.println("Максимальная грузоподьемность, кг: "
				+ getMaxWeight());
		System.out.println("Максимальные объем груза, м.куб.: "
				+ getMaxVolume());
		System.out.println("Средняя скорость транспорта, км/ч: "
				+ getTransportSpeed());
		System.out.println("День недели выезда транспорта: "
				+ getPossibleDeliveryDay());

	}

	/**
	 * переопределяемый в наследниках метод вывода специфической информации о
	 * траспорте
	 */
	public void showTransport() {

	}

	@Override
	/** метод выполняющий первое задание определенный в интерфейсе */
	public void showTransportForTime() {

		System.out
				.println("Задание 1 - ВОЗМОЖНОСТЬ ПЕРЕВОЗКИ ГРУЗА ЗА УКАЗАННОЕ ВРЕМЯ");
		System.out.println();
		for (Transport tr : getMyTransport()) {
			for (Goods go : getMyGoods()) {
				if (!((go.isOtherContinent()) && (tr instanceof Avto))) {
					if (go.getMaxTimeOfDelivery() > go.getDistance()
							/ tr.getTransportSpeed()) {

						System.out.println("Груз:");
						System.out
								.println("---------------------------------------------------");
						go.showGoodsInfo();
						System.out
								.println("---------------------------------------------------");
						System.out.println("может быть перевезен транспортом:");
						System.out
								.println("---------------------------------------------------");
						tr.showTransport();
						System.out
								.println("---------------------------------------------------");
						System.out.println("за время :"
								+ ((float) go.getDistance() / tr
										.getTransportSpeed()) + " ч.");
						System.out.println("при требуемых "
								+ go.getMaxTimeOfDelivery() + " ч.");
						System.out
								.println("---------------------------------------------------");
						showTransportForDay(tr, go);
						System.out.println();
						System.out.println();
						System.out.println();
					}

				}
			}
		}

	}

	/** метод выполняющий второе задание определенный в интерфейсе */
	@Override
	public void showTransportForVolume() {

		System.out
				.println("Задание 2 - ВОЗМОЖНОСТЬ ПЕРЕВОЗКИ ГРУЗА УКАЗАННОЙ МАССЫ И ОБЪЕМА");
		System.out.println();
		for (Transport tr : getMyTransport()) {
			for (Goods go : getMyGoods()) {
				if (!((go.isOtherContinent()) && (tr instanceof Avto))) {
					if ((go.getWeight() <= tr.getMaxWeight())
							&& (go.volumeCalculate() <= tr.getMaxVolume())) {

						System.out.println("Груз:");
						System.out
								.println("---------------------------------------------------");
						go.showGoodsInfo();
						System.out
								.println("---------------------------------------------------");
						System.out.println("может быть перевезен транспортом:");
						System.out
								.println("---------------------------------------------------");
						tr.showTransport();
						System.out
								.println("---------------------------------------------------");
						System.out.println("объем груза составляет :"
								+ go.volumeCalculate() + " м.куб");
						System.out.println("при максимально допустимом "
								+ tr.getMaxVolume() + " м.куб");
						System.out
								.println("---------------------------------------------------");
						System.out.println("масса груза составляет :"
								+ go.getWeight() + " кг");
						System.out.println("при максимально допустимой "
								+ tr.getMaxWeight() + " кг");
						System.out
								.println("---------------------------------------------------");
						showTransportForDay(tr, go);
						System.out.println();
						System.out.println();
						System.out.println();
					}

				}
			}
		}
	}

	/** метод воводящий количество дней до возможной отпраки груза */
	@Override
	public void showTransportForDay(Transport tr, Goods go) {
		int countOfDay = 0;

		if (tr.getPossibleDeliveryDay() < go.getDayStartDelivery()) {
			countOfDay = tr.getPossibleDeliveryDay() + 7
					- go.getDayStartDelivery();
		} else if (tr.getPossibleDeliveryDay() >= go.getDayStartDelivery()) {
			countOfDay = tr.getPossibleDeliveryDay() - go.getDayStartDelivery();
		}

		System.out.println("При предпологаемой готовности груза на: "
				+ go.getDayStartDelivery() + " день");

		if (countOfDay == 0) {
			System.out.println("Мы можем отправить ваш груз сегодня");
		} else {
			System.out.println("Мы можем отправить груз через: " + countOfDay
					+ " дней");
		}

	}

}

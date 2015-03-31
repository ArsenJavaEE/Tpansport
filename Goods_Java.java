package mypac1;

public class Goods implements Transportable {
	/** наименование груза */
	private String goodsName;
	/** масса груза */
	private int weight;
	/** растояние до получателя */
	private int distance;
	/** габариты груза */
	private int length;
	private int width;
	private int height;
	/** день готовности груза */
	private int dayStartDelivery;
	/** максимальное требуемое время доставки груза */
	private int maxTimeOfDelivery;
	/** достака на другой континет, если да - то не используется авто транспорт */
	private boolean otherContinent;
	/** переменная хранящая объем груза */
	private int volume;

	// конструкторы
	public Goods(String goodsName, int weight, int distance, int length,
			int width, int height, int dayStartDelivery, int maxTimeOfDelivery,
			boolean otherContinent) {

		this.goodsName = goodsName;
		this.weight = weight;
		this.distance = distance;
		this.length = length;
		this.width = width;
		this.height = height;
		this.dayStartDelivery = dayStartDelivery;
		this.maxTimeOfDelivery = maxTimeOfDelivery;
		this.otherContinent = otherContinent;
	}

	// геттеры и сеттеры
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDayStartDelivery() {
		return dayStartDelivery;
	}

	public void setDayStartDelivery(int dayStartDelivery) {
		this.dayStartDelivery = dayStartDelivery;
	}

	public int getMaxTimeOfDelivery() {
		return maxTimeOfDelivery;
	}

	public void setMaxTimeOfDelivery(int maxTimeOfDelivery) {
		this.maxTimeOfDelivery = maxTimeOfDelivery;
	}

	public boolean isOtherContinent() {
		return otherContinent;
	}

	public void setOtherContinent(boolean otherContinent) {
		this.otherContinent = otherContinent;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	/** метод вычисляющий объем груза, определенный в интерфейсе */
	public int volumeCalculate() {
		volume = width * height * length;
		return volume;
	}

	/** метод выводящий информацию о грузе */
	public void showGoodsInfo() {
		System.out.println("Наименование груза: " + getGoodsName());
		System.out.println("Вес груза, кг: " + getWeight());
		System.out.println("Расстояние до получателя, км.: " + getDistance());
		System.out.println("Габариты груза, м: " + getHeight() + "х"
				+ getLength() + "х" + getWidth());
		System.out
				.println("День недели формирования(готовности к отправки) груза: "
						+ getDayStartDelivery());
		System.out.println("Требуемое время доставки груза, ч: "
				+ getMaxTimeOfDelivery());
		System.out.println("Находится ли груз на другом континенте? "
				+ (isOtherContinent() ? "Да" : "Нет"));
	}
}

package mypac1;

/** интерфейс для транспорта */
public interface Movable {

	public void showTransport();

	public void showTransportForTime();

	public void showTransportForVolume();

	public void showTransportForDay(Transport tr, Goods go);

}

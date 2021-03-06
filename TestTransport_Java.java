package mypac1;

public class TestTransport {
	/**
	 * Задание: Транспортная компания, имеющая разные типы транспорта, каждый из
	 * которых описан собственной иерархией классов: автомобильный транспорт и
	 * авиационный. Предусмотреть реализацию общих для любого вида транспорта
	 * методов: 
	 * - возможность перевозки груза за указанное время; 
	 * - возможность перевозки груза указанной массы и габаритов; 
	 * - возможность отправки груза ближайшим по времени транспортом.
	 */

	public static void main(String[] args) {
		Transport MainTransport = new Transport();

		Goods bud = new Goods("Стройматериалы", 10000, 2000, 10, 20, 30, 4, 5,
				false);
		Goods wood = new Goods("Древесина", 20000, 50, 20, 5, 2, 5, 1, true);

		Transport truck = new Avto("Грузовик", 20000, 50000, 40, 3);
		Transport boing = new Avia("Самолет боинг", 50000, 100000, 1000, 1,
				"не опасный");

		MainTransport.addGoods(wood);
		MainTransport.addGoods(bud);
		MainTransport.addTransport(boing);
		MainTransport.addTransport(truck);

		MainTransport.showTransportForTime();
		MainTransport.showTransportForVolume();
	}

}

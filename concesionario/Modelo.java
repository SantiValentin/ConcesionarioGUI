package concesionario;

public enum Modelo {
	CORDOBA(Marca.SEAT), TOLEDO(Marca.SEAT), IBIZA(Marca.SEAT), SERIE_1(Marca.BMW), SERIE_2(Marca.BMW), SERIE_3(
			Marca.BMW), SERIE_5(Marca.BMW);

	private Marca brand;

	Modelo(Marca brand) {
		this.brand = brand;
	}

	public Marca getBrand() {
		return brand;
	}

	public void setBrand(Marca brand) {
		this.brand = brand;
	}
}

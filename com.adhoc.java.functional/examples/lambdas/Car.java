package examples.lambdas;

public class Car {
	private String id;
	private int costUSD;
	public Car(String id, int costUSD, String color, String type) {
		super();
		this.id = id;
		this.costUSD = costUSD;
		this.color = color;
		this.type = type;
	}
	public int getCostUSD() {
		return costUSD;
	}
	public void setCostUSD(int getCostUSD) {
		this.costUSD = getCostUSD;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String color;
	private String type;
	public Car(String id,String color, String type) {
		super();
		this.id=id;
		this.color = color;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", color=" + color + ", type=" + type + "]";
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}

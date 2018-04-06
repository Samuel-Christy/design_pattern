package Models;

public class MRole {

	private int id = -1;
	private String name;
	private boolean stored = false;

	public MRole(int id, String name, boolean stored) {

		this.id = id;
		this.name = name;
		this.stored = stored;
	}

	public MRole(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStored() {
		return stored;
	}

	public void setStored(boolean stored) {
		this.stored = stored;
	}

	@Override
	public String toString() {
		return "MRole [id=" + id + ", name=" + name + ", stored=" + stored + "]";
	}

}

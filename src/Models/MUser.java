package Models;

public class MUser {

	private boolean stored = false;
	private int id = -1;
	private String name;
	private MRole role;

	public MUser(int id, String name, MRole role) {

		this.id = id;
		this.name = name;
		this.role = role;
	}

	public MUser(String name, MRole role) {

		this(-1, name, role);
	}

	public MUser(MUser user) {

		id = user.id;
		stored = user.stored;
		name = user.name;
		role = user.role;

	}

	@Override
	public String toString() {
		return "MUser [stored=" + stored + ", id=" + id + ", name=" + name + ", role=" + role + "]";
	}

	public boolean isStored() {
		return stored;
	}

	public void setStored(boolean stored) {
		this.stored = stored;
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

	public MRole getRole() {
		return role;
	}

	public void setRole(MRole role) {
		this.role = role;
	}

}

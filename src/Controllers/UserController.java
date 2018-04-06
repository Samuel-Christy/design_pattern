package Controllers;

import Models.MRole;
import Models.MRoleStore;
import Models.MUser;
import Models.MUserStore;
import Views.VUsers;

public class UserController {

	private VUsers viewU = new VUsers();
	private RoleController rctrl = new RoleController();

	public UserController() {
		MUserStore.load();
	}

	public MUser addUser(String name, MRole role) {
		MUser u = new MUser(name, role);
		MUserStore.users.add(u);
		MUserStore.save();
		return u;
	}

	public void addUser() {

		viewU.write("Users list : ");
		printUsers();
		viewU.write("------------------------");
		viewU.write("------------------------");
		viewU.write("");
		viewU.write("Roles list : ");
		printRoles();

		viewU.write("choose a role, if it doesn't exist, it'll be created : ");
		MRole r = rctrl.findOrCreate(viewU.read());

		viewU.write("user's name : ");
		MUser u = addUser(viewU.read(), r);

		viewU.write("L'utilisateur " + u.getName() + " de type " + u.getRole().getName() + " a bien été créé.");

		printUsers();

	}

	public void printRoles() {
		viewU.write("------------------------");
		if (MRoleStore.roles.size() > 0) {
			for (MRole r : MRoleStore.roles) {
				viewU.write(r.getName());
			}
			viewU.write("------------------------");
		} else {
			viewU.write("no roles defined yet");
		}
	}

	public void printUsers() {
		viewU.write("------------------------");
		if (MUserStore.users.size() > 0) {
			viewU.write("role" + "\t=>\t" + "name");
			viewU.write("------------------------");
			for (MUser u : MUserStore.users) {
				viewU.write(u.getName() + "\t=>\t" + u.getRole().getName());
			}
		} else {
			viewU.write("no users defined yet");
		}
	}

}

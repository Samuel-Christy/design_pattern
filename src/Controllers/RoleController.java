package Controllers;

import Models.MRole;
import Models.MRoleStore;

public class RoleController {

	public RoleController() {
		MRoleStore.load();
	}

	public MRole addRole(String name) {

		MRole r = new MRole(name);
		MRoleStore.roles.add(r);
		MRoleStore.save();
		return r;

	}

	public MRole findRole(String name) {
		for (MRole r : MRoleStore.roles) {
			if (name.equals(r.getName())) {
				return r;
			}
		}
		return null;
	}

	public MRole findOrCreate(String name) {
		MRoleStore.load();
		MRole r = findRole(name);

		r = r == null ? addRole(name) : r;
		MRoleStore.save();
		r = findRole(name);

		return r;

	}

}

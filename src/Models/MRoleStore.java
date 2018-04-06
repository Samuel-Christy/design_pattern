package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import PDO.PDOSqlite;

public class MRoleStore {

	public static ArrayList<MRole> roles = new ArrayList<MRole>();

	public static void load() {
		ResultSet r = PDOSqlite.executeSQL("SELECT * FROM roles");

		if (r != null) {
			try {
				roles = new ArrayList<MRole>();
				while (r.next()) {
					MRole rr = new MRole(r.getString("role_name"));
					rr.setId(r.getInt("id"));
					roles.add(rr);
					// System.out.println(rr);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void save() {
		for (MRole r : roles) {
			if (r.getId() == -1) {
				PDOSqlite.executeSQL("insert into roles (role_name) VALUES (\"" + r.getName() + "\");");
				// System.out.println(r);
			}
		}
		MRoleStore.load();
	}

	public static MRole assoc(int role_id) {
		for (MRole mRole : roles) {
			if (mRole.getId() == role_id) {
				return mRole;
			}
		}
		return null;
	}

}

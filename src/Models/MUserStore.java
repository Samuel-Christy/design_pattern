package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import PDO.PDOSqlite;

public class MUserStore {

	public static ArrayList<MUser> users = new ArrayList<MUser>();

	public static void load() {
		ResultSet r = PDOSqlite.executeSQL("SELECT * FROM users");

		if (r != null) {
			try {
				users = new ArrayList<MUser>();
				while (r.next()) {
					MUser u = new MUser(r.getInt("id"), r.getString("name"), MRoleStore.assoc(r.getInt("role_id")));
					users.add(u);
					// users.add(rr);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void save() {
		MRoleStore.save();
		for (MUser r : users) {

			if (r.getId() < 0) {

				String sql = "insert into users (name,role_id) VALUES (\"" + r.getName() + "\"," + r.getRole().getId()
						+ ")";
				PDOSqlite.executeSQL(sql);
			}
		}
		MUserStore.load();
	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection connect() throws SQLException {

        try {
            // Get database credentials from DatabaseConfig class
            var jdbcUrl = DatabaseConfig.getDbUrl();
            var user = DatabaseConfig.getDbUsername();
            var password = DatabaseConfig.getDbPassword();

            // Open a connection
            return DriverManager.getConnection(jdbcUrl, user, password);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void disconnect(Connection connection) {
        try {
            connection.close();
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    public static Person login(Connection conn, String name, String cnic) {
        var sql = "SELECT * FROM \"Data\" where name='" + name + "' and cnic='" + cnic + "'";
        Person person = null;
        try (var stmt = conn.createStatement()) {
            var rs = stmt.executeQuery(sql);

            while (rs.next()) {
                person = new Person(
                        rs.getString("name"),
                        rs.getString("cnic"),
                        rs.getString("city"),
                        rs.getString("place"),
                        rs.getString("area"),
                        rs.getString("constitution"),
                        rs.getInt("id")
                );
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return person;
    }

    public static Candidate_Data Candidate(Connection conn, String constitution) {
        var sql = "SELECT * FROM \"Candidate\" where constitution='" + constitution + "'";
        Candidate_Data candidate_data = null;
        try (var stmt = conn.createStatement()) {

            var rs = stmt.executeQuery(sql);

            while (rs.next()) {
                candidate_data = new Candidate_Data(
                        rs.getString("constitution"),
                        rs.getString("pti"),
                        rs.getString("ptisymbol"),
                        rs.getString("pmln"),
                        rs.getString("pmlnsymbol"),
                        rs.getString("ppp"),
                        rs.getString("pppsymbol")
                );
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return candidate_data;
    }
}

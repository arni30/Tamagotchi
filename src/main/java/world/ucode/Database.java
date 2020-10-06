package world.ucode;

import java.sql.*;

public class Database {
    private String url = "jdbc:sqlite:src/main/resources/" + "Tamagotchi.sqlite";
    String sql = "CREATE TABLE IF NOT EXISTS tamagotchi (\n"
            + "	id integer PRIMARY KEY,\n"
            + "	name text NOT NULL,\n"
            + "	type text NOT NULL,\n"
            + "	health double,\n"
            + "	hunger double,\n"
            + "	thrist double,\n"
            + "	cleanlines double,\n"
            + "	happiness double\n"
            + ");";

    public void createDB() {
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                meta.getDriverName();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createTable() {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private Connection connect() {
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public void insert(String name, String type, double health, double hunger,
                       double thrist, double cleanlines, double happiness) {
        String sql = "INSERT INTO tamagotchi(name,type,health,hunger,thrist,cleanlines,happiness) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, type);
            pstmt.setDouble(3, health);
            pstmt.setDouble(4, hunger);
            pstmt.setDouble(5, thrist);
            pstmt.setDouble(6, cleanlines);
            pstmt.setDouble(7, happiness);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public ResultSet selectAll(){
        String sql = "SELECT name, type, health, hunger, thrist, cleanlines, happiness FROM tamagotchi";
        ResultSet rs = null;
        try {
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            rs = stmt.executeQuery(sql);

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
    public void deleteRow(String name, String type) {
        try {
            Connection conn = this.connect();
            PreparedStatement st = conn.prepareStatement("DELETE FROM tamagotchi WHERE name = ? AND type = ?");
            st.setString(1 ,name);
            st.setString(2 ,type);
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}

import java.sql.*;

public class Patient {

    Connection conn;

    public Patient() throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
        }
        catch (Exception e) {
        }
        conn = DriverManager.getConnection(dbUrl, "postgres", "ajaklnm1998");
    }

    public void createTablePatients() throws SQLException {
        try {
            Statement s = conn.createStatement();
            String sqlStr = "create table patients (id SERIAL PRIMARY KEY, familyname varchar(128) NOT NUll, givenname varchar(128) NOT NULL, phonenumber varchar(32));";
            s.execute(sqlStr);
            s.close();
        }
        catch (Exception e) {
        }
    }

    public void insertPatient(String famName, String gvnName, String phoNum) {
        try {
            Statement s=conn.createStatement();
            String sqlStr = "insert into patients (familyname,givenname,phonenumber) values ('"+famName+"','"+gvnName+"','"+phoNum+"');";
            s.execute(sqlStr);
            s.close();
        }
        catch (Exception e) {
        }
    }

  public void getPatient(int gvnID) {
        try {
            Statement s=conn.createStatement();
            String sqlStr = "SELECT * FROM patients WHERE id="+gvnID+";";
            ResultSet rset = s.executeQuery(sqlStr);
            while (rset.next()) {
                System.out.println(rset.getInt("id")+" "+ rset.getString("familyname")+" "+ rset.getString("givenname")+" "+ rset.getString("phonenumber"));
            }
            rset.close();
            s.close();
        }
        catch (Exception e) {
        }
  }

  public void getPhoneNumber(String gvnName) {
      try {
          Statement s=conn.createStatement();
          String sqlStr = "SELECT * FROM patients WHERE givenname='"+gvnName+"';";
          ResultSet rset = s.executeQuery(sqlStr);
          while (rset.next()) {
              System.out.println(rset.getString("givenname")+" "+ rset.getString("phonenumber"));
          }
          rset.close();
          s.close();
      }
      catch (Exception e) {
      }
  }

  public void updatePhoneNumber(int gvnID,String gvnPhoneNum) {
    try {
        Statement s=conn.createStatement();
        String sqlStr = "UPDATE patients SET phonenumber='"+gvnPhoneNum+"' WHERE id="+gvnID+";";
        s.execute(sqlStr);
        s.close();
    }
    catch (Exception e) {
    }
  }

}

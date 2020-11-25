import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Patient p_db = new Patient();
        /*p_db.createTablePatients();
        p_db.insertPatient("Vroullides","Neophytos","07493798139");
        p_db.insertPatient("Jones","Bill","07755678899");
        p_db.insertPatient("Smith","John","0775dd8899");*/
        p_db.getPatient(2);
        p_db.getPhoneNumber("Bill");
        p_db.updatePhoneNumber(2,"+4476886379");
        p_db.getPatient(2);

    }
}



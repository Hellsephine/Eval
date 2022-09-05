package eval;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    protected int id;
    protected int user_id;
    protected String user_pseudo;
    protected String user_pw;
    protected String user_name;
    protected String user_mail;
    protected List<Integer> f_id;

    public Utilisateur(int id){
        ResultSet resultat = DBManager.execute("SELECT * FROM user WHERE user_id ="+id);
        try {
            resultat.next();
            user_id = resultat.getInt("user_id");
            user_pseudo = resultat.getString("user_pseudo");
            user_pw = resultat.getString("user_pw");
            user_name = resultat.getString("user_name");
            user_mail = resultat.getString("user_mail");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        resultat = DBManager.execute("SELECT follow_id FROM follow WHERE user_id ="+id);
        try {
            f_id = new ArrayList<>();
            while(resultat.next()){
            f_id.add(resultat.getInt("follow_id"));
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_pseudo() {
        return user_pseudo;
    }

    public void setUser_pseudo(String user_pseudo) {
        this.user_pseudo = user_pseudo;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public List<Integer> getF_id() {
        return f_id;
    }

    public int getUser_id() {
        return user_id;
    }

    
}

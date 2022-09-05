package eval;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Post {
    protected int post_id;
    protected int id;
    protected String titre_post;
    protected String content_post;

    Post(int id){
        ResultSet resultat = DBManager.execute("SELECT * FROM post WHERE user_id = "+id+" ORDER BY post_id DESC LIMIT 1");
        try {
            resultat.next();
            post_id = resultat.getInt("post_id");
            titre_post = resultat.getString("titre");
            content_post = resultat.getString("content");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public int getPost_id() {
        return post_id;
    }

    public int getId() {
        return id;
    }

    public String getTitre_post() {
        return titre_post;
    }

    public String getContent_post() {
        return content_post;
    }

    
}

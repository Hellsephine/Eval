package eval;

import java.util.List;
import java.util.Scanner;

import org.checkerframework.checker.units.qual.s;

public class App {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        DBManager.init();

        System.out.println("Quel est votre Id ? (Entre 1 & 5)");
        int id = scan.nextInt();
        scan.nextLine();
        Utilisateur user = new Utilisateur(id);
        System.out.println("Bonjour "+user.getUser_pseudo()+"\n");
        //System.out.println("ID : "+id+"\n"+"Pseudo : "+user.getUser_pseudo()+"\n"+"Password : "+user.getUser_pw()+"\n"+"Real Name : "+user.getUser_name()+"\n"+"@ : "+user.getUser_mail()+"\n");
    
        System.out.println("Que voulez-vous faire ?");
        System.out.println("Taper 1 pour afficher tout les profils");
        System.out.println("Taper 2 pour avoir la liste des profils que vous suivez");
        System.out.println("Taper 3 pour faire un post");
        int choix = scan.nextInt();
        scan.nextLine();
        Navigation(choix, user);

     
        
        
    }

    public static void Navigation(int choix, Utilisateur user){
        if(choix == 1){
            System.out.println("Voici la listes des profils disponible : ");
            for (int i = 1;i < 6;i++){
            Utilisateur userL = new Utilisateur(i);
            System.out.println("ID : "+userL.getUser_id()+"\n"+"Pseudo : "+userL.getUser_pseudo()+"\n"+"Password : "+userL.getUser_pw()+"\n"+"Real Name : "+userL.getUser_name()+"\n"+"@ : "+userL.getUser_mail()+"\n");
            }
            return;

        }
        else if(choix == 2){
            List<Integer> follow = user.getF_id();
            
            for( int i = 0; i < follow.size();i++){
                Utilisateur userF = new Utilisateur(follow.get(i));
                System.out.println("Vous suivez les utilisateur suivant "+follow.get(i)+" "+userF.getUser_pseudo());
            }

            System.out.println("Qui voulez-vous suivre ?");
            int choix1 = scan.nextInt();
            scan.nextLine();
            Abonnement(choix1,user);
        }
        else if(choix == 3){
            System.out.println("Quel titre ?");
            String titre = scan.nextLine();
            System.out.println("Que voulez-vous dire ?");
            String content = scan.nextLine();
            Utilisateur userP = new Utilisateur(user.getUser_id());
            //Post post = new Post(userP.getId());
            DBManager.executeUpdate("INSERT INTO post(user_id,titre,content,time) VALUES ('"+userP.getUser_id()+"','"+titre+"','"+content+"',CURRENT_TIMESTAMP);");
            //Affichage du post pas fini
            //System.out.println("Félicitation pour votre post le voici :"+"\n"+"ID du post "+post.getPost_id()+"\n"+"Titre : "+post.getTitre_post()+"\n"+"Contenu : "+post.getContent_post());
            System.out.println("Merci d'avoir exprimé votre pensée.");
         
        }
    }

    public static void Abonnement(int choix1, Utilisateur user){
        
        DBManager.executeUpdate("INSERT INTO follow VALUES ('"+choix1+"','"+user.user_id+"');");
        Utilisateur userA = new Utilisateur(choix1);
        System.out.println("Vous vous etes abonné à "+userA.getUser_pseudo());
        
    }
}

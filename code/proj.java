
import java.sql.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class proj {
    private Connection c = null;
    private String dbName;
    private boolean isConnected = false;

    private void openConnection(String _dbName){
        //opens database
        dbName = _dbName;

        if(false == isConnected){
            System.out.println("------------------------------------");
            System.out.println("Open database: " + _dbName);
        
            try{
                String connStr = new String("jdbc:sqlite:");
                connStr = connStr + _dbName;

                Class.forName("org.sqlite.JDBC");

                c = DriverManager.getConnection(connStr);

                c.setAutoCommit(false);

                isConnected = true;
                System.out.println("Opening connection was successful.");
            }
            catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }

            System.out.println("------------------------------------");
        
        }

    } //end of openConnection()

    private void closeConnection(){
        //closes database
        if(isConnected == true){
            System.out.println("------------------------------------");
            System.out.println("Close database: " + dbName);

            try{
                c.close();  // closes connection

                isConnected = false;    
                dbName = "";    // sets database name back to an empty string in case we want to open another connection with another dbNmae
                System.out.println("Closing database was successful.");

            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("------------------------------------");

        }

    }// end of closeConnection()

    private void createTables(){ 
        System.out.println("------------------------------------");
        System.out.println("Create tables");

        try{
            Statement stmt = c.createStatement();

            String sql = "create table NormalIdentity ( " +
                "nl_ID integer," +
                "nl_PersonID integer, " + 
                "nl_Name char(40) not null, " +
                "nl_Occupation char(40) not null, " +
                "nl_Gender char(2) not null, " +
                "nl_DoB Date not null," +
                "nl_Location char(40) not null)";
            stmt.execute(sql);

            sql = "create table Superhero( "+
                "sh_ID integer, "+
                "sh_SuperheroID integer, "+
                "sh_Name char(40) not null, "+
                "sh_SuperpowerID integer, "+
                "sh_Description char(100) not null)";
            stmt.execute(sql);

            sql = "create table Antihero( " +
                "ah_ID integer, " +
                "ah_AntiheroID integer, " +
                "ah_Name char(40) not null, " +
                "ah_SuperpowerID integer, " +
                "ah_Description char(100) not null)";
            stmt.execute(sql);

            sql = "create table Villain( " +
                "v_ID integer, " +
                "v_VillainID integer, " +
                "v_Name char(40) not null, " +
                "v_SuperpowerID integer, " +
                "v_Description char(100) not null)";
            stmt.execute(sql);

            sql = "create table Team( " +
                "t_SuperheroID integer, " +
                "t_AntiheroID integer, " +
                "t_VillainID integer, " +
                "t_Name char(40) not null, " +
                "t_TeamID integer)";
            stmt.execute(sql);

            sql = "create table Version( " +
                "ver_ID integer, " +
                "ver_SuperheroID integer, " +
                "ver_AntiheroID integer, " +
                "ver_VillainID integer, " +
                "ver_Name char(40) not null)";
            stmt.execute(sql);

            sql = "create table Superpower( " +
                "sp_ID integer, " +
                "sp_PowerID integer, " +
                "sp_Name char(40) not null, " +
                "sp_Description char(100) not null)";
            stmt.execute(sql);

            sql = "create table Archenemy( " +
                "ae_ID integer, " +
                "ae_SuperheroID integer, " +
                "ae_VillainID integer)";
            stmt.execute(sql);

            sql = "create table Race( "+
                "r_ID integer, " +
                "r_Name char(40) not null)";
            stmt.execute(sql);

            sql = "create table Dimension( " +
                "d_DimensionID integer, " +
                "d_VersionID integer, " +
                "d_Name integer)";
            stmt.execute(sql);

            c.commit();
            
            stmt.close();
            System.out.println("success");

        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            try{
                c.rollback();
            } catch (Exception e1){
                System.err.println(e1.getClass().getName() + ": " +e1.getMessage());
            }
        }

        System.out.println("------------------------------------");
    }

    private void populateTable(){
        //populates the table
    }


    private void dropTables(){
        //drops table, deletes it and is now long available
        System.out.println("------------------------------------");
        System.out.println("Drop tables");

        try{

            Statement stmt = c.createStatement();

            String sql = "drop table NormalIdentity";
            stmt.execute(sql);

            sql = "drop table Superhero";
            stmt.execute(sql);

            sql = "drop table Antihero";
            stmt.execute(sql);

            sql = "drop table Villain";
            stmt.execute(sql);

            sql = "drop table Team";
            stmt.execute(sql);

            sql = "drop table Version";
            stmt.execute(sql);

            sql = "drop table Superpower";
            stmt.execute(sql);

            sql = "drop table Archenemy";
            stmt.execute(sql);

            sql = "drop table Race";
            stmt.execute(sql);

            sql = "drop table Dimension";
            stmt.execute(sql);

            sql = "drop table FromWhere";
            stmt.execute(sql);

            c.commit();
            
            stmt.close();
            System.out.println("success");

        } catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            try{
                c.rollback();
            } catch (Exception e1){
                System.err.println(e1.getClass().getName() + ": " +e1.getMessage());
            }
        }

        System.out.println("------------------------------------");



    }


    //----------------------------DC----------------------------
    private void allDCChars(){

        try {
            String sql = "SELECT nl_Name as realName, sh_Name as character, r_Name as type_race " +
            "from NormalIdentity, Superhero, Race " +
            "where nl_ID = sh_ID and sh_race = r_ID and sh_from = 2 " +
            "UNION " +
            "SELECT nl_Name as realName, v_Name as character, r_Name as type_race " +
            "from NormalIdentity, Villain, Race " +
            "where nl_ID = v_ID and v_race = r_ID and v_from = 2 " +
            "union  " +
            "SELECT nl_Name as realName, ah_Name as character, r_Name as type_race " +
            "from NormalIdentity, Antihero, Race " +
            "where nl_ID = ah_ID and ah_race = r_ID and ah_from = 2;";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s %-45s %-45s\n", "Real Name", "Character Name","race");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String race = rs.getString(3);
                System.out.printf("%-45s%-45s%-45s\n", realName, charac,race);
                //System.out.println(realName + " | " + charac + " | " + race);
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }


    private void allDCHeroes(){

        try {
            String sql = "SELECT nl_Name as realName, sh_Name as character, r_Name as type_race " +
            "from NormalIdentity, Superhero, Race " +
            "where nl_ID = sh_ID and sh_race = r_ID and sh_from = 2";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s %-45s %-45s\n", "Real Name", "Character Name","race");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String race = rs.getString(3);
                System.out.printf("%-45s%-45s%-45s\n", realName, charac,race);
                //System.out.println(realName + " | " + charac + " | " + race);
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }


    private void allDCVillains(){

        try {
            String sql = "SELECT nl_Name as realName, v_Name as character, r_Name as type_race " +
            "from NormalIdentity, Villain, Race " +
            "where nl_ID = v_ID and v_race = r_ID and v_from = 2";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s %-45s %-45s\n", "Real Name", "Character Name","race");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String race = rs.getString(3);
                System.out.printf("%-45s%-45s%-45s\n", realName, charac,race);
                //System.out.println(realName + " | " + charac + " | " + race);
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }


    private void allDCAntiHeroes(){

        try {
            String sql = "SELECT nl_Name as realName, ah_Name as character, r_Name as type_race " +
            "from NormalIdentity, Antihero, Race " +
            "where nl_ID = ah_ID and ah_race = r_ID and ah_from = 2";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s %-45s %-45s\n", "Real Name", "Character Name","race");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String race = rs.getString(3);
                System.out.printf("%-45s%-45s%-45s\n", realName, charac,race);
                //System.out.println(realName + " | " + charac + " | " + race);
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }




    //--------------------------MARVEL-----------------------------------

    private void allMarvelChars(){

        try {
            String sql = "SELECT nl_Name as realName, sh_Name as character, r_Name as type_race " +
            "from NormalIdentity, Superhero, Race " +
            "where nl_ID = sh_ID and sh_race = r_ID and sh_from = 1 " +
            "UNION " +
            "SELECT nl_Name as realName, v_Name as character, r_Name as type_race " +
            "from NormalIdentity, Villain, Race " +
            "where nl_ID = v_ID and v_race = r_ID and v_from = 1 " +
            "union  " +
            "SELECT nl_Name as realName, ah_Name as character, r_Name as type_race " +
            "from NormalIdentity, Antihero, Race " +
            "where nl_ID = ah_ID and ah_race = r_ID and ah_from = 1";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s %-45s %-45s\n", "Real Name", "Character Name","race");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String race = rs.getString(3);
                System.out.printf("%-45s%-45s%-45s\n", realName, charac,race);
                //System.out.println(realName + " | " + charac + " | " + race);
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }


    
    private void allMarvelHeroes(){

        try {
            String sql = "SELECT nl_Name as realName, sh_Name as character, r_Name as type_race " +
            "from NormalIdentity, Superhero, Race " +
            "where nl_ID = sh_ID and sh_race = r_ID and sh_from = 1";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s %-45s %-45s\n", "Real Name", "Character Name","race");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String race = rs.getString(3);
                System.out.printf("%-45s%-45s%-45s\n", realName, charac,race);
                //System.out.println(realName + " | " + charac + " | " + race);
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }


    private void allMarvelVillains(){

        try {
            String sql = "SELECT nl_Name as realName, v_Name as character, r_Name as type_race " +
            "from NormalIdentity, Villain, Race " +
            "where nl_ID = v_ID and v_race = r_ID and v_from = 1";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s %-45s %-45s\n", "Real Name", "Character Name","race");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String race = rs.getString(3);
                System.out.printf("%-45s%-45s%-45s\n", realName, charac,race);
                //System.out.println(realName + " | " + charac + " | " + race);
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }


    private void allMarvelAntiHeroes(){

        try {
            String sql = "SELECT nl_Name as realName, ah_Name as character, r_Name as type_race " +
            "from NormalIdentity, Antihero, Race " +
            "where nl_ID = ah_ID and ah_race = r_ID and ah_from = 1";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s %-45s %-45s\n", "Real Name", "Character Name","race");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String race = rs.getString(3);
                System.out.printf("%-45s%-45s%-45s\n", realName, charac,race);
                //System.out.println(realName + " | " + charac + " | " + race);
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }


// ----------------------- Both DC and Marvel
    private void AllChars(){
        try {
            String sql = "SELECT nl_Name as realName, sh_Name as character, r_Name as type_race " +
            "from NormalIdentity, Superhero, Race " +
            "where nl_ID = sh_ID and sh_race = r_ID  " +
            "UNION " +
            "SELECT nl_Name as realName, v_Name as character, r_Name as type_race " +
            "from NormalIdentity, Villain, Race " +
            "where nl_ID = v_ID and v_race = r_ID " +
            "union  " +
            "SELECT nl_Name as realName, ah_Name as character, r_Name as type_race " +
            "from NormalIdentity, Antihero, Race " +
            "where nl_ID = ah_ID and ah_race = r_ID;";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s %-45s %-45s\n", "Real Name", "Character Name","race");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String race = rs.getString(3);
                System.out.printf("%-45s%-45s%-45s\n", realName, charac,race);
                //System.out.println(realName + " | " + charac + " | " + race);
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }



    
    public static void main(String args[]){
        proj sj = new proj();

        sj.openConnection("data.sqlite");

         //sj.dropTables();
         //sj.createTables();
        // sj.populateTables();

        // //queries
        // sj.queryName();
        // ...

        Scanner input = new Scanner(System.in);

      System.out.println("Welcome to our Marvel/DC character Database.");
      System.out.println("Are you a new User or the Admin?");
      System.out.println("If new User please enter 1");
      System.out.println("If Admin please enter 2");
      int whoareyou = input.nextInt();

      if (whoareyou == 1){
        System.out.println("Welcome new User what would you like to look at?");
        System.out.println("the Marvel Database press 1");
        System.out.println("The DC Database press 2");
        System.out.println("Or both at them press 3");
        int whatyouwannasee = input.nextInt();

        if (whatyouwannasee == 1){
          System.out.println("welcome to Marvel Database what do wanna see buddy");
          System.out.println("To see all characters press 1");
          System.out.println("To see a specific character press 2");
          System.out.println("To find a custom search press 3");
          int marvelsearch = input.nextInt();

          if (marvelsearch == 1){
            System.out.println("Now choose which tables you would like to see");
            System.out.println("To see all Heros press 1");
            System.out.println("To see all Villians press 2");
            System.out.println("To see all Anti-Heros press 3");
            System.out.println("To see all of them press 4");
            int marvelsearch1 = input.nextInt();

            if (marvelsearch1 == 1){
                System.out.println("now printing all the heros of marvel");
                sj.allMarvelHeroes();
            }
            if (marvelsearch1 == 2){
                System.out.println("now printing all the Villians of marvel");
                sj.allMarvelVillains();
            }
            if (marvelsearch1 == 3){
              System.out.println("now printing all the Anti-Heros of marvel");
                sj.allMarvelAntiHeroes();
            }
            if (marvelsearch1 == 4){
              System.out.println("now printing all the characters of marvel");
                sj.allMarvelChars();
            }
          }
          if (marvelsearch == 2){
            System.out.println("Now choose what alignment your character belongs too");
            System.out.println("To see all Heros press 1");
            System.out.println("To see all Villians press 2");
            System.out.println("To see all Anti-Heros press 3");
            int marvelsearch2 = input.nextInt();
          }
          if (marvelsearch == 3){
            System.out.println("now tell me traveler watcha looking for");
          }


        }
        if (whatyouwannasee == 2){
          System.out.println("welcome to DC Database what do wanna see buddy");
          System.out.println("To see all characters press 1");
          System.out.println("To see a specific character press 2");
          System.out.println("To find a custom search press 3");
          int dcsearch = input.nextInt();

        if (dcsearch == 1){
          System.out.println("Now choose which tables you would like to see");
          System.out.println("To see all Heros press 1");
          System.out.println("To see all Villians press 2");
          System.out.println("To see all Anti-Heros press 3");
          System.out.println("To see all of them press 4");
          int dcsearch1 = input.nextInt();

          if (dcsearch1 == 1){
            System.out.println("now printing all the heros of DC");
            sj.allDCHeroes();

          }
          if (dcsearch1 == 2){
            System.out.println("now printing all the Villians of DC");
            sj.allDCVillains();
          }
          if (dcsearch1 == 3){
            System.out.println("now printing all the Anti-Heros of DC");
            sj.allDCAntiHeroes();
          }
          if (dcsearch1 == 4){
            System.out.println("now printing all the characters of DC");

            sj.allDCChars();
          }
        }
        if (dcsearch == 2){
          System.out.println("Now choose what alignment your character belongs too");
          System.out.println("To see all Heros press 1");
          System.out.println("To see all Villians press 2");
          System.out.println("To see all Anti-Heros press 3");
          int dcsearch2 = input.nextInt();
        }
        if (dcsearch == 3){
          System.out.println("now tell me traveler watcha looking for");
        }
      }

        if (whatyouwannasee == 3){
            System.out.println("welcome to Marvel & DC Database what do wanna see buddy");
            System.out.println("To see all characters press 1");
            System.out.println("To see a specific character press 2");
            System.out.println("To find a custom search press 3");
            int marveldcsearch = input.nextInt();


            if(marveldcsearch == 1){
                sj.AllChars();
            }

        }




    }


    if (whoareyou == 2){
        System.out.println("Welcome back Master plwes put pwassword plws");
        int psswrd = input.nextInt();

        if (psswrd == 1111){
          System.out.println("Correct password welcome back");
        }
        else{
          System.out.println("Incorrect password bzz bzz");
        }

      }




        sj.closeConnection();

    }

}


/* 

Calling on terminal

-> javac proj.java

-> java -classpath ".:sqlite-jdbc-3.32.3.2.jar" proj

*/


//
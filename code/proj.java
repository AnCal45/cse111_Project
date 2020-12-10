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


    private void CallCharWithName(String name){
        try{
            String sql = "SELECT nl_Name as realName, sh_Name as character, nl_Gender as gender, nl_DoB as Birthplace, where_name as franchise, r_Name as raceName " +
            "from NormalIdentity, Superhero, FromWhere, Race " +
            "where nl_ID = sh_ID and sh_from = where_id and sh_race = r_ID and sh_Name = '"+ name + "' "+
            "UNION " +
            "SELECT nl_Name as realName, v_Name as character, nl_Gender as gender, nl_DoB as Birthplace, where_name as franchise, r_Name as raceName " +
            "from NormalIdentity, Villain, FromWhere, Race " +
            "where nl_ID = v_ID and v_from = where_id and  v_race = r_ID and v_Name =  '"+ name + "' "+
            "union  " +
            "SELECT nl_Name as realName, ah_Name as character, nl_Gender as gender, nl_DoB as Birthplace, where_name as franchise, r_Name as raceName " +
            "from NormalIdentity, Antihero, FromWhere, Race " +
            "where nl_ID = ah_ID and ah_from = where_id and ah_race = r_ID and ah_Name = '"+ name + "'";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-35s %-35s %-35s %-35s %-35s %-35s\n", "Real Name", "Character Name","Gender", "Birthplace", "Franchise", "Race Name");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String gender = rs.getString(3);
                String birth = rs.getString(4);
                String franchise = rs.getString(5);
                String raceName = rs.getString(6);
                System.out.printf("%-35s%-35s%-35s%-35s%-35s%-35s\n", realName, charac, gender, birth, franchise, raceName);
                //System.out.println(realName + " | " + charac + " | " + race);
            }

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");

    }


    // -------------------------Heroes-----------------------
    private void HeroOfType(String race, String fromWhere){
        try{
            String sql = "SELECT nl_Name as realName, sh_Name as character, nl_Gender as gender, nl_DoB as Birthplace, where_name as franchise, r_Name as raceName " +
            "from NormalIdentity, Superhero, FromWhere, Race " +
            "where nl_ID = sh_ID and sh_from = where_id and where_name = '" + fromWhere + "' and sh_race = r_ID and r_Name = '"+ race + "' ";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-35s %-35s %-35s %-35s %-35s %-35s\n", "Real Name", "Character Name","Gender", "Birthplace", "Franchise", "Race Name");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String gender = rs.getString(3);
                String birth = rs.getString(4);
                String franchise = rs.getString(5);
                String raceName = rs.getString(6);
                System.out.printf("%-35s%-35s%-35s%-35s%-35s%-35s\n", realName, charac, gender, birth, franchise, raceName);
                //System.out.println(realName + " | " + charac + " | " + race);
            }

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");


    }


    private void heroByGender(String gender, String fromWhere){
        try{
            String sql = "SELECT nl_Name as realName, sh_Name as character,nl_DoB as Birthplace, where_name as franchise, r_Name as raceName " +
            "from NormalIdentity, Superhero, FromWhere, Race " +
            "where nl_ID = sh_ID and sh_from = where_id and where_name = '" + fromWhere + "' and sh_race = r_ID and nl_Gender = '"+ gender + "' ";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-35s %-35s %-35s %-35s %-35s\n", "Real Name", "Character Name", "Birthplace", "Franchise", "Race Name");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String birth = rs.getString(3);
                String franchise = rs.getString(4);
                String raceName = rs.getString(5);
                System.out.printf("%-35s%-35s%-35s%-35s%-35s\n", realName, charac, birth, franchise, raceName);
            }


        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        System.out.println("------------------------------------");
    }


    private void HeroOfTeam(String teamName, String fromWhere){
        try{
            System.out.println("Still need to add this part");

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");
    }


    //-------------------------Villains-----------------------------
    private void VillianOfRace(String race, String fromWhere){
        try{
            String sql = "SELECT nl_Name as realName, v_Name as character, nl_Gender as gender, nl_DoB as Birthplace, where_name as franchise, r_Name as raceName " +
            "from NormalIdentity, Villain, FromWhere, Race " +
            "where nl_ID = v_ID and v_from = where_id and where_name = '" + fromWhere + "' and  v_race = r_ID and r_Name =  '"+ race + "' ";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-35s %-35s %-35s %-35s %-35s %-35s\n", "Real Name", "Character Name","Gender", "Birthplace", "Franchise", "Race Name");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String gender = rs.getString(3);
                String birth = rs.getString(4);
                String franchise = rs.getString(5);
                String raceName = rs.getString(6);
                System.out.printf("%-35s%-35s%-35s%-35s%-35s%-35s\n", realName, charac, gender, birth, franchise, raceName);
            }

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");
    }


    private void villainByGender(String gender, String fromWhere){
        try{
            String sql = "SELECT nl_Name as realName, v_Name as character, nl_DoB as Birthplace, where_name as franchise, r_Name as raceName " +
            "from NormalIdentity, Villain, FromWhere, Race " +
            "where nl_ID = v_ID and v_from = where_id and where_name = '" + fromWhere + "' and  v_race = r_ID and nl_Gender =  '"+ gender + "' ";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-35s %-35s %-35s %-35s %-35s\n", "Real Name", "Character Name", "Birthplace", "Franchise", "Race Name");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                String birth = rs.getString(3);
                String franchise = rs.getString(4);
                String raceName = rs.getString(5);
                System.out.printf("%-35s%-35s%-35s%-35s%-35s\n", realName, charac, birth, franchise, raceName);
            }

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");
    }

    
    private void VillainOfTeam(String teamName, String fromWhere){
        try{
            System.out.println("Still need to add this part");

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
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
        System.out.println("------------------------------------");

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
        System.out.println("------------------------------------");

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
        System.out.println("------------------------------------");

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
        System.out.println("------------------------------------");

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
        System.out.println("------------------------------------");

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
        System.out.println("------------------------------------");

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
        System.out.println("------------------------------------");

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
        System.out.println("------------------------------------");

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
        System.out.println("------------------------------------");

    }

    private void VillainFromEarthNotHuman(){
        try {
            String sql = "SELECT nl_Name, v_Name"+
            "from Villain, NormalIdentity, Race "+
            "where nl_ID = v_ID and v_race = r_ID "+
            "    and r_Name <> 'human' and nl_DoB = 'Earth'";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s %-45s\n", "Real Name", "Character Name");

            while(rs.next()){
                String realName = rs.getString(1);
                String charac = rs.getString(2);
                System.out.printf("%-45s%-45s\n", realName, charac);
               
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");
    }


    private void HeroWithArchenemy(){
        try {
            String sql = "SELECT sh_Name " +
            "from Superhero, (SELECT ae_SuperheroID " +
            "                from Archenemy " +
            "                group by ae_SuperheroID " +
            "                having count(*)>= 3) " +
            "where ae_SuperheroID = sh_ID";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s\n", "Character Name");

            while(rs.next()){
                String charac = rs.getString(1);
                System.out.printf("%-45s\n", charac);
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");
    }


    private void AffiliationWithMostWomen(){
        try {
            String sql = "SELECT  " +
            "case  " +
            "    WHEN sh_femaleCount > ah_femaleCount and sh_femaleCount > v_femaleCount THEN " +
            "            'Superhero' " +
            "    WHEN ah_femaleCount > sh_femaleCount and ah_femaleCount > v_femaleCount THEN " +
            "            'Antihero' " +
            "    ELSE  " +
            "            'Villain' " +
            "    end groupName " +
        "from (SELECT count(*) as sh_femaleCount " +
        "    from Superhero, NormalIdentity " +
        "    where sh_ID = nl_ID and nl_Gender = 'f'), (SELECT count(*) as ah_femaleCount " +
            "                                            from Antihero, NormalIdentity " +
            "                                            where ah_ID = nl_ID and nl_Gender = 'f'), (SELECT count(*) as v_femaleCount " +
            "                                                                                        from Villain, NormalIdentity " +
            "                                                                                        where v_ID = nl_ID and nl_Gender = 'f')";

            PreparedStatement stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.printf("%-45s\n", "Affiliation");

            while(rs.next()){
                String group = rs.getString(1);
                System.out.printf("%-45s\n", group);
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");
    }



    //--------------------ADMIN----------------//
    private void insertToNormalIdentity(int normalID, int normalPersonID, String personName, String gender, String birthplace){
        try{
            Statement stmt = c.createStatement();
            String sql = "INSERT INTO normalIdentity VALUES( "+ normalID+", " + normalPersonID + ", " + personName +", " + gender +", " + birthplace +" )";
            stmt.execute(sql);

            c.commit();
            
            stmt.close();
            System.out.println("Insert successful.");

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");
    }

    private void updateIntNormalIdentity(String attribute, int newVal){
        try{
            Statement stmt = c.createStatement();
            String sql = "UPDATE normalIdentity set " + attribute + "= " + newVal+ ";";
            stmt.execute(sql);

            c.commit();
            
            stmt.close();
            System.out.println("Update successful.");

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");
        
    }

    private void updateStringNormalIdentity(String attribute, String newVal){
        try{
            Statement stmt = c.createStatement();
            String sql = "UPDATE normalIdentity set " + attribute + "= '" + newVal+ "';";
            stmt.execute(sql);

            c.commit();
            
            stmt.close();
            System.out.println("Update successful.");

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");
    }

    private void deleteFrom(String attributeName, int conditionVal){
        try{
            Statement stmt = c.createStatement();
            String sql = "DELETE FROM normalIdentity WHERE " + attributeName + "= " + conditionVal+ ";";
            stmt.execute(sql);

            c.commit();
            
            stmt.close();
            System.out.println("Delete successful.");

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");

    }

    private void deleteFrom(String attributeName, String conditionVal){
        try{
            Statement stmt = c.createStatement();
            String sql = "DELETE FROM normalIdentity WHERE " + attributeName + "= '" + conditionVal+ "';";
            stmt.execute(sql);

            c.commit();
            
            stmt.close();
            System.out.println("Delete successful.");

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");

    }

    private void viewTable(String tableName){
        try{
            Statement stmt = c.createStatement();
            String sql = "SELECT * FROM " + tableName;
            stmt.execute(sql);

            c.commit();
            
            /*
            
            Currently not printing tables
            
            */

            stmt.close();
            System.out.println("Search successful.");

        }catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("------------------------------------");

    }






       //--------------------ADMIN----------------//




    
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

                if (marvelsearch2 == 1){
                    System.out.println("Now that you know your charater is a Hero how would you to find them");
                    System.out.println("If you want to see by Name press 1");
                    System.out.println("If you want to see by Race press 2");
                    System.out.println("If you want to see by Gender press 3");
                    System.out.println("If you want to see by What Teams they are part of press 4");
                    int marvelherosearch = input.nextInt();
                    if (marvelherosearch == 1){
                        System.out.println("Please type the Name of the Hero you wanna see buddy");
                        String marvelHeroname = input.nextLine();

                        sj.CallCharWithName(marvelHeroname);
                    }
                    if (marvelherosearch == 2){
                        System.out.println("please select one of the following races that you want to see the heros from");
                        System.out.println("To see the following heros that are Human press 1");
                        System.out.println("To see the following heros that are Mutant press 2");
                        System.out.println("To see the following heros that are Inhuman press 3");
                        System.out.println("To see the following heros that are Asgardian press 4");
                        System.out.println("To see the following heros that are Human-Kree press 5");
                        System.out.println("To see the following heros that are Human Mutate press 6");
                        System.out.println("To see the following heros that are Zenn-Lavian press 7");
                        System.out.println("To see the following heros that are Alien press 8");
                        System.out.println("To see the following heros that are Flora colossus press 9");
                        System.out.println("To see the following heros that are os + old armor press 10");
                        int marvelherorace = input.nextInt();
    
                        if (marvelherorace == 1){
                            System.out.println("Now printing the heros that are Human");
                            sj.HeroOfType("Human", "Marvel");
                        }
                        if (marvelherorace == 2){
                            System.out.println("Now printing the heros that are Mutant");
                            sj.HeroOfType("Mutant", "Marvel");

                        }
                        if (marvelherorace == 3){
                            System.out.println("Now printing the heros that are Inhuman");
                            sj.HeroOfType("Inhuman", "Marvel");
                        }
                        if (marvelherorace == 4){
                            System.out.println("Now printing the heros that are Asgardian");
                            sj.HeroOfType("Asgardian", "Marvel");
                        }
                        if (marvelherorace == 5){
                            System.out.println("Now printing the heros that are Human-Kree");
                            sj.HeroOfType("Human-Kree", "Marvel");
                        }
                        if (marvelherorace == 6){
                            System.out.println("Now printing the heros that are Human Mutate");
                            sj.HeroOfType("Human Matate", "Marvel");
                        }
                        if (marvelherorace == 7){
                            System.out.println("Now printing the heros that are Zenn-Lavian");
                            sj.HeroOfType("Zenn-Lavian", "Marvel");
                        }
                        if (marvelherorace == 8){
                            System.out.println("Now printing the heros that are Alien");
                            sj.HeroOfType("Alien", "Marvel");
                        }
                        if (marvelherorace == 9){
                            System.out.println("Now printing the heros that are Flora colossus");
                            sj.HeroOfType("Flora colossus", "Marvel");
                        }
                        if (marvelherorace == 10){
                            System.out.println("Now printing the heros that are os + old armor");
                            sj.HeroOfType("os + old armor", "Marvel");
                        }
    
                    } // end of if (marvelherosearch == 2)

                    if (marvelherosearch == 3){
                        System.out.println("Here is the list of all the genders in Marvel heros choose which you like to see");
                        System.out.println("To see all of Male of the Marvel hearos press 1");
                        System.out.println("To see all of Female of the Marvel hearos press 2");
                        int marvelgendersearch = input.nextInt();
        
                        if (marvelgendersearch == 1){
                          System.out.println("Now printing all of Males of the Marvel heros tables");
                          sj.heroByGender("m", "Marvel");
        
                        }
                        if (marvelgendersearch == 2){
                          System.out.println("Now printing all of Female of the Marvel heros tables");
                          sj.heroByGender("f", "Marvel");
        
                        }
                    }   // end of if (marvelherosearch == 3){

                        if (marvelherosearch == 4){
                            System.out.println("Here is the list of all the teams in Marvel heros choose which you like to see");
                            System.out.println(" to see the members of Avengers please press 1");
                            System.out.println(" to see the members of S.H.I.E.L.D. please press 2");
                            System.out.println(" to see the members of Guardians of the Galaxy please press 3");
                            System.out.println(" to see the members of Fantastic 4 please press 4");
                            System.out.println(" to see the members of Defenders please press 5");
                            System.out.println(" to see the members of Mighty Avengers please press 6");
                            System.out.println(" to see the members of New Avengers please press 7");
                            System.out.println(" to see the members of Illuminati please press 8");
                            System.out.println(" to see the members of Weapon X please press 9");
                            System.out.println(" to see the members of X-men please press 10");
                            System.out.println(" to see the members of NASA please press 11");
                            System.out.println(" to see the members of Stark Industries please press 12");
                            System.out.println(" to see the members of KGB please press 13");
                            System.out.println(" to see the members of Lady Liberators please press 14");
                            System.out.println(" to see the members of Acts of Vengeance please press 15");
                            System.out.println(" to see the members of Heralds of Galactus please press 16");
                            System.out.println(" to see the members of Four Horsemen please press 17");
                            System.out.println(" to see the members of Dark Avengers please press 18");
                            System.out.println(" to see the members of Young Avengers please press 19");
                            int marvelheroteamsearch = input.nextInt();
          
                            if (marvelheroteamsearch == 1){
                                System.out.println("now printing all of the members of Avengers");
                                sj.HeroOfTeam("Avengers", "Marvel");
                            }
                            if (marvelheroteamsearch == 2){
                                System.out.println ("now printing all of the members of S.H.I.E.L.D.");
                                sj.HeroOfTeam("S.H.I.E.L.D.", "Marvel");
                            }
                            if (marvelheroteamsearch == 3){
                                System.out.println ("now printing all of the members of Guardians of the Galaxy");
                                sj.HeroOfTeam("Guardians of the Galaxy", "Marvel");
                            }
                            if (marvelheroteamsearch == 4){
                                System.out.println ("now printing all of the members of Fantastic 4");
                                sj.HeroOfTeam("Fantastic 4", "Marvel");
                            }
                            if (marvelheroteamsearch == 5){
                                System.out.println ("now printing all of the members of Defenders");
                                sj.HeroOfTeam("Defenders", "Marvel");
                            }
                            if (marvelheroteamsearch == 6){
                                System.out.println ("now printing all of the members of Mighty Avengers");
                                sj.HeroOfTeam("Mighty Avengers", "Marvel");
                            }
                            if (marvelheroteamsearch == 7){
                                System.out.println ("now printing all of the members of New Avengers");
                                sj.HeroOfTeam("New Avengers", "Marvel");
                            }
                            if (marvelheroteamsearch == 8){
                                System.out.println ("now printing all of the members of Illuminati");
                                sj.HeroOfTeam("Illuminati", "Marvel");
                            }
                            if (marvelheroteamsearch == 9){
                                System.out.println ("now printing all of the members of Weapon X");
                                sj.HeroOfTeam("Weapon X", "Marvel");
                            }
                            if (marvelheroteamsearch == 10){
                                System.out.println ("now printing all of the members of X-men");
                                sj.HeroOfTeam("X-men", "Marvel");
                            }
                            if (marvelheroteamsearch == 11){
                                System.out.println ("now printing all of the members of NASA");
                                sj.HeroOfTeam("NASA", "Marvel");
                            }
                            if (marvelheroteamsearch == 12){
                                System.out.println ("now printing all of the members of Stark Industries");
                                sj.HeroOfTeam("Stark Industries", "Marvel");
                            }
                            if (marvelheroteamsearch == 13){
                                System.out.println ("now printing all of the members of KGB");
                                sj.HeroOfTeam("KGB", "Marvel");
                            }
                            if (marvelheroteamsearch == 14){
                                System.out.println ("now printing all of the members of Lady Liberators");
                                sj.HeroOfTeam("Lady Liberators", "Marvel");
                            }
                            if (marvelheroteamsearch == 15){
                                System.out.println ("now printing all of the members of Acts of Vengeance");
                                sj.HeroOfTeam("Acts of Vengeance", "Marvel");
                            }
                            if (marvelheroteamsearch == 16){
                                System.out.println ("now printing all of the members of Heralds of Galactus");
                                sj.HeroOfTeam("Heralds of Galactus", "Marvel");
                            }
                            if (marvelheroteamsearch == 17){
                                System.out.println ("now printing all of the members of Four Horsemen");
                                sj.HeroOfTeam("Four Horsemen", "Marvel");
                            }
                            if (marvelheroteamsearch == 18){
                                System.out.println ("now printing all of the members of Dark Avengers");
                                sj.HeroOfTeam("Dark Avengers", "Marvel");
                            }
                            if (marvelheroteamsearch == 19){
                                System.out.println ("now printing all of the members of Young Avengers");
                                sj.HeroOfTeam("Young Avengers", "Marvel");
                            }

                        }// end of if (marvelherosearch == 4){

                }// end of if (marvelsearch2 == 1)

                if (marvelsearch2 == 2){
                    System.out.println("Now that you know your charater is a Villian how would you to find them");
                    System.out.println("If you want to see by Name press 1");
                    System.out.println("If you want to see by Race press 2");
                    System.out.println("If you want to see by Gender press 3");
                    System.out.println("If you want to see by What Teams they are part of press 4");
                    int marvelvilliansearch = input.nextInt();


                    if (marvelvilliansearch == 1){
                        System.out.println("Please type the Name of the villian you wanna see buddy");
                        String marvelvillianame = input.nextLine();
                        sj.CallCharWithName(marvelvillianame);

                    }

                    if (marvelvilliansearch == 2){
                        System.out.println("please pick one of the following races to see");
                        System.out.print("to see the following Taa-an please select 1");
                        System.out.print("to see the following Jotunn-God please select 2");
                        System.out.print("to see the following Synthezoid please select 3");
                        System.out.print("to see the following Human please select 4");
                        System.out.print("to see the following Eternals-Deviant Hybrid please select 5");
                        System.out.print("to see the following Mutant please select 6");
                        System.out.print("to see the following Human Mutate please select 7");
                        System.out.print("to see the following Symbiote please select 8");
                        System.out.print("to see the following Sentinel please select 9");
                        System.out.print("to see the following Arthrosian please select 10");
                        System.out.print("to see the following Human (empowered) please select 11");
                        System.out.print("to see the following Asgardian please select 12");
                        int marvelvillianracesearch = input.nextInt();
        
                        if (marvelvillianracesearch == 1){
                            System.out.println("now printing all the villians that are Taa-an ");
                            sj.VillianOfRace("Taa-an", "Marvel");
    
                        }
                        if (marvelvillianracesearch == 2){
                            System.out.println("now printing all the villians that are Jotunn-God ");
                            sj.VillianOfRace("Jotunn-God", "Marvel");
    
                        }
                        if (marvelvillianracesearch == 3){
                            System.out.println("now printing all the villians that are Synthezoid ");
                            sj.VillianOfRace("Synthezoid", "Marvel");
    
                        }
                        if (marvelvillianracesearch == 4){
                            System.out.println("now printing all the villians that are Human ");
                            sj.VillianOfRace("Human", "Marvel");

                        }
                        if (marvelvillianracesearch == 5){
                            System.out.println("now printing all the villians that are Eternals-Deviant Hybrid ");
                            sj.VillianOfRace("Eternals-Deviant Hybrid", "Marvel");

                        }
                        if (marvelvillianracesearch == 6){
                            System.out.println("now printing all the villians that are Mutant ");
                            sj.VillianOfRace("Mutant", "Marvel");
    
                        }
                        if (marvelvillianracesearch == 7){
                            System.out.println("now printing all the villians that are Human Mutate ");
                            sj.VillianOfRace("Human Mutate", "Marvel");

                        }
                        if (marvelvillianracesearch == 8){
                            System.out.println("now printing all the villians that are Symbiote ");
                            sj.VillianOfRace("Symbiote", "Marvel");

                        }
                        if (marvelvillianracesearch == 9){
                            System.out.println("now printing all the villians that are Sentinel ");
                            sj.VillianOfRace("Sentinel", "Marvel");

                        }
                        if (marvelvillianracesearch == 10){
                            System.out.println("now printing all the villians that are Arthrosian ");
                            sj.VillianOfRace("Arthrosian", "Marvel");

                        }
                        if (marvelvillianracesearch == 11){
                            System.out.println("now printing all the villians that are Human (empowered) ");
                            sj.VillianOfRace("Human (empowered)", "Marvel");

                        }
                        if (marvelvillianracesearch == 12){
                            System.out.println("now printing all the villians that are Asgardian ");
                            sj.VillianOfRace("Asgardian", "Marvel");

                        }
                    } // end of if (marvelvilliansearch == 2){

                        if (marvelvilliansearch == 3){
                            System.out.println("to see the following villian(s) that are Male press 1");
                            System.out.println("to see the following villian(s) that are Female press 2");
                            System.out.println("to see the following villian(s) that are Binary press 3");
                            int marvelvilliangendersearch = input.nextInt();
            
                            if (marvelvilliangendersearch == 1){
                                System.out.println("Now printing all of Males of the Marvel villian tables");
                                sj.villainByGender( "m", "Marvel");
            
                            }
                            if (marvelvilliangendersearch == 2){
                                System.out.println("Now printing all of Female of the Marvel villian tables");
                                sj.villainByGender("f", "Marvel");
            
                            }
                            if (marvelvilliangendersearch == 3){
                                System.out.println("Now printing all of Binary of the Marvel villian tables");
                                sj.villainByGender("binary", "Marvel");
            
                            }
            
                        }// end of if (marvelvilliansearch == 3){

                        if (marvelvilliansearch == 4){
                            System.out.println("Please select which Team of villians would you like to see");
                            System.out.println(" to see the villians that belong to Avengers please select 1");
                            System.out.println(" to see the villians that belong to X-men please select 2");
                            System.out.println(" to see the villians that belong to Acts of Vengeance please select 3");
                            System.out.println(" to see the villians that belong to Young Avengers please select 4");
                            System.out.println(" to see the villians that belong to Cabal please select 5");
                            System.out.println(" to see the villians that belong to Masters of Evil please select 6");
                            System.out.println(" to see the villians that belong to Ultron Sentries please select 7");
                            System.out.println(" to see the villians that belong to HYDRA please select 8");
                            System.out.println(" to see the villians that belong to Nazi Germany (SS-Oberführer) please select 9");
                            System.out.println(" to see the villians that belong to Black Order please select 10");
                            System.out.println(" to see the villians that belong to Infinity Watch please select 11");
                            System.out.println(" to see the villians that belong to Brotherhood of Mutants please select 12");
                            System.out.println(" to see the villians that belong to Order of the Goblin please select 13");
                            System.out.println(" to see the villians that belong to Dark Avengers please select 14");
                            System.out.println(" to see the villians that belong to S.H.I.E.L.D. please select 15");
                            System.out.println(" to see the villians that belong to Guardians of the Galaxy please select 16");
                            System.out.println(" to see the villians that belong to KGB please select 17");
                            System.out.println(" to see the villians that belong to AIM please select 18");
                            System.out.println(" to see the villians that belong to Lady Liberators please select 19");
                            System.out.println(" to see the villians that belong to Sisterhood of Mutants please select 20");
                            System.out.println(" to see the villians that belong to Annihilation Wave please select 21");
                            System.out.println(" to see the villians that belong to Council of Kangs please select 22");
                            System.out.println(" to see the villians that belong to Weapon X please select 23");
                            System.out.println(" to see the villians that belong to The Hand please select 24");
                            System.out.println(" to see the villians that belong to Emissaries of Evil please select 25");
                            System.out.println(" to see the villians that belong to Four Horsemen please select 26");
                            System.out.println(" to see the villians that belong to Dark Riders please select 27");
                            System.out.println(" to see the villians that belong to Alliance of Evil please select 28");
                            System.out.println(" to see the villians that belong to Sorcerers Supreme please select 29");
                            System.out.println(" to see the villians that belong to Stark Industries please select 30");
                            System.out.println(" to see the villians that belong to The Chessmen please select 31");
                            System.out.println(" to see the villians that belong to Death Gods please select 32");
                            System.out.println(" to see the villians that belong to Hell-Lords please select 33");
                            int marvelvillianteamsearch = input.nextInt();

                            if (marvelvillianteamsearch == 1){
                                System.out.println(" now showing the villian members of Avengers");
                                sj.VillainOfTeam("Avengers", "Marvel");
                
                            }
                            if (marvelvillianteamsearch == 2){
                                System.out.println(" now showing the villian members of X-men");
                                sj.VillainOfTeam("X-men", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 3){
                                System.out.println(" now showing the villian members of Acts of Vengeance");
                                sj.VillainOfTeam("Acts of Vengeance", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 4){
                                System.out.println(" now showing the villian members of Young Avengers");
                                sj.VillainOfTeam("Young Avengers", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 5){
                                System.out.println(" now showing the villian members of Cabal");
                                sj.VillainOfTeam("Cabal", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 6){
                                System.out.println(" now showing the villian members of Masters of Evil");
                                sj.VillainOfTeam("Masters of Evil", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 7){
                                System.out.println(" now showing the villian members of Ultron Sentries");
                                sj.VillainOfTeam("Ultron Sentries", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 8){
                                System.out.println(" now showing the villian members of HYDRA");
                                sj.VillainOfTeam("HYDRA", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 9){
                                    System.out.println(" now showing the villian members of Nazi Germany (SS-Oberführer)");
                                    sj.VillainOfTeam("Nazi Germany (SS-Oberführer)", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 10){
                                    System.out.println(" now showing the villian members of Black Order");
                                    sj.VillainOfTeam("Black Order", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 11){
                                    System.out.println(" now showing the villian members of Infinity Watch");
                                    sj.VillainOfTeam("Infinity Watch", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 12){
                                    System.out.println(" now showing the villian members of Brotherhood of Mutants");
                                    sj.VillainOfTeam("Brotherhood of Mutants", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 13){
                                    System.out.println(" now showing the villian members of Order of the Goblin");
                                    sj.VillainOfTeam("Order of the Goblin", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 14){
                                System.out.println(" now showing the villian members of Dark Avengers");
                                sj.VillainOfTeam("Dark Avengers", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 15){
                                System.out.println(" now showing the villian members of S.H.I.E.L.D.");
                                sj.VillainOfTeam("S.H.I.E.L.D.", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 16){
                                System.out.println(" now showing the villian members of Guardians of the Galaxy");
                                sj.VillainOfTeam("Guardians of the Galaxy", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 17){
                                System.out.println(" now showing the villian members of KGB");
                                sj.VillainOfTeam("KGB", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 18){
                                System.out.println(" now showing the villian members of AIM");
                                sj.VillainOfTeam("AIM", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 19){
                                System.out.println(" now showing the villian members of Lady Liberators");
                                sj.VillainOfTeam("Lady Liberators", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 20){
                                System.out.println(" now showing the villian members of Sisterhood of Mutants");
                                sj.VillainOfTeam("Sisterhood of Mutants", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 21){
                                System.out.println(" now showing the villian members of Annihilation Wave");
                                sj.VillainOfTeam("Annihilation Wave", "Marvel" );
            
                            }
                            if (marvelvillianteamsearch == 22){
                                System.out.println(" now showing the villian members of Council of Kangs");
                                sj.VillainOfTeam("Council of Kangs", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 23){
                                System.out.println(" now showing the villian members of Weapon X");
                                sj.VillainOfTeam("Weapon X", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 24){
                                System.out.println(" now showing the villian members of The Hand");
                                sj.VillainOfTeam("The Hand", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 25){
                                System.out.println(" now showing the villian members of Emissaries of Evil");
                                sj.VillainOfTeam("Emissaries of Evil", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 26){
                                System.out.println(" now showing the villian members of Four Horsemen");
                                sj.VillainOfTeam("Four Horsemen", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 27){
                                System.out.println(" now showing the villian members of Dark Riders");
                                sj.VillainOfTeam("Dark Riders", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 28){
                                System.out.println(" now showing the villian members of Alliance of Evil");
                                sj.VillainOfTeam("Alliance of Evil", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 29){
                                System.out.println(" now showing the villian members of Sorcerers Supreme");
                                sj.VillainOfTeam("Sorcerers Supreme", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 30){
                                System.out.println(" now showing the villian members of Stark Industries");
                                sj.VillainOfTeam("Stark Industries", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 31){
                                System.out.println(" now showing the villian members of The Chessmen");
                                sj.VillainOfTeam("The Chessmen", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 32){
                                System.out.println(" now showing the villian members of Death Gods");
                                sj.VillainOfTeam("Death Gods", "Marvel");
            
                            }
                            if (marvelvillianteamsearch == 33){
                                System.out.println(" now showing the villian members of Hell-Lords");
                                sj.VillainOfTeam("Hell-Lords", "Marvel");
            
                            }

                        } // of if (marvelvilliansearch == 4){

                } //end of if (marvelsearch2 == 2){

                if (marvelsearch2 == 3){
                    System.out.println("Now that you know your charater is a Anti-Hero how would you to find them");
                    System.out.println("If you want to see by Name press 1");
                    System.out.println("If you want to see by Race press 2");
                    System.out.println("If you want to see by Gender press 3");
                    System.out.println("If you want to see by What Teams they are part of press 4");
                
                }// end of if (marvelsearch2 == 3){



            } // end of if (marvelsearch == 2){}

            if (marvelsearch == 3){
                System.out.println("now tell me traveler watcha looking for");
            
            } //end of if (marvelsearch == 3){ 


        } // end of if(whatyouwannasee == 1){}

        if (whatyouwannasee == 2){
            System.out.println("welcome to DC Database what do wanna see buddy");
            System.out.println("To see all characters press 1");
            System.out.println("To see a specific character press 2");
            System.out.println("To find a custom search press 3");
            int dcsearch = input.nextInt();
            String fromWhere = "DC";

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

                if (dcsearch2 == 1){
                    System.out.println("Now that you know your charater is a Hero how would you to find them");
                    System.out.println("If you want to see by Name press 1");
                    System.out.println("If you want to see by Race press 2");
                    System.out.println("If you want to see by Gender press 3");
                    System.out.println("If you want to see by What Teams they are part of press 4");
                    int dcherosearch = input.nextInt();

                    if (dcherosearch == 1){
                        System.out.println("Please type the Name of the Hero you wanna see buddy");
                        String Heroname = input.nextLine();

                        sj.CallCharWithName(Heroname);
                    }

                    if (dcherosearch == 2){
                        System.out.println("please select one of the following races that you want to see the heros from");
                        System.out.println("If the certain race is Human press 1");
                        System.out.println("If the certain race is Cyborg press 2");
                        System.out.println("If the certain race is Human-Atlantean Hybrid press 3");
                        System.out.println("If the certain race is Tamaranean press 4");
                        System.out.println("If the certain race is Meta-human press 5");
                        System.out.println("If the certain race is Kryptonian press 6");
                        System.out.println("If the certain race is Green Martian press 7");
                        System.out.println("If the certain race is Amazonian-Olympian Goddess press 8");
                        System.out.println("If the certain race is Homo magi press 9");
                        System.out.println("If the certain race is Cambion press 10");
                        System.out.println("If the certain race is White Martian/Green Martian press 11");
                        int whatrace = input.nextInt();

                        if (whatrace == 1){
                            System.out.println("Now printing the Hero(s) of the following race Human");
                            sj.HeroOfType("Human", fromWhere);
            
                          }
                        if (whatrace == 2){
                            System.out.println("Now printing the Hero(s) of the following race Cyborg");
                            sj.HeroOfType("Cyborg", fromWhere);
            
                        }
                        if (whatrace == 3){
                            System.out.println("Now printing the Hero(s) of the following race Human-Atlantean Hybrid");
                            sj.HeroOfType("Human-Atlantean Hybrid", fromWhere);
            
                        }
                        if (whatrace == 4){
                            System.out.println("Now printing the Hero(s) of the following race Tamaranean");
                            sj.HeroOfType("Tamaranean", fromWhere);
            
                        }
                        if (whatrace == 5){
                            System.out.println("Now printing the Hero(s) of the following race Meta-human");
                            sj.HeroOfType("Meta-human", fromWhere);
            
                        }
                        if (whatrace == 6){
                            System.out.println("Now printing the Hero(s) of the following race Kryptonian");
                            sj.HeroOfType("Kryptonian", fromWhere);
            
                        }
                        if (whatrace == 7){
                            System.out.println("Now printing the Hero(s) of the following race Green Martian");
                            sj.HeroOfType("Green Martian", fromWhere);
            
                        }
                        if (whatrace == 8){
                            System.out.println("Now printing the Hero(s) of the following race Amazonian-Olympian Goddess");
                            sj.HeroOfType("Amazonian-Olympian Goddess", fromWhere);
            
                          }
                        if (whatrace == 9){
                            System.out.println("Now printing the Hero(s) of the following race Homo magi");
                            sj.HeroOfType("Homo magi", fromWhere);
            
                        }
                        if (whatrace == 10){
                            System.out.println("Now printing the Hero(s) of the following race Cambion");
                            sj.HeroOfType("Cambion", fromWhere);
            
                        }
                        if (whatrace == 11){
                            System.out.println("Now printing the Hero(s) of the following race White Martian/Green Martian");
                            sj.HeroOfType("White Martian/Green Martian", fromWhere);
            
                        }

                    }// end of if (dcherosearch == 2){

                    if (dcherosearch == 3){
                        System.out.println("Here is the list of all the genders in DC heros choose which you like to see");
                        System.out.println("To see all of Male of the DC hearos press 1");
                        System.out.println("To see all of Female of the DC hearos press 2");
                        int dcgendersearch = input.nextInt();

                        if (dcgendersearch == 1){
                            System.out.println("Now printing all of Males of the DC heros tables");
                            sj.heroByGender("m", fromWhere);
            
                        }
                        if (dcgendersearch == 2){
                            System.out.println("Now printing all of Female of the DC heros tables");
                            sj.heroByGender("f", fromWhere);
            
                        }

                    }//if (dcherosearch == 3){

                    if (dcherosearch == 4){
                        System.out.println("Here is the list of all the teams in DC heros choose which you like to see");
                        System.out.println("if you want to see the heros that belong to Justice League please press 1");
                        System.out.println("if you want to see the heros that belong to Teen Titans please press 2");
                        System.out.println("if you want to see the heros that belong to Batman Family please press 3");
                        System.out.println("if you want to see the heros that belong to Young Justice please press 4");
                        System.out.println("if you want to see the heros that belong to Doom Patrol please press 5");
                        System.out.println("if you want to see the heros that belong to Birds of prey please press 6");
                        System.out.println("if you want to see the heros that belong to Green Lantern Corps please press 7");
                        System.out.println("if you want to see the heros that belong to Justice League Dark please press 8");
                        System.out.println("if you want to see the heros that belong to Suicide Squad please press 9");
                        int dcheroteamsearch = input.nextInt();

                        if ( dcheroteamsearch == 1){
                            System.out.println ("Now printing the heros that belong to the Justice League");
                            sj.HeroOfTeam( "Justice League", fromWhere);
                        }
                        if ( dcheroteamsearch == 2){
                            System.out.println ("Now printing the heros that belong to the Teen Titans");
                            sj.HeroOfTeam( "Teen Titans", fromWhere);
                        }
                        if ( dcheroteamsearch == 3){
                            System.out.println ("Now printing the heros that belong to the Batman Family");
                            sj.HeroOfTeam( "Justice", fromWhere);
                        }
                        if ( dcheroteamsearch == 4){
                            System.out.println ("Now printing the heros that belong to the Young Justice");
                            sj.HeroOfTeam( "Justice", fromWhere);
                        }
                        if ( dcheroteamsearch == 5){
                            System.out.println ("Now printing the heros that belong to the Doom Patrol");
                            sj.HeroOfTeam( "Justice", fromWhere);
                        }
                        if ( dcheroteamsearch == 6){
                            System.out.println ("Now printing the heros that belong to the Birds of prey");
                            sj.HeroOfTeam( "Justice", fromWhere);
                        }
                        if ( dcheroteamsearch == 7){
                            System.out.println ("Now printing the heros that belong to the Green Lantern Corps");
                            sj.HeroOfTeam( "Justice", fromWhere);
                        }
                        if ( dcheroteamsearch == 8){
                            System.out.println ("Now printing the heros that belong to the Justice League Dark");
                            sj.HeroOfTeam( "Justice", fromWhere);
                        }
                        if ( dcheroteamsearch == 9){
                            System.out.println ("Now printing the heros that belong to the Suicide Squad please");
                            sj.HeroOfTeam( "Justice", fromWhere);
                        }

                    } // end of if (dcherosearch == 4){

                }//end of if (dcsearch2 == 1){

                if (dcsearch2 == 2){
                    System.out.println("Now that you know your charater is a Villian how would you to find them");
                    System.out.println("If you want to see by Name press 1");
                    System.out.println("If you want to see by Race press 2");
                    System.out.println("If you want to see by Gender press 3");
                    System.out.println("If you want to see by What Teams they are part of press 4");
                    int dcvilliansearch = input.nextInt();

                    if (dcvilliansearch == 1){
                        System.out.println("Please type the Name of the villian you wanna see buddy");
                        String villianame = input.nextLine();

                        sj.CallCharWithName(villianame);
                      }
                    if (dcvilliansearch == 2){
                        System.out.println("if the following villian's race is New God press 1");
                        System.out.println("if the following villian's race is Korugarian press 2");
                        System.out.println("if the following villian's race is Mutant press 3");
                        System.out.println("if the following villian's race is Coluan press 4");
                        System.out.println("if the following villian's race is Human press 5");
                        System.out.println("if the following villian's race is Prehistoric Kryptonian press 6");
                        System.out.println("if the following villian's race is Human Mutate press 7");
                        System.out.println("if the following villian's race is Mighty Human press 8");
                        System.out.println("if the following villian's race is Meta-Human press 9");
                        System.out.println("if the following villian's race is Ape press 10");
                        System.out.println("if the following villian's race is Kryptonian press 11");
                        System.out.println("if the following villian's race is Demon press 12");
                        int dcvillianracesearch = input.nextInt();

                        if (dcvillianracesearch == 1){
                            System.out.println("Now printing the following Villians that are the folloing race New God");
                            sj.VillianOfRace("New God", fromWhere);
            
                          }
                        if (dcvillianracesearch == 2){
                            System.out.println("Now printing the following Villians that are the folloing race Korugarian");
                            sj.VillianOfRace("Korugarian", fromWhere);
            
                        }
                        if (dcvillianracesearch == 3){
                            System.out.println("Now printing the following Villians that are the folloing race Mutant");
                            sj.VillianOfRace("Mutant", fromWhere);
            
                        }
                        if (dcvillianracesearch == 4){
                            System.out.println("Now printing the following Villians that are the folloing race Coluan");
                            sj.VillianOfRace("Coluan", fromWhere);
            
                        }
                        if (dcvillianracesearch == 5){
                            System.out.println("Now printing the following Villians that are the folloing race Human");
                            sj.VillianOfRace("Human", fromWhere);
            
                        }
                        if (dcvillianracesearch == 6){
                            System.out.println("Now printing the following Villians that are the folloing race Prehistoric Kryptonian");
                            sj.VillianOfRace("Prehistoric Kryptonian", fromWhere);
            
                        }
                        if (dcvillianracesearch == 7){
                            System.out.println("Now printing the following Villians that are the folloing race Human Mutate");
                            sj.VillianOfRace("Human Mutate", fromWhere);
            
                        }
                        if (dcvillianracesearch == 8){
                            System.out.println("Now printing the following Villians that are the folloing race Mighty Human");
                            sj.VillianOfRace("Mighty Human", fromWhere);
            
                        }
                        if (dcvillianracesearch == 9){
                            System.out.println("Now printing the following Villians that are the folloing race Meta-Human");
                            sj.VillianOfRace("Meta-Human", fromWhere);
            
                        }
                        if (dcvillianracesearch == 10){
                            System.out.println("Now printing the following Villians that are the folloing race Ape");
                            sj.VillianOfRace("Ape", fromWhere);
            
                          }
                        if (dcvillianracesearch == 11){
                            System.out.println("Now printing the following Villians that are the folloing race Kryptonian");
                            sj.VillianOfRace("Kryptonian", fromWhere);
            
                        }
                        if (dcvillianracesearch == 12){
                            System.out.println("Now printing the following Villians that are the folloing race Demon");
                            sj.VillianOfRace("Demon", fromWhere);
            
                        }

                    }//end of if (dcvilliansearch == 2){

                        if (dcvilliansearch == 3){
                            System.out.println("to see the following villian(s) that are Male press 1");
                            System.out.println("to see the following villian(s) that are Female press 2");
                            System.out.println("to see the following villian(s) that are Binary press 3");
                            int dcvilliangendersearch = input.nextInt();
              
                            if (dcvilliangendersearch == 1){
                              System.out.println("Now printing the following character(s) that are Male");
                              sj.villainByGender( "m", fromWhere);
                            }
              
                            if (dcvilliangendersearch == 2){
                              System.out.println("Now printing the following character(s) that are Female");
                              sj.villainByGender( "f", fromWhere);
                            }
              
                            if (dcvilliangendersearch == 3){
                              System.out.println("Now printing the following character(s) that are Binary");
                              sj.villainByGender( "binary", fromWhere);
                            }
              
                        } // end of if (dcvilliansearch == 3){

                        if (dcvilliansearch == 4){
                            System.out.println("Please select which Team of villians would you like to see");
                            System.out.println(" to see the members of Darkseid's Elite please press 1");
                            System.out.println(" to see the members of Legion of Doom please press 2");
                            System.out.println(" to see the members of Secret Society of Super Villains please press 3");
                            System.out.println(" to see the members of Sinestro Corps please press 4");
                            System.out.println(" to see the members of Injustice League please press 5");
                            System.out.println(" to see the members of Anti-Justice League please press 6");
                            System.out.println(" to see the members of Suicide Squad please press 7");
                            System.out.println(" to see the members of League of Assassins please press 8");
                            System.out.println(" to see the members of H.I.V.E. please press 9");
                            System.out.println(" to see the members of Kryptonian Military Guild please press 10");
                            System.out.println(" to see the members of Council of Immortals please press 11");
                            System.out.println(" to see the members of Church of Blood please press 12");
                            System.out.println(" to see the members of NASA please press 13");
                            int dcvillianteamsearch = input.nextInt();

                            if (dcvillianteamsearch == 1){
                                System.out.println("Now printing all of the characters that belong to Darkseid's Elite");
                                sj.VillainOfTeam("Darkseid's Elite", fromWhere);
                              }
                            if (dcvillianteamsearch == 2){
                                System.out.println("Now printing all of the characters that belong to Legion of Doom");
                                sj.VillainOfTeam("Legion of Doom", fromWhere);
                            }
                            if (dcvillianteamsearch == 3){
                                System.out.println("Now printing all of the characters that belong to Secret Society of Super Villains");
                                sj.VillainOfTeam("Secret Society of Super Villains", fromWhere);
                            }
                            if (dcvillianteamsearch == 4){
                                System.out.println("Now printing all of the characters that belong to Sinestro Corps");
                                sj.VillainOfTeam("Sinestro Corps", fromWhere);
                            }
                            if (dcvillianteamsearch == 5){
                                System.out.println("Now printing all of the characters that belong to Injustice League");
                                sj.VillainOfTeam("Injustice League", fromWhere);
                            }
                            if (dcvillianteamsearch == 6){
                                System.out.println("Now printing all of the characters that belong to Anti-Justice League");
                                sj.VillainOfTeam("Anti-Justice League", fromWhere);
                            }
                            if (dcvillianteamsearch == 7){
                                System.out.println("Now printing all of the characters that belong to Suicide Squad");
                                sj.VillainOfTeam("Suicide Squad", fromWhere);
                            }
                            if (dcvillianteamsearch == 8){
                                System.out.println("Now printing all of the characters that belong to League of Assassins");
                                sj.VillainOfTeam("League of Assassins", fromWhere);
                            }
                            if (dcvillianteamsearch == 9){
                                System.out.println("Now printing all of the characters that belong to H.I.V.E.");
                                sj.VillainOfTeam("H.I.V.E.", fromWhere);
                            }
                            if (dcvillianteamsearch == 10){
                                System.out.println("Now printing all of the characters that belong to Kryptonian Military Guild");
                                sj.VillainOfTeam("Kryptonian Military Guild", fromWhere);
                            }
                            if (dcvillianteamsearch == 11){
                                System.out.println("Now printing all of the characters that belong to Council of Immortals");
                                sj.VillainOfTeam("Council of Immortals", fromWhere);
                            }
                            if (dcvillianteamsearch == 12){
                                System.out.println("Now printing all of the characters that belong to Church of Blood");
                                sj.VillainOfTeam("Church of Blood", fromWhere);
                            }
                            if (dcvillianteamsearch == 13){
                                System.out.println("Now printing all of the characters that belong to NASA");
                                sj.VillainOfTeam("NASA", fromWhere);
                            }

                        } // end of if (dcvilliansearch == 4){

                } // end of if (dcsearch2 == 2){

                if (dcsearch2 == 3){
                    System.out.println("Now that you know your charater is a Anti-Hero how would you to find them");
                    System.out.println("If you want to see by Name press 1");
                    System.out.println("If you want to see by Race press 2");
                    System.out.println("If you want to see by Gender press 3");
                    System.out.println("If you want to see by What Teams they are part of press 4");
                
                
                } // end of if (dcsearch2 == 3){

            }   // end of dcsearch == 2){}
            if (dcsearch == 3){
                System.out.println("now tell me traveler watcha looking for");
            } // end of if (dcsearch == 3){

        }  // end of if(whatyouwannasee == 2){}

        if (whatyouwannasee == 3){
            System.out.println("welcome to Marvel & DC Database what do wanna see buddy");
            System.out.println("To see all characters press 1");
            System.out.println("To see a specific character press 2");
            System.out.println("To find a custom search press 3");
            int marveldcsearch = input.nextInt();


            if(marveldcsearch == 1){
                System.out.println("Showing all characters from both DC and Marvel");
                sj.AllChars();
            }

            if(marveldcsearch == 2){
                System.out.println("Type the name of the character you wish to look for:");
                String charname = input.nextLine();
                sj.CallCharWithName(charname);
            }

            if(marveldcsearch == 3){
                System.out.println("A list of custom commands are given, choose what you'd like:");
                System.out.println("To find all villains born on earth that are not human press 1");
                System.out.println("To find the heroes with at least 3 archenemies press 2");
                System.out.println("To determine which group (Superhero, Villain, Antihero) has the most females press 3");
                int customCommand = input.nextInt();

                if(customCommand == 1){
                    System.out.println("Showing all villains born on Earth that are not human");
                    sj.VillainFromEarthNotHuman();

                }

                if(customCommand == 2){
                    System.out.println("Showing heroes with at least 3 archenemies");
                    sj.HeroWithArchenemy();
                }

                if(customCommand == 3){
                    System.out.println("Showing the affiliation with the highest count of female members");
                    sj.AffiliationWithMostWomen();
                }


            }

        } //end of if(whatyouwannasee == 3){}




    } // end of if(whoareyou == 1){}


        if (whoareyou == 2){
            System.out.println("Welcome back Master plwes put pwassword plws");
            int psswrd = input.nextInt();
            int entry;

            if (psswrd == 1111){
                System.out.println("Correct password welcome back");
                entry = 1;
            }
            else{
                System.out.println("Incorrect password bzz bzz");
                entry = 0;
            }

    
            if(entry == 1){
                System.out.println("welcom admin what would u like to do today");
                System.out.println("if you would like to INSERT the Database press 1");
                System.out.println("if you would like to UPDATE the Database press 2");
                System.out.println("if you would like to DELETE the Database press 3");
                System.out.println("if you would like to VEIW the Database press 4");
                int whatchawannado = input.nextInt();

                if (whatchawannado == 1){
                    System.out.println("ah I see you would like to INSERT now which table would you like to edit ");
                    System.out.println("if you would like to edit NormalIdentity table press 1");
                    System.out.println("if you would like to edit Superhero table press 2");
                    System.out.println("if you would like to edit Antihero table press 3");
                    System.out.println("if you would like to edit Villain table press 4");
                    System.out.println("if you would like to edit Team table press 5");
                    System.out.println("if you would like to edit Version table press 6");
                    System.out.println("if you would like to edit Superpower table press 7");
                    System.out.println("if you would like to edit Archenemy table press 8");
                    System.out.println("if you would like to edit Race table press 9");
                    System.out.println("if you would like to edit Dimension table press 10");
                    int whattablebuddy1 = input.nextInt();

                    if (whattablebuddy1 == 1){
                        System.out.println("I see you want to insert into NormalIdentity please input the following values");
                        System.out.println("please put the ni_ID int");
                        int normalID = input.nextInt();
                        System.out.println("please put the ni_persoinID int");
                        int normalpersonID = input.nextInt();
                        System.out.println("please put the ni_name string");
                        String normalname = input.nextLine();
                        System.out.println("please put the ni_gender string");
                        String normalgender = input.nextLine();
                        System.out.println("please put the ni_dob string");
                        String normadob = input.nextLine();

                        sj.insertToNormalIdentity(normalID, normalpersonID, normalname, normalgender, normadob);

                        
                    }

                    if (whattablebuddy1 == 2){
                        System.out.println("I see you want to insert into Superhero please input the following values");
                        System.out.println("please put the sh_ID int");
                        int shID = input.nextInt();
                        System.out.println("please put the sh_SuperheroID int");
                        int SuperheroID = input.nextInt();
                        System.out.println("please put the sh_Name string");
                        String shname = input.nextLine();
                        System.out.println("please put the sh_SuperpowerID Int");
                        int shSuperpowerID = input.nextInt();
                        System.out.println("please put the sh_Description string");
                        String shDescription = input.nextLine();
                    }

                    if (whattablebuddy1 == 3){
                        System.out.println("I see you want to insert into Antihero please input the following values");
                        System.out.println("please put the ah_ID int");
                        int ahID = input.nextInt();
                        System.out.println("please put the ah_AntiheroID int");
                        int AntiheroID = input.nextInt();
                        System.out.println("please put the ah_Name string");
                        String ahname = input.nextLine();
                        System.out.println("please put the ah_SuperpowerID Int");
                        int ahSuperpowerID = input.nextInt();
                        System.out.println("please put the ah_Description string");
                        String ahDescription = input.nextLine();
                    }

                    if (whattablebuddy1 == 4){
                        System.out.println("I see you want to insert into Villain please input the following values");
                        System.out.println("please put the v_ID int");
                        int vID = input.nextInt();
                        System.out.println("please put the v_VillianID int");
                        int villianID = input.nextInt();
                        System.out.println("please put the v_Name string");
                        String  vname = input.nextLine();
                        System.out.println("please put the v_SuperpowerID Int");
                        int vSuperpowerID = input.nextInt();
                        System.out.println("please put the v_Description string");
                        String vDescription = input.nextLine();
                    }

                    if (whattablebuddy1 == 5){
                        System.out.println("I see you want to insert into Team please input the following values");
                        System.out.println("please put the t_superhetroID int");
                        int tshID = input.nextInt();
                        System.out.println("please put the t_VillianID int");
                        int tvID = input.nextInt();
                        System.out.println("please put the t_antiheroID int");
                        int tahID = input.nextInt();
                        System.out.println("please put the t_Name string");
                        String  vname = input.nextLine();
                        System.out.println("please put the t_teamID Int");
                        int vSuperpowerID = input.nextInt();
          
                    }

                    if (whattablebuddy1 == 6){
                        System.out.println("I see you want to insert into Version please input the following values");
                        System.out.println("please put the ver_superhetroID int");
                        int vershID = input.nextInt();
                        System.out.println("please put the ver_VillianID int");
                        int vervID = input.nextInt();
                        System.out.println("please put the ver_antiheroID int");
                        int verahID = input.nextInt();
                        System.out.println("please put the ver_Name string");
                        String vername = input.nextLine();
                        System.out.println("please put the ver_ID Int");
                        int verID = input.nextInt();
                    }

                    if (whattablebuddy1 == 7){
                        System.out.println("I see you want to insert into Superpower please input the following values");
                        System.out.println("please put the sp_ID int");
                        int spID = input.nextInt();
                        System.out.println("please put the sp_PowerID int");
                        int powerID = input.nextInt();
                        System.out.println("please put the t_Name string");
                        String  vname = input.nextLine();
                        System.out.println("please put the sp_Description string");
                        String  spdescrip = input.nextLine();
          
                    }

                    if (whattablebuddy1 == 8){
                        System.out.println("I see you want to insert into Archenemy please input the following values");
                        System.out.println("please put the ae_superhetroID int");
                        int aeshID = input.nextInt();
                        System.out.println("please put the ae_VillianID int");
                        int aevID = input.nextInt();
                        System.out.println("please put the ae_ID int");
                        int aeID = input.nextInt();
                    }

                    if (whattablebuddy1 == 9){
                        System.out.println("I see you want to insert into Race please input the following values");
                        System.out.println("please put the r_ID int");
                        int rID = input.nextInt();
                        System.out.println("please put the r_Name string");
                        String rname = input.nextLine();
                    }

                    if (whattablebuddy1 == 10){
                        System.out.println("I see you want to insert into Dimension please input the following values");
                        System.out.println("please put the d_dimensionID int");
                        int dID = input.nextInt();
                        System.out.println("please put the ver_Name string");
                        String dname = input.nextLine();
                        System.out.println("please put the d_verionID Int");
                        int dverID = input.nextInt();
          
                      }

                }// end of if(whatchawannado == 1){}

                if (whatchawannado == 2){
                    System.out.println("ah I see you would like to UPDATE now which table would you like to edit ");
                    System.out.println("if you would like to edit NormalIdentity table press 1");
                    System.out.println("if you would like to edit Superhero table press 2");
                    System.out.println("if you would like to edit Antihero table press 3");
                    System.out.println("if you would like to edit Villain table press 4");
                    System.out.println("if you would like to edit Team table press 5");
                    System.out.println("if you would like to edit Version table press 6");
                    System.out.println("if you would like to edit Superpower table press 7");
                    System.out.println("if you would like to edit Archenemy table press 8");
                    System.out.println("if you would like to edit Race table press 9");
                    System.out.println("if you would like to edit Dimension table press 10");
                    int whattablebuddy2 = input.nextInt();

                    if (whattablebuddy2 == 1){
                        System.out.println("so you wanted to UPDATE  the NormalIdentity table please input new values and where they would replace them");
                        System.out.println("press 1 if you are updating a Int value, press 2 for a string value");
                        int normalidentitupdate = input.nextInt();

                        if (normalidentitupdate == 1){
                            System.out.println("Type the attribute name that you would like to update:");
                            String attributeName = input.nextLine();
                            System.out.println("now put in the new int value that will replace the old");
                            int newnrmalid = input.nextInt();

                            sj.updateIntNormalIdentity(attributeName, newnrmalid);

                        }
                        if (normalidentitupdate == 2){
                            System.out.println("Type the attribute name that you would like to update:");
                            String attributeName = input.nextLine();
                            System.out.println("now put in the new string value that will replace the old");
                            String newVal = input.nextLine();

                            sj.updateStringNormalIdentity(attributeName, newVal);

                        }
                    } //end of if(whattablebuddy2 == 1){}

                } // end of if(whatchawannado == 2){}

                if (whatchawannado == 3){
                    System.out.println("ah I see you would like to DELETE now which table would you like to edit ");
                    System.out.println("if you would like to edit NormalIdentity table press 1");
                    System.out.println("if you would like to edit Superhero table press 2");
                    System.out.println("if you would like to edit Antihero table press 3");
                    System.out.println("if you would like to edit Villain table press 4");
                    System.out.println("if you would like to edit Team table press 5");
                    System.out.println("if you would like to edit Version table press 6");
                    System.out.println("if you would like to edit Superpower table press 7");
                    System.out.println("if you would like to edit Archenemy table press 8");
                    System.out.println("if you would like to edit Race table press 9");
                    System.out.println("if you would like to edit Dimension table press 10");
                    int whattablebuddy3 = input.nextInt();

                    if(whattablebuddy3 == 1){
                        System.out.println("so yoou want to delete from the NormalIdentity");
                        System.out.println("press 1 for int conditon or 2 for a string");
                        int deletenormid = input.nextInt();

                        if (deletenormid == 1){
                            System.out.println("Type the attribute name for your condition:");
                            String attributeName = input.nextLine();
                            System.out.println("now put in the int value for your condition:");
                            int conditionVal = input.nextInt();

                            sj.deleteFrom( attributeName,  conditionVal);

                        }
                        if (deletenormid == 2){
                            System.out.println("Type the attribute name for your condition:");
                            String attributeName = input.nextLine();
                            System.out.println("now put in the new string value that will replace the old");
                            String conditionVal = input.nextLine();

                            sj.deleteFrom( attributeName,  conditionVal);

                        }
          
                    }

                } // end of if(whatchawannado == 3){}

                if (whatchawannado == 4){
                    System.out.println("ah I see you would like to VEIW now which table would you like to view ");
                    System.out.println("if you would like to veiw NormalIdentity table press 1");
                    System.out.println("if you would like to veiw Superhero table press 2");
                    System.out.println("if you would like to veiw Antihero table press 3");
                    System.out.println("if you would like to veiw Villain table press 4");
                    System.out.println("if you would like to veiw Team table press 5");
                    System.out.println("if you would like to veiw Version table press 6");
                    System.out.println("if you would like to veiw Superpower table press 7");
                    System.out.println("if you would like to veiw Archenemy table press 8");
                    System.out.println("if you would like to veiw Race table press 9");
                    System.out.println("if you would like to veiw Dimension table press 10");
                    System.out.println("if you would like to veiw all tables press 11");
                    int whattablebuddy4 = input.nextInt();

                    if (whattablebuddy4 == 1){
                        System.out.println("now printing the NormalIdentity table");
                        sj.viewTable("NormalIdentity");

                      }
                    if (whattablebuddy4 == 2){
                        System.out.println("now printing the Superhero table");
                        sj.viewTable("Superhero");
                    }
                    if (whattablebuddy4 == 3){
                        System.out.println("now printing the Antihero table");
                        sj.viewTable("Antihero");
                    }
                    if (whattablebuddy4 == 4){
                        System.out.println("now printing the Villain table");
                        sj.viewTable("Villain");
                    }
                    if (whattablebuddy4 == 5){
                        System.out.println("now printing the Team table");
                        sj.viewTable("Team");
                    }
                    if (whattablebuddy4 == 6){
                        System.out.println("now printing the Version table");
                        sj.viewTable("Version");
                    }
                    if (whattablebuddy4 == 7){
                        System.out.println("now printing the Superpower table");
                        sj.viewTable("Superpower");
                      }
                    if (whattablebuddy4 == 8){
                        System.out.println("now printing the Archenemy table");
                        sj.viewTable("Archenemy");
                    }
                    if (whattablebuddy4 == 9){
                        System.out.println("now printing the Race table");
                        sj.viewTable("Race");
                    }
                    if (whattablebuddy4 == 10){
                        System.out.println("now printing the Dimension table");
                        sj.viewTable("Dimension");
                    }
                    if (whattablebuddy4 == 11){
                        System.out.println("now printing the all tables");
                        //sj.viewTable("tableName");
                    }

                }// end of if(whatchawannado == 4){}


            } // end of if(entry == 1){

            if (entry == 0){
                System.out.println("please run program again and input correct password or go to new user");
        
            } // end of if(entry == 0){}

        } // end of if (whoareyou == 2){

        sj.closeConnection();

    }

}


/* 

Calling on terminal

-> javac proj.java

-> java -classpath ".:sqlite-jdbc-3.32.3.2.jar" proj

*/


//
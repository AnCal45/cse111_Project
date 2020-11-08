
import java.sql.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.File;

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

    
    private void queryName(/* insert variables if needed */){
        //will need at least 20 queries for the project
        // each query will have it's own function
    }

    
    public static void main(String args[]){
        proj sj = new proj();

        sj.openConnection("data.sqlite");

         sj.dropTables();
         sj.createTables();
        // sj.populateTables();

        // //queries
        // sj.queryName();
        // ...


        sj.closeConnection();

    }

}


/* 

Calling on terminal

-> javac proj.java

-> java -classpath ".:sqlite-jdbc-3.32.3.2.jar" proj

*/
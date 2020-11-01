
import java.sql.*;

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
                String connStr = new String("jdbs:sqlite:");
                connStr = connStr + _dbName;

                Class.forName("org.sqlite.JDBC");

                c.DriverManager.getConnection(connStr);

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

    private void createTable(){ 
        //creates table
    }

    private void populateTable(){
        //populates the table
    }

    private void dropTable(){
        //drops table, deletes it and is now long available
    }

    
    private void queryName(/* insert variables if needed */){
        //will need at least 20 queries for the project
        // each query will have it's own function
    }


    public static void main(String args[]){
        proj sj = new proj();

        sj.openConnection("data.sqlite");

        // sj.dropTable();
        // sj.createTable();
        // sj.populateTable();

        // //queries
        // sj.queryName();
        // ...


        sj.closeConnection();

    }





}
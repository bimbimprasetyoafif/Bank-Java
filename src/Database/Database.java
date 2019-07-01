package Database;
/**
 *
 * @author Bimo Prasetyo Afif
 */
import Interfaces.DB;
import java.util.ArrayList;

public class Database implements DB{
    
    private static Database database;
    private ArrayList<Nasabah> nasabah;
    private ArrayList<Admin> admin;
    private ArrayList<TellerAdmin> telleradmin;
    
    public static Database getInstance(){
        if(database == null){
            database = new Database();
            database.nasabah = new ArrayList();
            database.admin = new ArrayList();
            database.telleradmin = new ArrayList();
        }
        return database;
    }
    
    @Override
    public ArrayList<Nasabah> getNasabah(){
        return database.nasabah;
    }
    
    @Override
    public ArrayList<Admin> getAdmin(){
        return database.admin;
    }
    
    @Override
    public ArrayList<TellerAdmin> getTellerAdmin(){
        return database.telleradmin;
    }
    
    
    
}
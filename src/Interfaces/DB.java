package Interfaces;
/**
 *
 * @author Bimo Prasetyo Afif
 */
import Database.*;
import java.util.ArrayList;

public interface DB {
    public abstract ArrayList<Nasabah> getNasabah();
    public abstract ArrayList<Admin> getAdmin();
    public abstract ArrayList<TellerAdmin> getTellerAdmin();
}
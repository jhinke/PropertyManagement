/**
 * This class controls file I/O
 */
package pms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author Ellen
 *
 */
public class IO {
  
	private ArrayList<reservation> reservations;
	
	private String tableName;
	
	private boolean dirty;
	
	public IO(String tableName) {
		this.tableName = tableName;
		
		reservations = new ArrayList<reservation>();
		
		dirty = false;
	}
	
	public boolean write() {
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(tableName)));
			
			out.writeInt(reservations.size());
			
			for (int i = 0; i < reservations.size(); i++) {
				reservation currentReservation = reservations.get(i);
				out.writeObject(currentReservation);
			}
			out.close();
		} catch (IOException ex){
			System.err.println( "ERROR: Attempting to write reservation dataset to" + tableName ) ;
			return false;
		}
		dirty = false;
		return true;
	}

	public boolean read() {
		
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(tableName)));
			
			int count = in.readInt();
			
			while(reservations.size() < count) {
				reservation currentReservation = (reservation)in.readObject();
				
				reservations.add(currentReservation);
			}
			in.close();
		} catch (IOException ex) {
			System.err.println("ERROR: Attempting to read reservation dataset from " + tableName);
			return false;
		} catch (ClassNotFoundException ex) {
			System.err.println("ERROR: Attempting to cast data from " + tableName + " as reservation");
			return false;
		}
		dirty = false;
		return true;
	}
	
	public int size() {
		return reservations.size();
		
	}
	
	public int fields() {
		return 5;
	}
	
	public boolean add(reservation currentReservation) {
		if(currentReservation == null){
			return false;
		}
		dirty = true;
		return reservations.add(currentReservation);
	}
	
	public boolean delete(reservation currentReservation) {
		boolean result = reservations.remove(currentReservation);
		
		if(result == true) {
			dirty = true;
		}
		return result;
	}
	
	public reservation get(int index) {
		if (index < reservations.size()) {
			return reservations.get(index);
		}
		return null;
	}
	
	public boolean isDirty() {
		return dirty;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public static ArrayList<String> getFieldNames() {
		return reservation.getFieldNames();
	}
	
}

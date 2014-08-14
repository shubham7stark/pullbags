package com.example.pullbags;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "addedItemsToCart";
 
    // Contacts table name
    private static final String TABLE_ITEMS = "items";
	private static String DB_PATH = "/data/data/in.co.sdslabs.cognizance/databases/";

	private SQLiteDatabase myDataBase;

    
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_BRIEF = "brief";
    private static final String KEY_STOCK = "stock";
    private static final String KEY_DETAILS = "details";
    private static final String KEY_PRICE = "price";
    private static final String KEY_QTY = "qty";
    private static final String KEY_IMAGEURL = "imageurl";
    
    private final Context myContext;
	private DatabaseHelper ourHelper;
    
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.myContext = context;
    }
    

 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_ITEMS = "CREATE TABLE " + TABLE_ITEMS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," 
        		+ KEY_NAME + " TEXT,"
                + KEY_BRIEF + " TEXT,"  
                + KEY_STOCK + " INTEGER,"  
                + KEY_PRICE + " DOUBLE,"
                + KEY_DETAILS + " TEXT,"  
                 + KEY_QTY + " INTEGER," 
                + KEY_IMAGEURL + " TEXT" + 
                ")";
        db.execSQL(CREATE_CONTACTS_ITEMS);
    }
    
    
	public DatabaseHelper getInstance(Context context) {
		if (ourHelper == null) {
			ourHelper = new DatabaseHelper(context);
		}
		return this;
	}
	
	
	public void openDataBase() throws SQLException {
		String myPath = DB_PATH + DATABASE_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READONLY);
	}
	
	@Override
	public synchronized void close() {
		if (myDataBase != null)
			myDataBase.close();
		super.close();
	}



 
    // Upgrading database
    @Override
    
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        // Create tables again
        onCreate(db);
    }


   public void insertItemToBag(CustomListItem cli) {
	 SQLiteDatabase db = this.getWritableDatabase();
	 
	 ContentValues values = new ContentValues();
	 values.put(KEY_ID,cli.getid());
	 values.put(KEY_NAME, cli.getname());
	 values.put(KEY_BRIEF, cli.getbrief());
	 values.put(KEY_STOCK, cli.getstock());
	 values.put(KEY_PRICE, cli.getprice());
	 values.put(KEY_DETAILS, cli.getdetail());
	 values.put(KEY_QTY, cli.getqty());
	 values.put(KEY_IMAGEURL, cli.getimageurl());
	 
	 long sc = db.insert(TABLE_ITEMS, null, values);
	 
   }
 
	public ArrayList<CustomListItem> getAlItems() {
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM "+TABLE_ITEMS,null);
		ArrayList<CustomListItem> cstmlist = new ArrayList<CustomListItem>(); 
		if (c != null ) {
			
	        if  (c.moveToFirst()) {
	              do {
	                CustomListItem clitem = new CustomListItem();
	                clitem.setid(Integer.parseInt(c.getString(0)));
	                clitem.setname(c.getString(1));
	                clitem.setbrief(c.getString(2));
	                clitem.setstock(Integer.parseInt(c.getString(3)));
	                clitem.setprice(Double.parseDouble(c.getString(4)));
	                clitem.setdetail(c.getString(5));
	                clitem.setqty(Integer.parseInt(c.getString(6)));
	                clitem.setimageurl(c.getString(7));
	                
	                cstmlist.add(clitem);
	                  
	              }while (c.moveToNext());
	        }
	 	}
	     return cstmlist;	
	}
	
	
	public void DeleteEntry(long id)
	  {
	   SQLiteDatabase db=this.getWritableDatabase();
	   db.delete(TABLE_ITEMS,id+"=?", new String [] {String.valueOf(id)});
	   db.close();
	  }
	


}


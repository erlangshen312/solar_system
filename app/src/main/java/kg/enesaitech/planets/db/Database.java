package kg.enesaitech.planets.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by e.zhumanasyrov on 15.04.2019.
 */

public class Database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "planets.db";
    private Context context;

    private static final String SQL_PLANETS =
            "CREATE TABLE sql_planets (" +
                    " id INTEGER PRIMARY KEY autoincrement," +
                    " name varchar(256), " +
                    " note varchar(2000), " +
                    " image varchar(256)" +
                    " )";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_PLANETS);

        db.execSQL("insert into sql_planets(id, name, note, image) values" +
                "(1, 'Earth' , 'Here will be a lot of information about this planet', 'logo.png' ), " +
                "(2, 'Jupiter' , 'Here will be a lot of information about this planet', 'logo.png' ), " +
                "(3, 'Mars' , 'Here will be a lot of information about this planet', 'logo.png') "

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public ArrayList<Planets> getPlanets() {
        ArrayList<Planets> planets = new ArrayList<Planets>();
        String selectQuery = "SELECT id, name, note, image FROM sql_planets order by id";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Planets planet = new Planets();
                planet.setId(c.getInt(c.getColumnIndex("id")));
                planet.setName(c.getString(c.getColumnIndex("name")));
                planet.setNote(c.getString(c.getColumnIndex("note")));
                planet.setImage(c.getString(c.getColumnIndex("image")));
                planets.add(planet);
            } while (c.moveToNext());
        }
        return planets;
    }

}

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
                    " note varchar(256), " +
                    " image varchar(256)," +
                    " description varchar(5000)" +
                    " )";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_PLANETS);

        db.execSQL("insert into sql_planets(id, name, note, image, description) values" +
                "(1, 'Mercury' , 'Here will be a lot of information about this planet', 'mercuri' , 'AAAAAAAAAAAAAAAAAAAAAA'), " +
                "(2, 'Venus' , 'Here will be a lot of information about this planet', 'venus' , 'BBBBBBBBBBBBBBBBBBBBBBBBB'), " +
                "(3, 'Earth' , 'Here will be a lot of information about this planet', 'earth', 'Earth is the third planet from the Sun and the only astronomical object known to harbor life. According to radiometric dating and other sources of evidence, Earth formed over 4.5 billion years ago.[24][25][26] Earth is gravity interacts with other objects in space, especially the Sun and the Moon, Earth is only natural satellite. Earth revolves around the Sun in 365.26 days, a period known as an Earth year. During this time, Earth rotates about its axis about 366.26 times.[n 5]\n" +
                "\n" +
                "Earth is axis of rotation is tilted with respect to its orbital plane, producing seasons on Earth. The gravitational interaction between Earth and the Moon causes ocean tides, stabilizes Earth is orientation on its axis, and gradually slows its rotation. Earth is the densest planet in the Solar System and the largest of the four terrestrial planets.\n" +
                "\n" +
                "Earth is lithosphere is divided into several rigid tectonic plates that migrate across the surface over periods of many millions of years. About 71% of Earth is surface is covered with water, mostly by oceans. The remaining 29% is land consisting of continents and islands that together have many lakes, rivers and other sources of water that contribute to the hydrosphere. The majority of Earth is polar regions are covered in ice, including the Antarctic ice sheet and the sea ice of the Arctic ice pack. Earth is interior remains active with a solid iron inner core, a liquid outer core that generates the Earth is magnetic field, and a convecting mantle that drives plate tectonics.\n" +
                "\n" +
                "Within the first billion years of Earth is history, life appeared in the oceans and began to affect the Earth is atmosphere and surface, leading to the proliferation of aerobic and anaerobic organisms. Some geological evidence indicates that life may have arisen as much as 4.1 billion years ago. Since then, the combination of Earth is distance from the Sun, physical properties, and geological history have allowed life to evolve and thrive. In the history of the Earth, biodiversity has gone through long periods of expansion, occasionally punctuated by mass extinction events. Over 99% of all species that ever lived on Earth are extinct. Estimates of the number of species on Earth today vary widely; most species have not been described. Over 7.6 billion humans live on Earth and depend on its biosphere and natural resources for their survival. Humans have developed diverse societies and cultures; politically, the world has about 200 sovereign states.'), " +
                "(4, 'Mars' , 'Here will be a lot of information about this planet', 'mars', 'CCCCCCCCCCCCCCCCCCCCCCC'), " +
                "(5, 'Jupiter' , 'Here will be a lot of information about this planet', 'jupiter', 'CCCCCCCCCCCCCCCCCCCCCCC'), " +
                "(6, 'Saturn' , 'Here will be a lot of information about this planet', 'saturn', 'CCCCCCCCCCCCCCCCCCCCCCC'), " +
                "(7, 'Uranus' , 'Here will be a lot of information about this planet', 'uranus', 'CCCCCCCCCCCCCCCCCCCCCCC'), " +
                "(8, 'Neptune' , 'Here will be a lot of information about this planet', 'neptun', 'CCCCCCCCCCCCCCCCCCCCCCC'), " +
                "(9, 'Pluto' , 'Here will be a lot of information about this planet', 'pluto', 'CCCCCCCCCCCCCCCCCCCCCCC'), " +
                "(10, 'Sun' , 'Here will be a lot of information about this planet', 'sun', 'CCCCCCCCCCCCCCCCCCCCCCC'), " +
                "(11, 'Moon' , 'Here will be a lot of information about this planet', 'moon', 'CCCCCCCCCCCCCCCCCCCCCCC'), " +
                "(12, 'Asteroid' , 'Here will be a lot of information about this planet', 'asteroid', 'CCCCCCCCCCCCCCCCCCCCCCC'), " +
                "(13, 'Comets' , 'Here will be a lot of information about this planet', 'comets', 'CCCCCCCCCCCCCCCCCCCCCCC'), " +
                "(14, 'Black Hole' , 'Here will be a lot of information about this planet', 'blackhole', 'CCCCCCCCCCCCCCCCCCCCCCC'), " +
                "(15, 'Galaxy' , 'Here will be a lot of information about this planet', 'galaxy', 'CCCCCCCCCCCCCCCCCCCCCCC') "
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

    public Planets getPlanet(int planet_id) {
        String selectQuery = "SELECT id, name, note, description, image FROM sql_planets  where id = " + planet_id + " order by id";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        Planets planet = null;
        if (c.moveToFirst()) {
            do {
                planet = new Planets();
                planet.setId(c.getInt(c.getColumnIndex("id")));
                planet.setName(c.getString(c.getColumnIndex("name")));
                planet.setNote(c.getString(c.getColumnIndex("note")));
                planet.setImage(c.getString(c.getColumnIndex("image")));
                planet.setDescription(c.getString(c.getColumnIndex("description")));
            } while (c.moveToNext());
        }
        return planet;
    }

}

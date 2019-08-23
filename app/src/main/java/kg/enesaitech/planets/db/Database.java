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
    public static final String DATABASE_NAME = "a.db";
    private Context context;

    private static final String SQL_PLANETS =
            "CREATE TABLE sql_planets (" +
                    " id INTEGER PRIMARY KEY autoincrement," +
                    " name varchar(256), " +
                    " subname varchar(256), " +
                    " distance varchar(256), " +
                    " light_time_from_sun varchar(256), " +
                    " light_of_year varchar(256), " +
                    " planet_type varchar(256), " +
                    " note varchar(256), " +
                    " description varchar(5000)," +
                    " main_image varchar(256)," +
                    " second_image varchar(256)," +
                    " third_image varchar(256)," +
                    " diameter varchar(256)," +
                    " equatorial_diameter varchar(256)," +
                    " polar_diameter varchar(256)," +
                    " mass varchar(256)," +
                    " moons varchar(256)," +
                    " orbit_distance varchar(256)," +
                    " orbit_period varchar(256)," +
                    " surface_temperature varchar(256)," +
                    " effective_temperature varchar(256)," +
                    " rings varchar(256)," +
                    " recorded_date varchar(256)," +
                    " recorded_by varchar(256)," +
                    " discovery_date varchar(256)," +
                    " discovery_by varchar(256)," +
                    " quick_facts varchar(256)," +
                    " detailed_facts varchar(256)," +
                    " rings_note varchar(256)," +
                    " atmosphere_note varchar(256)" +
                    " )";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_PLANETS);

        db.execSQL("insert into sql_planets(" +
                        "id, " +
                        "name, " +
                        "subname, " +
                        "distance, " +
                        "light_time_from_sun, " +
                        "light_of_year, " +
                        "planet_type, " +
                        "note, " +
                        "description, " +
                        "main_image, " +
                        "second_image, " +
                        "third_image, " +
                        "diameter, " +
                        "equatorial_diameter, " +
                        "polar_diameter, " +
                        "mass, " +
                        "moons, " +
                        "orbit_distance, " +
                        "orbit_period, " +
                        "surface_temperature, " +
                        "effective_temperature, " +
                        "rings, " +
                        "recorded_date, " +
                        "recorded_by, " +
                        "discovery_date, " +
                        "discovery_by, " +
                        "quick_facts, " +
                        "detailed_facts, " +
                        "rings_note, " +
                        "atmosphere_note) values" +
                "(0, " +
                        "'Mercury', " +
                        "'The Swiftest Planet', " +
                        "'~39,183,389 mi km'," +
                        "'~3.505740 mins'," +
                        "'88 Earth Days'," +
                        "'Terrestrial'," +
                        "'Mercury is the closest planet to the Sun and due to its proximity it is not easily seen except during twilight. For every two orbits of the Sun, Mercury completes three rotations about its axis and up until 1965 it was thought that the same side of Mercury constantly faced the Sun. Thirteen times a century Mercury can be observed from the Earth passing across the face of the Sun in an event called a transit, the next will occur on the 9th May 2016.', " +
                        "'None'," +
                        "'mercuri'," +
                        "'mercury_main'," +
                        "'mercury_second'," +
                        "'4,879 km'," +
                        "'None'," +
                        "'None'," +
                        "'3.30 x 10^23 kg (5.5% Earth)'," +
                        "'None'," +
                        "'57,909,227 km (0.39 AU)'," +
                        "'88 days'," +
                        "'-173 to 427°C'," +
                        "'None'," +
                        "'None'," +
                        "'14th century BC'," +
                        "'Assyrian astronomers'," +
                        "'None'," +
                        "'None'," +
                        "' - Mercury does not have any moons or rings. \n" +
                        " - Your weight on Mercury would be 38% of your weight on Earth. \n" +
                        " - A day on the surface of Mercury lasts 176 Earth days. \n" +
                        " - A year on Mercury takes 88 Earth days. \n" +
                        " - Mercury has a diameter of 4,879 km, making it the smallest planet. \n" +
                        " - It’s not known who discovered Mercury. \n'," +
                        "'A year on Mercury is just 88 days long.\n" +
                        "One solar day (the time from noon to noon on the planet’s surface) on Mercury lasts the equivalent of 176 Earth days while the sidereal day (the time for 1 rotation in relation to a fixed point) lasts 59 Earth days. Mercury is nearly tidally locked to the Sun and over time this has slowed the rotation of the planet to almost match its orbit around the Sun. Mercury also has the highest orbital eccentricity of all the planets with its distance from the Sun ranging from 46 to 70 million km.\n\n" +
                        "Mercury is the smallest planet in the Solar System.\n\n" +
                        "One of five planets visible with the naked eye a, Mercury is just 4,879 Kilometres across its equator, compared with 12,742 Kilometres for the Earth.\n\n" +
                        "Mercury is the second densest planet. \n\n" +
                        "Even though the planet is small, Mercury is very dense. Each cubic centimetre has a density of 5.4 grams, with only the Earth having a higher density. This is largely due to Mercury being composed mainly of heavy metals and rock.\n" +
                        "Mercury has wrinkles.\n" +
                        "As the iron core of the planet cooled and contracted, the surface of the planet became wrinkled. Scientist have named these wrinkles, Lobate Scarps. These Scarps can be up to a mile high and hundreds of miles long.\n\n" +
                        "Mercury has a molten core.\n" +
                        "In recent years scientists from NASA have come to believe the solid iron core of Mercury could in fact be molten. Normally the core of smaller planets cools rapidly, but after extensive research, the results were not in line with those expected from a solid core. Scientists now believe the core to contain a lighter element such as sulphur, which would lower the melting temperature of the core material. It is estimated Mercury’s core makes up 42% of its volume, while the Earth’s core makes up 17%.\n\n" +
                        "Mercury is only the second hottest planet.\n" +
                        "Despite being further from the Sun, Venus experiences higher temperatures. The surface of Mercury which faces the Sun sees temperatures of up to 427°C, whilst on the alternate side this can be as low as -173°C. This is due to the planet having no atmosphere to help regulate the temperature.\n\n" +
                        "Mercury is the most cratered planet in the Solar System. \n" +
                        "Unlike many other planets which “self-heal” through natural geological processes, the surface of Mercury is covered in craters. These are caused by numerous encounters with asteroids and comets. Most Mercurian craters are named after famous writers and artists. Any crater larger than 250 kilometres in diameter is referred to as a Basin. The Caloris Basin is the largest impact crater on Mercury covering approximately 1,550 km in diameter and was discovered in 1974 by the Mariner 10 probe.\n\n" +
                        "Only two spacecraft have ever visited Mercury.\n" +
                        "Owing to its proximity to the Sun, Mercury is a difficult planet to visit. During 1974 and 1975 Mariner 10 flew by Mercury three times, during this time they mapped just under half of the planet’s surface. On August 3rd 2004, the Messenger probe was launched from Cape Canaveral Air Force Station, this was the first spacecraft to visit since the mid 1970’s.\n\n" +
                        "Mercury is named for the Roman messenger to the gods. " +
                        "The exact date of Mercury’s discovery is unknown as it pre-dates its first historical mention, one of the first mentions being by the Sumerians around in 3,000 BC." +
                        "Mercury has an atmosphere (sort of).\n\n" +
                        "Mercury has just 38% the gravity of Earth, this is too little to hold on to what atmosphere it has which is blown away by solar winds. However while gases escape into space they are constantly being replenished at the same time by the same solar winds, radioactive decay and dust caused by micrometeorites'," +
                        "'None'," +
                        "null)"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public ArrayList<Planets> getPlanets() {
        ArrayList<Planets> planets = new ArrayList<Planets>();
        String selectQuery = "SELECT id, name, subname, planet_type, main_image FROM sql_planets order by id";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Planets planet = new Planets();
                planet.setId(c.getInt(c.getColumnIndex("id")));
                planet.setName(c.getString(c.getColumnIndex("name")));
                planet.setSubname(c.getString(c.getColumnIndex("subname")));
                planet.setPlanet_type(c.getString(c.getColumnIndex("planet_type")));
                planet.setMain_image(c.getString(c.getColumnIndex("main_image")));
                planets.add(planet);
            } while (c.moveToNext());
        }
        return planets;
    }

    public Planets getPlanet(int planet_id) {
        String selectQuery = "SELECT id, name, subname, distance, light_time_from_sun, light_of_year, planet_type, note, description, main_image, second_image, third_image, diameter, equatorial_diameter, polar_diameter, mass, moons, orbit_distance, orbit_period, surface_temperature, effective_temperature, rings, recorded_date, recorded_by, discovery_date, discovery_by, quick_facts, detailed_facts, rings_note, atmosphere_note FROM sql_planets  where id = " + planet_id + " order by id";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        Planets planet = null;
        if (c.moveToFirst()) {
            do {
                planet = new Planets();
                planet.setId(c.getInt(c.getColumnIndex("id")));
                planet.setName(c.getString(c.getColumnIndex("name")));
                planet.setSubname(c.getString(c.getColumnIndex("subname")));
                planet.setDistance(c.getString(c.getColumnIndex("distance")));
                planet.setLight_time_from_sun(c.getString(c.getColumnIndex("light_time_from_sun")));
                planet.setLight_of_year(c.getString(c.getColumnIndex("light_of_year")));
                planet.setPlanet_type(c.getString(c.getColumnIndex("planet_type")));
                planet.setNote(c.getString(c.getColumnIndex("note")));
                planet.setDescription(c.getString(c.getColumnIndex("description")));
                planet.setMain_image(c.getString(c.getColumnIndex("main_image")));
                planet.setSecond_image(c.getString(c.getColumnIndex("second_image")));
                planet.setThird_image(c.getString(c.getColumnIndex("third_image")));
                planet.setDiameter(c.getString(c.getColumnIndex("diameter")));
                planet.setEquatorial_diameter(c.getString(c.getColumnIndex("equatorial_diameter")));
                planet.setPolar_diameter(c.getString(c.getColumnIndex("polar_diameter")));
                planet.setMass(c.getString(c.getColumnIndex("mass")));
                planet.setMoons(c.getString(c.getColumnIndex("moons")));
                planet.setOrbit_distance(c.getString(c.getColumnIndex("orbit_distance")));
                planet.setOrbit_period(c.getString(c.getColumnIndex("orbit_period")));
                planet.setSurface_temperature(c.getString(c.getColumnIndex("surface_temperature")));
                planet.setEffective_temperature(c.getString(c.getColumnIndex("effective_temperature")));
                planet.setRings(c.getString(c.getColumnIndex("rings")));
                planet.setRecorded_date(c.getString(c.getColumnIndex("recorded_date")));
                planet.setRecorded_by(c.getString(c.getColumnIndex("recorded_by")));
                planet.setDiscovery_date(c.getString(c.getColumnIndex("discovery_date")));
                planet.setDiscovery_by(c.getString(c.getColumnIndex("discovery_by")));
                planet.setQuick_facts(c.getString(c.getColumnIndex("quick_facts")));
                planet.setDetailed_facts(c.getString(c.getColumnIndex("detailed_facts")));
                planet.setRings_note(c.getString(c.getColumnIndex("rings_note")));
                planet.setAtmosphere_note(c.getString(c.getColumnIndex("atmosphere_note")));
            } while (c.moveToNext());
        }
        return planet;
    }

}


//
//
//"(2, 'Venus' , 'Planetary Hot Spot', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','venus', 'descrtiption'), " +
//        "(3, 'Earth' , 'Our Home Planet', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','earth', 'descrtiption'), " +
//        "(4, 'Mars' , 'The Red Planet', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','mars', 'descrtiption'), " +
//        "(5, 'Jupiter' , 'Twice as massive as all the pther planets combined', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','jupiter', 'descrtiption'), " +
//        "(6, 'Saturn' , 'Jewel of Our Solar System', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','saturn', 'descrtiption'), " +
//        "(7, 'Uranus' , 'The Sideways Planet', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','uranus', 'descrtiption'), " +
//        "(8, 'Neptune' , 'The Windiest Planet', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','neptun', 'descrtiption'), " +
//        "(9, 'Pluto' , 'Dwari Planet', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','pluto', 'descrtiption'), " +
//        "(10, 'Sun' , 'Here will be text', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','sun', 'descrtiption'), " +
//        "(11, 'Moon' , 'Here will be text', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','moon', 'descrtiption'), " +
//        "(12, 'Asteroid' , 'Here will be text', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','asteroid', 'descrtiption'), " +
//        "(13, 'Comets' , 'Here will be text', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','comets', 'descrtiption'), " +
//        "(14, 'Black Hole' , 'Here will be text', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','blackhole', 'descrtiption'), " +
//        "(15, 'Galaxy' , 'Here will be text', '~152,759,478 mi km','~13.667381 mins','687 Earth Days','Terrestrial','No planet beyond Earth has been studied as intensely as Mars. Recorded observations of Mars date as far back as the era of ancient Egypt over 4,000 years ago, when they charted the planet is movements in the sky. Today, a science fleet of robotic spacecraft study Mars from all angles.\n Six spacecraft are in orbit at Mars. NASA is scient trio are Mars Reconnaissance Orbiter, Mars Odyssey and MAVEN. ESA managed the ExoMars Trace Gas Orbiter and Mars Express missions. India is first Red Planet spacecraft — the Mars Orbiter Mission (MOM) — since 2014.\n Two robotic spacecraft are at work on the surface. NASA is Curiosity rover is exploring Mount Sharp in Gale Crater. NASA is InSight, a stationary lander, is probing Mars interior from a site on a flat smooth plain called Elysium Planitia. Both NASA and ESA have plans to send new rovers to Mars in 2020.', 'Mars was named by the ancient Romans for their god of war because its reddish color was reminiscent of blood. Other civilizations also named the planet for this attribute; for example, the Egyptians called it \"Her Desher,\" meaning \"the red one.\" Even today, it is frequently called the \"Red Planet\" because iron minerals in the Martian dirt oxidize, or rust, causing the surface to look red.','galaxy', 'descrtiption') "
//





//db.execSQL("insert into sql_planets(id, name, subname, distance, light_time_from_sun, light_of_year, planet_type, note, description, main_image, second_image, third_image, diameter, equatorial_diameter, polar_diameter, mass, moons, orbit_distance, orbit_period, surface_temperature, effective_temperature, rings, recorded_date, recorded_by, discovery_date, discovery_by, quick_facts, detailed_facts, rings_note, atmosphere_note) values" +
//        "(1, 'Mercury', 'The Swiftest Planet', '~39,183,389 mi km','~3.505740 mins','88 Earth Days','Terrestrial','Mercury is the closest planet to the Sun and due to its proximity it is not easily seen except during twilight. For every two orbits of the Sun, Mercury completes three rotations about its axis and up until 1965 it was thought that the same side of Mercury constantly faced the Sun. Thirteen times a century Mercury can be observed from the Earth passing across the face of the Sun in an event called a transit, the next will occur on the 9th May 2016.', ' ','mercuri','mercuri2','mercuri3', '4,879 km',' ',' ','3.30 x 10^23 kg (5.5% Earth)','None','57,909,227 km (0.39 AU)','88 days','-173 to 427°C',' ','14th century BC','Assyrian astronomers',' ',' ','Mercury does not have any moons or rings." +
//        "Your weight on Mercury would be 38% of your weight on Earth.\n" +
//        "A day on the surface of Mercury lasts 176 Earth days.\n" +
//        "A year on Mercury takes 88 Earth days.\n" +
//        "Mercury has a diameter of 4,879 km, making it the smallest planet.\n" +
//        "It’s not known who discovered Mercury.','A year on Mercury is just 88 days long.\n" +
//        "One solar day (the time from noon to noon on the planet’s surface) on Mercury lasts the equivalent of 176 Earth days while the sidereal day (the time for 1 rotation in relation to a fixed point) lasts 59 Earth days. Mercury is nearly tidally locked to the Sun and over time this has slowed the rotation of the planet to almost match its orbit around the Sun. Mercury also has the highest orbital eccentricity of all the planets with its distance from the Sun ranging from 46 to 70 million km.\n" +
//        "Mercury is the smallest planet in the Solar System.\n" +
//        "One of five planets visible with the naked eye a, Mercury is just 4,879 Kilometres across its equator, compared with 12,742 Kilometres for the Earth.\n" +
//        "Mercury is the second densest planet. \n" +
//        "Even though the planet is small, Mercury is very dense. Each cubic centimetre has a density of 5.4 grams, with only the Earth having a higher density. This is largely due to Mercury being composed mainly of heavy metals and rock.\n" +
//        "Mercury has wrinkles.\n" +
//        "As the iron core of the planet cooled and contracted, the surface of the planet became wrinkled. Scientist have named these wrinkles, Lobate Scarps. These Scarps can be up to a mile high and hundreds of miles long.\n" +
//        "Mercury has a molten core.\n" +
//        "In recent years scientists from NASA have come to believe the solid iron core of Mercury could in fact be molten. Normally the core of smaller planets cools rapidly, but after extensive research, the results were not in line with those expected from a solid core. Scientists now believe the core to contain a lighter element such as sulphur, which would lower the melting temperature of the core material. It is estimated Mercury’s core makes up 42% of its volume, while the Earth’s core makes up 17%.\n" +
//        "Mercury is only the second hottest planet.\n" +
//        "Despite being further from the Sun, Venus experiences higher temperatures. The surface of Mercury which faces the Sun sees temperatures of up to 427°C, whilst on the alternate side this can be as low as -173°C. This is due to the planet having no atmosphere to help regulate the temperature.\n" +
//        "Mercury is the most cratered planet in the Solar System. \n" +
//        "Unlike many other planets which “self-heal” through natural geological processes, the surface of Mercury is covered in craters. These are caused by numerous encounters with asteroids and comets. Most Mercurian craters are named after famous writers and artists. Any crater larger than 250 kilometres in diameter is referred to as a Basin. The Caloris Basin is the largest impact crater on Mercury covering approximately 1,550 km in diameter and was discovered in 1974 by the Mariner 10 probe.\n" +
//        "Only two spacecraft have ever visited Mercury.\n" +
//        "Owing to its proximity to the Sun, Mercury is a difficult planet to visit. During 1974 and 1975 Mariner 10 flew by Mercury three times, during this time they mapped just under half of the planet’s surface. On August 3rd 2004, the Messenger probe was launched from Cape Canaveral Air Force Station, this was the first spacecraft to visit since the mid 1970’s.\n" +
//        "Mercury is named for the Roman messenger to the gods.\n" +
//        " The exact date of Mercury’s discovery is unknown as it pre-dates its first historical mention, one of the first mentions being by the Sumerians around in 3,000 BC.\n" +
//        "Mercury has an atmosphere (sort of).\n" +
//        "Mercury has just 38% the gravity of Earth, this is too little to hold on to what atmosphere it has which is blown away by solar winds. However while gases escape into space they are constantly being replenished at the same time by the same solar winds, radioactive decay and dust caused by micrometeorites','','')"
//        );
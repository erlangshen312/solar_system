package kg.enesaitech.planets.db;

/**
 * Created by e.zhumanasyrov on 15.04.2019.
 */

public class Planets {

    private int id;
    private String name;
    private String note;
    private String description;
    private String image;

    //constructor
    public Planets(){

    }

    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.ludwiglarsson.learnwordswithtamagotchi.data;

public class Words {
    private int id;
    private String name;
    private String description;
    private String hints;
    private String photo;

    public Words(int id, String name, String description, String hints, String photo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hints = hints;
        this.photo = photo;
    }
    public Words(String name, String description, String hints, String photo) {
        this.name = name;
        this.description = description;
        this.hints = hints;
        this.photo = photo;
    }

    public Words() {}

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

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}
    public String getHints() {
        return hints;
    }
    public void setHints(String hints) {
        this.hints = hints;
    }
    public String getPhoto(){return photo;}

    public void setPhoto(String photo){this.photo = photo;}
}

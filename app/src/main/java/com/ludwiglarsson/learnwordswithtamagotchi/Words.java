package com.ludwiglarsson.learnwordswithtamagotchi;

public class Words {
    private int id;
    private String name;
    private String description;
    private String hints;

    private int usage;

    public Words(int id, String name, String description, String hints, int usage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hints = hints;
        this.usage = usage;
    }
    public Words(String name, String description, String hints, int usage) {
        this.name = name;
        this.description = description;
        this.hints = hints;
        this.usage = usage;
    }
    public Words(String name, String description, String hints) {
        this.name = name;
        this.description = description;
        this.hints = hints;
    }
    public Words() {

    }

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
    public int getUsage() {
        return usage;
    }
    public void setUsage(int usage) {
        this.usage = usage;
    }
}

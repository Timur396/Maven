package me.aminov.demo.model;

public class Ingredients {
    private String name;
    private int numberOfIngredients;
    private String measure;
    private  Integer id;
private static int counter=0;

    public Ingredients(String name, int numberOfIngredients, String measure) {
        setName(name);
        setNumberOfIngredients(numberOfIngredients);
        setMeasure(measure);
        id=counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isBlank() && name != null) {
            this.name = name;
        } else this.name = "Разное";
    }


    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }

    public void setNumberOfIngredients(int numberOfIngredients) {
        if (numberOfIngredients >= 0) {
            this.numberOfIngredients = numberOfIngredients;
        } else this.numberOfIngredients = 0;

    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        if (measure != null && !measure.isBlank()) {
            this.measure = measure;
        } else this.measure = "единиц";
    }
}


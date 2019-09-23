import com.github.javafaker.Faker;

import java.util.Random;

public class Item {
    String name;
    boolean scanned;
    View view;
    public Item() {
        this.scanned = false;
        this.view = new View();
        Faker faker = new Faker();
        Random rand = new Random();
        int n = rand.nextInt(4);
        switch (n){
            case 1:
                this.name = faker.food().dish();
                break;
            case 2:
                this.name = faker.food().fruit();
                break;
            case 3:
                this.name = faker.food().sushi();
                break;
            case 4:
                this.name = faker.food().vegetable();
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isScanned() {
        return scanned;
    }

    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }

    public void printProcess(){
        String string = (this.scanned) ? "Se proceso" : "La caja no lo proceso";
        this.view.print("Articulo - "+this.name + " - " + string);
    }
}

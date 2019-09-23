import com.github.javafaker.Faker;

import java.util.*;

public class Client {
    String first_name;
    String last_name;
    ArrayList<Item> items = new ArrayList<Item>();;
    View view;

    public Client() {
        Faker faker = new Faker();
        Random rand = new Random();
        int n = rand.nextInt(14);
        if (n == 0)
            n++;
        for (int i = 0; i < n; i++){
            this.items.add(new Item());
        }
        this.first_name = faker.name().firstName();
        this.last_name = faker.name().lastName();
        this.view = new View();
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void removeItem(){
        this.items.get(0).setScanned(true);
        view.print("Cliente - " + this.first_name + " " + this.last_name);
        this.items.get(0).printProcess();
        this.items.remove(0);
        view.print("El objeto ha sido removido\n");
    }
}

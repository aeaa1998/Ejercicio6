import java.util.*;

public class Cashier {
    ArrayList<Client> clients  = new ArrayList<Client>();;
    boolean free;
    View view;
    String type;
    int itemsClient;

    public Cashier(String type) {
        this.free = true;
        this.type = type;
        view = new View();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void pushClient(Client client) {
        this.clients.add(client);
        view.print("Cliente añadido con exito a la caja "+ this.type +".\n");
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getItemsClient() {
        return itemsClient;
    }

    public void setItemsClient(int itemsClient) {
        this.itemsClient = itemsClient;
    }
    public void processItem(){
        if (!this.clients.isEmpty()){
            Client client  = this.clients.get(0);
            ArrayList<Item> items = client.getItems();
            if (!items.isEmpty()){
                Item firstItem = items.get(0);
                Random random = new Random();
                int randomNumber = random.nextInt(2);
                if (randomNumber == 1){
                    this.clients.get(0).removeItem();
                    if (this.clients.get(0).getItems().isEmpty()){
                        this.clients.remove(client);
                        this.view.print("El cliente "+ client.getFirst_name() + " " + client.getLast_name() +" abandonara la caja.");
                    }
                }else{
                    view.print("Cliente - " + client.getFirst_name() + " " + client.getLast_name());
                    firstItem.printProcess();
                    this.view.print("No se proceso el articulo\n");
                }
            }else{
                this.view.print("No hay articulos");
            }
        }else {
            this.view.print("No tiene clientes esta caja");
        }

    }
}

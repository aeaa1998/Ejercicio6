import java.util.*;
public class Manager {
    ArrayList<Client> allClients = new ArrayList<Client>();
    ArrayList<Cashier> specialCashiers = new ArrayList<Cashier>();;
    ArrayList<Cashier> cashiers = new ArrayList<Cashier>();;
    int clientRate;
    int rounds;
    Random random;
    View view;

    public Manager(int clientRate, int cashiers, int specialCashiers, int rounds) {
        this.random = new Random();
        this.clientRate = clientRate;
        for (int i = 0; i < (cashiers - specialCashiers); i++) {
            this.cashiers.add(new Cashier("Normal"));
        }
        for (int i = 0; i < (specialCashiers); i++) {
            this.specialCashiers.add(new Cashier("Especial"));
        }
        this.rounds = rounds;
        view = new View();
    }

    public ArrayList<Client> getAllClients() {
        return allClients;
    }

    public void setAllClients(ArrayList<Client> allClients) {
        this.allClients = allClients;
    }

    public int getClientRate() {
        return clientRate;
    }

    public void setClientRate(int clientRate) {
        this.clientRate = clientRate;
    }
    public void generateClient(){
        for (int i = 0; i < rounds; i++) {
            int random = this.random.nextInt(this.clientRate);
            if (random == 1){
                Client newClient = new Client();
                this.allClients.add(newClient);
                view.print("Cliente añadido con exito a la cola.");
            }
        }
        view.print("\n");

    }

    public void assignClient(){
        if (!this.allClients.isEmpty()){
            boolean bool = true;
            Client choosen = this.allClients.get(this.allClients.size() - 1);
            this.allClients.remove(choosen);
            if (choosen.getItems().size() < 10){
                while (bool){
                    int index = this.random.nextInt(this.specialCashiers.size());
                    if (this.specialCashiers.get(index).isFree()){
                        this.specialCashiers.get(index).pushClient(choosen);
                        bool = false;
                    }
                }
            }else{
                while (bool){
                    int index = this.random.nextInt(this.cashiers.size());
                    if (this.cashiers.get(index).isFree()){
                        this.cashiers.get(index).pushClient(choosen);
                        bool = false;
                    }
                }
            }
        }else{
            view.print("No hay clientes\n");
        }
    }

    public void processAllClients(){
        for (int i = 0; i < cashiers.size(); i++) {
            Cashier cashier = cashiers.get(i);
            view.print("Cajero normal - " + (i+1));

            if (!cashier.getClients().isEmpty()){
                cashiers.get(i).processItem();
            }else{
                view.print("No tiene clientes");
            }
            view.print("\n");
        }
        for (int i = 0; i < specialCashiers.size(); i++) {
            Cashier cashier = specialCashiers.get(i);
            view.print("Cajero especial - " + (i+1));

            if (!cashier.getClients().isEmpty()){
                specialCashiers.get(i).processItem();
            }else{
                view.print("No tiene clientes");
            }
            view.print("\n");
        }
    }
}

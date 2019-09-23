import java.util.*;

public class Controller {
    boolean active = true;
    View view;
    ArrayList<String> menu = new ArrayList<String>(
            Arrays.asList("Otra ronda", "Salir"));
    Manager manager;
    int counter = 1;

    public Controller() {
        this.view = new View();
        int clientRate = view.intInput("Ingrese el valor n para la probabilidad 1/n que se genere un nuevo cliente.", "Ingrese un valor valido", 1);
        int cashiers = view.intInput("Numero de cajas normales minimo 2", "Ingrese un valor mayor o igual a 2", 2);
        int specialCashiers = view.intPositiveInput("Numero de cajas especiales", "Ingrese un valor valido", (cashiers -1));
        int rounds = view.intInput("Numero de clientes potenciales por ronda.", "Ingrese un valor valido", 1);

        this.manager = new Manager(clientRate, cashiers, specialCashiers, rounds);
    }

    public void start(){
        this.view.print("Ronda "+ counter);
        this.manager.generateClient();
        this.manager.assignClient();
        this.manager.processAllClients();
        this.counter++;
        while (active){
            String c = this.view.selectOptions(menu, "Ingrese una opcion valida");
            if (c.equalsIgnoreCase("Otra ronda")){
                view.print("Ronda "+ counter);
                this.manager.generateClient();
                this.manager.assignClient();
                this.manager.processAllClients();
                this.counter++;
            }else{
                active = false;
            }
        }
        view.print("Gracias por usar el programa");
    }
}

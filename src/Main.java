import Domain.ClientValidator;
import Domain.DrugValidator;
import Domain.TransactionValidator;
import Repository.ClientRepository;
import Repository.DrugRepository;
import Repository.TransactionRepository;
import Service.ClientService;
import Service.DrugService;
import Service.TransactionService;
import UI.Consola2;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        DrugValidator drugValidator = new DrugValidator();
        ClientValidator clientValidator = new ClientValidator();
        TransactionValidator transactionValidator = new TransactionValidator();

        DrugRepository drugRepository = new DrugRepository(drugValidator);
        ClientRepository clientRepository = new ClientRepository(clientValidator);
        TransactionRepository transactionRepository = new TransactionRepository(transactionValidator);

        DrugService drugService = new DrugService(drugRepository);
        ClientService clientService = new ClientService(clientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, drugRepository);

        Consola2 console = new Consola2(drugService);
        console.run();
    }
}

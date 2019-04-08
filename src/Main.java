import Domain.*;
import Domain.Validators.ClientValidator;
import Domain.Validators.DrugValidator;
import Domain.Validators.TransactionValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.ClientService;
import Service.DrugService;
import Service.TransactionService;
import UI.Consola2;

public class Main {
    public static void main(String[] args) {
        IValidator<Drug> drugValidator = new DrugValidator();
        IValidator<Client> clientValidator = new ClientValidator();
        IValidator<Transaction> transactionValidator = new TransactionValidator();

        IRepository<Drug> drugRepository = new InMemoryRepository<>(drugValidator);
        IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
        IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);

        DrugService drugService = new DrugService(drugRepository);
        ClientService clientService = new ClientService(clientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, drugRepository);

        Consola2 console = new Consola2(drugService);
        console.run();
    }
}
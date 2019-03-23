package Service;

import Domain.Drug;
import Domain.Transaction;
import Repository.DrugRepository;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionService {



    private TransactionRepository transactionRepository;
    private DrugRepository drugRepository;

    public TransactionService(TransactionRepository transactionRepository, DrugRepository drugRepository) {
        this.transactionRepository = transactionRepository;
        this.drugRepository = drugRepository;
    }

    public Transaction addOrUpdate(String id, String idDrug, String idClientCard, int numberOfItems, String date, String time) {
        Transaction existing = transactionRepository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (idDrug.isEmpty()) {
                idDrug = existing.getIdDrug();
            }
            if (idClientCard.isEmpty()) {
                idClientCard = existing.getIdClientCard();
            }
            if (numberOfItems == 0) {
                numberOfItems = existing.getNumberOfItems();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (time.isEmpty()) {
                time = existing.getTime();
            }
        }

        Drug drugSold = drugRepository.findById(idDrug);
        if (drugSold == null) {
            throw new RuntimeException("There is no drug with the given id!");
        }
        double basePrice = drugSold.getPrice();
        double discount = 0;
        if (idClientCard != null && !drugSold.isNeeedRecipe()) {
            discount = 0.1; // 10% discount

        }else if (drugSold.isNeeedRecipe()){
            discount = 0.15; //15% discount
        }

        Transaction transaction = new Transaction(id, idDrug, idClientCard, date, time, numberOfItems,basePrice, discount);
        transactionRepository.upsert(transaction);
        return transaction;
    }

    public void remove(String id) {
        transactionRepository.remove(id);
    }

    public List<Transaction> getAll() {
        return transactionRepository.getAll();
    }
}

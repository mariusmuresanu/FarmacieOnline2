package Domain.Validators;

import Domain.IValidator;
import Domain.Transaction;

public class TransactionValidator implements IValidator<Transaction> {

public TransactionValidator(){

}


    @Override
    public void validate(Transaction transaction) throws ValidatorException{
        StringBuilder error = new StringBuilder();
        if (error.length() > 0) {
            throw new IllegalArgumentException(error.toString());
        }
        if (transaction.getNumberOfItems() <= 0) {
            throw new RuntimeException("The number of items must be at least 1.");
        }
    }

}

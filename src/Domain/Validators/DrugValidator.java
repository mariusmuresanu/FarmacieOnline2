package Domain.Validators;

import Domain.Drug;
import Domain.IValidator;

public class DrugValidator implements IValidator<Drug> {

    public DrugValidator() {
    }

    @Override
    public void validate(Drug drug) throws ValidatorException {
        StringBuilder error = new StringBuilder();
        if (drug.getId() == null || drug.getId().equals(" ")) {
            error.append("ID should have a value");
        }
        if (drug.getName() == null || drug.getName().equals(" ")) {
            error.append("Name must be completed");
        }
        if (drug.getPrice()<= 0) {
        throw new RuntimeException("Price must be > 0!");
        }
        if (error.length() > 0) {
            throw new IllegalArgumentException(error.toString());
        }
    }


}

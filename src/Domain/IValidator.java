package Domain;

import Domain.Validators.ValidatorException;

public interface IValidator <T extends Entity>{



    void validate(T entity) throws ValidatorException;
}

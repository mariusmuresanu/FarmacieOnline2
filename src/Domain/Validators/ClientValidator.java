package Domain.Validators;

import Domain.Client;
import Domain.IValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientValidator  implements IValidator<Client> {


    public ClientValidator() {
    }




@Override
    public void validate(Client client) throws ValidatorException{

    StringBuilder error = new StringBuilder();
    if (client.getFirstName() == null || client.getFirstName().equals(" ")) {
        error.append("First name must be completed");
    }
    if ((client.getLastName() == null) || client.getLastName().equals(" ")) {
        error.append("Last name must be completed");
    }
    if (client.getId() == null ) {
        error.append("ID should have a value");
    }

    if (error.length() > 0) {
        throw new IllegalArgumentException(error.toString());
    }

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.parse(client.getDateOfBirth());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of birth is not in a correct format!");
        }

        try {
            format.parse(client.getDateOfRegistration());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of registration is not in a correct format!");
        }
    }
}

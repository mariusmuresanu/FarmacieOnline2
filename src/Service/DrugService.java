package Service;

import Domain.Drug;
import Repository.IRepository;

import java.util.List;

public class DrugService {

    private IRepository<Drug> repository;

    public DrugService(IRepository<Drug> repository) {
        this.repository = repository;
    }

    public void addOrUpdate(String id, String name, String manufacturer, double price, boolean neeedRecipe) {
        Drug existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (name.isEmpty()) {
                name = existing.getName();
            }
            if (manufacturer.isEmpty()) {
                manufacturer = existing.getManufacturer();
            }
            if (price == 0) {
                price = existing.getPrice();
            }
        }
        Drug drug = new Drug(id, name, manufacturer, price, neeedRecipe);
        repository.upsert(drug);
    }

    public void remove(String id) {
        repository.remove(id);
    }

    public List<Drug> getAll() {
        return repository.getAll();
    }



}

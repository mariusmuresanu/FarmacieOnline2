package Repository;

import Domain.Drug;
import Domain.Validators.DrugValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {

    @Test
    void findByIdWithExistingIdShouldReturnCorrectDrug() {
    IRepository<Drug> repo = new InMemoryRepository<>(new DrugValidator());
    Drug added = new Drug("1", "test", "test", 12.5, true);
    repo.upsert(added);

    Drug found = repo.findById("1");
    assertNotNull(found, "Returned null for existing id!");
    assertEquals("1", found.getId(), String.format("Returned id %s instead of correct id=1!", found.getId()));
    assertEquals("test",  found.getName(), String.format("Returned name=%s instead of %s", found.getName(), added.getName()));


    }

    @Test
    void upsert() {
    }

    @Test
    void remove() {
    }

    @Test
    void getAll() {
    }
}
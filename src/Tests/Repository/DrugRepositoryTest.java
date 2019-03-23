package Tests.Repository;

import Domain.Drug;
import Domain.DrugValidator;
import Repository.DrugRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DrugRepositoryTest {

    @Test
    void insertShouldAddDrugs() {

        DrugValidator validator = new DrugValidator();
        DrugRepository repository = new DrugRepository(validator);
        Drug drug1 = new Drug("1","2", "3", 10.2, true);
        Drug drug2 = new Drug("2", "2", "3", 10.2, true);
        Drug drugDupe = new Drug("1", "2", "3", 10.2, true);

        repository.upsert(drug1);
        List<Drug> all = repository.getAll();
        assertEquals(1, all.size());
        assertEquals(drug1, all.get(0));

        try {
            repository.upsert(drugDupe);
            fail("Exception not thrown for duplicate drug id!");
        }catch (RuntimeException rex){
            assertTrue(true);
        }
    }
    @Test
    void update() {
    }
}
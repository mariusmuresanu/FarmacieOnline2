package Tests.Domain;

import Domain.Drug;

import static org.junit.jupiter.api.Assertions.*;

class DrugTest {



    @org.junit.jupiter.api.Test
    void getIdShouldReturnCorrectId() {
        Drug drug = new Drug("1", "test", "test", 10.2, true);
        assertEquals("1", drug.getId(), String.format("Returned %s, expected=%s", drug.getId(), "1"));
        Drug drug2 = new Drug("2", "test", "test", 10.2, true);
        assertEquals("2", drug2.getId(), String.format("Returned %s, expected=%s", drug.getId(), "2"));
    }

    @org.junit.jupiter.api.Test
    void setIdShouldSetTheGivenId() {
        Drug drug = new Drug("1", "test", "test", 10.2, true);
        String setId = "7";
        drug.setId(setId);
        assertEquals(setId, drug.getId(), String.format("Returned=%s, Expected=%s", drug.getId(), setId));
    }

    @org.junit.jupiter.api.Test
    void constructorShouldSetAllFieldsCorrectly() {
        Drug drug = new Drug("1", "test", "test", 10.2, true);
        assertEquals("1", drug.getId());
        assertEquals("test", drug.getName());
        assertEquals("test", drug.getManufacturer());
        assertEquals(10.2, drug.getPrice());
        assertTrue(drug.isNeeedRecipe());
    }

    @org.junit.jupiter.api.Test
    void settersShouldSetFieldsCorrectly() {
        Drug drug = new Drug("1", "test", "test", 10.2, true);

        drug.setId("2");
        drug.setName("test2");
        drug.setManufacturer("test2");
        drug.setPrice(20.2);
        drug.setNeeedRecipe(false);


        assertEquals("2", drug.getId());
        assertEquals("test2", drug.getName());
        assertEquals("test2", drug.getManufacturer());
        assertEquals(20.2, drug.getPrice());
        assertFalse(drug.isNeeedRecipe());

    }

    @org.junit.jupiter.api.Test
    void equalityShouldWorkCorrectly() {
        Drug drug1 = new Drug("1", "test", "test", 10.2, true);
        Drug drug2 = new Drug("1", "test", "test", 10.2, true);
        Drug drug3 = new Drug("1", "test", "test", 10.2, true);

        assertEquals(drug1, drug3);
        assertEquals(drug3, drug1);
        assertEquals(drug3, drug2);
        assertEquals(drug2, drug3);
        assertEquals(drug1, drug2);
        assertEquals(drug2, drug1);
    }


    @org.junit.jupiter.api.Test
    void toStringShouldReturnALongEnoughString() {
        Drug drug1 = new Drug("1", "test", "test", 10.2, true);

        assertTrue(drug1.toString().length() >10);
    }
}
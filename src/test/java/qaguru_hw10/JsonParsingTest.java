package qaguru_hw10;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import qaguru_hw10.model.EmployeesModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JsonParsingTest {
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void jsonTest() throws Exception {

        File file = new File("src/test/resources/Sample-employee-JSON-data.json");
        EmployeesModel user = objectMapper.readValue(file, EmployeesModel.class);
        Assertions.assertEquals(user.employees.get(0).userId,"krish");
        Assertions.assertEquals(user.employees.get(0).jobTitle,"Developer");
        Assertions.assertEquals(user.employees.get(0).firstName,"Krish");
        Assertions.assertEquals(user.employees.get(0).lastName,"Lee");
        Assertions.assertEquals(user.employees.get(0).employeeCode,"E1");
        Assertions.assertEquals(user.employees.get(0).region,"CA");
        Assertions.assertEquals(user.employees.get(0).phoneNumber,"123456");
        Assertions.assertEquals(user.employees.get(0).emailAddress,"krish.lee@learningcontainer.com");

    }
}

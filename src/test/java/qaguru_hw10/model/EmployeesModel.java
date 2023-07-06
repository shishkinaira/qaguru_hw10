package qaguru_hw10.model;
import java.util.List;
public class EmployeesModel {
        public List<EmployeesList> Employees;

        // подскажите пожалуйста почему когда я добавила static к описанию класса данные стали норм читаться в JsonParsingTest?
        //       public static class EmployeesList {
        public static class EmployeesList {
                public  String userId;
                public String jobTitle;
                public String firstName;
                public String lastName;
                public String employeeCode;
                public String region;
                public String phoneNumber;
                public String emailAddress;
        }

}

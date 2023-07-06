package qaguru_hw10.model;
import java.util.List;
public class EmployeesModel {
        public List<EmployeesList> employees;

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

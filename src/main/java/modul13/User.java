package modul13;

import lombok.Builder;
import lombok.Data;
import modul13.Address;
import modul13.Company;

@Builder
@Data
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}

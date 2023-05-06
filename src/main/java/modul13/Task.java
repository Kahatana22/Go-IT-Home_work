package modul13;

import lombok.Data;

@Data
public class Task {
    private int userId;
    private int id;
    private String title;
    boolean completed;
}

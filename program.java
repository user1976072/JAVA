
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class program {
    public static void main(String[] args) {
        Book phoneBook = new Book();
        phoneBook.add("123456789", "Иванов");
        phoneBook.add("111111111", "Петров");
        phoneBook.add("222222222", "Васечкин");
        phoneBook.add("333333333", "Игнатов");
        phoneBook.add("444444444", "Иванов");
        phoneBook.add("555555555", "Иванов");
        phoneBook.add("111122222", "Петров");
        phoneBook.add("222233333", "Ливанов");
        phoneBook.add("345678911", "Суворов");
        
        System.out.println(phoneBook.getAll());
    }
}

class Book {
    private Map<String, List<String>> map = new HashMap<>();

    void add(String phoneNum, String name) {
        if (map.containsKey(name)) {
            List<String> phoneNumbers = map.get(name);
            phoneNumbers.add(phoneNum);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNum);
            map.put(name, phoneNumbers);
        }
    }

    String getAll() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(map.entrySet());
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        for (Map.Entry<String, List<String>> entry : entries) {
            List<String> phoneNumbers = entry.getValue();
            stringBuilder.append(entry.getKey());
            stringBuilder.append(" : ");
            stringBuilder.append(phoneNumbers);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
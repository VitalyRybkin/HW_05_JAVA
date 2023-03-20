import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TASK02 {
    public static void main(String[] args) {
        String[] employee_list = {"Иван Иванов","Светлана Петрова","Кристина Белова","Анна Мусина",
                "Анна Крутова","Иван Юрин","Петр Лыков","Павел Чернов","Петр Чернышов","Мария Федорова",
                "Марина Светлова","Мария Савина","Мария Рыкова","Марина Лугова","Анна Владимирова","Иван Мечников",
                "Петр Петин","Иван Ежов"};

        Map<String, Integer> employee_counter = new HashMap<>();

        for (String employee : employee_list){
            int counter;
            String[] name = employee.split(" ");
            employee_counter.putIfAbsent(name[0], 1);
            if (employee_counter.containsKey(name[0])) {
                counter = employee_counter.get(name[0]);
                counter ++;
                employee_counter.put(name[0], counter);

            }
        }

        Map<String, Integer> names_sorted_list = new LinkedHashMap<>();
        while (!employee_counter.isEmpty()) {
            int common_name_counter = 0;
            String name_found = "";
            for (Map.Entry<String, Integer> entry : employee_counter.entrySet()) {
                if (common_name_counter < entry.getValue()){
                    common_name_counter = entry.getValue();
                    name_found = entry.getKey();
                }
            }

            names_sorted_list.put(name_found, common_name_counter);
            employee_counter.remove(name_found);
        }

        for (Map.Entry<String, Integer> item : names_sorted_list.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }
}

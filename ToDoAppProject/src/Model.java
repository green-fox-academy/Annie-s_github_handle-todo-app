import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Model {
    private final String path = "/Users/annie/greenfox/Annie-s_github_handle-todo-app/ToDoAppProject/Tasks";
    private final Path filePath = Paths.get(path);
    private List<String> tasks;

    public Model() throws Exception{
        tasks = Files.readAllLines(filePath);
    }

    void storeFile() throws Exception{
        Files.write(filePath,tasks);
    }

    int getSize(){
        return tasks.size();
    }

    List<String> getAllItems(){
        return tasks;
    }

    void printTasks(){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).substring(0,1).equals("c")) {
                tasks.set(i, (i + 1) + " - " + "[" + "x" + "] " + tasks.get(i).substring(1));
            } else {
                tasks.set(i, (i + 1) + " - " + "[" + " " + "] " + tasks.get(i));
            }
        }
    }

    void checkItem (int n){
        tasks.set(n, "c" + tasks.get(n));
    }

    void UncheckItem(int n){
        tasks.set(n,"u" + tasks.get(n).substring(1,getSize()));
    }

    void addItem(String item) {
        tasks.add(item);
    }

    String getItem(int i) {
        return tasks.get(i);
    }

    void deleteItem(int i) {
        tasks.remove(i);
    }
}

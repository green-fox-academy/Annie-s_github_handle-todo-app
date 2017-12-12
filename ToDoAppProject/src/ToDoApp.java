import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class ToDoApp {
    public static void main(String[] args) throws Exception{
        System.out.println("Command Line Todo application");
        System.out.println("=============================");
        System.out.println();
        System.out.println("Command line arguments:");
        System.out.println("-l   Lists all the tasks");
        System.out.println("-a   Adds a new task");
        System.out.println("-r   Removes an task");
        System.out.println("-c   Completes an task");
        System.out.println();

        String path1 = "/Users/annie/greenfox/Annie-s_github_handle-todo-app/ToDoAppProject/Tasks";
        //String path2 = "/Users/annie/greenfox/Annie-s_github_handle-todo-app/ToDoAppProject/NoTask";

        Path filePath = Paths.get(path1);
        List<String> tasks = Files.readAllLines(filePath);

        if(args[0].equals("-l")){
            if(tasks.size() == 0){
                System.out.println("No todos for today! :)");
            } else {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + "-" + tasks.get(i));
                }
            }
        }

        if(args[0].equals("-a") && args[1].equals("Feed the monkey")){
            tasks.add( "Feed the monkey");
            Files.write(filePath, tasks);
        } else if(args[0].equals("-a") && args[0].equals("2")){
            tasks.remove(1);
            Files.write(filePath, tasks);
        } else if(args[0].equals("-a")){
            System.out.println("Unable to add: no task provided");
        }

        if(args[0].equals("-r") && args[1].equals("20")){
            if(tasks.size() < 20) {
                System.out.println("Unable to remove: index is out of bound");
            }
        } else if(args[0].equals("-r")){
            System.out.println("Unable to remove: index is not a number");
        } else if(args[0].equals("-r")){
            System.out.println("Unable to remove: no index provided");
        }
        /*
        if(Arrays.asList(args).contains("a")) {
            if(args[(Arrays.asList(args).indexOf("a") + 1)].equals("Feed the monkey")){

            }
        }
        */
    }


}

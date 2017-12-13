import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class ToDoApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Command Line Todo application");
        System.out.println("=============================");
        System.out.println();
        System.out.println("Command line arguments:");
        System.out.println("-l   Lists all the tasks");
        System.out.println("-a   Adds a new task");
        System.out.println("-r   Removes an task");
        System.out.println("-c   Completes an task");
        System.out.println();

        Model model = new Model();

        List<String> keyArgument = new ArrayList<>(Arrays.asList("-l", "-a", "-r", "-c"));
        final String additionalTask = "Feed the monkey";
        final int deleteIndex = 2;
        final String notNumber = "apple";
        final int checkIndex = 2;

        if (doesContain(args, "-l")) {
            if (model.getSize() == 0) {
                System.out.println("No todos for today! :)");
            } else {
                model.printTasks();
                for(int i = 0; i < model.getSize(); i++){
                    System.out.println(model.getAllItems().get(i));
                }
            }
        }

        if (doesContain(args, "-a")) {
            if(args.length <=1){
                System.out.println("Unable to add: no task provided");
            } else if (doesContain(args, "-a", additionalTask)) {
                model.addItem(additionalTask);
                model.storeFile();
            }
        }

        if (doesContain(args, "-r")) {
            if(args.length <=1){
                System.out.println("Unable to remove: no index provided");
            } else if (doesContain(args, "-r", Integer.toString(deleteIndex))){
                if (deleteIndex > model.getSize()) {
                    System.out.println("Unable to remove: index is out of bound");
                } else {
                    model.deleteItem( deleteIndex - 1);
                    model.storeFile();
                }
            } else if (doesContain(args, "-r", notNumber)) {
                System.out.println("Unable to remove: index is not a number");
            }
        }

        if(doesContain(args, "-c")){
            if(args.length <=1){
                System.out.println("Unable to check: no index provided");
            } else if(doesContain(args, "-c", Integer.toString(checkIndex))){
                if (deleteIndex > model.getSize()) {
                    System.out.println("Unable to remove: index is out of bound");
                } else {
                    if(model.getAllItems().get(checkIndex - 1).substring(0,1).equals("c")){
                        System.out.println("Already check!");
                    } else {
                        model.checkItem(checkIndex - 1);
                        model.storeFile();
                    }
                }
            } else if (doesContain(args, "-c", notNumber)) {
                System.out.println("Unable to check: index is not a number");
            }
        }
    }

    private static boolean doesContain(String [] args, String a){
        boolean result = false;
        if(Arrays.asList(args).contains(a)){
            result = true;
        }
        return result;
    }

    private static boolean doesContain(String [] args, String a, String b){
        boolean result = false;
        if(args[(Arrays.asList(args).indexOf(a) + 1)].equals(b)){
            result = true;
        }
        return result;
    }
}


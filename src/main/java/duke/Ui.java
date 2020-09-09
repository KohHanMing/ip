package duke;

import duke.task.Task;

import java.util.Scanner;

/**
 * Supports interactions with user.
 */
public class Ui {
    protected Scanner sc;
    protected static final String[] CMD_ARR = {"help", "add", "list", "done", "delete", "date", "bye"};
    protected static final String DIVIDER = "____________________________________________________________";
    protected static final String LOGO = " __________________________________________________________\n"
            + "|                                                          |\n"
            + "|  ____     _     _____   ____  _   _ ____   ____ _______  |\n"
            + "| |  _ \\   / \\   |  __ \\ / __ \\| \\ | |  _ \\ / __ \\__   __| |\n"
            + "| | |_) | /   \\  | |__) | |  | |  \\| | |_) | |  | | | |    |\n"
            + "| |  _ < / /_\\ \\ |  _  /| |  | | . ` |  _ <| |  | | | |    |\n"
            + "| | |_) / _____ \\| | \\ \\| |__| | |\\  | |_) | |__| | | |    |\n"
            + "| |____/_/     \\_\\_|  \\_\\\\____/|_| \\_|____/ \\____/  |_|    |\n"
            + "|                                                          |\n"
            + "|__________________________________________________________|\n";

    public Ui (Scanner sc) {
        this.sc = sc;
    }
    /**
     * Displays the startup UI and prompts user to enter input.
     * @param taskList List of tasks.
     */
    public void start(TaskList taskList) {
        this.printDivider();
        System.out.println(LOGO);
        this.printDivider();
        System.out.println("Hello, I am BaronBot!");
        System.out.println("What can I do for you?");
        this.printDivider();
    }

    public String readCommand() {
        return sc.nextLine().toLowerCase();
    }

    public void displayError(String errorMsg) {
        System.out.println(errorMsg);
    }

    /**
     * Displays the divider that separates different actions.
     */
    public void printDivider() {
        System.out.println(DIVIDER);
    }

    /**
     * Displays a prompt for the user to enter additional input.
     */
    public void printAdditionActionMessage() {
        this.printDivider();
        System.out.println("What else would you like to do?");
        this.printDivider();
    }

    /**
     * Displays the goodbye message.
     */
    public void printGoodbyeMessage() {
        this.printDivider();
        System.out.println("Bye! See you around :)");
        this.printDivider();
    }

    /**
     * Displays the list of commands the user can enter.
     */
    public void printHelp() {
        System.out.println("Here are the commands you can use:");
        for (int i = 0; i < CMD_ARR.length; i++) {
            System.out.println((i + 1) + ". " + CMD_ARR[i]);
        }
    }

    /**
     * Displays the types of tasks the user can enter.
     */
    public void printTaskTypes() {
        System.out.println("What kind of task is it?");
        System.out.print(" - duke.task.Todo\n"
                + " - duke.task.Deadline\n"
                + " - duke.task.Event\n");
    }

    /**
     * Displays the prompt for the user to enter the task.
     */
    public void printEnterTaskPrompt() {
        System.out.println("Please enter the task");
    }

    /**
     * Displays the example for the deadline format.
     */
    public void printDeadlineExample() {
        System.out.println("Please enter the task followed by the date and time of the deadline");
        System.out.println("e.g., submit report ,11/10/2019 1700");
    }

    /**
     * Displays the example for the duke.task.Event format.
     */
    public void printEventExample() {
        System.out.println("Please enter the event followed by the date and time of the event");
        System.out.println("e.g., team project meeting ,2/10/2019 1400-1600");
    }

    /**
     * Displays the acknowledgement of the user's added task.
     * @param taskList List of tasks.
     */
    public void printAddAcknowledgement(TaskList taskList) {
        System.out.println("Alright, I've added this task:");
        System.out.println(taskList.getMostRecentTask().toString());
        System.out.println("You now have " + taskList.getTaskListSize() + " tasks on your list");
    }

    /**
     * Displays the tasks currently on the list of tasks.
     * @param taskList List of tasks.
     */
    public void printList(TaskList taskList) {
        System.out.println("These are the tasks on your list:");
        for (int j = 0; j < taskList.getTaskListSize(); j++) {
            System.out.println((j + 1)
                    + ". "
                    + taskList.getTask(j).toString());
        }
    }

    /**
     * Displays the prompt for the user to specify which task is done.
     */
    public void printDonePrompt() {
        System.out.println("Which task do you want to mark as done?");
    }

    /**
     * Displays the acknowledgement of a task status being changed to done.
     * @param taskList List of tasks.
     * @param taskNum duke.task.Task specified to be changed to done.
     */
    public void printDoneAcknowledgement(TaskList taskList, int taskNum) {
        System.out.println("Good job! This task is now marked as done:");
        System.out.println(taskList.getTask(taskNum - 1).toString());
    }

    /**
     * Displays the exception message for trying to reference an out of bounds index and
     * prompts the user to enter correct input.
     *
     * @param e ArrayIndexOutOfBoundsException.
     */
    public void showIndexOutOfBoundsException(IndexOutOfBoundsException e){
        System.out.println();
        System.out.println();
    }

    /**
     * Displays the prompt for the user to delete a task.
     */
    public void printDeletePrompt() {
        System.out.println("Which task do you want to delete?");
    }

    /**
     * Displays the acknowledgement of the task that the user deleted from the list of tasks.
     * @param taskList List of tasks.
     * @param task duke.task.Task that was deleted.
     */
    public void printDeleteAcknowledgement(TaskList taskList, Task task) {
        System.out.println("Alright, the following task has been removed:");
        System.out.println(task.toString());
        System.out.println("You now have " + taskList.getTaskListSize() + " tasks on your list");
    }

    public void printFindPrompt() {
        System.out.println("What are you trying to find? Search using a keyword.");
    }

    public void printFoundTasksHeader() {
        System.out.println("These are the tasks that match the keyword:");
    }

    public void printTask(TaskList taskList, int taskNum) {
        System.out.println((taskNum + 1)
                + ". "
                + taskList.getTask(taskNum).toString());
    }
}

package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.exception.NonExistentTaskException;
import duke.task.Task;

public class DeleteTaskCommand extends Command {
    protected int taskNum;

    public DeleteTaskCommand(int taskNum) {
        super(CommandType.DELETETASK);
        this.taskNum = taskNum;
    }

    @Override
    public String execute(Ui ui, TaskList taskList) throws NonExistentTaskException {
        if (taskNum > taskList.getTaskListSize()) {
            throw new NonExistentTaskException();
        }
        Task task = taskList.getTask(taskNum - 1);
        taskList.removeTask(taskNum - 1);
        Storage.saveTaskChanges(taskList);
        return ui.printDeleteAcknowledgement(taskList, task);
    }
}

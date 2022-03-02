import java.io.Serializable;
import java.util.Objects;

public class Task implements Serializable {
    private String deadline, dueDate, name;
    private int priority;

    public Task(String deadline, String dueDate, String name, int priority) {
        this.deadline = deadline;
        this.dueDate = dueDate;
        this.name = name;
        this.priority = priority;
    }


    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return priority == task.priority && Objects.equals(deadline, task.deadline) && Objects.equals(dueDate, task.dueDate) && Objects.equals(name, task.name);
    }

    @Override
    public String toString() {
        String level = "";
        switch (priority){
            case 1:
                level = "High";
                break;
            case 2:
                level = "Medium";
                break;
            case 3:
                level = "Low";
                break;
        }

        return "Task [" +
                "name=" + name  +
                ", dueDate=" + dueDate +
                ", deadline=" + deadline +
                ", priority=" + level +
                ']';
    }
}

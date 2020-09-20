package seedu.duck.command.misc;

import seedu.duck.command.Command;

public abstract class HistoryTraverseCommand extends Command {
    public static final String MESSAGE_USAGE_IN_ENGLISH =
            "Up / Down arrow"
            + ": Traverse up / down the command history.";

    public static final String MESSAGE_USAGE_IN_CHINESE =
            "上下箭头"
            + ": 向上/向下浏览命令记录.";
}

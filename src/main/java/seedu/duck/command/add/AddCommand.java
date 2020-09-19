package seedu.duck.command.add;

import seedu.duck.command.Command;
import seedu.duck.command.CommandResult;

/**
 * A dummy class for dummy add command
 * The dummy add command is Level-1 for Duck system and was abandoned
 * after having more specific add commands
 */
public abstract class AddCommand extends Command {

    public AddCommand() {
    }

    @Override
    public abstract CommandResult executeInEnglish();

    @Override
    public abstract CommandResult executeInChinese();
}

package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ModelNew;
import seedu.address.model.opening.Opening;

/**
 * Deletes a person identified using it's displayed index from the address book.
 */
public class DeleteCommandNew extends CommandNew {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the opening identified by the index number used in the displayed person list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_OPENING_SUCCESS = "Deleted Opening: %1$s";

    private final Index targetIndex;

    public DeleteCommandNew(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResultNew execute(ModelNew model) throws CommandException {
        requireNonNull(model);
        List<Opening> lastShownList = model.getFilteredOpeningList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_OPENING_DISPLAYED_INDEX);
        }

        Opening openingToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteOpening(openingToDelete);
        return new CommandResultNew(String.format(MESSAGE_DELETE_OPENING_SUCCESS, openingToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommandNew // instanceof handles nulls
                && targetIndex.equals(((DeleteCommandNew) other).targetIndex)); // state check
    }
}

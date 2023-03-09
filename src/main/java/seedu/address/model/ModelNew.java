package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.opening.Opening;

/**
 * The API of the Model component.
 */
public interface ModelNew {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Opening> PREDICATE_SHOW_ALL_OPENINGS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefsNew userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefsNew getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getUltronFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setUltronFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setUltron(ReadOnlyUltron addressBook);

    /** Returns the Ultron */
    ReadOnlyUltron getUltron();

    /**
     * Returns true if a opening with the same identity as {@code opening} exists in the address book.
     */
    boolean hasOpening(Opening opening);

    /**
     * Deletes the given opening.
     * The opening must exist in the address book.
     */
    void deleteOpening(Opening target);

    /**
     * Adds the given opening.
     * {@code opening} must not already exist in the address book.
     */
    void addOpening(Opening opening);

    /**
     * Replaces the given opening {@code target} with {@code editedOpening}.
     * {@code target} must exist in the address book.
     * The opening identity of {@code editedOpening} must not be the same
     * as another existing opening in the address book.
     */
    void setOpening(Opening target, Opening editedOpening);

    /** Returns an unmodifiable view of the filtered opening list */
    ObservableList<Opening> getFilteredOpeningList();

    /**
     * Updates the filter of the filtered opening list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredOpeningList(Predicate<Opening> predicate);
}

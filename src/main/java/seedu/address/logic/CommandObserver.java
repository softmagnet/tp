package seedu.address.logic;

/**
 * Interface to represent the observers of command class.
 */
public interface CommandObserver {

    /**
     * Updates the view of the observer.
     *
     * @param indexOfTabToView tab index to change the view to.
     */
    public void updateView(Integer indexOfTabToView);

    /**
     * Updates the class selected of the observer.
     *
     * @param indexOfClassToSelect class index to change the selected to.
     */
    public void updateClass(Integer indexOfClassToSelect);

}

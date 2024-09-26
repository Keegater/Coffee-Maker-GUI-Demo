import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private ImageView sizeIcon, strengthIcon, brewIcon, size1Icon, size2Icon, size3Icon, size4Icon, strength1Icon, strength2Icon, strength3Icon, brewingProgressIcon = null;

    @FXML
    public void initialize() {

        /** TODO: Create init function
         * Should load each respective graphic into its imageview
         * Set all imageviews except those on the home page, to invisible.
         * Initialize the 'cursor' position on the first item
         */


        // Load testing image
        Image testImage = new Image(getClass().getResourceAsStream("/Icons/testing_Icon.png"));

        // Set the image for each ImageView
        sizeIcon.setImage(testImage);
        strengthIcon.setImage(testImage);
        brewIcon.setImage(testImage);
        size1Icon.setImage(testImage);
        size2Icon.setImage(testImage);
        size3Icon.setImage(testImage);
        size4Icon.setImage(testImage);
        strength1Icon.setImage(testImage);
        strength2Icon.setImage(testImage);
        strength3Icon.setImage(testImage);
        brewingProgressIcon.setImage(testImage);


    }

    /**TODO: changePage() is called when a valid selection imput is pressed.
        Makes all imageviews transparent except on the target page.
        Updates all internal logic to reflect being on a new page.

     Will probably also need to set the new 'default' selected item (dotted line thingy) on the new page.

     */
    public void changePage (String page){

    }


    /**
     * Handles inputs from the 'left, right, select' buttons on the GUI Demo.
     *
     * left / right should move the active selection (dotted box) to the next element
     * select, if valid, should change the page and/or send all relevant information to the coffee maker.
     * @param actionEvent
     */
    public void handleUserInput(ActionEvent actionEvent){


    }


}

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    @FXML
    private HBox homeLayout, sizeLayout, strengthLayout, brewingLayout = null;

    @FXML
    private ImageView sizeIcon, strengthIcon, brewIcon, size1Icon, size2Icon, size3Icon, size4Icon, strength1Icon, strength2Icon, strength3Icon, brewingProgressIcon = null;

    @FXML
    private StackPane homeSizeStackpane, homeStrengthStackpane, homeBrewStackpane, size1Stackpane, size2Stackpane, size3Stackpane, size4Stackpane, strength1Stackpane, strength2Stackpane, strength3Stackpane, brewingLayoutStackpane = null;

    // Arrays or lists to store the StackPanes for each page
    private List<StackPane> homeStackPanes;
    private List<StackPane> sizeStackPanes;
    private List<StackPane> strengthStackPanes;

    // Variables to keep track of the current page and the selected item
    private String currentPage = "home";
    private int selectedItem = 0;



    @FXML
    public void initialize() {

        /** TODO: Create init function
         * Should load each respective graphic into its imageview
         * Set all imageviews except those on the home page, to invisible.
         * Initialize the 'cursor' position on the first item
         */

        // Assign each ImageView its icon
        sizeIcon.setImage(new Image(getClass().getResourceAsStream("/Icons/home_size_icon.png")));
        strengthIcon.setImage(new Image(getClass().getResourceAsStream("/Icons/home_strength_icon.png")));
        brewIcon.setImage(new Image(getClass().getResourceAsStream("/Icons/home_brew_icon.png")));
        size1Icon.setImage(new Image(getClass().getResourceAsStream("/Icons/size_4oz_icon.png")));
        size2Icon.setImage(new Image(getClass().getResourceAsStream("/Icons/size_6oz_icon.png")));
        size3Icon.setImage(new Image(getClass().getResourceAsStream("/Icons/size_8oz_icon.png")));
        size4Icon.setImage(new Image(getClass().getResourceAsStream("/Icons/size_12oz_icon.png")));
        strength1Icon.setImage(new Image(getClass().getResourceAsStream("/Icons/strength_weak_icon.png")));
        strength2Icon.setImage(new Image(getClass().getResourceAsStream("/Icons/strength_normal_icon.png")));
        strength3Icon.setImage(new Image(getClass().getResourceAsStream("/Icons/strength_strong_icon.png")));
        brewingProgressIcon.setImage(new Image(getClass().getResourceAsStream("/Icons/brewing_inprogress_icon.png")));

        // Build list of StackPanes for each page
        homeStackPanes = new ArrayList<>();
        homeStackPanes.add(homeSizeStackpane);
        homeStackPanes.add(homeStrengthStackpane);
        homeStackPanes.add(homeBrewStackpane);

        sizeStackPanes = new ArrayList<>();
        sizeStackPanes.add(size1Stackpane);
        sizeStackPanes.add(size2Stackpane);
        sizeStackPanes.add(size3Stackpane);
        sizeStackPanes.add(size4Stackpane);

        strengthStackPanes = new ArrayList<>();
        strengthStackPanes.add(strength1Stackpane);
        strengthStackPanes.add(strength2Stackpane);
        strengthStackPanes.add(strength3Stackpane);


        // Setting only homepage as visible
        setPageVisible(currentPage);
        moveSelectionOutline(getCurrentPageStackPanes(), 0);

    }


    private void setPageVisible(String page){
        homeLayout.setVisible(false);
        sizeLayout.setVisible(false);
        strengthLayout.setVisible(false);
        brewingLayout.setVisible(false);

        switch (page) {
            case "size":
                sizeLayout.setVisible(true);
                break;
            case "strength":
                strengthLayout.setVisible(true);
                break;
            case "home":
                homeLayout.setVisible(true);
                break;
            case "brew":
                brewingLayout.setVisible(true);
                break;
        }
    }

    private List<StackPane> getCurrentPageStackPanes() {
        switch (currentPage) {
            case "size":
                return sizeStackPanes;
            case "strength":
                return strengthStackPanes;
            default:
                return homeStackPanes;
        }
    }










    /**TODO: changePage() is called when a valid selection input is pressed.
        Makes all imageviews transparent except on the target page.
        Updates all internal logic to reflect being on a new page.

     Will probably also need to set the new 'default' selected item (dotted line thingy) on the new page.

     */
    public void changePage (String page){
        getCurrentPageStackPanes().get(selectedItem).getStyleClass().remove("dotted-border");


        currentPage = page;
        setPageVisible(currentPage);
        selectedItem = 0;
        moveSelectionOutline(getCurrentPageStackPanes(), 0);
    }


    private void highlightIcon(ImageView icon) {
        icon.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.5, 0, 0);");
    }


    public void handleButtonLeft(ActionEvent actionEvent){
        int nextItem = selectedItem;
        List<StackPane> currentElements = getCurrentPageStackPanes();
        int currentPageElements = currentElements.size() - 1;
        System.out.println(currentElements.size());
        if (selectedItem == 0){
            nextItem = currentPageElements;
        } else {
            nextItem--;
        }
        selectedItem = nextItem;

        moveSelectionOutline(currentElements, nextItem);
    }

    public void handleButtonRight(ActionEvent actionEvent){
        int nextItem = selectedItem;
        List<StackPane> currentElements = getCurrentPageStackPanes();
        int currentPageElements = currentElements.size() - 1;
        System.out.println(currentElements.size());
        if (selectedItem >= currentPageElements){
            nextItem = 0;
        } else {
            nextItem++;
        }
        selectedItem = nextItem;

        moveSelectionOutline(currentElements, nextItem);
    }

    public void handleButtonSelect(ActionEvent actionEvent) {

        List<StackPane> currentElements = getCurrentPageStackPanes();

        if (currentPage.equals("home")) {

            switch (selectedItem) {
                case 0:
                    changePage("size");
                    break;
                case 1:
                    changePage("strength");
                    break;
                case 2:
                    changePage("brew");
                    break;
            }
        } else {
            //idk we need something
            System.out.println("Action on " + currentPage + " page at item " + selectedItem);
        }
    }


    //will remove the dotted outline from the current stackpane and place it on the new one identified by "target index"
    public void moveSelectionOutline(List<StackPane> currentStackPanes, int targetIndex){

        for( StackPane stackPane : currentStackPanes){
            stackPane.getStyleClass().remove("dotted-border");
        }

        currentStackPanes.get(targetIndex).getStyleClass().add("dotted-border");
    }


    public void handleButtonBack(ActionEvent actionE) {
        changePage("home");
    }













}

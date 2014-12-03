/*Author: Quentin Jones
CLID: qej4373
Class:  CMPS 360
Assignment: project­1
Due Date: 10/26/14 11:55pm
Description: A simple calculator for integer operations.
*/

package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** Application for performing basic integer mathematics

 */
public class Calculator extends Application {
    
    /** Loads calculator application FXML and creates scene
     * @param stage the default stage
     * @throws java.lang.Exception
    */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CalcFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /** Start the calculator application
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

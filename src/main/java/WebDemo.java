import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;

public class WebDemo extends JFXPanel {
    private WebView webView;
    private WebEngine webEngine;

    public WebDemo() {
        Platform.runLater(() -> {
            initialiseJavaFXScene();
        });
    }

    public static void main(String[] args){
        WebDemo e=new WebDemo();
        JFrame frame=new JFrame();
        frame.add(e);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

    private void initialiseJavaFXScene() {
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load("https://rietoverflow.com");

        Scene scene = new Scene(webView);
        setScene(scene);
    }
}

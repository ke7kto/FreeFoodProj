import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;

public class event extends JFXPanel {
    private WebView webView;
    private WebEngine webEngine;

    public event() {
        Platform.runLater(() -> {
            initialiseJavaFXScene();
        });
    }

    public static void main(String[] args){
        event e=new event();
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
        webEngine.load("http://www.google.com");

        Scene scene = new Scene(webView);
        setScene(scene);
    }
}

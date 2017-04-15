import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Tokeninfo;
import com.google.api.services.oauth2.model.Userinfoplus;

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
        webEngine.load("http://rietoverflow.com");

        Scene scene = new Scene(webView);
        setScene(scene);
    }
}

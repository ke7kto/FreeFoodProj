import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class event extends JFXPanel {
    private WebView webView;
    private WebEngine webEngine;

    public event() {
        Platform.runLater(() -> {
            initialiseJavaFXScene();
        });
    }

    private void initialiseJavaFXScene() {
        webView = new WebView();
        webEngine = webView.getEngine();
        webEngine.load("http://www.google.com");

        Scene scene = new Scene(webView);
        setScene(scene);
    }
}

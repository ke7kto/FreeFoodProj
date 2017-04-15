import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.oauth.OAuth10aService;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.concurrent.Worker.State;
import javafx.scene.web.WebView;
import javafx.beans.value.ChangeListener;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class WebDemo extends JFXPanel {
    private WebView webView;
    private WebEngine webEngine;
    private String authUrl;
    final OAuth10aService service=new ServiceBuilder()
            .apiKey("U7rWvd4nzvoOCDRQiyzUUC9o9")
            .apiSecret("bwuFId5UkXxt8OZC3eRh5sLxzWh1LVVsWvLiJNrS1GkRQOP3yU")
            .build(TwitterApi.instance());
    final OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/account/verify_credentials.json", service);
    OAuth1RequestToken requestToken;
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

    private void nextThingToDo(String textInput){
        try{
            final OAuth1AccessToken accessToken = service.getAccessToken(requestToken, "837125662318161920-wgN6KHBNQ60LkMHaA2Kwl53L9pkhOHy");
            service.signRequest(accessToken, request); // the access token from step 4
            final Response response = request.send();
            System.out.println(response.getBody());
        }
        catch(java.io.IOException e) {
            System.out.println(e.getMessage());
        }

    }
    private void initialiseJavaFXScene() {
        webView = new WebView();
        try {
            requestToken = service.getRequestToken();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        webEngine = webView.getEngine();
        authUrl=service.getAuthorizationUrl(requestToken);
        webEngine.load(authUrl);
        webEngine.getOnStatusChanged();
        Stage stage;
        webEngine.getLoadWorker().stateProperty().addListener(
            new ChangeListener<State>() {
              @Override public void changed(ObservableValue ov, State oldState, State newState) {
                  if (newState == Worker.State.SUCCEEDED) {
                    stage.setTitle(webEngine.getLocation());
                    System.out.println("called");
                }

                }
            });
        Scene scene = new Scene(webView);
        setScene(scene);
    }
}

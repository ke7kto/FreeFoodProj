/**
 * This class is for communicating with Facebook, using the restfb API.
 * restfb API implements Facebook's Graph API into Java syntax
 * Currently, there is only one method - equivalent to using the search bar on your facebook page for events.
 *
 * To Use:
 * (1) Create an instance of this class
 * (2) Set the accessToken with setAccessToken(String accessToken)
 * (3) Grant access to the facebook client with getGraphReaderAccess()
 * (4) Search for events using searchEvents(String query)
 * (5) Parse fields in each event using parseEventData(Connection<Event> EventsList)
 * Created by Dan Gil on 4/15/2017.
 */

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import com.restfb.*;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import com.restfb.types.*;

import java.util.*;

public class FBGraphReader {


    private String accessToken;        //This should be the accessToken that the user gets
    private FacebookClient fbClient1;       //This is the object that talks with Facebook

    //Set the accessToken
    public void setAccessToken(String inputAccessToken){
        this.accessToken = inputAccessToken;
    }

    //Get the accessToken
    public String getAccessToken(){
        return this.accessToken;
    }

    //Create a facebook client given the accessToken
    public void getGraphReaderAccess(){
        fbClient1 = new DefaultFacebookClient(this.accessToken, Version.VERSION_2_3);
    }

    //Search facebook for events
    public Connection<Event> searchEvents(String query) {
        Connection<Event> eventList =
                fbClient1.fetchConnection("search", Event.class,
                        Parameter.with("q", query), Parameter.with("type", "event"));
        return eventList;
    }

    //Parse Connection<Event> into individual items.
    //Adriaan, here is where you want to figure out how to parse the data into Rui's Event class.
    //The basic loop structure for parsing the information is here, but you will need to work with data types to make it work.
    public void parseEvents(Connection<Event> inputEventList){
        int listSize = inputEventList.getData().size();
        Event anEvent;
        for(int i = 0; i < listSize; i++){
            anEvent = inputEventList.getData().get(i);  //Each individual event is called with this statement
            out.println(anEvent);                       //You can parse the list to individual events
            out.println(anEvent.getLocation());         //Or you can extract individual fields at a time
                                                        // Let me know if you want the URL to the API
        }


    }
}

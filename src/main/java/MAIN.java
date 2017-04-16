//import com.restfb.types.TestUser;

/**
 * This is the main class
 * Call the methods to do the jobs
 */
public class MAIN {
    public static void main(String[] args){
        //data initialization

        //TwitterDemo twd = new TwitterDemo();

        //main usr interface

        //...

        //... Testing FBReader
       // TestUser usr = new TestUser();
        //System.out.println(usr.getAccessToken());
        String accessToken = "EAACEdEose0cBAOReOQl5L9QkFWeGCLBtZBQPRh9f8ZCRzHH3uA6F7fs3DjeDknPOWDCux9sOwABPX10CoNtvyjmNNK1d6T3VsQWwvbMtgeJw9wnLvNUR3nMaQDbvZBxFIB6d9GXGGcxpQZAZBibxhmzCxG2B4dojcSJx0yd7EM9fi6V16Kl0N3mfpT0ZCobOcZD";
        FBGraphReader newRder = new FBGraphReader();
        newRder.setAccessToken(accessToken);
        newRder.getGraphReaderAccess();
        newRder.parseEvents(newRder.searchEvents("banana"));
    }
}

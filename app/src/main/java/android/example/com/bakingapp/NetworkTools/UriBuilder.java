package android.example.com.bakingapp.NetworkTools;

import android.net.Uri;
import android.util.Log;

public class UriBuilder {

    private String SCHEME ="https";
    private String MAIN_URI_STRING = "d17h27t6h515a5.cloudfront.net";
    private String PATH1 = "topher";
    private String PATH2 = "2017";
    private String PATH3 = "May";
    private String PATH4 = "59121517_baking";
    private String PATH5 = "baking.json";


public String makeUri(){

    Uri.Builder builtUri = new Uri.Builder();

    builtUri.scheme(SCHEME).appendPath(MAIN_URI_STRING)
            .appendPath(PATH1).appendPath(PATH2)
            .appendPath(PATH3).appendPath(PATH4)
            .appendPath(PATH5);


    Log.i("tag", builtUri.build().toString());
    return builtUri.build().toString();



}


}

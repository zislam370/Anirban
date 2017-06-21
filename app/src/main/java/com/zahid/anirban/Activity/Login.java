package com.zahid.anirban.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Bus;
import com.zahid.anirban.Interface.ApiInterface;
import com.zahid.anirban.Model.ServerResponse;
import com.zahid.anirban.Model.User;
import com.zahid.anirban.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Login extends AppCompatActivity {



    private String username, password, orgcode;
    private EditText usernameET, passwordET , orgcodeET;
    private Button loginButton;
    public static Bus bus;

    private boolean scalingComplete = false;

    private static final String TAG = "Communicator";
    private static final String SERVER_URL = "http://221.120.102.198/api/API/MfiService/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        usernameET = (EditText)findViewById(R.id.username);
        passwordET = (EditText)findViewById(R.id.password);

        orgcodeET = (EditText)findViewById(R.id.orgcode);

        //This is used to hide the password's EditText characters. So we can avoid the different hint font.
        passwordET.setTransformationMethod(new PasswordTransformationMethod());

        //loginButton = (Button)findViewById(R.id.loginBtn);



    }



    /// Responsive screen ////


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (!scalingComplete) // only do this once
        {
            scaleContents(findViewById(R.id.contents), findViewById(R.id.container));
            scalingComplete = true;
        }
        super.onWindowFocusChanged(hasFocus);
    }

    /** Called when the views have been created. We override this in order to scale
     *  the UI, which we can't do before this.
     */
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = super.onCreateView(name, context, attrs);
        return view;
    }

    /** Scales the contents of the given view so that it completely fills the given
     * container on one axis (that is, we're scaling isotropically).
     * @param rootView	The view that contains the interface elements
     * @param container	The view into which the interface will be scaled
     */
    private void scaleContents(View rootView, View container)
    {
        // Compute the scaling ratio. Note that there are all kinds of games you could
        // play here - you could, for example, allow the aspect ratio to be distorted
        // by a certain percentage, or you could scale to fill the *larger* dimension
        // of the container view (useful if, for example, the container view can scroll).
        float xScale = (float)container.getWidth() / rootView.getWidth();
        float yScale = (float)container.getHeight() / rootView.getHeight();
        float scale = Math.min(xScale, yScale);

        // Scale our contents
        scaleViewAndChildren(rootView, scale);
    }

    /** Scale the given view, its contents, and all of its children by the given factor.
     * @param root	The root view of the UI subtree to be scaled
     * @param scale	The scaling factor
     */
    public static void scaleViewAndChildren(View root, float scale)
    {
        // Retrieve the view's layout information
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();

        // Scale the view itself
        if (layoutParams.width != ViewGroup.LayoutParams.FILL_PARENT &&
                layoutParams.width != ViewGroup.LayoutParams.WRAP_CONTENT)
        {
            layoutParams.width *= scale;
        }
        if (layoutParams.height != ViewGroup.LayoutParams.FILL_PARENT &&
                layoutParams.height != ViewGroup.LayoutParams.WRAP_CONTENT)
        {
            layoutParams.height *= scale;
        }

        // If this view has margins, scale those too
        if (layoutParams instanceof ViewGroup.MarginLayoutParams)
        {
            ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams)layoutParams;
            marginParams.leftMargin *= scale;
            marginParams.rightMargin *= scale;
            marginParams.topMargin *= scale;
            marginParams.bottomMargin *= scale;
        }

        // Set the layout information back into the view
        root.setLayoutParams(layoutParams);

        // Scale the view's padding
        root.setPadding(
                (int)(root.getPaddingLeft() * scale),
                (int)(root.getPaddingTop() * scale),
                (int)(root.getPaddingRight() * scale),
                (int)(root.getPaddingBottom() * scale));

        // If the root view is a TextView, scale the size of its text. Note that this is not quite precise -
        // it appears that text can't be exactly scaled to any desired size, presumably due to limitations
        // of the font system. You may have to make your fonts a little bit smaller than you otherwise might
        // in order to make sure that the text will always fit at any scaling factor.
        if (root instanceof TextView)
        {
            TextView textView = (TextView)root;
            Log.e("Calculator", "Scaling text size from " + textView.getTextSize() + " to " + textView.getTextSize() * scale);
            textView.setTextSize(textView.getTextSize() * scale);
        }

        // If the root view is a ViewGroup, scale all of its children recursively
        if (root instanceof ViewGroup)
        {
            ViewGroup groupView = (ViewGroup)root;
            for (int cnt = 0; cnt < groupView.getChildCount(); ++cnt)
                scaleViewAndChildren(groupView.getChildAt(cnt), scale);
        }
    }


/// Responsive screen end ////



    public void login(View v) {

        username = usernameET.getText().toString();
        password = passwordET.getText().toString();
        orgcode = orgcodeET.getText().toString();

        User user = new User();



        user.setUserName(username);
        user.setPassword(password);
        user.setOrgCode(orgcode);
        useGet();



//        Intent intent = new Intent(getApplicationContext(), Landing.class);
//        startActivity(intent);
    }


    private void useGet(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //The Retrofit builder will have the client attached, in order to get connection logs
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        ApiInterface service = retrofit.create(ApiInterface.class);



        Call<ServerResponse> call = service.get(username,password,orgcode);


        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                //BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");
                ServerResponse validity = response.body();
                //Toast.makeText(getApplicationContext(), validity.getOrgcode(), Toast.LENGTH_LONG).show();

                if (validity.getOrgcode()!=null) {
                    //starting profile activity
                    //finish();
                    Toast.makeText(getApplicationContext(), validity.getOrgcode(), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Collection.class));
                }

                else {
                    Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_LONG).show();
                }

           }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                //BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });

    }



}

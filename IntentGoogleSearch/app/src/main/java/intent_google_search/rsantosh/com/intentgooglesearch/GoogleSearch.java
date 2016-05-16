package intent_google_search.rsantosh.com.intentgooglesearch;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GoogleSearch extends AppCompatActivity implements View.OnClickListener {

    //Declaration of the variables.
    private EditText mEditText;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_search);

        //Initialisation of variables.
        mEditText = (EditText) findViewById(R.id.google_search);

        mButton = (Button) findViewById(R.id.search_button);
        mButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        //Switch case for the click of button.
        switch (view.getId()){

            //This case is written for search button.
            case R.id.search_button:
                //Getting the variable from the edit tex to the variable.
                String strSearchWord = mEditText.getText().toString().trim();

                //Checking if the variable is empty.
                if (strSearchWord.isEmpty()){

                    //If empty displaying the message.
                    Toast.makeText(getApplicationContext(),"Please enter some text to search in google.",Toast.LENGTH_LONG).show();
                    break;

                }else {

                    //If not empty then the string variable is passed on to google.
                    Intent googleIntent = new Intent(Intent.ACTION_WEB_SEARCH, Uri.parse("http://www.google.co.in"));
                    googleIntent.putExtra(SearchManager.QUERY, strSearchWord);
                    startActivity(googleIntent);
                    finish();

                    break;
                }
        }

    }
}

package dk.easj.anbo.collectwordsx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "MYWORDS";
    private static final String LIST = "LIST";
    private ArrayList<CharSequence> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequenceArrayList(LIST, words);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        words = savedInstanceState.getCharSequenceArrayList(LIST);
    }


    public void clickedSave(View view) {
        EditText input = findViewById(R.id.mainWordEdittext);
        String word = input.getText().toString();
        words.add(word);
        input.setText("");
        Log.d(LOG_TAG, words.toString());
    }

    public void clickedClear(View view) {
        words.clear();
    }

    public void clickedShow(View view) {
        // Toast.makeText(this, words.toString(), Toast.LENGTH_LONG).show();
        TextView output = findViewById(R.id.mainMessageTextview);
        if (words.isEmpty()) {
            output.setText("empty");
        } else {
            output.setText(words.toString());
        }
    }
}

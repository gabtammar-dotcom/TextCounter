package com.example.textcounter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private Spinner spinnerCountType;
    private TextView textViewResult;
    private TextCounter textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (view, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());
                    view.setPadding(systemBars.left, systemBars.top,
                            systemBars.right, systemBars.bottom);
                    return insets;
                });

        editTextInput = findViewById(R.id.editTextInput);
        spinnerCountType = findViewById(R.id.spinnerCountType);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        textCounter = new TextCounter();

        buttonCalculate.setOnClickListener(view -> calculateResult());
    }

    private void calculateResult() {
        String inputText = editTextInput.getText().toString();

        if (inputText.trim().isEmpty()) {
            Toast.makeText(this, R.string.empty_text_message,
                    Toast.LENGTH_SHORT).show();
            textViewResult.setText(R.string.result_placeholder);
            return;
        }

        if (spinnerCountType.getSelectedItemPosition() == 0) {
            int wordCount = textCounter.countWords(inputText);
            textViewResult.setText(
                    getString(R.string.word_count_result, wordCount));
        } else {
            int characterCount = textCounter.countCharacters(inputText);
            textViewResult.setText(
                    getString(R.string.character_count_result, characterCount));
        }
    }
}
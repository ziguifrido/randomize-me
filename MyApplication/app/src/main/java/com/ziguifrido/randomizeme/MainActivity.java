package com.ziguifrido.randomizeme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private EditText editFrom;
    private EditText editTo;
    private Button btnRandomize;
    private Random random = new Random();
    private int from;
    private int to;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = (TextView) findViewById(R.id.txtResultId);
        editFrom = (EditText) findViewById(R.id.editFromId);
        editTo = (EditText) findViewById(R.id.editToId);
        btnRandomize = (Button) findViewById(R.id.btnRandomizeId);

        btnRandomize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isEmpty(editFrom) || isEmpty(editTo)) {
                    Toast.makeText(getApplicationContext(), R.string.errorEmptyEdit, Toast.LENGTH_LONG).show();
                    txtResult.setText("");
                } else{
                    from = Integer.parseInt(editFrom.getText().toString());
                    to = Integer.parseInt(editTo.getText().toString());
                    if ((from > to) || (from == to)){
                        Toast.makeText(getApplicationContext(), R.string.errorFromTo, Toast.LENGTH_LONG).show();
                        txtResult.setText("");
                    } else{
                        result = random.nextInt(to - from + 1) + from;
                        txtResult.setText(Integer.toString(result));
                    }
                }
            }
        });
    }

    public boolean isEmpty(EditText editText){
        return editText.getText().toString().trim().length() == 0;
    }

}


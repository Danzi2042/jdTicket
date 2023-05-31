package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // определение полей
    private EditText nameIn; // поле имени
    private EditText placeAndTimeIn; // поле адреса
    private EditText ticketCostIn; // поле электронного адреса
    private Button button; // поле кнопки

    private String name; // поле хранения имени

    private String placeAndTime; // поле хранения адреса

    private String ticketCost; // поле хранения электронного адреса

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка id к полям
        nameIn = findViewById(R.id.nameIn);
        placeAndTimeIn = findViewById(R.id.addressIn);
        ticketCostIn = findViewById(R.id.emailIn);
        button = findViewById(R.id.button);

        // обработка нажатия кнопки
        button.setOnClickListener(listener);
    }

    // создание слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // переключение на другой экран и передача данных

            // ситывание данных с экрана
            name = nameIn.getText().toString();
            placeAndTime = placeAndTimeIn.getText().toString();
            ticketCost = ticketCostIn.getText().toString();

            // создание намерения
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

            // запаковка данных в контейнер намерения
            intent.putExtra("name", name);
            intent.putExtra("placeAndTime", placeAndTime);
            intent.putExtra("email", ticketCost);

            // старт переключения активити и передачи данных
            startActivity(intent);
        }
    };
}
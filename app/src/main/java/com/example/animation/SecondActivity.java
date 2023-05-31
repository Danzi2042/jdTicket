package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    // определение полей
    private TextView dataMainActivity; // поле вывода информации из главной активити
    private Button button; // кнопка переключения на главную активити

    private String name; // поле хранения имени
    private String placeAndTime; // поле хранения адреса
    private String ticketCost; // поле хранения электронного адреса

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // привязка id к полю
        dataMainActivity = findViewById(R.id.dataMainActivity);
        button = findViewById(R.id.button);

        // считывание данных из главной активити
        Bundle bundleIntent = getIntent().getExtras();

        // инициализация данных
        name = bundleIntent.get("name").toString(); // считывание и инициализация имени
        placeAndTime = bundleIntent.get("placeAndTime").toString(); // считывание и инициализация времени и места
        ticketCost = bundleIntent.getString("ticketCost"); // считывание и инициализация стоимости билета

        // вывод на экран данных из главной активити
        dataMainActivity.setText("Имя " + name + "\n"
                + "время и место "+ placeAndTime + "\n"
                + "Стоимость билета "+ ticketCost + "\n" );

        // обработка нажатия кнопки
        button.setOnClickListener(listener);
    }

    // создание слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // переключение на другой экран
            Intent intent = new Intent(getApplicationContext(), MainActivity.class); // создание намерения переключения на другой экран
            startActivity(intent); // запуск дополнительной активити через намерение
        }
    };
}
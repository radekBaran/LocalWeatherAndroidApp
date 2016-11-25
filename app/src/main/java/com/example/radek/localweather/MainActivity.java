package com.example.radek.localweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.radek.localweather.weatherApi.RespBody;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import it.sephiroth.android.library.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.image_icon)
    protected ImageView imageIcon;
    @BindView(R.id.search_text_field)
    protected EditText searchTextField;
    @BindView(R.id.temperature_c)
    protected TextView tempInCelsius;
    @BindView(R.id.location_label)
    protected TextView locationLabel;
    @BindView(R.id.country_label)
    protected TextView countryLabel;
    @BindView(R.id.date_label)
    protected TextView dateLabel;
    @BindView(R.id.conditions_weather)
    protected TextView weatherConditions;
    @BindView(R.id.pressure_mb)
    protected TextView pressure;
    @BindView(R.id.btn_search)
    protected Button searchButton;

    private RespBody mData;
    private String location = "Warsaw";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public RespBody getData() {
        return mData;
    }

    public void setData(RespBody data) {
        mData = data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWeatherService(location);
    }

    public void getWeatherService(String location) {
        WeatherApi weatherApi = WeatherFactory.getApi();
        weatherApi.getWeather(location, "8eeb185d22cf455c9e3145753161711").enqueue(new Callback<RespBody>() {
            @Override
            public void onResponse(Call<RespBody> call, Response<RespBody> response) {
                RespBody body = response.body();
                setData(body);
                setValues();
            }

            @Override
            public void onFailure(Call<RespBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getUserLocation() {
        String city = searchTextField.getText().toString();

        return city;
    }

    public void setValues() {
        try {
            String url = "https:" + mData.getCurrent().getCondition().getIcon();
            Picasso.with(this).load(url).into(imageIcon);
            tempInCelsius.setText(String.valueOf(mData.getCurrent().getTempInCelsius()) + " \u00b0C");
            locationLabel.setText(String.valueOf(mData.getLocation().getName()));
            countryLabel.setText(String.valueOf(mData.getLocation().getCountry()));
            dateLabel.setText(String.valueOf(mData.getCurrent().getLastUpdated()));
            pressure.setText(String.valueOf(mData.getCurrent().getPressureMb()) + " hPa");
            weatherConditions.setText(String.valueOf(mData.getCurrent().getCondition().getText()));
        } catch (Exception e) {
            Toast.makeText(this, "Give location", Toast.LENGTH_SHORT).show();
        }
    }


    @OnClick(R.id.btn_search)
    public void onSearchClick() {
        setLocation(getUserLocation());
        getWeatherService(getLocation());

    }
}

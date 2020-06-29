package jugistanbul.pattern.observer.client;

import jugistanbul.pattern.observer.station.WeatherForecast;
import jugistanbul.pattern.observer.Observer;

public class DataScienceCompany implements Observer {

    @Override
    public void observe(WeatherForecast forecast) {
        System.out.println("Data Science Company : Update Prediction : "+ forecast.toString());
    }
}

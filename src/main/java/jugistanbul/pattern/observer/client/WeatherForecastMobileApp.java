package jugistanbul.pattern.observer.client;

import jugistanbul.pattern.observer.Observer;
import jugistanbul.pattern.observer.station.WeatherForecast;

public class WeatherForecastMobileApp implements Observer {
    
    @Override
    public void observe(WeatherForecast forecast) {
        System.out.println("Mobile App : Update Dashboard : "+ forecast.toString());
    }
}

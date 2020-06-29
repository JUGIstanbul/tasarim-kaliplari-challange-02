package jugistanbul.pattern.observer;

import jugistanbul.pattern.observer.station.WeatherForecast;

public interface Observer {

    void observe(WeatherForecast condition);
}

package jugistanbul.pattern.observer.station;


import jugistanbul.pattern.observer.Observable;
import jugistanbul.pattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static jugistanbul.pattern.observer.station.WeatherForecast.randomly;

public class WeatherForecastStation implements Observable {

    private List<Observer> observers = new ArrayList<>();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public WeatherForecastStation() {
        executor.scheduleAtFixedRate(()->{
            WeatherForecast condition = randomly();
            this.publish(condition);
        }, 0, 5, TimeUnit.SECONDS);
    }

    private void publish(WeatherForecast condition) {
        observers.forEach(o->o.observe(condition));
    }

    @Override
    public void register(Observer observer) {
        this.observers.add(observer);
    }
}

package jugistanbul.pattern.observer;

import jugistanbul.pattern.observer.client.DataScienceCompany;
import jugistanbul.pattern.observer.client.WeatherForecastMobileApp;
import jugistanbul.pattern.observer.station.WeatherForecastStation;
import jugistanbul.utils.ThreadUtil;

public class WeatherForecastApp {

    public static void main(String[] args) {

        var station = new WeatherForecastStation();
        var mobileApp = new WeatherForecastMobileApp();
        var company = new DataScienceCompany();

        station.register(mobileApp);
        station.register(company);

        ThreadUtil.sleep(15000);
    }
}

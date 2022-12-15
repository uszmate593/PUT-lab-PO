public class Weather
{
    public Forecast forecast;

    public Weather(Forecast forecast)
    {
        this.forecast = forecast;
    }

    public String todayTemprature()
    {
        return Float.toString(forecast.temprature());
    }
}

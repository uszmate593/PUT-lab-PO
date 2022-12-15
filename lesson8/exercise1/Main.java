public class Main
{
    public static void main(String[] args)
    {
        Forecast forecast = new Forecast.Fake();
        Weather today = new Weather(forecast);
        assert "12.5".equals(today.todayTemprature());
        assert "18.4".equals(today.todayTemprature());
    }
}



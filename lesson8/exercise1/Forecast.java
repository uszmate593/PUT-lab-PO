public interface Forecast
{
    public float temprature();
    public final class Fake implements Forecast
    {
        @Override
        public float temprature()
        {
            return 12.5f;
        }
    }
}

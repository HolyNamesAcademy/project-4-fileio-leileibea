/*
Holds weather data related to a city
 */
public class WeatherData implements Comparable<WeatherData> {
    private String city;
    private double averageTemp;
    private double averageHumidity;

    // constructor
    public WeatherData(String c, double t, double h) {
        city = c;
        averageTemp = t;
        averageHumidity = h;
    }

    // getters
    public String getCity() {
        return city;
    }
    public double getAverageTemp() {
        return averageTemp;
    }
    public double getAverageHumidity() {
        return averageHumidity;
    }

    /*
    Returns a string representation of WeatherData:

    [City], [Average Temperature], [Average Humidity]
     */
    public String toString()
    {
        String stringOut = "";
        stringOut +=this.getCity()+", "+this.getAverageTemp()+", "+this.getAverageHumidity();
        return stringOut;
    }

    /*
    Read the compareTo documentation and implement it here:
    https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html#compareTo-T-
     */
    public int compareTo(WeatherData other)
    {
        if(other==null){
            throw new NullPointerException();
        }
        else if(!other.getClass().equals(WeatherData.class)){
            throw new ClassCastException();
        }
        double thisAvgTemp = this.getAverageTemp();
        double otherAvgTemp = other.getAverageTemp();
        int diff = (int) (thisAvgTemp-otherAvgTemp);
        if(diff==0&&thisAvgTemp!=otherAvgTemp){
            if(thisAvgTemp-otherAvgTemp>0){
                diff=1;
            }
            else{
                diff=-1;
            }
        }
        return diff;
    }
}

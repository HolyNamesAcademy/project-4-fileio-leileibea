import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
    Takes commands from the user and executes them. Possible commands are
    'read' - reads a file of weather data into the system
    'write' - writes weather data to a file -- overwrites the file if it exists
    'sort' - sorts weather data by the hottest to coldest average temperature
    'append' - writes weather data to a file -- appends data to the file if it exists
    'quit' - ends the program
     */
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<WeatherData> weatherData = null;
        while (true)
        {
            System.out.print("Enter a command: ");
            Scanner sc = new Scanner(System.in);

            String command = sc.next().toLowerCase();
            switch (command)
            {
                case "read":
                {
                    System.out.print("Enter the path to the file: ");
                    String path = sc.next();

                    weatherData = ReadFile(path);
                    PrintWeatherData(weatherData);
                    break;
                }
                case "sort":
                {
                    if (weatherData == null)
                    {
                        System.out.println("Please call 'read' first, before calling 'append'.");
                        break;
                    }

                    SortWeatherData(weatherData);
                    break;
                }
                case "write":
                {
                    if (weatherData == null)
                    {
                        System.out.println("Please call 'read' first, before calling 'write'.");
                        break;
                    }

                    System.out.print("Enter the path to the file: ");
                    String path = sc.next();

                    WriteFile(path, false, weatherData);
                    break;
                }
                case "append":
                {
                    if (weatherData == null)
                    {
                        System.out.println("Please call 'read' first, before calling 'append'.");
                        break;
                    }

                    System.out.print("Enter the path to the file: ");
                    String path = sc.next();

                    WriteFile(path, true, weatherData);
                    break;
                }
                case "quit":
                {
                    return;
                }
                default:
                {
                    System.out.println("Unrecognized command. Possible commands are 'read', 'write', 'append', 'sort', and 'quit'");
                    break;
                }
            }
        }
    }

    /*
    Reads a file from the given path and puts the information into an ArrayList.
    If the file does not exist, the function catches the exception, prints a message
    to the console, and return an empty (not null) array.
     */
    public static ArrayList<WeatherData> ReadFile(String path) {
        ArrayList<WeatherData> wData = new ArrayList<WeatherData>();
        Scanner reader;
        try {
            java.io.File toRead = new java.io.File(path);
            reader = new Scanner(toRead);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist to be read");
            return wData;
        }
        while (reader.hasNextLine()&&reader.nextLine().contains("  ")) {
            String wDataString = reader.nextLine();
            String c = wDataString.substring(wDataString.lastIndexOf(" ")+1,wDataString.indexOf(","));
            wDataString = wDataString.substring(wDataString.indexOf(",")+1);
            double t = Double.parseDouble(wDataString.substring(0,wDataString.indexOf(",")));
            wDataString = wDataString.substring(wDataString.indexOf(",")+1);
            double h= Double.parseDouble(wDataString);
            WeatherData newWInfo = new WeatherData(c,t,h);
            wData.add(newWInfo);
        }
        return wData;
    }

    /*
    Prints the weather data ArrayList to the console. Each weather data item should
    go on a new line:

    [City1], [Average Temperature], [Average Humidity]
    [City2], [Average Temperature], [Average Humidity]
    ...
     */
    public static void PrintWeatherData(ArrayList<WeatherData> weatherData)
    {
        for (WeatherData w:weatherData) {
            System.out.println(w.toString());
        }
    }

    /*
    Sorts the given ArrayList from hottest average temperature to coldest average temperature
     */
    public static void SortWeatherData(ArrayList<WeatherData> weatherData)//let's do a merge sort for funsies
    {
        //mergeSortArrayList(weatherData);//didn't work obvi
        //try other sort
        int holdPos=0;
        double highTemp=0;
        for(int i = 0; i<weatherData.size(); i++){
            for(int j = i; j<weatherData.size(); j++){
                if(weatherData.get(j).getAverageTemp()>highTemp){
                    holdPos=j;
                    highTemp=weatherData.get(j).getAverageTemp();
                }
            }
            weatherData.add(i,weatherData.get(holdPos));
            weatherData.remove(holdPos+1);
            holdPos=0;
            highTemp=0;
        }
    }
    /*public static void mergeSortArrayList(ArrayList<WeatherData> w){
        int midPoint = w.size()/2;
        ArrayList<WeatherData> leftChunk = new ArrayList<WeatherData>();//create left chunk
        for(int i = 0; i<midPoint; i++){
            leftChunk.add(w.get(i));
        }
        ArrayList<WeatherData> rightChunk = new ArrayList<WeatherData>();//create right chunk
        for(int i = midPoint; i<w.size(); i++){
            rightChunk.add(w.get(i));
        }
        if(leftChunk.size()!=1){//if left chunk can be checked
            for(int i = 0; i<leftChunk.size()-1; i++){//check left chunk
                if(leftChunk.get(i).getAverageTemp()<leftChunk.get(i+1).getAverageTemp()){//if left chunk unsorted, split
                    mergeSortArrayList(leftChunk);
                }
            }
        }
        if(rightChunk.size()!=1) {//if right chunk can be checked
            for (int i = 0; i < rightChunk.size() - 1; i++) {//check right chunk
                if (rightChunk.get(i).getAverageTemp()<rightChunk.get(i + 1).getAverageTemp()) {//if right chunk unsorted, split
                    mergeSortArrayList(rightChunk);
                }
            }
        }
        //atp they should both either be 1 or be sorted
        int posTrack = 0;
        boolean wethAdded = false;
        for (WeatherData weth: rightChunk) {//merge!!
            for(int i=posTrack; i<leftChunk.size(); i++){
                if(leftChunk.get(i).getAverageTemp()<weth.getAverageTemp()){
                    leftChunk.add(i,weth);
                    wethAdded = true;
                }
                break;
            }
            if(!wethAdded){
                leftChunk.add(weth);
            }

        }
        w = leftChunk;//set original arraylist to be new sorted list
    }*/

    /*
    Writes the weather data information into the file with the given path.
    If shouldAppend is false, the function replaces the existing contents of the file
    (if it exists) with the new weatherData. If shouldAppend is true, the function
    adds the weather data to the end of the file.
    If the file cannot be created, the function catches the exception, prints a message
    to the console, and does not try to write to the file.
     */
    public static void WriteFile(String path, boolean shouldAppend, ArrayList<WeatherData> weatherData) throws FileNotFoundException {
        try{
            java.io.File putDataHere = new java.io.File(path);
            PrintWriter p = new PrintWriter (new FileOutputStream(putDataHere), shouldAppend);
            if(putDataHere.exists()) {
                for (WeatherData w : weatherData) {
                    p.write(w.toString() + "\n");
                }
            }
            p.close();
        }
        catch(FileNotFoundException fnf){
            System.out.println("File cannot be found");
        }
    }
}

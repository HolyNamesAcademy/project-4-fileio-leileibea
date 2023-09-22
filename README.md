File IO
=========

Good work pledge
-----
We are here to broaden your exposure to Computer Science. We can only achieve that purpose when you work hard and honestly. It may be tempting to copy-paste code from a classmate, or let a classmate do all your work for you—don't! You will be cheating yourself from the most valuable thing course has to offer—overcoming challenges.

We know that hard, and honest work doesn't come easily. If you feel like you are falling behind:

1. Don't copy-paste code, or let someone do your work for you
2. Ask for help!
3. Tell the teaching-team you need more time

Getting started
-----
1. Go to the provided assignment link, and click accept. It should take you to your project page.
  (If it doesn't, click on the link above again, and click on the link to the project page).
2. On the GitHub project page, click on the green "Clone or Download" button and copy the link.
3. Open Intellij, click on the "Checkout from Version Control" drop down and select "GitHub"
4. On the next page paste the link you copied into the "Git Repository URL" box.
5. Click Clone. You may have to enter your GitHub username and password.
6. If it asks you whether you want to open the project or not, select yes.
7. You should see your project open. If you need to reopen the project, you should see it under "File > Open Recent"

The Project
-----
In this project, you will be implementing functionality to read data from a file and write data to a file. Along with reading and writing to a file, you will get a flavor for dealing with exceptions and sorting.

The program allows you to run several commands that allows you to read data, manipulate data, and write data. The only manipulation we will be doing is sorting. Here are the commands that the program allows you to run:
- **Read**: takes in a file path and reads the weather data from the file.
- **Sort**: must be called after at least one 'read'. This command sorts the weather data that was read into the program in order of highest average temperature (the city with the highest average temperature will come first).
- **Write**: must be called after at least one 'read'. This commmand takes in a path and writes the data we have read into the file at that path. If the file already contains data, it is overwritten.
- **Append**: must be called after at least one 'read'. This commmand takes in a path and writes the data we have read into the file at that path. If the file already contains data, the new data will be appended to the existing contents.
- **Quit**: ends the program.

These are the functions you will implement:
- In Main.java:
    - **ReadFile**: Reads a file from the given path and puts the information into an ArrayList. If the file does not exist, the function catches the exception, prints a message to the console, and return an empty (not null) array.
    - **PrintWeatherData**: Prints the weather data ArrayList to the console. Each weather data item should go on a new line:

        [City1], [Average Temperature], [Average Humidity]
        [City2], [Average Temperature], [Average Humidity]

    - **SortWeatherData**: Sorts the given ArrayList from hottest average temperature to coldest average temperature
    - **WriteFile**: Writes the weather data information into the file with the given path. If shouldAppend is false, the function replaces the existing contents of the file (if it exists) with the new weatherData. If shouldAppend is true, the function adds the weather data to the end of the file. If the file cannot be created, the function catches the exception, prints a message to the console, and does not try to write to the file.
- In WeatherData.java:
    - **toString**: Returns a string representation of WeatherData:

        [City], [Average Temperature], [Average Humidity]
    - **compareTo**: Read the compareTo documentation and implement it here: https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html#compareTo-T-

Committing your Changes and Turning In The Project
-----
The same instructions with screenshots are in the OneNote at the bottom of the page [here](https://holynamesseattle.sharepoint.com/sites/Section_6558/_layouts/OneNote.aspx?id=%2Fsites%2FSection_6558%2FSiteAssets%2FProjects%20in%20Comp%20Sci%20-%20Mon-Wed%2019-20%20Notebook&wd=target%28Class%20Overview.one%7C74AD5220-0070-4A9A-BD5E-85B1624E453C%2FGetting%20Started%20With%20A%20Project%7C127DA7EC-BEEC-4463-BE97-A79C378AD455%2F%29).

At the end of every class period, you should commit your changes. "Committing your changes" is basically a fancy way of saving the changes you made. It is very important and useful for two reasons:

1. You save your changes online, so you can never lose them. Even if your computer breaks, your changes will still be saved somewhere.
2. You can go back to any previous version that you committed. So if you accidentally make a wrong change that breaks your program, you can always go back to a state where the program was working.

You can commit and push ("push" means send it to GitHub.com to save it there) by doing the steps below:

1. Once you are ready to save your changes, click on VCS > Commit Changes… in the taskbar.
2. It will show you a list of files that you have made changes to. (It might also show changes to a file called workspace.xml, which you didn’t touch. That's ok, IntelliJ modifies that file behind the scenes). You can double click on any file and see the changes you've made to the file.
3. Hover over the commit button and select "Commit and Push". It will prompt you, asking if you are sure. Select "Commit", and then on the next page, select "Push".
4. Go to your project page on GitHub, and make sure that your changes are there.
5. That's it. The last change you submit before the deadline will be considered your turned in assignment. You can turn in additional submissions after the deadline, but remember that there is a 10% penalty added each week after the deadline you turn in the assignment.

# Grading

Your grade for each project will fall into one of four categories:

| Grade Level         | Explanation |
| :------------------ |:----------- |
| *Exceeds Expectations*        | <ul><li>Quality is outstanding.</li></ul> |
| *Excellent*                   | <ul><li>Overall quality is high.</li></ul> |
| *Satisfactory*                | <ul><li>Overall quality is good.</li><li>Improvements can be made to bring the quality up to <i>Excellent</i>.</li></ul> |
| *Needs Improvement*           | <ul><li>Overall quality is not yet high enough and the submission will not be accepted.</li><li>Improvements must be made to bring the quality up to at least <i>Satisfactory</i>.</li></ul> |

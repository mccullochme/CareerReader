# fall-19-project-appmonsters
fall-19-project-appmonsters created by GitHub Classroom
Project: CareerReader

>>>Iteration 1..
-We worked on the find a college function of our app, so those are the user stories we decided to implement
-One challenge was figuring out how to print out the specific colleges depending on the user specifications
-The next user stories that we plan to implement are the find a major and find a job function in the future iterations

>>>Iteration 2..
-created a major select screen that creates a textView (this textView holds the compatibility statement) and a radio group with 5 radio buttons dynamically. It does this for every line in the questions.txt file
-while the radio buttons are being checked it is adding to the corresponding field of study total score
-the method getCompatible field compares the totalScores and passes to the next screen with a putExtra of the field of study with the highest total Score
-the final results screen searches through a txt file to display the top 10 majors in that field of study as a clickable button
-the most difficult part was finding a way to get the ID of the radio buttons since we created them dynamically.
-we accomplished this by setting the button to a tag and getting the button by use of the tag
-our future iteration will encapsulate the find a job feature
-the design pattern we chose to implement was the facade design pattern, we used the design pattern to encapsulate the object classes we are using into one so we can access the methods in one place.

>>>Iteration 3..
-Added the functionality of find a job feature, this uses a webscraper for simply hired .com 
-We wanted to use indeed's website but because the url does not change for the different jobs when selected we had to go with simply hired
-When you search for a job it passes the scraper whatever search filters you have and appends it to the url
-When the results screen is created buttons for each result on the first page of simply hired is created
-each button has a different url attached to it that will bring you to the job that cooresponds to that button
-The websraper was done by using Jsooups library and looking at the html code of the different webpages and using Jsoups commands to grab whatever elements I need for the website, and looking at how the url changes when entering different webpages

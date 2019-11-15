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

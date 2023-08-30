Web site of youtube videos for comedy standup shows
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Consider the design of a database for a web site of youtube videos for comedy standup shows, in which each youtube is exactly for one comedian.  
Each youtube video is identified by a unique URL (such as https://youtu.be/buSv1jjAels), a title and a description of the youtube, the date on which the youtube is posted, and a list of tags (each tag is a single word in lower cases).    
A registered user can search for youtube videos by the name of a comedian or by the tags of videos, using a text field like the one used by google.com, and then click any youtube link in the result list to play that youtube video.   
Each comedian has a first name, a last name, a birthday, and a birthplace. Moreover, registered users can post and comment on these youtubes. Each registered user is identified by a unique username, which must be an email, a password, a first name, a last name, the gender, and his/her age. A registered user can give at most one review for each youtube video, but on a particular day, the user can post at most five youtube videos. The review given by a user has a score of {“Poor”, “Fair”, “Good”, “Excellent”} and then a short remark. A user can also modify an existing review as well as deleting an existing review. Each user has a favorite list of comedians. Each user can insert and delete a comedian from that favorite list.     
A new comedian can be added to a list when the user is watching a comedian’s video that interests him/her by clicking the “Add to favorite comedians” button.   
The system has a distinguished user called “root” whose username is root (this is the only username that is not an email).

**For all parts of this project, your system must be web-based. Some simple GUI interfaces are required for each functionality. All functionality must be performed via the interface of your system, direct SQL statement execution via any tools (MySQL workbench) can only be used for debugging purposes.**


***Use Java and SQL, implement the following functionality:***    
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
1. Implement a user registration and login interface so that only a registered user can login into the system. The root user has a username “root” and password “pass1234” (Note this is a
different root – it is for the website, not a user for the MySQL database system). Sign up for a new user with information such as: username (which is an email), password, password
confirmed, first name, last name, age. Duplicate username should be detected and fail the signup. Unmatching passwords should be detected as well.  
2. For the root user, implement a button called “Initialize Database”. This button will only be displayed after the root user signed in successfully. Each time the root user clicks the “Initialize Database” button, the following three things will happen:
   1) all existing tables, if any, will be dropped;
   2) all necessary tables will be created or recreated automatically; and
   3) each table will be inserted with at least 10 realistic tuples (which can be hard-coded in your program), so that each query below will return some meaningful results.
3. Implement a web interface for so that a registered user can insert a youtube video such as
               URL: https://youtu.be/buSv1jjAels  
               Title: C-SPAN: Joe Wong at RTCA Dinner  
               Description: A debut of Joe Wong  
               Tags: logical, serious, funny    
The posting date should be generated automatically without a user’s input. Make sure that a user can only post at most five youtube videos a day.  
4. Implement a search interface as a web form so that after a user can type the name of a comedian, all youtube videos of that comedian will be returned. The result needs to be shown
as a table/list in a webpage in which a user can easily click any result and play the video.  
5. Using the same search interface, a user can also search youtube videos by tags (one or many). The result will show those youtube videos that contain any of the given tags (OR semantics).
6. Given any youtube video, a registered user can write a comment like the following:  
Choose the ranking of the youtube by a dropdown menue (poor, fair, good and excellent), and then a description such as “A show that makes me laugh to tears.” Make sure only registered user can give comments and a user cannot give a review to her own youtube videos.   
7. Implement the functionality of add/delete comedians to the “My favorite comedian list” using the “Add to my favorite comedians” and “delete from my favorite comedians” buttons. A
favorite comedian can be added after a user is playing a youtube of that comedian Based on part 1 & part 2, implement the following functionality using Java and SQL with necessary GUI interfaces. Part 3 emphasizes both the web interfaces and their integration with backend database operations. Implement the following functionality for the root user.    
8. [Who’s cool]: List those comedians who received some reviews and each of them is excellent. Make sure the name of a comedian is associated with a link so that after clicking the link, all youtubes of that comedian will be listed.  
2. [Who’s new]: List those comedians whose youtubes are just posted TODAY – no youtubes for that comedian have ever been posted before today.  
3. [Who’s hot]: List the top 3 comedians who received the most number of reviews, from the the most to the least.  
4. [Who’s top]: List the comedians that have the most number of youtube videos. List the top comedian if there is no tie, list all the tied top comedians if there is a tie.  
5. [Popular tags]: List those tags that have been used by every user.  
6. [Common favorite comedian] Given two users, X, and Y, which are specified by the user with two dropdown menu lists, list the comedians that are on both X and Y’s favorite comedian lists. Note X and Y will be decided dynamically by the TA during the demo.  
7. [Most productive users]: List the users who have posted the most number of youtubes, list the top user if there is no tie; list all the top tied users if there is a tie. The user’s name must be associated a link so that when the link is clicked, all the youtubes posted by the user will be listed.  
8. [Positive reviewers] List those users that have given some reviews, and each review is either good or excellent.   
9. [Poor youtubes]. List those youtubes that received some reviews, but each review is poor.   
10. [Twin users]. List a user pair (A, B) such that their favorite comedian lists are exactly the same. The result needs to be displayed as a two-column table with the first column shows the name of the first user and a link to his/her favorite comedian list, and the second column shows the name of the second user and a link to his/her favorite comedian list. Do no display
duplicates, that is, after showing (A, B), we do not need to show (B, A).  


**NOTE:** To run the project, go to the webContent, and under folder admin, run the home.jsp file.



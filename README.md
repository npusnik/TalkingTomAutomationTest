# TalkingTomAutomationTest
Expertise automation test using Appium for android app Talking Tom


This automation test consists of 4 individual test scenarios each presented as a separate java class:
* BaseTest - prepares the state of the app for all of the following test scenarios
* InfoTest - checks if instuction label contains correct text
* FoodTest - checks if feeding functionality works as expected
* VideoTest - records a short video and saves it to the gallery

# BaseTest

Base test was a preset JAVA class file with one error I found. There was a wrong id specified for a special permission dialog prompt:
line 65: **com.android.packageinstaller:id** instead of **com.android.permissioncontroller:id**.

As the test would fail due to the "element not found on the screen" error, I fixed it with the help of Appium.

# InfoTest

Info test is a test scenario for checking the text of the first label in "How to" section of the app. I assumed the best way to test this was to navigate to the instructions page, take the string of the first label and then compare it using *assertEquals* method with a preset string that I know is correct.

# FoodTest

Food test is a test scenario for checking if feeding functionality works. I assumed I do not need to test each and every way of feeding Tom, that is why I chose a random option from the food menu - a cake. I also assumed taking a screenshot alone is not the best way to test this, so to double check if functionality really works I compared the numbers under the food menu button indicating how many times a user can feed Tom. Assuming the number decreses by one each time Tom is fed, I stored the number prior feeding him and compared it to the number after. This time I've used the method *assertNotEquals* since the expected outcome is for numbers to be different.

# VideoTest (custom)

Video test is a test scenario that checks if the video recording functionality works and enables user to save it to the phone gallery. First it starts recording by clicking the record buttton in the upper left corner. The test proceedes with some taps to initiate some response from Tom to capture it in the video. The recording then stops which should bring playback options in the foreground. This is tested by checking if the Play Button has appeared on the screen. When the video starts playing, the Stop Playback button replaces the play button which is also being checked. Clicking the Stop Playback button should bring the user back to the playback menu with some sharing options at the bottom. This test case tests the gallery option that should save the recorded video to the phone gallery. After clicking on Gallery button, the test takes a screenshot to confirm video is being converted. The last step is to check if the final label has appeared on the screen to tell the user that the video was sucessfully saved to the gallery and also check if the text is correct.

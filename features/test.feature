Feature: To test the audio album
	


Scenario: Test the addition feature of audio album
Given Audio album web app is launched
	And Add new album is clicked
When Valid values are entered
	And Ok button is clicked
	Then Album added message is displayed
	
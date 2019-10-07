------------------------------- Proof of Concept Project ---------------------------------
Assumption:
I'm always assuming that we know the test data and all APIs responses.

Important Notes:
- TestCase1 Class is responsible to test when username does not exit
- TestCase2 Class is responsible to test end-to-end scenario
- TestCase3 Class is responsible to test when user does not have any posts
- TestCase4 Class is responsible to test when post does not have any comments
- TestCase5 Class is responsible to test end-to-end scenario and there are invalid emails
- I have add my own test data to cover the following scenarios and you can find it in db.json file:
    - User does not have any posts
    - Post does not have any comments
    - end-to-end scenario and there are invalid emails
	
Test Cases Reports:
- You can find Test Cases report under the following path:
	- localPath/proof-of-concepts/target/site/surefire-report.html
	

Project Links:

Project source code in GitHub: https://github.com/sobky/proof-of-concepts
Project CI pipeline in CircleCi: https://circleci.com/gh/sobky/proof-of-concepts
How to deploy the project in Google Cloud Shell.
We need to follow these steps to deploy and start a project in Google Cloud Console.
    Login to GCP console with a valid user account.
    Create a valid project for the application, we can create a new project. Click on the activate Cloud Shell, this will open a new Virtual machine for the user.
    In case the project is not config, then use the command
        gcloud config set project <PROKECT_ID>.
        gcloud config set project myspringboot-415415
    Clone the code from GIT Hub, use the command.
        Git clone GIT Hub URL.
        git clone https://github.com/Abhijeet-2019/My_Parking_Lot.git
Once we can download the code base, we need to build the code. Run the command in the folder that has POM.XML
		mvn clean install
Once we can build the code we can check if the code is working on the console.
Use the command java -jar Parking_Service-1.0-SNAPSHOT.jar
This should start a Spring Boot application.
Use the browser to check the application.

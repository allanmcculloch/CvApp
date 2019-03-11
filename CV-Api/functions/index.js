const functions = require('firebase-functions');

exports.jobs = functions.region('europe-west1').https.onRequest((request, response) => {

	var jobs = 
		[
			{
				"company" : "Just Eat Plc.",
				"title" : "Senior Android Consultant",
				"description" : "Developing and supporting a business critical Android order processing application (“Orderpad”) including highly scalable backend services. The system is used internationally on all Just Eat restaurants, processing millions of orders per week. Tech: Android - Kotlin / Architecture Components / MVVM / Retrofit2 / Coroutines / LiveData / Koin DI / Espresso / Firebase / Braze Xamarin Native / C# / UITest / .NET Web API / Team City / Soti MDM Amazon Web Services - Dynamo DB / SQS / SNS / EC2 / Cloud formation etc.",
				"period": "(Apr 2017 - Present)",
				"location" : "London"
			},
			{
				"company" : "Fraedom, HRG Plc.",
				"title" : "Senior Mobile Consultant",
				"description" : "Developed a business travel mobile app for itinerary management and travel assistance. This was a greenfield project in a newly formed agile team. Tech: Xamarin Forms (iOS / Android), Xamarin Native / MVVMCross (iOS / Android), SQLite, Web API / MVC on Azure, Redis, Notifications, Git, Team City",
				"period": "(Jan 2016 – Mar 2017)",
				"location" : "London"
			}
		]
	
  response.json(jobs);

});


exports.contactDetails = functions.region('europe-west1').https.onRequest((request, response) => {

	var contactDetails = 
		{
			"name" : "Allan McCulloch",
			"addressLines" : [ "42 My Street", "London", "E1 1AB" ],
			"emailAddress" : "allan@hotcross.co.uk",
			"mobileContact": "0712345678",
			"webAddress" : "https://www.linkedin.com/in/allanmcculloch"
		}
	
	 	var simulateNetworkDelayMs = 5;
  		setTimeout(function notifyTimeover() { response.json(contactDetails) }, simulateNetworkDelayMs);
});
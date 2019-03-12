const functions = require('firebase-functions');

exports.jobs = functions.region('europe-west1').https.onRequest((request, response) => {

	//TODO: extract to DB or external file
	var jobs = 
		[
			{
				"company" : "Just Eat Plc.",
				"title" : "Senior Android Contractor",
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
			},
			{
				"company" : "Just Eat Plc.",
				"title" : "Mobile Contractor (Senior)",
				"description" : "Worked on multiple agile projects to communicate order and delivery tracking information from the Just Eat platform to restaurants and partners. Developed scalable APIs using .NET Web API 2, Amazon Web Services (EC2, Dynamo DB, SNS and SQS) and mobile / tablet clients using Xamarin Android / iOS (MVVMCross Native / Xamarin Forms). Tools/Tech used: Visual Studio, Xamarin Studio, NUnit/Moq, Git, TeamCity, JIRA, Google Cloud Messaging, PubNub, HockeyApp, TopShelf etc.",
				"period": "(Sept 2013 - Dec 2015)",
				"location" : "London"
			},
			{
				"company" : "Novarum DX",
				"title" : "Xamarin Contractor",
				"description" : "Developed mobile iOS and Android apps for reading (via camera) and tracking medical diagnostic tests. Extensive use of Xamarin iOS / Android, SQLite and integration with REST APIs written in Django. Exposure to ISO 13485 and the application of this process within an agile software development context.",
				"period": "(Sept 2012 - Sept 2013)",
				"location" : "Edinburgh"
			},
			{
				"company" : "Avian Communications (Agency)",
				"title" : "Technical Lead",
				"description" : "Developed mobile iOS and Android apps for reading (via camera) and tracking medical diagnostic tests. Extensive use of Xamarin iOS / Android, SQLite and integration with REST APIs written in Django. Exposure to ISO 13485 and the application of this process within an agile software development context.",
				"period": "(Nov 2007 - Sept 2012)",
				"location" : "Dundee, Scotland"
			}
		]
	
		var simulateNetworkDelayMs = 3;
  		setTimeout(function notifyTimeover() { response.json(jobs) }, simulateNetworkDelayMs);
});


exports.contactDetails = functions.region('europe-west1').https.onRequest((request, response) => {

	//TODO: extract to DB or external file
	var contactDetails = 
		{
			"name" : "Allan McCulloch",
			"addressLines" : [ "42 My Street", "London", "E1 1AB" ],
			"emailAddress" : "allan@hotcross.co.uk",
			"mobileContact": "0712345678",
			"webAddress" : "https://www.linkedin.com/in/allanmcculloch",
			"imageUrl" : "https://www.linkedin.com/in/allanmcculloch/?lipi=urn%3Ali%3Apage%3Ad_flagship3_feed%3B1uKXj79uQT2jZlDAkJBRUA%3D%3D&licu=urn%3Ali%3Acontrol%3Ad_flagship3_feed-identity_profile_photo"
		}
	
	 	var simulateNetworkDelayMs = 3;
  		setTimeout(function notifyTimeover() { response.json(contactDetails) }, simulateNetworkDelayMs);
});


exports.sendMessage = functions.region('europe-west1').https.onRequest((request, response) => {

	 var requestBody = request.body

	 if (!requestBody.name || !requestBody.fromEmail || !requestBody.message) {

	 	console.log("Failed to send message")
	 	console.log(requestBody)

	 	return response.status(400).end()
	 }
	 
	 //TODO: send message via SendGrid or similar
	 console.log("Would have sent message")
 	 console.log(requestBody)
	 return response.status(204).end()
});

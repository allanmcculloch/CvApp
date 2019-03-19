exports.handler = (request, response) => {

   //TODO: extract to DB or external file
    var contactDetails = 
        {
            "name" : "Allan McCulloch",
            "addressLines" : [ "42 My Street", "London", "E1 1AB" ],
            "emailAddress" : "allan@hotcross.co.uk",
            "mobileContact": "0712345678",
            "webAddress" : "https://www.linkedin.com/in/allanmcculloch",
            "imageUrl" : "https://firebasestorage.googleapis.com/v0/b/cvapi-2b579.appspot.com/o/me.png?alt=media"
        }
        
        var simulateNetworkDelayMs = 3;
            setTimeout(function notifyTimeover() { response.json(contactDetails) }, simulateNetworkDelayMs);
}
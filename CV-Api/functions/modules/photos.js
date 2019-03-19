exports.handler = (request, response) => {
    //TODO: extract to DB or external file
    var photos = 
        [
            {
                "title" : "Ben Wyvis, Scotland (Final Munro)",
                "imageUrl" : "https://firebasestorage.googleapis.com/v0/b/cvapi-2b579.appspot.com/o/photos%2Ffinal_munro.jpg?alt=media"
            },
            {
                "title" : "Mont Blanc",
                "imageUrl" : "https://firebasestorage.googleapis.com/v0/b/cvapi-2b579.appspot.com/o/photos%2Fmontblank..jpg?alt=media"
            },
            {
                "title" : "Mount Kilimanjaro",
                "imageUrl" : "https://firebasestorage.googleapis.com/v0/b/cvapi-2b579.appspot.com/o/photos%2Fkil.jpg?alt=media"
            }        
        ]
    
        var simulateNetworkDelayMs = 3;
        setTimeout(function notifyTimeover() { response.json(photos) }, simulateNetworkDelayMs);
}
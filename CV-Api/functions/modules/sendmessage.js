exports.handler = (request, response) => {
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
}
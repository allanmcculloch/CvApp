const functions = require('firebase-functions');

const jobsModule = require('./modules/jobs');
const contactDetailsModule = require('./modules/contactdetails');
const sendMessageModule = require('./modules/sendmessage');
const photosModule = require('./modules/photos');

exports.jobs = functions.region('europe-west1').https.onRequest(jobsModule.handler);
exports.contactdetails = functions.region('europe-west1').https.onRequest(contactDetailsModule.handler);
exports.sendmessage = functions.region('europe-west1').https.onRequest(sendMessageModule.handler);
exports.photos = functions.region('europe-west1').https.onRequest(photosModule.handler);
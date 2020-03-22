
# Minionify

## Background
An app that allows basic control over remote devices.
The users would be divided into 2 groups; managers and minions.
A manager can use the app to execute certain operations on the minions' devices, such as gathering statistics, sending notifications, determining location, opening another app etc.
The minions would use the app passively; by using the app, they willingly give the managers permission to execute operations on their devices.
Each minion can have only one manager, while managers can multiple minions.

Possible users of the app are worried parents with their children or strict bosses with their employees.


## Roles
- Minions: The minions will run a background service that will listen for incoming requests from the managers.

- Managers: The managers will have a GUI that lets them control their minions.
For example, a manager can choose one of its minions and get their location, statistics and more... 

## Technology
The Minionify app will use Firebase as its server. 
A manager will send a request to a minion through Firebase (using to Firebase storage), in order to get information about/from the minion.

## The Minions' Background Service
The Minions' Background Service will be responsible every FETCH_INTERVAL (configurable) seconds to check if a new request has been registered for the minion.
Once the service has withdrew a request from the manager, it is responsible to delete the request from the minion's requests folder.
After withdrawing the request, the service will run the request and put the answer in the minion's answers folder.

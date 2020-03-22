
# Minionify

## Introduction
An app that allows basic control over remote devices.
The users would be divided into 2 groups; managers and minions.
A manager can use the app to execute certain operations on the minions' devices, such as gathering statistics, sending notifications, determining location, opening another app etc.
The minions would use the app passively; by using the app, they willingly give the managers permission to execute operations on their devices.
Each minion can have only one manager, while managers can have multiple minions.

Possible users of the app are worried parents with their children or strict bosses with their employees.


## Modes
The Minionify app will have two different modes that it can operate.
- As A Minion: Minionify will run a background service that will listen for incoming requests from the managers, execute them and send back a response back to the manager.

- As A Manager: Minionify will present a GUI to the user that will let them to control their minions apps.
For example, a user can choose one of its minions and get their location, statistics and more...

## Protocol
The Minionify app will use Firebase as its server. 
A manager will be able to send requests to a minion through Firebase (using to Firebase storage), in order to get information about/from the minion.

Each minion will have a main folder that will have two folders nested in it:
- Requests Folder: the folder where the managers will put the requests for the minion. When a minion withdraws a request, the minion will delete the request file from the requests folder.
- Answers Folder: the folder where the minion will put its answers back to the manager.

## Components
### The Minions' Background Service
The Minions' Background Service will be responsible every FETCH_INTERVAL (configurable) seconds to check if a new request had been registered for the minion.
Once the service has withdrew a request from the manager, it is responsible to delete the request from the minion's requests folder.
After withdrawing the request, the service will run the request and put the answer in the minion's answers folder.

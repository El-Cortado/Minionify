
# Minionify

## Introduction
An app that allows basic control over remote devices.
The users would be divided into 2 groups; managers and minions.
A manager can use the app to execute certain operations on the minions' devices, such as gathering statistics, sending notifications, determining location, opening another app etc.
The minions would use the app passively; by using the app, they willingly give the managers permission to execute operations on their devices.
Each minion can have only one manager, while managers can have multiple minions.

Possible users of the app are worried parents with their children or strict bosses with their employees.


## Modes
The Minionify app will have two different modes in which it can operate:

- As A Minion: Minionify will run a background service that will listen for incoming requests from the managers, execute them and send the response back to the manager.
- As A Manager: Minionify will display a GUI to the user that will let them control their minions' apps.
For example, a manager can choose one of its minions and get their location, statistics and more...

## Protocol
The Minionify app will use Firebase for communication between the minions and the managers. 
A manager will be able to send requests to a minion through Firebase (using the Firebase database), in order to get information about/from the minion.

The app will use Firebase's Realtime Database that will allow minions and managers to get realtime updates about data that has been inserted into the database (requests/responses).
The database will contain a requests path and a responses path. Each minion will have a path nested in the requests path that will contain all of its requests. When a minion will be notified
of request that has been inserted, it will delete the request from the requests path, run the request and put the response back in the repsonses path under the minion's id (responses/{minionId}/response_1).

### Requests And Responses Structure
The requests and responses will be serialized Java object (Request/Response).

### Retrieving Big Data
The DB can contain references to the storage for big data.

## Components
### The Minions' Background Service
The Minions' Background Service will be responsible to listen for incoming requests registered for the minion.
Once the service has withdrew a request from the manager, it is responsible to delete the request from the minion's requests path.
After withdrawing the request, the service will run the request and put the response in the minion's responses path.

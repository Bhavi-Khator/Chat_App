# Chat_App
A client server based chat app that can be used by multiple clients written in java using socket programming.

The server side maintains a recored of all the active users using hashmap and deletes the user once the the client is offline due to any reason like network not working or if the program is shut. It transfers the messages by reading the to and from in the message. 

The client side first registers itself with the server and then sends an object of message in the format of To, From, Message. 


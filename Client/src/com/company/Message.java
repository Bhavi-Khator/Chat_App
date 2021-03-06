package Client.src.com.company;

import java.io.Serializable;

public class Message implements Serializable {
    private String message;
    private String from;
    private String to;


    public Message(String message, String from, String to) {
        this.message = message;
        this.from = from;
        this.to = to;
    }


    public String getTo(){
        return this.to;
    }
    public String getMessage(){
        return this.message;
    }
    public String getFrom(){
        return this.from;
    }



    public String toString() {
        return String.format("Message : %s\nFrom : %s\nTo : %s"
                , message, from, to);

    }

}

package ch.brj.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.Date;


@Stateless
@Remote
public class StatelessSessionRemoteBean implements StatelessSessionRemote {

    @PostConstruct
    public void initialize() {
        System.out.println("*** StatelessSessionRemoteBean created.");
    }

    /**
     * Creates a greeting to the person with the supplied name.
     *
     * @param inName Name of person to greet.
     * @return Greeting.
     */
    public String greeting(final String inName) {
        Date theCurrentTime = new Date();
        String theMessage = "Hello " + inName + ", I am stateless session bean " +
                ". The time is now: " + theCurrentTime;
        return theMessage;
    }

}
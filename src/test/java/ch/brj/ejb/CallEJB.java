package ch.brj.ejb;

import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

/**
 * Created by jakob on 01.10.2016.
 */
public class CallEJB {

    //
    // For stateless beans:
    // ejb:<app-name>/<module-name>/<distinct-name>/<bean-name>!<fully-qualified-classname-of-the-remote-interface>
    //
    //  For stateful beans:
    // ejb:<app-name>/<module-name>/<distinct-name>/<bean-name>!<fully-qualified-classname-of-the-remote-interface>?stateful

    @Test
    public void test() throws Exception {
        final Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

        String name1 = "ejb:EJBTest/web/StatelessSessionRemoteBean!ch.brj.ejb.StatelessSessionRemote";

        Context ctx = new InitialContext(env);
        StatelessSessionRemote bean = (StatelessSessionRemote) ctx.lookup(name1);
        String message = bean.greeting("Client");
        System.out.println(message);

//        String name2 = "ejb:EJBTest/web/StatefulSession1Bean!ch.brj.ejb.StatefulSession1Bean?stateful";
//        ctx.lookupLink(name2);
    }
}

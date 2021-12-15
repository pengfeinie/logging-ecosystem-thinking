package com.example.logging.log4j2.cv2.hacker;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

public class EvilHackerHandler implements ObjectFactory {

    static {
        System.out.println("you are a pig.!");
        handle();
    }

    public static void handle(){
        System.out.println("you are a dog.!");
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return null;
    }
}

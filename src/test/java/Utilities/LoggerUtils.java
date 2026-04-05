package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtils {

        // Returns a logger for any class passed to it
        public static Logger getLogger(Class<?> cls) {
            return LogManager.getLogger(cls);
        }

}

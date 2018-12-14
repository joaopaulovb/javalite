package org.javalite.activejdbc.logging;

import org.slf4j.Logger;

import java.util.function.Supplier;

/**
 * Implement this interface if you want to completely replace logging behavior with your own.
 * <p>
 * For more information, refer: <a href="http://javalite.io/logging">Logging</a>.
 *
 * @author igor on 5/20/17.
 */
public interface ActiveJDBCLogger {
    /**
     * @param logger   logger instance to use.
     * @param logLevel suggested log level
     * @param log      content to log
     */
    void log(Logger logger, LogLevel logLevel, String log);

    /**
     * Default implementation of lazy log message building for backward compatibility.
     *
     * @param logger   logger instance to use.
     * @param logLevel suggested log level
     * @param messageSupplier log message supplier.
     */
    default void log(Logger logger, LogLevel logLevel, Supplier<String> messageSupplier)
    {
        log(logger, logLevel, messageSupplier.get());
    }

    /**
     * @param logger   logger instance to use.
     * @param logLevel suggested log level
     * @param log      content to log
     * @param param    parameters for the log
     */
    void log(Logger logger, LogLevel logLevel, String log, Object param);

    /**
     * @param logger   logger instance to use.
     * @param logLevel suggested log level
     * @param log      content to log
     * @param param    parameters array for the log
     */
    void log(Logger logger, LogLevel logLevel, String log, Object... param);

    /**
     * @param logger   logger instance to use.
     * @param logLevel suggested log level
     * @param log      content to log
     * @param param1   first parameter for the log
     * @param param2   second parameter for the log
     */
    void log(Logger logger, LogLevel logLevel, String log, Object param1, Object param2);
}

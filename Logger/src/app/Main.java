package app;

import app.appenders.Appender;
import app.appenders.console.ConsoleAppender;
import app.appenders.file.File;
import app.appenders.file.FileAppender;
import app.appenders.file.LogFile;
import app.enums.ReportLevel;
import app.layouts.Layout;
import app.layouts.SimpleLayout;
import app.layouts.XmlLayout;
import app.loggers.Logger;
import app.loggers.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Appender> appenders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] appenderInfo = reader.readLine().split("\\s+");
            Appender appender = createAppender(appenderInfo);

            if (appenderInfo.length == 3) {
                appender.setReportLevel(ReportLevel.valueOf(appenderInfo[2].toUpperCase()));
            } else {
                appender.setReportLevel(ReportLevel.INFO);
            }
            appenders.add(appender);
        }

        Logger logger = new MessageLogger(appenders.toArray(new Appender[n]));

        String line;

        while (!(line = reader.readLine()).equals("END")) {
                String[] tokens = line.split("\\|");

            ReportLevel level = ReportLevel.valueOf(tokens[0]);
            switch (level) {
                case INFO:
                    logger.logInfo(tokens[1],tokens[2]);
                    break;
                case WARNING:
                    logger.logWarning(tokens[1],tokens[2]);
                    break;
                case FATAL:
                    logger.logFatal(tokens[1],tokens[2]);
                    break;
                case CRITICAL:
                    logger.logCritical(tokens[1],tokens[2]);
                    break;
                case ERROR:
                    logger.logError(tokens[1],tokens[2]);
                    break;
            }
        }

        System.out.println(logger.logInfo());
    }

    public static Appender createAppender(String[] tokens) {
        switch (tokens[0]) {
            case "ConsoleAppender":
                return new ConsoleAppender(createLayout(tokens[1]));
            case "FileAppender":
                FileAppender fileAppender = new FileAppender(createLayout(tokens[1]));
                fileAppender.setFile(new LogFile());
                return fileAppender;
            default: throw new IllegalArgumentException("Invalid appender");
        }
    }

    public static Layout createLayout(String layout) {
        switch (layout) {
            case "SimpleLayout":
                return new SimpleLayout();
            case "XmlLayout":
                return new XmlLayout();
            default:
                throw new IllegalArgumentException("Invalid layout");
        }
    }
}

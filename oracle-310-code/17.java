package org.kodejava.example.nio;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class FileWatchDemo {
    public static void main(String[] args) {
        try {
            // Creates a instance of WatchService.
            WatchService watcher = FileSystems.getDefault().newWatchService();

            // Registers the logDir below with a watch service.
            Path logDir = Paths.get("/Users/kodejava/temp/");
            logDir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

            // Monitor the logDir at listen for change notification.
            while (true) {
                WatchKey key = watcher.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    if (ENTRY_CREATE.equals(kind)) {
                        System.out.println("Entry was created on log dir.");
                    } else if (ENTRY_MODIFY.equals(kind)) {
                        System.out.println("Entry was modified on log dir.");
                    } else if (ENTRY_DELETE.equals(kind)) {
                        System.out.println("Entry was deleted from log dir.");
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
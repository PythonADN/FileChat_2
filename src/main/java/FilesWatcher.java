import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FilesWatcher implements Runnable {
    @Override
    public void run() {
        try {
            Register();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void Register() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("C:\\Users\\ADN\\IdeaProjects\\FileChat\\src\\main\\out_1");
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        for (; ; ) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                switch (kind.name()) {
                    case "ENTRY_CREATE":
                        WriteLabelOut(path); // пробегаемся по всем файлам и записываем их в панель
                        break;
                    default:
                        System.out.println("Wrong event called.");
                        break;
                }
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        }
    }

    public static void WriteLabelOut(Path path) throws IOException {
        List<File> files = Files.walk(path)
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
        Iterator<File> iterator = files.iterator();
        while (iterator.hasNext()) {
            Path p = iterator.next().toPath();
            System.out.println(p.getFileName());
            byte[] buffer = Files.readAllBytes(p);
            String line = new String(buffer);
            Layout.textAreaOut.appendText("out: " + line + "\n"); // записываем в поле вывода наш текст
            Files.delete(p);
        }


    }
}

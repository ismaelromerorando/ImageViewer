package persistence;

import model.ProxyImage;
import model.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileListLoader implements  ListLoader {
    private String directory;

    public FileListLoader(String directory) {
        this.directory = directory;
    }

    @Override
    public List<Image> load() {
        return linkImages(loadImages());
    }

    private List<Image> loadImages() {
        List<Image> list = new ArrayList<>();
        for (String file : new File(directory).list()) {
            list.add(new ProxyImage(new FileImageLoader(directory + "/" + file)));
        }
        return list;
    }

    private List<Image> linkImages(List<Image> list) {
        for (int i = 0; i < list.size(); i++) {
            Image image = list.get(i);
            image.setNext(list.get((i + 1) % list.size()));
            image.setPrev(list.get((i + list.size() - 1) % list.size()));
        }
        return list;
    }

}

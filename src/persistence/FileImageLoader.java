package persistence;



import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import model.Image;
import model.RealImage;
import swing.SwingBitmap;

public class FileImageLoader implements ImageLoader {

    private final String directory;

    public FileImageLoader(String directory) {
        this.directory = directory;
    }

    @Override
    public Image load() {
        return new RealImage(new SwingBitmap(loadImage()));
    }

    private BufferedImage loadImage() {
        try {
            return ImageIO.read(new File(directory));
        } catch (IOException ex) {
            return null;
        }
    }
}
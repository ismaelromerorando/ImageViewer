package swing;

import java.awt.image.BufferedImage;
import model.Bitmap;

public class SwingBitmap implements Bitmap {

    private final BufferedImage bufferedImage;

    public SwingBitmap(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }
    @Override
    public int getHeight() {
        return bufferedImage.getHeight();
    }
    
    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }


}
package ui;

import model.Image;

public interface ImageViewer {

    public void setImage(Image image);

    public Image getImage();
 
    public void showPrev();
    
    public void showNext();
}

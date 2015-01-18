package model;

public abstract class Image {
    private Image prevImage;
    private Image nextImage;
    
    
    public void setPrev(Image image){
        this.prevImage = image;
    }
    public Image getPrev(){
        return prevImage;
    }
    public void setNext(Image image){
        this.nextImage = image;
    }
    public Image getNext(){
        return nextImage;
    }
    public abstract Bitmap getBitmap();
}

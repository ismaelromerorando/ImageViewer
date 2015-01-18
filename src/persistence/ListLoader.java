package persistence;

import model.Image;
import java.util.List;

public interface ListLoader {
    public abstract List<Image> load();
}

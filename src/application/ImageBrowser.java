package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import control.Command;
import control.NextImageCommand;
import control.PrevImageCommand;
import model.Image;
import persistence.FileListLoader;
import persistence.ListLoader;
import swing.ApplicationFrame;
import swing.ActionListenerFactory;



public class ImageBrowser {

    private Map<String, Command> commandMap;
    private ApplicationFrame frame;
    private String directory;

    public static void main(String[] args) {
        String directory = "C:/Users/Ismael/Pictures";
        new ImageBrowser().execute(directory);
    }

    private void execute(String directory) {
        this.directory = directory;
        ListLoader loader = new FileListLoader(directory);
        List<Image> list = loader.load();
        frame = new ApplicationFrame(createActionListenerFactory());
        frame.getViewer().setImage(list.get(0));
        createCommandMap();
    }

    private ActionListenerFactory createActionListenerFactory() {
        return new ActionListenerFactory() {
            
            @Override
            public ActionListener addAction(final String action) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Command command = commandMap.get(action);
                        if (command == null) {
                            return;
                        }
                        command.execute();
                    }
                };
            }
        };
    }

    private void createCommandMap() {
        commandMap = new HashMap<>();
        commandMap.put("Prev", new PrevImageCommand(frame.getViewer()));
        commandMap.put("Next", new NextImageCommand(frame.getViewer()));
    }
}
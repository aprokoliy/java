package chat.writer.appmanager;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 26-Apr-16.
 */
public class ApplicationManager {

    public FirefoxDriver wd;

    public void init() {
            wd = new FirefoxDriver();
            wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            wd.get("http://localhost/addressbook/addressbook/");

        }

        public  void stop() {
            wd.quit();
        }

    }

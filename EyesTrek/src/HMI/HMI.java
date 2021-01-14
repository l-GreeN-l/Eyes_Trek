
package HMI;

import static eyestrek.EyesTrek.APPLICATION_NAME;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.lang.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


//------------------------------------------------------------------------------
//Ссылки:
//  https://eax.me/java-tray-icon/
//  https://habrahabr.ru/post/27108/
//  http://developer.alexanderklimov.ru/android/library/gson.php
//
//------------------------------------------------------------------------------

public class HMI {

    
    public static int x=300,     //ширина Фрэйма
                      y=500 ;   //высота
    

  
  public static final String ICON_STR = "logo2.png"; 
  
  
  public static SetFrame runF;              //  экземпляр класса фрейма
    
  public static boolean tr = true;          // Тригер фрейма
  
//****************************************************************************** 
  
    

  

    
// Интерфейс иконки
    
 public static void setTrayIcon() throws Exception  {
    if(! SystemTray.isSupported() ) {
      return;
    }
    
   
    
    

    PopupMenu trayMenu = new PopupMenu();
    MenuItem item = new MenuItem("Exit");
    MenuItem item2 = new MenuItem("Settings");
   
    
    
    
    
    item.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
        
      }
      
      
    }); 
    
    
    trayMenu.add(item);
   //-------------------------------------------------------------
   
   
   
   
   
    
   
    item2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
       
          if(tr)runF = new SetFrame();
     
       
      }
        
    }); 
    
    
    trayMenu.add(item2);
    //-------------------------------------------------------------
   
   

    URL imageURL = HMI.class.getResource(ICON_STR);

    Image icon = Toolkit.getDefaultToolkit().getImage(imageURL);
    TrayIcon trayIcon = new TrayIcon(icon, APPLICATION_NAME, trayMenu);
    trayIcon.setImageAutoSize(true);

    SystemTray tray = SystemTray.getSystemTray();
    try {
      tray.add(trayIcon);
    } catch (AWTException e) {
    }

    trayIcon.displayMessage(APPLICATION_NAME, "Open programm!",
                            TrayIcon.MessageType.INFO);
    
    
    
//------------------------------------------------------------------------------    
  }
 
 


 
//==============================================================================
//END

}    
    
    

package eyestrek;
import Logics.Ws_client;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static HMI.HMI.setTrayIcon;


//******************************************************************************    
//
//  Ссылки:  
//      JSON:
//          https://ru.stackoverflow.com/questions/510187/
//          https://jsoneditoronline.org
//          http://qaru.site/questions/362318/json-object-max-size
//          https://stackoverrun.com/ru/q/5240210
//       
//      WS client lib and exemple:
//          https://oss.sonatype.org/content/repositories/snapshots/org/java-websocket/Java-WebSocket/1.3.9-SNAPSHOT/
//          https://github.com/TooTallNate/Java-WebSocket/blob/master/src/main/example/ExampleClient.java
//          http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
//    
//      Logs:
//          https://javarush.ru/quests/lectures/questcollections.level04.lecture09
//
//      Rest lib OkHTTP: 
//          https://square.github.io/okhttp/
//            Требует несколько доп бибилиотек(OkIO,Kotlin stdll см stack overflow)
//    
//******************************************************************************


public class EyesTrek {

  
public static final String APPLICATION_NAME = "EyesTrek v0.2";   
    
// Преобразования ip адресов    
public static String ip_addr = "10.20.30.42";
public static int portHTTP = 5000;
public static int portWS = 5008;
	
public static String http= "http://"+ip_addr+":"+portHTTP+"/"; 
public static String urlWS = "ws://"+ip_addr+":"+portWS;
public static int api = 3;

public static String urlhttp = http+api;;
public static String auth_token = "";
 
// Порог распознавания лиц  60%
public static double SimilarityLimit = 0.6;

//______________________________________________________________________________        

	public static void main( String[] args ) throws IOException {
		      
            try {
                setTrayIcon(); 
                Ws_client c = new Ws_client( new URI(urlWS+"/api/subscribe?auth_token="+ auth_token));
                c.connect();

            } catch (Exception ex) {
                Logger.getLogger(EyesTrek.class.getName()).log(Level.SEVERE, null, ex);
            }
    
//==============================================================================    
}


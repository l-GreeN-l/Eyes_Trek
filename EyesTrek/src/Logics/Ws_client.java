//______________________________________________________________________________
// 
//          Обработка событий , получаемых через WS
//
//______________________________________________________________________________

package Logics;

import Pojo.WS_Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;


public class Ws_client extends WebSocketClient {
    
//******************************************************************************    
 public static   DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//******************************************************************************    

	public Ws_client( URI serverUri , Draft draft ) {
		super( serverUri, draft );
	}

	public Ws_client( URI serverURI ) {
		super( serverURI );
	}

	public Ws_client( URI serverUri, Map<String, String> httpHeaders ) {
		super(serverUri, httpHeaders);
	}

	@Override
	public void onOpen( ServerHandshake handshakedata ) {
		send("Hello, it is me. Mario :)");
		System.out.println( "opened connection" );
		// if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
	}
        
        
//_____________________________Сообщенька при событии___________________________        
	@Override
    public void onMessage( String message ) {
     		
	    new onMessage(message);
                            
	}

	
//___________________________При закрытии соединения____________________________        
	@Override
	public void onClose( int code, String reason, boolean remote ) {
		// The codecodes are documented in class org.java_websocket.framing.CloseFrame
		System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) + " Code: " + code + " Reason: " + reason );         
	}

//_______________________При ошибке_____________________________________________        
	@Override
	public void onError( Exception ex ) {
		ex.printStackTrace();
		// if the error is fatal then onClose will be called additionally
	}

            
//=====EnD======================================================================
}

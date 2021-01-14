




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

    
    
//______________________________________________________________________________        
//_______________П А Р А М Е Т Р Ы___П Р О Г Р А М М Ы__________________________        
 
    
 public static final String APPLICATION_NAME = "EyesTrek v0.2";   
    
// Преобразования ip адресов    
public static String ip_addr = "10.20.30.42";
public static int portHTTP = 5000;
public static int portWS = 5008;


public static String http= "http://"+ip_addr+":"+portHTTP+"/"; 
 
public static String urlWS = "ws://"+ip_addr+":"+portWS;


public static int api = 3;

public static String urlhttp = http+api;;


public static String auth_token = "9a6ce219-a4c7-44f7-9dc8-d3a770408841";
 


// Порог распознавания лиц  60%
public static double SimilarityLimit = 0.6;


//______________________________________________________________________________        
//______________________________________________________________________________        






	public static void main( String[] args ) throws IOException {
		
            
    
                
            try {


                setTrayIcon();
               
                Ws_client c = new Ws_client( new URI(urlWS+"/api/subscribe?auth_token="+ auth_token));


            
               c.connect();







            } catch (Exception ex) {
                Logger.getLogger(EyesTrek.class.getName()).log(Level.SEVERE, null, ex);
            }






//Requests req = new Requests();





//GetAllpers.Response pj = req.getAllpersons(url);

//GetPerson pj = req.getPerson(url,"0a67186a-261c-4327-9692-70d07665df48");

//System.out.println(pj.user_data);


//req.linkedPhoto(url,"0a67186a-261c-4327-9692-70d07665df48","e7d040d8-fa55-42f9-b7dc-1933900d3a88");




//String name ="Какой - то Вася ";



//req.createPerson(url, name, "46f9312d-c658-42ab-9327-fcaeb6047e26");


 



//GetAllpers.Response pj = req.getPersonList(http,req.getPersonList(http,0).count);



//System.out.println("All:  "+pj.count);


//req.AddPhoto(url, "e8e293d3-577e-45c7-bc7c-6b038d9366fe", "e2369240-74f6-4aa4-a2bf-58dce09e5d94");


    }
//______________________________________________________________________________        
        
 
        
//  public void ws_connect()
//  {
//      
//                    Ws_client c;
//            try {
//                c = new Ws_client( new URI( "ws://172.20.160.29:5008/api/subscribe?auth_token=9a6ce219-a4c7-44f7-9dc8-d3a770408841" ));
//          
//            
//            
//                    c.connect();
//
//                    
//                    while(!c.isOpen())  System.out.println("Connection....");c.reconnect();
//              
//            
//            
//                  } catch (URISyntaxException ex) {
//                Logger.getLogger(EyesTrek.class.getName()).log(Level.SEVERE, null, ex);
//            }
//		
//  
//  
//  }      
        
        
        






//____________JSON parse requests code__________________________________________




//-------------------------------Exemple Guide----------------------------------

//Pojo pj = new Pojo();

//pj.desk = "Bla bla bla";
//pj.name = "Uk";
//pj.size = 1;



//String txt = "{\"name\":\"Uk\",\"size\":1}";
//
//
        
//            
//String str = gson.toJson(pj);
//System.out.println("Request: "+str);
//------------------------------------------------------------------------------






//----------------------JSON texts----------------------------------------------
//  public static String GetPersons = TextJson.text1;
//    public static String Getperson = TextJson.text3;
//
//    public static String postperstxt = TextJson.text2;
//    
//    public static String personIdent = TextJson.PersIdent;
//    public static String personUnk = TextJson.PersUnkn;
//------------------------------------------------------------------------------





//-----------------------------Get person list----------------------------------

//GsonBuilder builder = new GsonBuilder();
//Gson gson = builder.create();            
//Pojo.Response pj = gson.fromJson(GetPersons, Pojo.Response.class);
//        
//try{
//
//System.out.println("Всего людей: "+ pj.count);
////System.out.println(ar.get(2));
//int num = 1;
//for(Pojo.persons pers: pj.persons){
//System.out.println("№__"+num);    
//System.out.println(pers.user_data+"\t"+"id: "+pers.id+"\t"+"time_create: "+ pers.create_time);
//System.out.println();
//for(int i=0;i<pers.lists.length;i++)System.out.println("list_"+i+": "+pers.lists);
//System.out.println();
//for(int i=0;i<pers.descriptors.length;i++)System.out.println("Descriptor_"+i+": "+pers.descriptors);
//System.out.println();
//System.out.println("-----------------------------------------------------------------------------------");
//num++;
//}
//}
//catch(NullPointerException ex)
//{
//    System.out.println("Нет ответа или ошибка чтения!");
//}
//
//finally
//        {
////        System.out.println(c.text);
////        System.out.println(   pj.persons .get(9));
//
//        }
//------------------------------------------------------------------------------




//-----------------------------Post person--------------------------------------
//GsonBuilder builder = new GsonBuilder();
//Gson gson = builder.create();            
//PostPers pj = gson.fromJson(postperstxt, PostPers.class);
//
//
//System.out.println("Request: "+pj.person_id);
//------------------------------------------------------------------------------





//-----------------------------Get person---------------------------------------
//GsonBuilder builder = new GsonBuilder();
//Gson gson = builder.create();            
//GetPerson pj = gson.fromJson(Getperson, GetPerson.class);
//
//
//    
//System.out.println(pj.user_data+"\t"+"id: "+pj.id+"\t"+"time_create: "+ pj.create_time);
//System.out.println();
//for(int i=0;i<pj.lists.length;i++)System.out.println("list_"+i+": "+pj.lists);
//System.out.println();
//for(int i=0;i<pj.descriptors.length;i++)System.out.println("Descriptor_"+i+": "+pj.descriptors);
//------------------------------------------------------------------------------



//---------------------------Parse WS Json Response-----------------------------
//
// try{       
//        
//GsonBuilder builder = new GsonBuilder();
//Gson gson = builder.create();            
//WS_Response pj = gson.fromJson(personUnk, WS_Response.class);
//       
//
//
//System.out.println(pj.result.candidates.get(0).user_data);
//System.out.println(pj.result.candidates.get(1).user_data);
//System.out.println(pj.result.candidates.get(2).user_data);
// }
// catch(JsonSyntaxException ex)
// {
//     
//     ex.printStackTrace();
// }
//------------------------------------------------------------------------------





        
        
        
        
//==============================================================================    
}


//______________________________________________________________________________ 
//
//           Простые запросы на получение персон / привязке дескрипторов   
//
//
//______________________________________________________________________________   


package Logics;

import Pojo.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.JsonIOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;


public class Requests {
    
// Функция возвращает персону по id    
public  GetPerson getPerson(String url,String id_pers)
{
    
try{    
GsonBuilder builder = new GsonBuilder();
Gson gson = builder.create();            
GetPerson pj = gson.fromJson(GET(url+"/storage/persons/"+id_pers), GetPerson.class);
return pj;
}
catch(NullPointerException ex)
{
    System.out.println("Нет ответа или ошибка чтения!");
    return null;
}

 catch(JsonIOException ex)
{
    System.out.println("Ошибка чтения!");
    return null;
}
   
}
//______________________________________________________________________________    
    
    
  
// Функция возвращает заданное колличество персон <size>     
public Pojo.GetAllpers.Response getPersonList(String url, int size)
    { 
        
 try{         
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();            
            Pojo.GetAllpers.Response pj = gson.fromJson(GET(url+"/storage/persons?page_size="+size) , Pojo.GetAllpers.Response.class);
return pj; 
}

catch(NullPointerException ex)
{
    System.out.println("Нет ответа или ошибка чтения!");
    return null;
}
 catch(JsonIOException ex)
{
    System.out.println("Ошибка чтения!");
    return null;
}
    }
//______________________________________________________________________________    
    
    
// Привязка персоны к листам
public void linked(String url,String id_pers)
{

    PATCH( url+"/storage/persons/"+id_pers+"/linked_lists?list_id=d67ed25d-2205-47a3-b704-ec8485b3b2bc&do=attach");
    PATCH( url+"/storage/persons/"+id_pers+"/linked_lists?list_id=89a1cbb9-2e72-4c74-bf90-fdbeb4e033d3&do=attach");
    PATCH( url+"/storage/persons/"+id_pers+"/linked_lists?list_id=c3511d75-9051-44cb-b1aa-1d75be28f575&do=attach");

    
}
//______________________________________________________________________________    



// Привязка фотки к персоне
public void linkedPhoto(String url, String id_pers, String id_photo)
{
    PATCH( url+"/storage/persons/"+id_pers+"/linked_descriptors?descriptor_id="+id_photo+"&do=attach");
       
}
//______________________________________________________________________________    


    
// Сборочный запрос - создает персону с именем + привязывает к листам + привязывает к фотке    
    public void createPerson(String url,String name,String id_photo)
    {
    MediaType mediaType = MediaType.parse("application/octet-stream");
    RequestBody body = RequestBody.create(mediaType, "{ \"user_data\": \""+name+"\"}");
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();            
    PostPers pj = gson.fromJson( POST(url+"/storage/persons",body), PostPers.class);
    linked(url,pj.person_id);
    linkedPhoto(url,pj.person_id,id_photo);
    System.out.println("Request: "+pj.person_id);    
    }
//______________________________________________________________________________    
    
 
    
    
// добавляет фотку к персоне , если фоток меньше лимита    
public void AddPhoto(String url, String id_pers, String id_photo)
{
   GetPerson pj = getPerson(url,id_pers);
   
   if(pj.descriptors.length<20)
   {
       linkedPhoto(url,id_pers,id_photo);
   }
} 
    
//______________________________________________________________________________    
    
    
 
    
         
//       Функции базовых запросов GET/POST/PATCH

// Функция запроса GET, возвращает строку json    
    public String GET(String url)
    {
         try {
             
            OkHttpClient client = new OkHttpClient();

            String credential = Credentials.basic("demo@demo.demo", "DEMO_TEST");

            Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Authorization", credential)
                .build();

            Response response = client.newCall(request).execute();         
            return response.body().string();
           
        } catch (IOException ex) {
            System.out.println("Ошибка запроса!");
            return null;
        }
    }
//______________________________________________________________________________     
    
     
  // Функция запроса PATCH без тела, ничего не возвращает   
    public void PATCH(String url)
    {
         try {
             
            OkHttpClient client = new OkHttpClient();    
            String credential = Credentials.basic("demo@demo.demo", "DEMO_TEST");
            Request request = new Request.Builder()
                .url(url)
                .patch(RequestBody.create(null, new byte[0]))
                .addHeader("Authorization", credential)
                .build();
            Response response = client.newCall(request).execute();
        } catch (IOException ex) {
            System.out.println("Ошибка запроса!");
        }
    }
//______________________________________________________________________________    
    
    
  // Функция запроса POST, возвращает JSON строку   
    public String  POST(String url, RequestBody body)
    {
         try {         
            OkHttpClient client = new OkHttpClient();   
            String credential = Credentials.basic("demo@demo.demo", "DEMO_TEST");
            Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Authorization", credential)
                .build();
            Response response = client.newCall(request).execute(); 
          return response.body().string();
        } catch (IOException ex) {
            System.out.println("Ошибка запроса!");
            return null;
        }
    }

    
//End
//==============================================================================   
}




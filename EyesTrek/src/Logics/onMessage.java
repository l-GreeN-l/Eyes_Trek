//______________________________________________________________________________
// 
//       Класс действий для класса WS_client протокола при получении сообщения 
//
//______________________________________________________________________________

package Logics;
import static Logics.Ws_client.dateFormat;
import Pojo.WS_Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Pojo.*;
import static eyestrek.EyesTrek.SimilarityLimit;
import static eyestrek.EyesTrek.urlhttp;
import java.util.Date;

public class onMessage {
    
public onMessage(String message) 
    {     
            Requests req = new Requests();           
               // Json ответ
            System.out.println( "received: " + message );     
            //Контейнер для самого похожего кандидата
            WS_Response.candidates TruePerson = null ;  
            
try{       
        
// Настройки Json билдера
GsonBuilder builder = new GsonBuilder();
Gson gson = builder.create();            
WS_Response pj = gson.fromJson(message, WS_Response.class); // messege - строка сообщения
                         
//Вывод даты
System.out.println(dateFormat.format(new Date())+"___________Result:");                     
TruePerson = trueCand(pj); // Вывод списка кандидатов и нахождение самого похожего

if (TruePerson==null)
// Создание персоны    
{
//    GetAllpers.Response pjs = req.getPersonList(urlhttp, 0);
//    req.createPerson(urlhttp, "№_"+pjs.count , pj.result.face.id);
//    System.out.println("Person is create!");
}
else
{
// Добавление фото к персоне
    req.AddPhoto(urlhttp, TruePerson.person_id, pj.result.face.id );
    System.out.println("Photo is attach to exist person !");
}
    
// Очистка контейнера персоны
TruePerson=null;

//-- end try
 }
// ------------- Exception чтения Json---------------
 catch(JsonSyntaxException ex)
 { 
     ex.printStackTrace();
 } 

 
    }
 //_____________________________END Constructor_________________________________   
    

    
//Вывод списка кандидатов и нахождение самого похожего__________________________
public WS_Response.candidates  trueCand(WS_Response pj )
{
    WS_Response.candidates TruePerson = null;
// Максимальное сходство из представленных кандидатов
double MaxSimilarity = 0;

    //Вывод списка кандидатов
for(int i=0;i<pj.result.candidates.size();i++)
       {
    
        System.out.println("Num_"+i+" :  "+pj.result.candidates.get(i).user_data+
        "   procent: "+pj.result.candidates.get(i).similarity);

    // Выявление самого похожего кандидата        
        if(Double.parseDouble(pj.result.candidates.get(i).similarity) > MaxSimilarity)
        {
            TruePerson = pj.result.candidates.get(i);
            MaxSimilarity = Double.parseDouble(TruePerson.similarity);
            
        }
 log(dateFormat.format(new Date())+"__"+TruePerson.user_data+"  ");

}

if(MaxSimilarity>SimilarityLimit)return TruePerson;
else return null;
}
//__________Конец цикла чтения кандидатов_______________________________________


    
public void log(String str)
{
        
    try {  
        PrintWriter  writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Person_Log.txt", true), "UTF-8"));
        writer.println("| "+str+" |");
        
        writer.close();
  
    } catch (FileNotFoundException ex) {
        Logger.getLogger(onMessage.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedEncodingException ex) {
        Logger.getLogger(onMessage.class.getName()).log(Level.SEVERE, null, ex);
    }
}

// end class ===================================================================    
}

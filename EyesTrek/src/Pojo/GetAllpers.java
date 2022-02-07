//______________________________________________________
//
//      Request pojo Get ALL persons
//
//______________________________________________________

package Pojo;
import java.util.List;


public class GetAllpers {
   
        public class persons
        {
           public String [] descriptors;
           public String   create_time;
           public String   user_data;
           public String id; 
           public String [] lists;
           public persons(){}
        
        }
   
        public class Response
        {
            public int count;   
            public List<persons> persons;
            public Response(){};
        }

        public GetAllpers(){}  
}

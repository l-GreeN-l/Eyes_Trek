
//______________________________________________________
//
//      Request pojo WebSocket protocol event 
//
//______________________________________________________


package Pojo;

import java.util.List;


public class WS_Response {
    
    
    // iner WS_Response
    public String source;
    public String authorization;
   public  result result; 
   public  candidate attributes; 
   public  template template; 
//******************************************************************************  
 
    
    
    
    
    
//------------------------- iner result  ---------------------------------------   
    public class candidates{
            public String person_id;
            public String user_data;
            public String descriptor_id;
            public String similarity;
        
            
      public   candidates(){}   
            
    }
//------------------------------------------------------------------------------



    
    
    
    
    
 // ------------------------iner result ----------------------------------------       
    public class face 
    {
        
          public  rectISO rectISO;   
          public String id;
          public  attributes attributes;  
          public  rect rect;  
          public String score;
          
          
          public   face(){}
    }
//------------------------------------------------------------------------------    
    
    
    
    
    
    
    
//----------------------------------- iner face---------------------------------        
   public class rectISO 
   {
        public int  height;
        public int y;
        public int x;
        public int width;
        
        
       public   rectISO(){}
   }
//------------------------------------------------------------------------------    
    

   
   
   
   
//------------------------------- iner face   ----------------------------------   
public class attributes {
              public int  age;
              public int gender;
              public String eyeglasses;
              
              
              public   attributes(){}
        
}    
//------------------------------------------------------------------------------       
 






//----------------------------- iner face  ------------------------------------- 
public class rect
				{
				public int height;
				public int y;
				public int x;
				public int width;
                                
                                
                                
                                public   rect(){}
				}


//------------------------------------------------------------------------------





   
   
    
//-------------------------- iner WS_Response  ---------------------------------   
   public class  result
   {
      public  List<candidates> candidates;
      public  face face;
     
      public   result(){}
   }
//------------------------------------------------------------------------------ 

   
   
   
 //iner WS_Response    
 public String event_type;
 
 
 
 
   
//----------------------------- iner WS_Response -------------------------------   
 public class  candidate
   {
      public String list_id;
      
      
      public   candidate(){}
   }
//------------------------------------------------------------------------------
 
 
 
//------------------------------- iner WS_Response ----------------------------- 
 public class  template
   {
      public String descriptor_id;
      
      
      public   template(){}
   }  
//------------------------------------------------------------------------------   
    
 
 
//iner WS_Response
public String  timestamp;



 
 //=============================================================================   
   public WS_Response(){} 
}

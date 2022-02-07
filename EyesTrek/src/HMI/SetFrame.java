/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HMI;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JLabel;
import HMI.HMI;


public class SetFrame {
   
    public static JTextField SQLTF = new JTextField(20) ;            // для настройки пути к БД
    public static JTextField CantechTF= new JTextField(20);
    public static JTextField  MyDB = new JTextField(20);
                                
    public static String PathSQL;               // Тут хранится путь к БД
    public static String PathCantech;                    
    public static String PathMyDB;
    
    public static JButton btnSave = new JButton("SAVE");              // кнопка сэйв
    public static JButton btnCancel = new JButton("Cancel");            // кнопка отмена
    
    public static JCheckBox AutoChB = new JCheckBox();
    public static JLabel AvtoL = new JLabel("Автозагрузка при запуске");
    
    public static JLabel NPathSQL = new JLabel("Путь к БД Luna");
    public static JLabel NPathCantech = new JLabel("Путь к БД Cantech ");
    public static JLabel NPathMyDB = new JLabel("Путь к БД OpenFDoor");
    
    
    
    public static JFrame Frame;
    
//******************************************************************************
    
    SetFrame(){
        HMI.tr = false;
        Frame = new JFrame("Settings");
        Frame.setSize(HMI.x, HMI.y);
        Frame.setLayout(null); 
        
        Font font = new Font("Verdana", Font.PLAIN, 11); 

//------------------------------------------------------------------------------

  
 Frame.add(NPathSQL);
 Insets insets = Frame.getInsets(); 
 Dimension size = NPathSQL.getPreferredSize(); 
           
        NPathSQL.setBounds(
                25 + insets.left, 
                5 + insets.top, 
                     
                size.width, size.height); 
 //--------------------------------------------- 
 
Frame.add(SQLTF);
 size = SQLTF.getPreferredSize();         
 SQLTF.setBounds(
                25 + insets.left, 
                25 + insets.top,              
                size.width, size.height); 
//--------------------------------------------- 

Frame.add(NPathCantech);
 size = NPathCantech.getPreferredSize();      
 NPathCantech.setBounds(
                25 + insets.left, 
                70 + insets.top, 
                     
                size.width, size.height); 

//--------------------------------------------- 

Frame.add(CantechTF);
size = CantechTF.getPreferredSize(); 
CantechTF.setBounds(
                25 + insets.left, 
                90 + insets.top, 
                     
                size.width, size.height); 

//--------------------------------------------- 
      
Frame.add(NPathMyDB);
size = NPathMyDB.getPreferredSize(); 
NPathMyDB.setBounds(
                25 + insets.left, 
                130 + insets.top,              
                size.width, size.height); 

//--------------------------------------------- 

Frame.add(MyDB);
size = MyDB.getPreferredSize(); 
MyDB.setBounds(
                25 + insets.left, 
                150 + insets.top,                     
                size.width, size.height); 

//--------------------------------------------- 

Frame.add(AvtoL);
size = AvtoL.getPreferredSize(); 
AvtoL.setBounds(
                25 + insets.left, 
                180 + insets.top, 
                     
                size.width, size.height); 
//--------------------------------------------- 

Frame.add(AutoChB);
size = AutoChB.getPreferredSize(); 
AutoChB.setBounds(
                200 + insets.left, 
                180 + insets.top,                      
                size.width, size.height); 
//--------------------------------------------- 
  
 //Слушатель закрытия окна
 WindowListener W = new WindowAdapter(){ 
     public void windowClosing(WindowEvent e) {HMI.tr = true;} 
 };        
        Frame.addWindowListener(W);           //Слушатель закрытия окна 
        Frame.setResizable(false);
        Frame.setVisible(true);  
            
    }
  
//==============================================================================
//END    
}

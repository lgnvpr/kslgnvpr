/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELPER;

/**
 *
 * @author ADMIN
 */
public class MyComBoBox {
    String value;
    String text;
    public MyComBoBox(String value, String text){
        this.value = value;
        this.text = text;
    }
    
    @Override
    public String toString(){
        return text.toString();
    }
    
    
    public int maInt(){
        return Integer.parseInt(value.toString());
    }
    
    public String MaString(){
        return value.toString();
    }
}

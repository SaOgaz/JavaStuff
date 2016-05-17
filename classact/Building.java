/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ogaz
 */
public class Building {
    int sqFt;
    
    public Building(int x){
        //constructor
        sqFt = x;
    }
    
    public String getSize(){
        return Integer.toString(sqFt);
    }
}

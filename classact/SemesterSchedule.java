/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ogaz
 */
public class SemesterSchedule {
    int credits;
    
    public SemesterSchedule(int x){
        //constructor
        credits = x;
    }
    
    public String getSize(){
        return Integer.toString(credits);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ogaz
 */

public class StudentRecords implements Sized{
    
    int records;
    
    public StudentRecords(int x){
        //constructor
        records = x;
    }
    
    public String getSize(){
        return Integer.toString(records) + " records";
    }
}

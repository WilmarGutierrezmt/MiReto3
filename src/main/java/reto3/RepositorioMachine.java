/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMachine {
    
        @Autowired
    private InterfaceMachine crud;

    public List<Machine> getAll(){
        return (List<Machine>) crud.findAll();
    }

    public Optional<Machine> getBike(int id){
        return crud.findById(id);
    }

    public Machine save(Machine Machine){
        return crud.save(Machine);
    }
    public void delete(Machine Machine){
        crud.delete(Machine);
    }

    Optional<Machine> getMachine(int MachineId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

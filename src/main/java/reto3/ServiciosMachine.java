/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMachine {
    
     @Autowired
    private RepositorioMachine metodosCrud;

    public List<Machine> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Machine> getMachine(int MachineId) {
        return metodosCrud.getMachine(MachineId);
    }

    public Machine save(Machine Machine){
        if(Machine.getId()==null){
            return metodosCrud.save(Machine);
        }else{
            Optional<Machine> e=metodosCrud.getMachine(Machine.getId());
            if(e.isEmpty()){
                return metodosCrud.save(Machine);
            }else{
                return Machine;
            }
        }
    }

    public Machine update(Machine Machine){
        if(Machine.getId()!=null){
            Optional<Machine> e=metodosCrud.getMachine(Machine.getId());
            if(!e.isEmpty()){
                if(Machine.getName()!=null){
                    e.get().setName(Machine.getName());
                }
                if(Machine.getBrand()!=null){
                    e.get().setBrand(Machine.getBrand());
                }
                if(Machine.getYear()!=null){
                    e.get().setYear(Machine.getYear());
                }
                if(Machine.getDescription()!=null){
                    e.get().setDescription(Machine.getDescription());
                }
                if(Machine.getCategory()!=null){
                    e.get().setCategory(Machine.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return Machine;
            }
        }else{
            return Machine;
        }
    }


    public boolean deleteMachine(int MachineId) {
        Boolean aBoolean = getMachine(MachineId).map(Machine -> {
            metodosCrud.delete(Machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }


    
}

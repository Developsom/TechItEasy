package com.example.techiteasy.Services;
import com.example.techiteasy.Dto.Output.TelevisionOutputDto;
import com.example.techiteasy.Exceptions.RecordNotFoundException;
import com.example.techiteasy.Model.Television;
import com.example.techiteasy.Repository.TelevisionRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TelevisionService {

    //Onderstaande code block koppelt de repository aan de service laag
    private final TelevisionRepository repos;
    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }




    ////Find all method

    public List<TelevisionOutputDto> getAllTelevisions(){
        Iterable<Television> television = repos.findAll();
        List<TelevisionOutputDto> televisionOutputDtos = new ArrayList<>();
        for (Television t : television){
            TelevisionOutputDto tdto = televisionToDto(t);
            televisionOutputDtos.add(tdto);
        }
        return televisionOutputDtos;
    }





    public TelevisionOutputDto getTelevisionById(Long id){
        Optional<Television> televisionOptional = repos.findById(id); //Returned een optional van type Television. Wordt dus opgeslagen als een Optional television.

        if (televisionOptional.isEmpty()){ //Met de t.isEmpty methode checken we of er iets in de optional zit
            throw new RecordNotFoundException("Television not found");
        }
        else {
            Television t = televisionOptional.get(); //Als die niet empty is returned die met t.get() de television uit de optional
            TelevisionOutputDto tdto = televisionToDto(t);
            return tdto;
        }
    }


    //We vertalen een Television naar een Dto. Dus de input is een Television. De output is een Dto. Dus output is een Television Dto. Method naam is TelevisionToDto.
    public TelevisionOutputDto televisionToDto(Television t) {

        TelevisionOutputDto tdto = new TelevisionOutputDto(); // Hier vertaal ik de television naar een Dto
        tdto.id = t.getId();
        tdto.type = t.getType();
        tdto.brand = t.getBrand();
        tdto.name = t.getName();
        tdto.price = t.getPrice();
        tdto.availableSize = t.getAvailableSize();
        tdto.refreshRate = t.getRefreshRate();
        tdto.screenType = t.getScreenType();
        tdto.screenQuality = t.getScreenQuality();
        tdto.smartTv = t.getSmartTv();
        tdto.wifi = t.getWifi();
        tdto.voiceControl = t.getVoiceControl();
        tdto.hdr = t.getHdr();
        tdto.bluetooth = t.getBluetooth();
        tdto.ambiLight = t.getAmbiLight();
        tdto.originalStock = t.getOriginalStock();
        tdto.sold = t.getSold();
        return tdto;
    }
}

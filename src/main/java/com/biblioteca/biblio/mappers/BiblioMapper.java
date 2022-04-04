package com.biblioteca.biblio.mappers;

import com.biblioteca.biblio.DTO.BiblioDTO;
import com.biblioteca.biblio.models.BiblioModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BiblioMapper {

    public BiblioModel fromDto(BiblioDTO dto) {
        BiblioModel biblioModel = new BiblioModel();
        biblioModel.setId(dto.getId());
        biblioModel.setName(dto.getName());
        biblioModel.setAutor(dto.getAutor());
        biblioModel.setLend(dto.getLend());
        biblioModel.setTheme(dto.getTheme());
        biblioModel.setTipe(dto.getTipe());
        biblioModel.setDate(dto.getDate());
        return biblioModel;

    }

    public BiblioDTO fromCollection(BiblioModel collection) {
        BiblioDTO biblioDTO = new BiblioDTO();
        biblioDTO.setId(collection.getId());
        biblioDTO.setName(collection.getName());
        biblioDTO.setAutor(collection.getAutor());
        biblioDTO.setLend(collection.getLend());
        biblioDTO.setTheme(collection.getTheme());
        biblioDTO.setTipe(collection.getTipe());
        biblioDTO.setDate(collection.getDate());
        return biblioDTO;

    }

//devuelve de lista de modelos a listado dto:
    public List<BiblioDTO> fromCollectionList(List<BiblioModel> collection) {
        if (collection == null) {
            return null;
        }
        List<BiblioDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while (listTracks.hasNext()) {
            BiblioModel biblioModel = (BiblioModel) listTracks.next();
            list.add(fromCollection(biblioModel));
        }
        return list;
    }


}
package com.biblioteca.biblio.respositories;


import com.biblioteca.biblio.models.BiblioModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BiblioRepository extends MongoRepository<BiblioModel, String>{
    List<BiblioModel> findByTheme(String theme);
    List<BiblioModel> findByTipe(String tipe);
}

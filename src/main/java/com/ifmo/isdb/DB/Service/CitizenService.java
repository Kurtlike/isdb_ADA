package com.ifmo.isdb.DB.Service;

import com.ifmo.isdb.DB.DAO.CitizenDao;
import com.ifmo.isdb.DB.pojo.CitadelCitizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Repository
public class CitizenService {

    @Autowired
    CitizenDao citizenDao;

    public List<CitadelCitizen> getAllCitizens(){
        return this.citizenDao.findAll();
    }
    public CitadelCitizen addCitizen(CitadelCitizen citizen){
        BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
        citizen.setPassword(bcryptEncoder.encode(citizen.getPassword()));
        return  citizenDao.save(citizen);
    }
    public CitadelCitizen getCitizen(String login){
        return citizenDao.findAll().stream().filter(citizens->login.equals(citizens.getLogin())).findFirst().orElse(null);
    }
    public boolean isCitizen(String login){
        return citizenDao.findAll().stream().anyMatch(citizens -> login.equals(citizens.getLogin()));
    }
}

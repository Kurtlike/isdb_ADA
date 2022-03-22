package com.ifmo.isdb.DB.serviceImpls;

import com.ifmo.isdb.DB.pojo.CitadelCitizen;
import com.ifmo.isdb.DB.Service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CitizenServiceImpl implements UserDetailsService {
    @Autowired
    CitizenService citizenService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        CitadelCitizen citizen = findCitizenByLogin(login);

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (citizen != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(login);
            builder.password(citizen.getPassword().toString());
            builder.roles(citizen.getPermission().toString());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }

    private CitadelCitizen findCitizenByLogin(String login) {
        return citizenService.getCitizen(login);

    }
}

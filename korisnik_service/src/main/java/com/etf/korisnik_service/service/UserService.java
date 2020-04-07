package com.etf.korisnik_service.service;

import com.etf.korisnik_service.dto.LoginResponseDto;
import com.etf.korisnik_service.dto.LoginUserDto;
import com.etf.korisnik_service.exception.LoginException;
import com.etf.korisnik_service.exception.RoleException;
import com.etf.korisnik_service.exception.UserException;
import com.etf.korisnik_service.model.Role;
import com.etf.korisnik_service.model.User;
import com.etf.korisnik_service.repository.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserInterface userRepository;
    private List<User> sviKorisnici;

    public User addUser(User noviUser) throws NoSuchAlgorithmException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPassword = passwordEncoder.encode(noviUser.getPassword());
        noviUser.setPassword(hashPassword);
        return userRepository.save(noviUser);
    }

    public LoginResponseDto loginUser(LoginUserDto user) throws LoginException {
        return null;
    }

    private String generateToken() {return null;}

    public User getUserById(Integer id) throws UserException {
        return userRepository.findById(id).orElseThrow(() -> new UserException(id));
    }

    public void deleteUserById(Integer id) throws UserException {
        if (!userRepository.existsById(id)) {
            throw new UserException(id);
        }
        userRepository.deleteById(id);
    }

    public void editUser(User noviUser, Integer id) throws UserException {
        userRepository.findById(id).orElseThrow(() -> new UserException(id));
        userRepository.findById(id).map(
                user -> {
                    user.setFullName(noviUser.getFullName());
                    user.setAddress(noviUser.getAddress());
                    user.setEmail(noviUser.getEmail());
                    user.setPhoneNumber(noviUser.getPhoneNumber());
                    return userRepository.save(user);
                }
        );
    }

    public List<User> getListOfUsers() throws Exception {
        if (userRepository.count() == 0) {
            throw new Exception("Nema korisnika u bazi");
        }
        List<User> sviKorisnici = new ArrayList<>();
        userRepository.findAll().forEach(sviKorisnici::add);
        return sviKorisnici;
    }

    public List<User> getAllUsersWithRole(String uloga) throws Exception {
        sviKorisnici = getListOfUsers();
        List<User> korisnici = new ArrayList<>();
        for (User user : sviKorisnici) {
            if (user.getRoleId() != null && user.getRoleId().getRoleName().equals(uloga)) {
                korisnici.add(user);
            }
        }
        if (korisnici.size() == 0) {
            throw new Exception("Nema korisnika sa tom ulogom");
        }
        return korisnici;
    }

    public User getUserWithName(String imePrezime) throws Exception {
        sviKorisnici = getListOfUsers();
        for (User user : sviKorisnici) {
            if (user.getFullName() != null && user.getFullName().equals(imePrezime)) {
                return user;
            }
        }
        throw new Exception("Nema korisnika sa tom ulogom");
    }

    public void deleteAllUsers()  throws Exception {
        if (userRepository.count() == 0) {
            throw new Exception("U bazi nema vise korisnika");
        }
        userRepository.deleteAll();
    }

}

package com.example.demo4.services.user;

import com.example.demo4.convertor.user.UserConvertor;
import com.example.demo4.persistances.dto.user.SignUpDTO;
import com.example.demo4.persistances.dto.user.UserDTO;
import com.example.demo4.persistances.model.user.User;
import com.example.demo4.repositories.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@Slf4j
public class UserServices {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public UserServices(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Page<UserDTO> getAllUsers(Pageable pageable){
        return new PageImpl<>(UserConvertor.convertListOfEntityToDTO(
                userRepository.findAll(pageable).getContent()
        ), userRepository.findAll(pageable).getPageable(), userRepository.findAll(pageable).getTotalElements()
        );
    }

    public Long signUp(SignUpDTO dto){
        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new RuntimeException("Email is already registered");
        }
        if(userRepository.findByUsername(dto.getUsername()).isPresent()){
            throw new RuntimeException("Username is already used");
        }
        return userRepository.save(modelMapper.map(dto, User.class)).getId();
    }

    public UserDTO getUserById(long id){
        User user = userRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("User not found with id: "+id)
        );
        return modelMapper.map(user,UserDTO.class);
    }
    public Long updateUser(UserDTO dto,String username){
        User user = userRepository
                .findByUsername(username).orElseThrow(()->new EntityNotFoundException("User not found: "+username));
        return userRepository.save(modelMapper.map(dto,User.class)).getId();
    }
    public UserDTO getUserByEmail(String email){
        User user = userRepository.findByEmail(email).orElseThrow(
                ()-> new EntityNotFoundException("User not found with email: "+email)
        );
        return modelMapper.map(user,UserDTO.class);
    }

    public UserDTO getUserByUsername(String username){
        User user = userRepository.findByUsername(username).orElseThrow(
                ()-> new EntityNotFoundException("User not found with username: "+username)
        );
        return modelMapper.map(user,UserDTO.class);
    }
}
